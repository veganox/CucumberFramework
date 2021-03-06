package managers;

import org.openqa.selenium.WebDriver;

import pageobjects.*;

public class PageObjectManager {
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private InvoicePage invoicePage;
	private PurchaseOrderPage purchaseOrderPage;
	private PaymentPage paymentPage;
	private HeaderArea header;
	private LineItemArea lineItem;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public HomePage getHomePage() {
		return (homePage==null) ? new HomePage(driver) : homePage;
	}
	
	public LoginPage getLoginPage() {
		return (loginPage==null) ? new LoginPage(driver) : loginPage;
	}

	public InvoicePage getInvoicePage() {
		return (invoicePage==null) ? new InvoicePage(driver) : invoicePage;
	}

	public PurchaseOrderPage getPurchaseOrderPage() {
		return (purchaseOrderPage==null) ? new PurchaseOrderPage(driver) : purchaseOrderPage;
	}

	public PaymentPage getPaymentPage() {
		return (paymentPage==null) ? new PaymentPage(driver) : paymentPage;
	}
	
	public HeaderArea getHeader() {
		return (header==null) ? new HeaderArea(driver) : header;
	}

	public LineItemArea getLineItem() {
		return (lineItem==null) ? new LineItemArea(driver) : lineItem;
	}
}
