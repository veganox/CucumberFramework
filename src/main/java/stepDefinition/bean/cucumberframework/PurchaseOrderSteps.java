package stepDefinition.bean.cucumberframework;

import org.openqa.selenium.By;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import pageobjects.HeaderArea;
import pageobjects.LineItemArea;
import pageobjects.PurchaseOrderPage;

public class PurchaseOrderSteps {
	TestContext testContext;
	PurchaseOrderPage poPage;
	HeaderArea header;
	LineItemArea lineItem;

	public PurchaseOrderSteps(TestContext context) {
		testContext=context;
		poPage = testContext.getPageObjectManager().getPurchaseOrderPage();
		header = testContext.getPageObjectManager().getHeader();
		lineItem = testContext.getPageObjectManager().getLineItem();
	}
	
	@Given("^POcreator has successfully login$")
	public void pocreator_has_successfully_login() throws Throwable {
		poPage.verifyPOPage();
	}
	
	@Given("^user is on Purchase Order creation page$")
	 public void user_is_on_Purchase_Order_creation_page() throws Throwable {
		 poPage.createPO();
	 }

	
	@When("^pocreator enters the value for \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" in header$")
	public void pocreator_enters_the_value_for_in_header(String legalentity, String vendor, String description) throws Throwable {
		header.enterLegalEntity(legalentity);
		header.enterVendor(vendor);
		header.enterDescription(description);
	}

	@When("^pocreator enters \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" in lineitem$")
	public void pocreator_enters_and_in_lineitem(String accountName, String customerName, String item, String total) throws Throwable {
		System.out.println("entering account name\n");
		lineItem.setAccount(accountName);
		lineItem.setCustomer(customerName);
		lineItem.setItem(item);
		lineItem.setTotal(total);
	}

	 @When("^user selects save po$")
	 public void user_selects_save_po() throws Throwable {
		 header.save();
	 }

	 @Then("^purchase order should be created$")
	 public void purchase_order_should_be_created() throws Throwable {
		 header.getPONumber(); 
	 }
}

