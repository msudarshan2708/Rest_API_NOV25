package RestapiPractice;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Test
public class Whirpool_PostRequest {

	public void Get() {

		RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
		Response Resp = given().when().get().then().extract().response();
		JsonPath values = Resp.jsonPath();
		System.out.println(values.get());
	}

}
