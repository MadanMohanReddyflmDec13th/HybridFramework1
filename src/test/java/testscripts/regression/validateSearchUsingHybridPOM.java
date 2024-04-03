package testscripts.regression;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;
import utils.UtilKit;

public class validateSearchUsingHybridPOM extends BaseTest{
	
	@Test(dataProvider = "getData")
	public void validateSearchHotel(HashMap<String, String> dataMap)
	{
		LoginPage lp=new LoginPage();
		
		lp.username_textbox(dataMap.get("username"));
		lp.password_textbox(dataMap.get("password"));
		lp.login_button();
		
		SearchHotelPage searchHotelPage= new SearchHotelPage ();
		
		 searchHotelPage.verifyTitle(dataMap.get("Expected Title1"));
		 searchHotelPage.welcomeMenuText(dataMap.get("Welcome Text"));
		 searchHotelPage.locationDropdown(dataMap.get("Location"));
		 searchHotelPage.checkInDateTextbox(dataMap.get("Check In Date"));
		 searchHotelPage.checkOutDateTextbox(dataMap.get("Check Out Date"));
		 searchHotelPage.searchButton();
		 
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object [1][1];
		data[0][0]=UtilKit.getTestDataFromExcel("TC-102");
		
		return data;
		
	}
}
