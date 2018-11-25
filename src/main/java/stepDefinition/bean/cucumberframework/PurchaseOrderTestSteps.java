package stepDefinition.bean.cucumberframework;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 
public class PurchaseOrderTestSteps {
WebDriver driver;
 
@Given("^user is on homepage$")
public void user_is_on_homepage() throws Throwable {
 driver = new ChromeDriver();
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 driver.get("https://beandev.com");
 }

 @Given("^user enters his credentials$")
 public void user_enters_his_credentials(DataTable usercredentials) throws Throwable {
	 List<List<String>> data = usercredentials.raw();
	 driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(data.get(0).get(0));
	 driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(data.get(0).get(1));
	 driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
 }

 @Given("^user has successfully login$")
 public void user_has_successfully_login() throws Throwable {
	 driver.findElement(By.id("posModule"));
 }

 @Given("^user is on Purchase Order creation page$")
 public void user_is_on_Purchase_Order_creation_page() throws Throwable {
	 driver.findElement(By.linkText("Create")).click();
 }

 @When("^user selects legalentity \"([^\"]*)\"$")
 public void user_selects_a(String legalentity) throws Throwable {
	 driver.findElement(By.partialLinkText("Search for a Legal Entity")).click();
	 String legalentityxpath=".//*[text()='"+legalentity+"']";
	 driver.findElement(By.xpath(legalentityxpath)).click();
	 
 }
 
 @When("^user selects vendor \"([^\"]*)\"$")
 public void user_selects_vendor(String vendor) throws Throwable {
	 driver.findElement(By.partialLinkText("Search for a Vendor")).click();
	 String vendorxpath=".//*[text()='"+vendor+"']";
	 driver.findElement(By.xpath(vendorxpath)).click();
 }

 @When("^user enters \"([^\"]*)\" under header description$")
 public void user_enters_under_header_description(String description_text) throws Throwable {
	 driver.findElement(By.name("description")).sendKeys(description_text);	 
 }

 @When("^user sets Billable to \"([^\"]*)\"$")
 public void user_sets_Billable_to(String billable) throws Throwable {
	 WebElement setBillable = driver.findElement(By.xpath("(.//span[@class=\"cell-value\"])[4]"));
	 Actions actions = new Actions(driver);
	 actions.moveToElement(setBillable);
	 actions.doubleClick();
	 actions.sendKeys(billable).perform();
	 driver.findElement(By.xpath(".//div[@class='Select-option is-focused']")).click();
 }

 @When("^user sets Customer to \"([^\"]*)\"$")
 public void user_sets_Customer_to(String customer) throws Throwable {
	 WebElement setCustomer = driver.findElement(By.xpath("(.//span[@class=\"cell-value\"])[6]"));
	 Actions actions = new Actions(driver);
	 actions.moveToElement(setCustomer);
	 actions.doubleClick();
	 actions.sendKeys(customer).perform();
	 driver.findElement(By.xpath(".//div[@class='Select-option is-focused']")).click();
 }

 @When("^user sets Total to \"([^\"]*)\"$")
 public void user_sets_Total_to(String total) throws Throwable {
	 // xpath for lineitem account: (//span[@class="cell-value"])[3]
	 WebElement poTotal = driver.findElement(By.xpath("(.//span[@class=\"cell-value cell-currency\"])[last()]"));
	 Actions actions = new Actions(driver);
	 actions.moveToElement(poTotal);
	 actions.click();
	 actions.sendKeys(total).perform();
}

 
 @When("^user selects save$")
 public void user_selects_save() throws Throwable {
	 driver.findElement(By.id("save")).click();
 }

 @Then("^purchase order should be created$")
 public void purchase_order_should_be_created() throws Throwable {

 }

 @Then("^image buttons should appear$")
 public void image_buttons_should_appear() throws Throwable {
	 driver.findElement(By.id("imagePanesContainer"));
	 driver.quit();
 }

}
