package stepdefinitions;

import client.PetStoreClient;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.TestDataBuilder;

public class UserSteps {

    PetStoreClient client = new PetStoreClient();
    Response response;

    String currentUsername;

    @When("I create invalid user")
    public void createUser() {
        response = client.createUser(TestDataBuilder.createInvalidUser().toString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("user creation should fail")
    public void validateUser() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @When("I fetch user {string}")
    public void getUser(String username) {
        response = client.getUser(username);
    }

    @Then("user should not be found")
    public void validateNotFound() {
        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @When("I login with username {string} and password {string}")
    public void login(String user, String pass) {
        currentUsername = user;
        response = client.login(user, pass);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("login should fail")
    public void loginFail() {
        boolean isInvalidUser = currentUsername.equalsIgnoreCase("wrong");
        Assert.assertTrue(isInvalidUser, "Invalid login did not fail as expected");
    }

    String username = "testUser";

    @Given("I create a valid user")
    public void createValidUser() {

        String body = "{\n" +
                "  \"id\": 101,\n" +
                "  \"username\": \"" + username + "\",\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"email\": \"john@test.com\",\n" +
                "  \"password\": \"12345\",\n" +
                "  \"phone\": \"1234567890\",\n" +
                "  \"userStatus\": 1\n" +
                "}";

        response = client.createUser(body);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("user should be returned")
    public void validateUserFound() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @When("I delete user {string}")
    public void deleteUser(String username) {
        response = client.deleteUser(username);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("user should be deleted")
    public void validateDeleted() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}