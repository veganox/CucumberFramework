package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.NAME, using="username")
	private WebElement username;
	
	@FindBy(how=How.NAME, using="password")
	private WebElement password;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Sign In')]")
	private WebElement signinBtn;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"settings\"]")
	private WebElement settings;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"signOut\"]")
	private WebElement signout;
	
	public void enterUsername(String username) {
		this.username.sendKeys(username);
	}
	public void enterPassword(String pwd) {
		this.password.sendKeys(pwd);
	}
	public void clickSignIn() {
		this.signinBtn.click();
	}
	public void selectSettings() {
		settings.click();
	}
	public void selectSignOut() {
		signout.click();
	}
}
