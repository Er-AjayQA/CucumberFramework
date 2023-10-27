package PageObject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.WebDriverUtilities;

public class CreateCustomerPage extends WebDriverUtilities{

	WebDriver ldriver;
	
	public CreateCustomerPage(WebDriver sdriver) {
		ldriver= sdriver;
		PageFactory.initElements(sdriver, this);
	}
	
	@FindBy(id="Email") private WebElement emailTextField;
	@FindBy(id="Password") private WebElement passwordTextField;
	@FindBy(id="FirstName") private WebElement firstNameTextField;
	@FindBy(id="LastName") private WebElement lastNameTextField;
	@FindBy(xpath="//input[@type=\"radio\"]") private List<WebElement> genderRadioButton;
	@FindBy(id="DateOfBirth") private WebElement dobTextField;
	@FindBy(id="Company") private WebElement companyNameTextField;
	@FindBy(xpath="//input[@type=\"checkbox\" and @id=\"IsTaxExempt\"]") private WebElement taxCheckbox;
	@FindBy(id="VendorId") private WebElement managerOfVendorsDropdown;
	@FindBy(id="Active") private WebElement activeCheckbox;
	@FindBy(id="AdminComment") private WebElement adminCommentTextField;
	@FindBy(xpath="//button[@type=\"submit\" and @name=\"save\"]") private WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-success')]") private WebElement alertBox;
	
	
	public WebDriver getLdriver() {
		return ldriver;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public List<WebElement> getGenderRadioButton() {
		return genderRadioButton;
	}

	public WebElement getDobTextField() {
		return dobTextField;
	}

	public WebElement getCompanyNameTextField() {
		return companyNameTextField;
	}

	public WebElement getTaxCheckbox() {
		return taxCheckbox;
	}

	public WebElement getManagerOfVendorsDropdown() {
		return managerOfVendorsDropdown;
	}

	public WebElement getActiveCheckbox() {
		return activeCheckbox;
	}

	public WebElement getAdminCommentTextField() {
		return adminCommentTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getAlertBox() {
		return alertBox;
	}


	public void createCustomer(String email, String password, String firstName, String lastName, String gender, String dob, String companyName, String taxStatus, String vendor, String activeStatus) {
		emailTextField.sendKeys(email);
		passwordTextField.sendKeys(password);
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		
		for(WebElement genderText: genderRadioButton) {
			String genderchar= genderText.getAttribute("value");
			if(genderchar.contains(gender)) {
				genderText.click();
				break;
			}
		}
		
		dobTextField.sendKeys(dob);
		companyNameTextField.sendKeys(companyName);
		
		if(taxStatus.equalsIgnoreCase("De-Select")) {
			taxCheckbox.click();
		}
		
		selectFromDropDownByText(managerOfVendorsDropdown, vendor);
		
		if(activeStatus.equalsIgnoreCase("Select")) {
			activeCheckbox.click();
		}	
		
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	public void validatePageTitle(String expectedTitle, String actualTitle) {
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	public void validateAlertMessage(String expectedMessage) {
		String actualMessage= alertBox.getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}

}
