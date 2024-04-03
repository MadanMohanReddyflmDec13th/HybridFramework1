package testscripts.regression;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class ToVerifyInvalidLoginDetails extends BaseTest {

	@Test
	public void ToVerifyInValidUsernameValidPassword() 
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Madan");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Madan123");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
	}
	
	@Test
	public void toVerifyValidUserNameInValidPassword()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("MadanReddy");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Madan111");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
	}
	
	@Test
	public void toVerifyInValidUserNameInValidPassword()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Madan");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Madan111");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
	}

	
}

