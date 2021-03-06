package stepDefinition.bean.cucumberframework;

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
		poPage = testContext.getPageObjectManager().getPurchaseOrderPage();
		paymentPage = testContext.getPageObjectManager().getPaymentPage();
	}
	
	@Then("^user should login to \"([^\"]*)\" successfully$")
	public void user_should_login_to_successfully(String module) throws Throwable {
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
