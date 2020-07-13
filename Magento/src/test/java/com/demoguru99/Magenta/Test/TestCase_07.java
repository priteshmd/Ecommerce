package com.demoguru99.Magenta.Test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoguru99.Magenta.Pages.AccountPage;
import com.demoguru99.Magenta.Pages.CartPage;
import com.demoguru99.Magenta.Pages.Checkout;
import com.demoguru99.Magenta.Pages.HomePage;
import com.demoguru99.Magenta.Util.BrowserUtilities;
import com.demoguru99.Magenta.Util.ConfigurationReader;

public class TestCase_07 extends TestBase{

	@Test
	public void TestReOrder() throws InterruptedException
	{
		new HomePage().goToLoginPage(ConfigurationReader.getProperty("email", "Email.properties"), "password");
		CartPage cp = new AccountPage().ReOrderProduct();
		BrowserUtilities.implicitlyWait(10);
		BrowserUtilities.waitForElementToAppear(cp.txtquantityOfTV);
		cp.txtquantityOfTV.clear();
		BrowserUtilities.waitForElementToAppear(cp.btnUpdateQtyforTV);
		Double price1 = cp.getGrandTotal();
		cp.txtquantityOfTV.sendKeys("10");
		cp.btnUpdateQtyforTV.click();
//		Thread.sleep(1500);
		Double price2 = cp.getGrandTotal();
		Assert.assertFalse(price2 == price1);
		Assert.assertTrue(cp.verifyTotal(),"Grand Total not updated!");
//		Thread.sleep(1500);
		BrowserUtilities.scrollDown();
		BrowserUtilities.waitForElementToClick(cp.btnProceedToCheckout);
		cp.btnProceedToCheckout.click();
//		Thread.sleep(1500);
		
		Checkout ck = new Checkout();
		BrowserUtilities.waitForElementToClick(ck.btnContinueAfterBilling);
		ck.btnContinueAfterBilling.click();
		BrowserUtilities.scrollDown();
//		Thread.sleep(1500);
		BrowserUtilities.waitForElementToClick(ck.btnContinueAfterShipping);
		ck.btnContinueAfterShipping.click();
		BrowserUtilities.scrollDown();
//		Thread.sleep(1500);
		ck.enterPaymentInfo();
//		Thread.sleep(3500);
		
		String orderId = ck.verifyOrder(ConfigurationReader.getProperty("ordersuccessMsg1"), ConfigurationReader.getProperty("ordersuccessMsg2"));
		System.out.println(orderId);
		
	}
}
