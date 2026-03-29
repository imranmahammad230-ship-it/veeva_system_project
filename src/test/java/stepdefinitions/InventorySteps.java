package stepdefinitions;

import client.PetStoreClient;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.Assert;

public class InventorySteps {

    PetStoreClient client = new PetStoreClient();
    Response response;

    int inventoryCount;
    int apiCount;

    @When("I get inventory")
    public void getInventory() {
        response = client.getInventory();
        inventoryCount = response.jsonPath().getInt("available");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @When("I fetch pets by status {string}")
    public void getPetsByStatus(String status) {
        response = client.findByStatus(status);
        apiCount = response.jsonPath().getList("$").size();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("counts should match")
    public void validateCounts() {
        Assert.assertEquals(apiCount, inventoryCount);
    }
}