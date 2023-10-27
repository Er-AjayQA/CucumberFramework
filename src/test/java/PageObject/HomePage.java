package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	WebDriver ldriver;

	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[text()=\"Logout\"]")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	private WebElement customerMenuButton;
	
	@FindBy(xpath = "//a[contains(@href,'/Admin/Customer/List')]//p[contains(text(),'Customers')]")
	private WebElement customerSubMenuButton;

	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	public WebDriver getLdriver() {
		return ldriver;
	}

	public WebElement getCustomerMenuButton() {
		return customerMenuButton;
	}

	public WebElement getCustomerSubMenuButton() {
		return customerSubMenuButton;
	}



	/* Business Libraries */
	
	public void navigateToCustomerPage() {
		customerMenuButton.click();
		customerSubMenuButton.click();
	}
	
	public void logoutFromApp() {
		logoutButton.click();
	}

	public void validatePageTitle(String expectedTitle, String actualTitle) {
		Assert.assertEquals(actualTitle, expectedTitle);
	}
}
