package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BasePage{
	
	public SearchHotelPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//td[@class='welcome_menu']")
	WebElement welcomeMenuText;
	
	@FindBy(xpath="//select[@name='location']")
	WebElement locationDropdown ;
	
	@FindBy(xpath="//select[@name='hotels']")
	WebElement hotelsDropdown ;
	
	@FindBy(xpath="//select[@name='room_type']")
	WebElement roomTypeDropdown ;
	
	@FindBy(xpath="//select[@name='room_nos']")
	WebElement noOfRoomsDropdown ;
	
	@FindBy(xpath="//input[@name='datepick_in']")
	WebElement checkInDateTextbox;
	
	@FindBy(xpath="//input[@name='datepick_out']")
	WebElement checkOutDateTextbox;
	
	@FindBy(xpath="//select[@name='adult_room']")
	WebElement adultsPerRoomDropdown;
	
	@FindBy(xpath="//select[@name='child_room']")
	WebElement childrenPerRoomDropdown;
	
	@FindBy(xpath="//input[@name='Submit']")
	WebElement searchButton ;
	
	
	
	public void welcomeMenuText(String text)
	{
		verifyText(welcomeMenuText, text);
	}
	
	public void locationDropdown(String text)
	{
		selectFromDropdown(locationDropdown, text);
	}
	
	public void checkInDateTextbox(String date)
	{
		checkInDateTextbox.clear();
		type(checkInDateTextbox,date);
	}
	
	public void checkOutDateTextbox(String text)
	{
		checkOutDateTextbox.clear();
		type(checkOutDateTextbox,text);
	}
	
	public void adultsPerRoomDropdown(String option)
	{
		selectFromDropdown(adultsPerRoomDropdown, option);
	}
	
	public void searchButton()
	{
		click(searchButton);
	}
	
}



