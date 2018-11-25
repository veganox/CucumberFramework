package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import managers.FileReaderManager;


public class HomePage {
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void gotoHomePage() {
		this.driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
}
