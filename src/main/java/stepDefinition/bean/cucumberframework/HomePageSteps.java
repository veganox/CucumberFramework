package stepDefinition.bean.cucumberframework;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import pageobjects.HomePage;

public class HomePageSteps {
	TestContext testContext;
	HomePage homePage;

	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("^user is on signinPage$")
	public void user_is_on_signinPage() throws Throwable {
		homePage.gotoHomePage();
	}

}
