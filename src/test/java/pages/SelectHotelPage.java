package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectHotelPage extends BasePage {

	@FindBy(xpath="//input[@name='radiobutton_1']")
	WebElement radioButton1;
	
	@FindBy(xpath="//input[@name='continue']")
	WebElement continueButton;
	
	
	public void radioButton1()
	{
		click(radioButton1);
	}
	
	public void continueButton()
	{
		click(continueButton);
	}
	
}
