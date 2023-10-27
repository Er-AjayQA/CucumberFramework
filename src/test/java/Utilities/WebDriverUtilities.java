package Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtilities {
	
	public void selectFromDropDownByText(WebElement selElement, String optionText) {
		Select sel= new Select(selElement);
		sel.selectByVisibleText(optionText);
	}

}
