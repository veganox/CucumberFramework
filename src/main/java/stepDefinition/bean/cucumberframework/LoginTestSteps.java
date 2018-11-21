package stepDefinition.bean.cucumberframework;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pageobjects.bean.cucumberframework.*;

public class LoginTestSteps {
	WebDriver driver;
	LoginPage loginPage;
	InvoicePage invoicePage;
	
	@Given("^user is on signin page$")
	public void user_is_on_homepage() throws Throwable {
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get("https://beandev.com");
	 }
	
	
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) throws Throwable {
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickSignIn();

	}

	@Then("^user logins to \"([^\"]*)\" successfully$")
	public void user_logins_to_successfully(String module) throws Throwable {
		if(module=="invoice"){
			invoicePage = new InvoicePage(driver);
			invoicePage.verifyInvoicePage();
			System.out.println("Login Successfully");
		}
	}

	@Then("^user can logout successfully$")
	public void user_can_logout_successfully() throws Throwable {
		 loginPage = new LoginPage(driver);
		 loginPage.selectSettings();
		 loginPage.selectSignOut();
		 driver.quit();
	}
	
}
