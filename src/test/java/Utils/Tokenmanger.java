package Utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.time.Instant;

import Resource.ConfigReader;

public class Tokenmanger {
	private static String token;
	private static Instant tokenExpiryTime;

	public static String getToken() {
		// If token not available or expired, generate a new one
		if (token == null || Instant.now().isAfter(tokenExpiryTime)) {
			token = generateToken();
			// Assuming token validity ~10 min (Heroku mock doesn’t expire, but good
			// practice)
			tokenExpiryTime = Instant.now().plusSeconds(600);
		}
		return token;
	}

	private static String generateToken() {
		Response response = given().baseUri(ConfigReader.getProperty("base_url")).contentType("application/json")
				.body("{\"username\":\"" + ConfigReader.getProperty("username") + "\",\"password\":\""
						+ ConfigReader.getProperty("password") + "\"}")
				.when().post("/auth");

		response.then().statusCode(200);
		return response.jsonPath().getString("token");
	}

}
