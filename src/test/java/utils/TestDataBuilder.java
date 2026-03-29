package utils;

import org.json.JSONObject;
import java.util.Random;

public class TestDataBuilder {

    public static JSONObject createPet() {
        int id = new Random().nextInt(10000);

        JSONObject obj = new JSONObject();
        obj.put("id", id);
        obj.put("name", "pet_" + id);
        obj.put("status", "available");

        return obj;
    }

    public static JSONObject createInvalidUser() {
        JSONObject obj = new JSONObject();
        obj.put("username", "testUser");
        obj.put("email", "invalid_email");

        return obj;
    }
    public static JSONObject createValidUser() {
        JSONObject user = new JSONObject();
        user.put("id", 1001);
        user.put("username", "testUser");
        user.put("firstName", "Test");
        user.put("lastName", "User");
        user.put("email", "test@mail.com");
        user.put("password", "12345");
        user.put("phone", "9999999999");
        user.put("userStatus", 1);
        return user;
    }
}