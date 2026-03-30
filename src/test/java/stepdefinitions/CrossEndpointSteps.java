package stepdefinitions;

import client.PetStoreClient;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.Assert;

public class CrossEndpointSteps {

    PetStoreClient client = new PetStoreClient();

    Response response;
    Response inventoryResponse;

    int petId;

    @Given("I create a pet with category {string} and status {string}")
    public void createPetWithCategory(String category, String status) {

        petId = (int) (Math.random() * 10000);

        String body = "{\n" +
                "  \"id\": " + petId + ",\n" +
                "  \"category\": { \"id\": 1, \"name\": \"" + category + "\" },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";

        response = client.createPet(body);
    }

    @When("I update pet status to {string} for cross endpoint")
    public void updatePet(String status) {
        response = client.updatePet((long) petId, "doggie", status);
    }

    @When("I fetch store inventory")
    public void fetchInventory() {
        inventoryResponse = client.getInventory();
    }

    @When("I fetch pets by status {string} for cross endpoint")
    public void fetchPetsForCrossEndpoint(String status) {
        response = client.findByStatus(status);
    }

    @Then("created pet should be present in sold list")
    public void validatePetInSoldList() {

        boolean found = response.jsonPath().getList("id")
                .stream()
                .anyMatch(id -> id.equals(petId));

        Assert.assertTrue(found, "Pet not found in sold list");
    }
}