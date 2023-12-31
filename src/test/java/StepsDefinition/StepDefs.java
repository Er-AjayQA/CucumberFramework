package StepsDefinition;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObject.CreateCustomerPage;
import PageObject.CustomersListPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import Utilities.ExcelFileUtilities;
import Utilities.JavaUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefs {

	public WebDriver driver;
	public LoginPage loginPg;
	public HomePage homePg;
	public CustomersListPage clPg;
	public CreateCustomerPage ccPg;
	public ExcelFileUtilities eUtil= new ExcelFileUtilities();;
	public JavaUtilities jutil= new JavaUtilities();;

	@When("User Will Launch Browser")
	public void user_will_launch_browser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		loginPg = new LoginPage(driver);
	}

	@When("User Will Open Url {string}")
	public void user_will_open_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	@When("User Will Enter Email as {string} and Password as {string}")
	public void user_will_enter_email_as_and_password_as(String userEmail, String userPassword) {
		loginPg.enterUserEmail(userEmail);
		loginPg.enterUserPassword(userPassword);
	}

	@When("User Will Click on Login button")
	public void user_will_click_on_login_button() {
		loginPg.clickOnLoginButton();
	}

	@Then("HomePage Title Should be {string}")
	public void homepage_title_should_be(String expectedHomePageTitle) {
		String actualHomePageTitle = driver.getTitle();
		loginPg.validatePageTitle(expectedHomePageTitle, actualHomePageTitle);
	}

	@When("User Will Click on Logout link")
	public void user_will_click_on_logout_link() {
		homePg= new HomePage(driver);
		homePg.logoutFromApp();
	}

	@Then("LoginPage Title Should be {string}")
	public void loginpage_title_should_be(String expectedLoginPgTitle) {
		String actualLoginPgTitle = driver.getTitle();
		homePg.validatePageTitle(expectedLoginPgTitle, actualLoginPgTitle);
	}

	@Then("User Will Close the Browser")
	public void user_will_close_the_browser() {
		driver.close();
		driver.quit();
	}
	
	///////////// Add Customer /////////////
	
	@When("User expands the Customers menu tab and click on Customers from submenus")
	public void user_expands_the_customers_menu_tab_and_click_on_customers_from_submenus() {
		homePg= new HomePage(driver);
		homePg.navigateToCustomerPage();
	}

	@Then("User lands on Customers Page {string}")
	public void user_lands_on_customers_page(String expectedCustomerPgTitle) {
		String actualCustomerPgTitle= driver.getTitle();
		clPg= new CustomersListPage(driver);
		clPg.validatePageTitle(expectedCustomerPgTitle, actualCustomerPgTitle);
	}

	@When("User clicks on the Add New button")
	public void user_clicks_on_the_add_new_button() {		
		clPg.navigateToCreateNewCustomerPage();
	}

	@Then("User lands on the Create Customer Page {string}")
	public void user_lands_on_the_create_customer_page(String expectedCreateCustomerPgTitle) {
		String actualCreateCustomerPgTitle= driver.getTitle();
		ccPg= new CreateCustomerPage(driver);
		ccPg.validatePageTitle(expectedCreateCustomerPgTitle, actualCreateCustomerPgTitle);
	}

	@When("User enters the customers info in the form")
	public void user_enters_the_customers_info_in_the_form() throws EncryptedDocumentException, IOException {
		String email= eUtil.getDataFromExcelFile("Customers", 3, 0)+jutil.getRandomNumber()+"@gmail.com";
		String password= eUtil.getDataFromExcelFile("Customers", 3, 1)+jutil.getRandomNumber();
		String firstName= eUtil.getDataFromExcelFile("Customers", 3, 2)+jutil.getRandomNumber();
		String lastName= eUtil.getDataFromExcelFile("Customers", 3, 3)+jutil.getRandomNumber();
		String gender= eUtil.getDataFromExcelFile("Customers", 3, 4);
		String dob= eUtil.getDataFromExcelFile("Customers", 3, 5);
		String companyName= eUtil.getDataFromExcelFile("Customers", 3, 6)+jutil.getRandomNumber();
		String taxStatus= eUtil.getDataFromExcelFile("Customers", 3, 7);
		String vendorName= eUtil.getDataFromExcelFile("Customers", 3, 8);
		String activeStatus= eUtil.getDataFromExcelFile("Customers", 3, 9);
		ccPg.createCustomer(email, password, firstName, lastName, gender, dob, companyName, taxStatus, vendorName, activeStatus);
		
	}

	@When("user Clicks on Save button")
	public void user_clicks_on_save_button() {
		ccPg.clickOnSaveButton();
	}

	@Then("User can view the Confirmation Message {string}")
	public void user_can_view_the_confirmation_message(String string) throws EncryptedDocumentException, IOException {
		String expectedMsg= eUtil.getDataFromExcelFile("Customers", 3, 10);
		ccPg.validateAlertMessage(expectedMsg);
	}

	@Then("user closes the browser")
	public void user_closes_the_browser() {
		driver.close();
		driver.quit();
	}

}
