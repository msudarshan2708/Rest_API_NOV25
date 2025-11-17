package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = ("C:\\Users\\Admin\\eclipse-workspace\\cucumber-restassured\\src\\main\\resources\\restapifeature\\api.feature"), glue = ("stepdef"),

		plugin = { "pretty", "html:target/cucumber-reports.html",
				"rerun:target/failed_scenarios.txt" }, dryRun = false, monochrome = true, publish = true ,
				tags = "@SIT"
				
)

public class RestApiRunner extends AbstractTestNGCucumberTests {

}
