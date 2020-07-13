package com.demoguru99.Magenta.Util;

import org.openqa.selenium.WebDriver.Timeouts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import okio.Timeout;

public class BrowserUtilities {

	public BrowserUtilities() {
		
	}
	
	public static void pageNavigateBack()
	{
		Driver.getDriver().navigate().back();
	}
	
	public static void waitForElementToAppear(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
		wait.until (ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElementToAppear(By locator)
	{
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
		wait.until (ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static void waitForElementToClick(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
		wait.until (ExpectedConditions.elementToBeClickable(element));
	}
	public static void pageUrlContains(String s)
	{
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
		wait.until (ExpectedConditions.urlContains(s));
	}
	public static void selectByVisibleText(WebElement element, String s)
	{
		Select select = new Select(element);
		select.selectByVisibleText(s);
	}
	
	public static void scrollDown() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(300);
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(300);
		js.executeScript("window.scrollBy(0,100)");
	}
	public static void implicitlyWait(int x)
	{
		Driver.getDriver().manage().timeouts().implicitlyWait(x, TimeUnit.SECONDS);
	}
}

