package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {
	public InvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Invoice Number')]")
	private WebElement invoicePage;
	
	public void verifyInvoicePage() {
		invoicePage.isDisplayed();
	}
}
