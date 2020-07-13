package com.demoguru99.Magenta.Test;

import java.awt.event.KeyEvent;

import org.apache.commons.collections4.trie.KeyAnalyzer;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoguru99.Magenta.Pages.AccountPage;
import com.demoguru99.Magenta.Pages.HomePage;
import com.demoguru99.Magenta.Util.BrowserUtilities;
import com.demoguru99.Magenta.Util.ConfigurationReader;
import com.demoguru99.Magenta.Util.Driver;
import com.demoguru99.Magenta.Util.EmailIdGenerator;

public class TestCase_07 extends TestBase {
	
	@Test
	public void TestOrderPdf()
	{
		AccountPage ap = new HomePage().goToLoginPage(ConfigurationReader.getProperty("email", "Email.properties"), "password");
		BrowserUtilities.waitForElementToClick(ap.lnkMyOrders);
		ap.lnkMyOrders.click();
		Assert.assertEquals(ap.txtOrderStatus.getText(), "Pending");
		BrowserUtilities.waitForElementToClick(ap.lnkViewOrder);
		ap.lnkViewOrder.click();
		BrowserUtilities.waitForElementToClick(ap.lnkPrintOrder);
		String printUrl = ap.lnkPrintOrder.getAttribute("href");

	    Driver.getDriver().navigate().to(printUrl);
		
	}
}
