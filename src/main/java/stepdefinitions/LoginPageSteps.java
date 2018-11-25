package stepdefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.LoginPage;

public class LoginPageSteps {

	TestContext testContext;
	LoginPage loginPage;
	
	public LoginPageSteps(TestContext context) {
		testContext=context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
	}
	
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) throws Throwable {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickSignIn();
	}
	@Then("^user can logout successfully$")
	public void user_can_logout_successfully() throws Throwable {
		loginPage.selectSettings();
		loginPage.selectSignOut();
		testContext.getWebDriverManager().closeDriver();
	}
	
}
