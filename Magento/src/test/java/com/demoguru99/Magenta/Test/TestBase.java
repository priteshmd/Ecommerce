package com.demoguru99.Magenta.Test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.demoguru99.Magenta.Util.ConfigurationReader;
import com.demoguru99.Magenta.Util.Driver;



public class TestBase {

	protected WebDriver driver;
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(@Optional String browser) {
		driver =  Driver.getDriver(browser);
		driver.get(ConfigurationReader.getProperty("url"));
		log.debug("Open home page");
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
		log.debug("browser closed");
		//report.endTest(test);	
		
	}

	
	
}
