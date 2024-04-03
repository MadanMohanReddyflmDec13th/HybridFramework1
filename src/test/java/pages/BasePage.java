package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BaseTest;

public class BasePage extends BaseTest {
	
	public void verifyTitle(String expTitle) 
	{
		Assert.assertEquals(driver.getTitle(),expTitle);
		test.info("Assertion passed...");
	}
	
	public void verifyText(WebElement element,String expText)
	{
		Assert.assertEquals(element.getText(), expText);
		test.info("Text Verified...both are same...");
	}
	
	public void type(WebElement element,String text)
	{
		element.sendKeys(text);
		test.info("Entered text"+text+"into textbox "+element);
	}
	
	public void click(WebElement element)
	{
		element.click();
		test.info("Clicked the element "+element);
	}
	
	public void clear(WebElement element)
	{
		element.clear();
		test.info("Cleared the element "+element);
	}
	
	public void selectFromDropdown(WebElement element,String option)
	{
		Select drop=new Select(element);
		drop.selectByVisibleText(option);
		test.info("Selected option "+option +"from dropdown "+element);
	}
	
	public static String screenShot()
	{
		String screenShotsFolderPath =System.getProperty("user.dir")+"\\ScreenShorts";
		File screenShotsFolder =new File(screenShotsFolderPath);
		screenShotsFolder.mkdir();
		

		Date d=new Date();
		System.out.println(d);
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(d);
		System.out.println(date);
		
		date=date.replace(":","-");
		System.out.println(date);
		
		String screenShotFilePath=screenShotsFolderPath+"\\"+date+".png";
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(screenShotFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return screenShotFilePath ;
		
	}
	
	
}


