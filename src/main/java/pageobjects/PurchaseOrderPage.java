package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {
	public PurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.ID, using="posModule")
	private WebElement posModule;

	@FindBy(how=How.XPATH, using="//span[contains(text(),'PO Number')]")
	private WebElement poNumber;
	
	@FindBy(how=How.LINK_TEXT, using="Create")
	private WebElement createPO;
		
	public void verifyPOPage() {
		posModule.isDisplayed();
		poNumber.isDisplayed();
	}
	
	public void createPO() {
		createPO.click();
	}
	
	
}
