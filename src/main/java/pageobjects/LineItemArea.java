package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LineItemArea {
	private WebDriver driver;
	
	public LineItemArea(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH, using="(.//span[@class=\"cell-value\"])[3]")
	private WebElement account;
	
	@FindBy(how=How.XPATH, using="(.//span[@class=\"cell-value\"])[6]")
	private WebElement customer;

	@FindBy(how=How.XPATH, using="(.//span[@class=\"cell-value\"])[7]")
	private WebElement item;

	@FindBy(how=How.XPATH, using="(.//span[@class=\"cell-value cell-currency\"])[last()]")
	private WebElement total;
	
	@FindBy(how=How.XPATH, using =".//div[@class='Select-option is-focused']")
	private WebElement selectLineItemList;
	
	@FindBy(how=How.XPATH, using=".//div[@class='enable-wildcard action']")
	private WebElement wildcard;
	
	public void setAccount(String accountName) {
		System.out.println("setting account name");
		Actions actions = new Actions(this.driver);
		actions.moveToElement(account);
		actions.doubleClick().perform();
		System.out.println("finding wildcard");
		wildcard.click();
		System.out.println("found wildcard");
		actions.sendKeys(accountName).perform();
		selectLineItemList.click();
	}

	public void setCustomer(String customerName) {
		System.out.println("setting customer name");
		Actions actions = new Actions(this.driver);
		actions.moveToElement(customer);
		actions.doubleClick();
		actions.sendKeys(customerName).perform();
		selectLineItemList.click();
	}
	
	public void setItem(String itemName) {
		System.out.println("setting Item");
		Actions actions = new Actions(this.driver);
		actions.moveToElement(item);
		actions.doubleClick();
		actions.sendKeys(itemName).perform();
		selectLineItemList.click();
	}

	public void setTotal(String totalValue) {
		System.out.println("setting total");
		Actions actions = new Actions(this.driver);
		actions.moveToElement(total);
		actions.click();
		actions.sendKeys(totalValue).perform();
	}

}
