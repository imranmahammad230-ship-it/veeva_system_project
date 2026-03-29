package stepdefinitions;

import client.PetStoreClient;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.TestDataBuilder;

public class PetSteps {

    PetStoreClient client = new PetStoreClient();
    Response response;
    long petId;

    @Given("I create a pet")
    public void createPet() {
        response = client.createPet(TestDataBuilder.createPet().toString());
        Assert.assertEquals(response.getStatusCode(), 200);  // ✅ ADD THIS
        petId = response.jsonPath().getLong("id");
    }

    @When("I fetch the pet")
    public void fetchPet() {
        response = client.getPetById(petId);
        Assert.assertEquals(response.getStatusCode(), 200);  // ✅ ADD THIS
    }

    @Then("pet should be available")
    public void validatePetAvailable() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @When("I update pet status to {string}")
    public void updatePet(String status) {
        response = client.updatePet(petId, "doggie", status);
    }

    @Then("pet status should be updated")
    public void validateUpdate() {
        response = client.getPetById(petId);  // 🔥 fetch again
        String updatedStatus = response.jsonPath().getString("status");
        Assert.assertEquals(updatedStatus, "sold");
    }

    @When("I delete the pet")
    public void deletePet() {
        response = client.deletePet(petId);
        Assert.assertEquals(response.getStatusCode(), 200);  // ✅ ADD THIS

    }

    @Then("pet should be deleted")
    public void validateDelete() {
        Response checkResponse = client.getPetById(petId);
        Assert.assertEquals(checkResponse.getStatusCode(), 404);
    }
}