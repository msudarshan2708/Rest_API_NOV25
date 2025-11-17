package Tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import Resource.ConfigReader;
import Utils.Tokenmanger;

public class BaseTest {
	protected String token;

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = ConfigReader.getProperty("base_url");
		token = Tokenmanger.getToken();
	}
}
