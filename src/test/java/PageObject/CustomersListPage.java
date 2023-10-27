package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomersListPage {

	WebDriver ldriver;

	public CustomersListPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'/Admin/Customer/Create')]")
	private WebElement addNewButton;

	public WebDriver getLdriver() {
		return ldriver;
	}

	public WebElement getAddNewButton() {
		return addNewButton;
	}
	
	public void navigateToCreateNewCustomerPage(){
		addNewButton.click();
	}
	
	public void validatePageTitle(String expectedTitle, String actualTitle) {
		Assert.assertEquals(actualTitle, expectedTitle);
	}
}
