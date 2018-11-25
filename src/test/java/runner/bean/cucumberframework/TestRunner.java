package runner.bean.cucumberframework;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/smokeTests",
		glue = {"stepDefinition.bean.cucumberframework"},
		tags= {"@invoice,@login,@smoke" }
		)
public class TestRunner {
}