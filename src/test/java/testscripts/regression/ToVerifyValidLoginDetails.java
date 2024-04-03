package testscripts.regression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

public class ToVerifyValidLoginDetails extends BaseTest {
	
	@Test
	public void toVerifyValidLoginDetailsTest()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("MadanReddy");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Madan123");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		Assert.assertEquals(driver.getTitle(),"Adactin.com - Search Hotel");
	}
	
	
	}

