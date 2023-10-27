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

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	/* Business Libraries */
	public void logoutFromApp() {
		logoutButton.click();
	}

	public void validatePageTitle(String expectedTitle, String actualTitle) {
		Assert.assertEquals(actualTitle, expectedTitle);
	}
}
