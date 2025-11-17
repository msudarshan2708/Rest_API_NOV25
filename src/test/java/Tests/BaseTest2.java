package Tests;

import Tests.BaseTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BaseTest2 extends BaseTest {

	@Test
	public void updateBooking_shouldReturn200() {
		given().contentType("application/json").accept("application/json").cookie("token=" + token)
				.body("{\"firstname\":\"James\",\"lastname\":\"Brown\"}").when().put("/booking/1").then()
				.statusCode(200).body("firstname", equalTo("James")).body("lastname", equalTo("Brown"));
	}
}
