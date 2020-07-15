package com.demoguru99.Magenta.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.demoguru99.Magenta.Util.BrowserUtilities;

public class listener extends TestBase implements ITestListener {

	
	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
//			
			driver = (WebDriver) result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			BrowserUtilities.getScreenShot(testMethodName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
