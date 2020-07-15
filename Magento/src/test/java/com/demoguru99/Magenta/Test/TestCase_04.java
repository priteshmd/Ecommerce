package com.demoguru99.Magenta.Test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoguru99.Magenta.Pages.HomePage;
import com.demoguru99.Magenta.Pages.MobilePage;
import com.demoguru99.Magenta.Util.BrowserUtilities;
import com.demoguru99.Magenta.Util.ConfigurationReader;
import com.demoguru99.Magenta.Util.Driver;

public class TestCase_04 extends TestBase{

	private WebDriver driver = Driver.getDriver();
	@Test
	public void TestCompareMobiles() throws InterruptedException
	{
		HomePage hp = new HomePage();
		hp.lnkMobile.click();
		
		MobilePage mp = new MobilePage();
		mp.lnkSonyCompare.click();
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
		wait.until (ExpectedConditions.visibilityOf(mp.msgSuccess));
		Assert.assertEquals(mp.msgSuccess.getText(), ConfigurationReader.getProperty("successMsgSony"));
		
		wait.until (ExpectedConditions.visibilityOf(mp.msgSuccess));
		Thread.sleep(2000);
		mp.lnkIphoneCompare.click();
		Thread.sleep(2000);
		
		Assert.assertEquals(mp.msgSuccess.getText(), ConfigurationReader.getProperty("successMsgIphone"));
		
//		String w1 = driver.getWindowHandle();
		//System.out.println(w1);
		mp.btnCompare.click();
		Thread.sleep(2000);
		/*
		 * Set<String> windows = driver.getWindowHandles(); Iterator<String> itr =
		 * windows.iterator(); String w = w1; while(itr.hasNext()) { w = itr.next(); if
		 * (w == w1) break; } //System.out.println(w); driver.switchTo().window(w);
		 */
		BrowserUtilities.switchToNewWindow();
		Thread.sleep(1000);
		driver.manage().window().maximize();
		WebElement btnClose = driver.findElement(By.xpath("//span[contains(text(),'Close Window')]"));
		wait.until(ExpectedConditions.elementToBeClickable(btnClose));
		btnClose.click();
		//mp.closePopup.click();
		
		
		
	}
}
