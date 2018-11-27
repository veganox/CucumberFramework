package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.Date;
import java.util.List;

public class HeaderArea {
	private WebDriver driver;
	
	public HeaderArea(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Search for a Legal Entity")
	private WebElement searchLegalEntity;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Search for a Vendor")
	private WebElement searchVendor;
	
	@FindBy(how=How.NAME, using="description")
	private WebElement descriptionHeader;
	
	@FindBy(how=How.ID, using="save")
	private WebElement saveBtn;

	@FindBy(how=How.ID, using="submitForApproval")
	private WebElement submitBtn;
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"numberContainer\"]/div/input[@value]")
	private WebElement poNumberContainer;

	@FindBy(how=How.XPATH, using ="//a[@value]")
	private WebElement poValue;
	
	public void searchLegalEntity() {
		searchLegalEntity.click();
	}
	
	public void enterLegalEntity(String legalentity) {
		searchLegalEntity();
		String legalentityxpath=".//*[text()='"+legalentity+"']";
		this.driver.findElement(By.xpath(legalentityxpath)).click();
	}
	
	public void searchVendor() {
		searchVendor.click();
	}
	
	public void enterVendor(String vendor) {
		searchVendor();
		String vendorxpath=".//*[text()='"+vendor+"']";
		this.driver.findElement(By.xpath(vendorxpath)).click();
	}
	
	public void enterDescription(String description) {
		Date date = new Date();
		description = description + "\n" + date.toString();
		System.out.println( description);
		descriptionHeader.sendKeys(description);

	}

	public void save() {
		 saveBtn.click();		
	}
	
	public void submitForApproval() {
		submitBtn.click();
	}

	public String getVal(WebElement webElement) {
	    JavascriptExecutor e = (JavascriptExecutor) driver;
	    return (String) e.executeScript(String.format("return arguments[5].value", webElement));
	}
	
	public String getPONumber() {
		//String poNumber = getVal(poNumberContainer);
		String poNumber=poNumberContainer.getAttribute("innerHTML");
		System.out.println("PO " + poNumber);
		System.out.println(poNumberContainer.getAttribute("innerText"));
		return poNumber;
	}
}
