package RestapiPractice;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	@Test
	public static void postmethod() {
		// String Json = "{\r\n" + " \"username\" : \"admin\",\r\n" + " \"password\" :
		// \"password123\"\r\n" + "}";

		// ✅ Create request body using a Map
		Map<String, Object> credentials = new HashMap<String, Object>();
		credentials.put("username", "admin");
		credentials.put("password", "password123");
		// JsonPath jp = new JsonPath(Json);
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		Response RR = given().header("Content-Type", "application/json").body(credentials).when().post("/auth").then()
				.extract().response();
		String Stringvales = RR.asPrettyString();
		System.out.println(Stringvales);
	}

}
