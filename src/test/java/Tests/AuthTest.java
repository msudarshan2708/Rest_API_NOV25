package Tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AuthTest {

	@Test
	public void verifyTokenGeneration() {
		Response response = given().baseUri("https://restful-booker.herokuapp.com").contentType("application/json")
				.body("{\"username\":\"admin\", \"password\":\"password123\"}").when().post("/auth");

		response.then().statusCode(200).body("token", notNullValue());
	}
}
