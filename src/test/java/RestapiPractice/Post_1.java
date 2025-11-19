package RestapiPractice;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Post_1 {
	ResponseSpecification responseSpecification;
	RequestSpecification REQ;

	@BeforeClass

	public void SpecBuilder() {
		RequestSpecBuilder ReqSpecBuilder = new RequestSpecBuilder();
		ReqSpecBuilder.setBaseUri("https://restful-booker.herokuapp.com/booking");
		ReqSpecBuilder.addHeader("Content-Type", "application/json");
		ReqSpecBuilder.addHeader("Accept", "application/json");
		ReqSpecBuilder.log(LogDetail.ALL);
		REQ = ReqSpecBuilder.build();

		ResponseSpecBuilder Responsespecbuilder = new ResponseSpecBuilder();
		Responsespecbuilder.expectContentType(ContentType.JSON);
		Responsespecbuilder.log(LogDetail.ALL);
		responseSpecification = Responsespecbuilder.build();
	}

	@Test
	public void Post1() {

		given().spec(REQ)
				.body("{\r\n" + "    \"firstname\" : \"sudarshan\",\r\n" + "    \"lastname\" : \"Mandlik\",\r\n"
						+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
				.when().post().then().spec(responseSpecification).

				extract().response();

	}

}
