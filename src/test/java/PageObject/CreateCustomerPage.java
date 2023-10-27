package PageObject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


}
