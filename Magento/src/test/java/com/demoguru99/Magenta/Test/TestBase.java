package com.demoguru99.Magenta.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import com.demoguru99.Magenta.Util.ConfigurationReader;
import com.demoguru99.Magenta.Util.Driver;



public class TestBase {

	private WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(@Optional String browser) {
		driver = Driver.getDriver(browser);
		driver.get(ConfigurationReader.getProperty("url"));
		
	}

	@BeforeTest
	public void pause() throws InterruptedException
	{
		//driver = Driver.getDriver();
		Thread.sleep(100);
		
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		Driver.closeDriver();
		//report.endTest(test);	
		
	}

	
	
}
