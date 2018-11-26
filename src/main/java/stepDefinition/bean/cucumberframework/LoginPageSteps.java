package stepDefinition.bean.cucumberframework;

import java.util.List;

import org.openqa.selenium.By;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
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

	@Given("^pocreator enters his credentials$")
	 public void pocreator_enters_his_credentials(DataTable usercredentials) throws Throwable {
		 List<List<String>> data = usercredentials.raw();
		 loginPage.enterUsername(data.get(0).get(0));
		 loginPage.enterPassword(data.get(0).get(1));
		 loginPage.clickSignIn();
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
	}
	
}
