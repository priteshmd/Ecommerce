package com.demoguru99.Magenta.Test;

import java.awt.Checkbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoguru99.Magenta.Pages.AccountPage;
import com.demoguru99.Magenta.Pages.CartPage;
import com.demoguru99.Magenta.Pages.Checkout;
import com.demoguru99.Magenta.Pages.DashBoard;
import com.demoguru99.Magenta.Pages.HomePage;
import com.demoguru99.Magenta.Util.BrowserUtilities;
import com.demoguru99.Magenta.Util.ConfigurationReader;

public class TestCase_06 extends TestBase{

	@Test
	public void purchaseItem() throws InterruptedException
	{		
		BrowserUtilities.implicitlyWait(10);
		//Login using the credentials stored in Email.properties file
		AccountPage ap = new HomePage().goToLoginPage(ConfigurationReader.getProperty("email", "Email.properties"), "password");
		
		//Go to My wishlist & Add the wishlisted item in cart		
		CartPage cp = ap.addWishlistItemToCart();
		BrowserUtilities.waitForElementToAppear(cp.errorMsgTop);
		Assert.assertTrue(cp.errorMsgTop.getText().contains("was added to your shopping cart."));
		
		//Select country/region to estimate shipping cost and verify shipping cost
		Assert.assertTrue(cp.verifyEstimateShipping("United States", "New York", "542896"));
		
		//Click on update total and verify Total cost is inclusive of shipping
		cp.updateTotal();
		Assert.assertTrue(cp.verifyTotal());
		
		Checkout ck = cp.proceedToCheckout();
		
		//Enter the use and shipping details
		ck.enterBillingInfo("ABC City", "New York","New York", "542896", "United States", "12345678");
		
		//Select the payment method and continue to place order
		ck.enterPaymentInfo();
		
		//Verify order is placed
		String orderId = ck.verifyOrder(ConfigurationReader.getProperty("ordersuccessMsg1"), ConfigurationReader.getProperty("ordersuccessMsg2"));
		System.out.println(orderId);
		
		
	}
}
