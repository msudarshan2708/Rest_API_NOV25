package RestapiPractice;

import io.cucumber.java.en.Given;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Resquestspec {
	RequestSpecification RB;
	ResponseSpecification RB2;

	@BeforeMethod
	public void Request_Response_Specbuilder() {

		RequestSpecBuilder Requestspecbuildr = new RequestSpecBuilder();
		Requestspecbuildr.setBaseUri("https://petstore.swagger.io/v2");
		Requestspecbuildr.addHeader("accept", "application/json");
		Requestspecbuildr.addHeader("Content-Type", "application/json");
		Requestspecbuildr.log(LogDetail.ALL);
		RB = Requestspecbuildr.build();

		ResponseSpecBuilder responseSpecBuildr = new ResponseSpecBuilder();
		responseSpecBuildr.expectStatusCode(200);
		responseSpecBuildr.expectContentType(ContentType.JSON);
		responseSpecBuildr.log(LogDetail.ALL);
		RB2 = responseSpecBuildr.build();

	}

	@Test
	public void CreateUSer() {

		given().spec(RB)
				.body("{\r\n" + "  \"id\": 0,\r\n" + "  \"username\": \"msudarshan\",\r\n"
						+ "  \"firstName\": \"sudarshan\",\r\n" + "  \"lastName\": \"mandlik\",\r\n"
						+ "  \"email\": \"msudarshan007@gmail.com\",\r\n" + "  \"password\": \"Police\",\r\n"
						+ "  \"phone\": \"70384858522\",\r\n" + "  \"userStatus\": 1\r\n" + "}")
				.when().post("/user").then().spec(RB2).extract().response();

	}

	@Test
	public void extractuserdetails() {
		given().spec(RB).when().get("user/msudarshan").then().spec(RB2).extract().response();

	}
}