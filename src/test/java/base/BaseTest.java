package base;

import io.restassured.RestAssured;
import utils.ConfigReader;

public class BaseTest {

    public static void setup() {
        RestAssured.baseURI = ConfigReader.get("baseUrl");
    }
}