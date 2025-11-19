package Utils;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Token1 {
	@Test
	public void T2() {
		String Token = T1();
		System.out.println(Token);

	}

	public String T1() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/auth";

		Map<String, String> body = new HashMap<String, String>();
		body.put("username", "admin");
		body.put("password", "password123");

		Response resp = given().header("Content-Type", "application/json").body(body).when().post().then().extract()
				.response();

		// String Token = resp.jsonPath().getString("token");

		return resp.jsonPath().getString("token");

	}
}
