package com.demoguru99.Magenta.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {

	private static WebDriver driver;
	
	private Driver() {
		
	}
	
	public static WebDriver getDriver(String brows)
	{
		if (brows == null) {
			brows = ConfigurationReader.getProperty("browser");
		}

		//String browser = ConfigurationReader.getProperty("browser");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("start-maximized");
		if(driver == null)
		{
			switch(brows)
			{
				case "firefox":
					driver = new FirefoxDriver();
					break;
					
				case "chrome":
					driver = new ChromeDriver(op);
					break;
					
				case "IE":
					driver = new InternetExplorerDriver();
					break;
					
				case "Edge":
					driver = new EdgeDriver();
					break;
					
				default:
					driver = null;
			}
			
		}
		
		return driver;
	}
	public static WebDriver getDriver()
	{
		return getDriver(null);
	}
	public static void closeDriver() {
		if(driver!= null)
		{
			driver.quit();
			driver = null;
		}
	}
}
