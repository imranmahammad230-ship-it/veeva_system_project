package client;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class PetStoreClient {

    public PetStoreClient() {
            baseURI = "https://petstore.swagger.io/v2";
    }
    public Response createPet(Object body) {
        return given().header("Content-Type", "application/json")
                .body(body).post("/pet");
    }
    public Response getInventory() {
        return given().when().get("/store/inventory");
    }

    public Response findPetsByStatus(String status) {
        return given().queryParam("status", status)
                .when().get("/pet/findByStatus");
    }
    public Response getPet(int id) {
        return given().get("/pet/" + id);
    }

    public Response updatePet(long id, String name, String status) {
        String body = "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";

        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .put("/pet");
    }

    public Response deletePet(int id) {
        return given().delete("/pet/" + id);
    }


    public Response findByStatus(String status) {
        return given().queryParam("status", status)
                .get("/pet/findByStatus");
    }

    public Response createUser(String body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .post("/user");
    }

    public Response getUser(String username) {
        return given().get("/user/" + username);
    }

    public Response login(String username, String password) {
        return given()
                .queryParam("username", username)
                .queryParam("password", password)
                .get("/user/login");
    }
    public Response getPetById(int id) {
        return given()
                .get("/pet/" + id);
    }
    public Response deleteUser(String username) {
        return given()
                .delete("/user/" + username);
    }
    public Response getPetById(long petId) {
        return given().get("/pet/" + petId);
    }

    public Response updatePetStatus(long petId, String status) {
        return given()
                .queryParam("petId", petId)
                .queryParam("status", status)
                .post("/pet/" + petId);
    }

    public Response deletePet(long petId) {
        return given().delete("/pet/" + petId);
    }
}