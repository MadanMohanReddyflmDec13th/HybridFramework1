package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static FileInputStream fis1;
	public static Properties configprop;
	public static FileInputStream fis2;
	public static Properties locatorsprop;
	
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@AfterTest
	public void closeReports()
	{
		if(reports!=null)
		{
			reports.flush();
		}
	}
	
	@BeforeTest
	public void fileSetUp() throws IOException {
		
		
		
		fis1=new FileInputStream("src\\test\\resources\\properties\\config.properties");
		configprop=new Properties();
		configprop.load(fis1);
		
		fis2=new FileInputStream("src\\test\\resources\\properties\\locators.properties");
		locatorsprop=new Properties();
		locatorsprop.load(fis2);
		
		reports=ExtentManager.getReports();
		
	}
	
	@BeforeMethod
	public void setUp(ITestContext context) 
	{
		
		//test =reports.createTest("Login Test");
		test =reports.createTest(context.getCurrentXmlTest().getClasses().get(0).getName());
		
		String browserName=configprop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			test.info("Chrome browser started");
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			test.info("Firefox browser started");
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			test.info("Edge browser started");
		}
		
		driver.get(configprop.getProperty("url"));
		test.info("Application launched using url"+configprop.getProperty("url"));
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configprop.getProperty("implicitwait"))));
	}
	
	
	@AfterMethod
	public void teardown()
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
