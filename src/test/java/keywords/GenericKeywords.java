package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import base.BaseTest;

public class GenericKeywords extends BaseTest{
	
	public void openBrowser()
	{
		String browserName=configprop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		
		driver.get(configprop.getProperty("url"));
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configprop.getProperty("implicitwait"))));
	}
	
	public void launchApp()
	{
		driver.get(configprop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configprop.getProperty("implicitwait"))));
	}
	
	public void type(String locatorkey,String text)
	{
		getElement(locatorkey).sendKeys(text);
	}
	
	public void click(String locatorkey)
	{
		getElement(locatorkey).click();
	}
	
	public WebElement getElement(String locatorkey)
	{
		WebElement element=null;
		element=driver.findElement(getLocator(locatorkey));
		
		return element;
	}
	
	public By getLocator(String locatorkey)
	{
		By by=null;
		
		if (locatorkey.endsWith("_id"))
		{
			by=By.id(locatorsprop.getProperty(locatorkey));
		}
		else if (locatorkey.endsWith("_name"))
		{
			by=By.name(locatorsprop.getProperty(locatorkey));
		}
		else if (locatorkey.endsWith("_linkText"))
		{
			by=By.linkText(locatorsprop.getProperty(locatorkey));
		}
		else 
		{
			by=By.xpath(locatorsprop.getProperty(locatorkey));
		}
		
		return by;
		
	}
	
	public void closeBrowser() 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
