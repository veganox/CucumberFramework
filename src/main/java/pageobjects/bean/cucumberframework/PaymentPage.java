package pageobjects.bean.cucumberframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	public PaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH, using="//span[contains(text(),'Payment Number')]")
	private WebElement paymentPage;
	
	public void verifyPaymentPage() {
		paymentPage.isDisplayed();
	}
}
