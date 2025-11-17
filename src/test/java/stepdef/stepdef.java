package stepdef;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class stepdef {

	private String token;
	private Response response;

	private final String TOKEN_URL = "https://api.example.com/oauth/token";
	private final String USER_URL = "https://api.example.com/users/";

	@Given("I have valid credentials")
	public void i_have_valid_credentials() {
		System.out.println("Using valid credentials for OAuth");
	}

	@When("I request an access token")
	public void i_request_an_access_token() {
		response = given().contentType("application/json")
				.body("{ \"username\": \"myuser\", \"password\": \"mypassword\" }").post(TOKEN_URL);

		token = response.jsonPath().getString("access_token");
	}

	@Then("I should receive a valid access token")
	public void i_should_receive_a_valid_access_token() {
		response.then().statusCode(200);
		if (token == null || token.isEmpty()) {
			throw new RuntimeException("Access token not received");
		}
		System.out.println("Received token: " + token);
	}

	@When("I update user {string} with new details using the token")
	public void i_update_user_with_new_details_using_the_token(String userId) {
		JSONObject requestBody = new JSONObject();
		requestBody.put("name", "John Doe Updated");
		requestBody.put("email", "john.updated@example.com");

		response = given().header("Authorization", "Bearer " + token).contentType("application/json")
				.body(requestBody.toString()).put(USER_URL + userId);
	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer statusCode) {
		response.then().statusCode(statusCode);
	}

	@Then("the response should contain the updated user information")
	public void the_response_should_contain_the_updated_user_information() {
		response.then().body("name", equalTo("John Doe Updated")).body("email", equalTo("john.updated@example.com"));
	}

	// --- Optional: Restful-Booker API example ---
	@Given("I give valid URI")
	public void i_give_valid_uri() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	}

	@When("I add the correct body in request")
	public void i_add_the_correct_body_in_request() {
		String requestBody = "{ \"username\": \"admin\", \"password\": \"password123\" }";
		response = given().header("Content-Type", "application/json").body(requestBody).when().post("/auth").then()
				.extract().response();
	}

	@Then("I validate the Response code")
	public void i_validate_the_response_code() {
		assertEquals(200, response.getStatusCode());
	}

	@Then("I extract the Response")
	public void i_extract_the_response() {
		System.out.println("Response: " + response.asString());
	}

	@Then("I add correct end point")
	public void i_add_correct_end_point() {
	System.out.println("there is no end point ");
	}

	@Then("I add correct PathParameter")
	public void i_add_correct_path_parameter() {
		System.out.println("there is no path parameter ");
	}

	@Then("Response code should be correct")
	public void response_code_should_be_correct() {
		System.out.println("correct status code should be there ");
	}

}
