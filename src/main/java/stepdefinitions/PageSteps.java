package stepdefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageobjects.InvoicePage;
import pageobjects.PurchaseOrderPage;
import pageobjects.PaymentPage;

public class PageSteps {

	TestContext testContext;
	InvoicePage invoicePage;
	PurchaseOrderPage poPage;
	PaymentPage paymentPage;
	
	public PageSteps(TestContext context) {
		testContext=context;
		invoicePage = testContext.getPageObjectManager().getInvoicePage();
	}
	
	@Then("^user logins to \"([^\"]*)\" successfully$")
	public void user_logins_to_successfully(String module) throws Throwable {
		System.out.println(module);
		if (module.equals("invoice")) {
			invoicePage.verifyInvoicePage();
			System.out.println("Login Successfully");
		} else if (module.equals("purchaseorder")) {
			poPage.verifyPOPage();
			System.out.println("Login Successfully");
		} else if (module.equals("payment")) {
			paymentPage.verifyPaymentPage();
			System.out.println("Login Successfully");
		}
	}

}
