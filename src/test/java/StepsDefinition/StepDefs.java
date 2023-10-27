package StepsDefinition;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.HomePage;
import PageObject.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefs {

	public WebDriver driver;
	public LoginPage loginPg;
	public HomePage homePg;

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

	}

	@Then("User lands on Customers Page")
	public void user_lands_on_customers_page() {

	}

	@When("User clicks on the Add New button")
	public void user_clicks_on_the_add_new_button() {

	}

	@Then("User lands on the Create Customer Page")
	public void user_lands_on_the_create_customer_page() {

	}

	@When("User enters the customers info in the form")
	public void user_enters_the_customers_info_in_the_form() {

	}

	@When("user Clicks on Save button")
	public void user_clicks_on_save_button() {

	}

	@Then("User can view the Confirmation Message {string}")
	public void user_can_view_the_confirmation_message(String string) {

	}

	@Then("user closes the browser")
	public void user_closes_the_browser() {

	}

}
