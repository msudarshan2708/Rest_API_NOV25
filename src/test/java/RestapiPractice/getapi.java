package RestapiPractice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class getapi {
	@Test
	public void getapi() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		Response JP = given().headers("accept", "application/json").header("Content-Type", "application/json").when()
				.get().then().extract().response();
		String re = JP.asPrettyString();
		System.out.println(re);
		JsonPath op = JP.jsonPath();
		int toatl = op.getInt("total");
		System.out.println(toatl);
		String avatar = op.getString("data[1]");
		System.out.println(avatar);

		for (int i = 0; i < 6; i++) {
			String emails = op.getString("data[" + i + "].email");
			System.out.println(emails);
		}

		for (int i = 0; i < 6; i++) {
			String idvslues = op.getString("data[" + i + "].first_name");
			System.out.println(idvslues);
		}

	}

}
