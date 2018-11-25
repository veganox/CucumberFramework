package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {
	public PurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH, using="//span[contains(text(),'PO Number')]")
	private WebElement poPage;
	
	public void verifyPOPage() {
		poPage.isDisplayed();
	}
	
	
}
