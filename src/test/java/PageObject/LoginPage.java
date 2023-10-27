package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage{
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@id=\"Email\" and @name=\"Email\"]")
	private WebElement emailTextField;
	@FindBy(xpath = "//input[@id=\"Password\" and @name=\"Password\"]")
	private WebElement passwordTextField;
	@FindBy(xpath = "//input[@id=\"RememberMe\" and @type=\"checkbox\"]")
	private WebElement rememberMeCheckBox;
	@FindBy(xpath = "//button[text()=\"Log in\" and @type=\"submit\"]")
	private WebElement loginButton;

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getRememberMeCheckBox() {
		return rememberMeCheckBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	
	/* Business Libraries */
	public void enterUserEmail(String userEmail) {
		emailTextField.clear();
		emailTextField.sendKeys(userEmail);
	}

	public void enterUserPassword(String userPassword) {
		passwordTextField.clear();
		passwordTextField.sendKeys(userPassword);
	}

	public void clickOnRememberMeCheckbox() {
		rememberMeCheckBox.click();
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void validatePageTitle(String expectedTitle, String actualTitle) {
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
