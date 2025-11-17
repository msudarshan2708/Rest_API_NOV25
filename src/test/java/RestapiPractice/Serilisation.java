package RestapiPractice;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.sun.tools.javac.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Serilisation {
	@Test
	public void serilisation() {

		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		Map<String, Object> mp = new HashMap();
		mp.put("firstname", "Sudarshan");
		mp.put("lastname", "mandlik");
		mp.put("totalprice", 2708);
		mp.put("depositpaid", true);

		Map<String, Object> bookingdates = new HashMap<String, Object>();
		bookingdates.put("checkin", "2018-01-01");
		bookingdates.put("checkout", "2019-01-01");
		mp.put("additionalneeds", "Breakfasts");
		mp.put("bookingdates", bookingdates);

		Response Resp = given().header("Content-Type", "application/json").body(mp).when().post("/booking").then()
				.extract().response();
		String actstring = Resp.asPrettyString();
		System.out.println(actstring);

		System.out.println("serilastion ");

	}

}
