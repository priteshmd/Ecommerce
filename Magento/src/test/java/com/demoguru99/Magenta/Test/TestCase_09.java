package com.demoguru99.Magenta.Test;

import org.openqa.selenium.ElementNotVisibleException;
import org.testng.annotations.Test;

import com.demoguru99.Magenta.Pages.CartPage;
import com.demoguru99.Magenta.Pages.HomePage;
import com.demoguru99.Magenta.Pages.MobilePage;
import com.demoguru99.Magenta.Util.ConfigurationReader;

public class TestCase_09  extends TestBase{

	@Test
	public void TestDiscountCoupon() throws InterruptedException
	{
		new HomePage().lnkMobile.click();
		
		CartPage cp = new MobilePage().addToCart(ConfigurationReader.getProperty("product3"));
		
		cp.applyCouponCode("GURU50");
		
		cp.verifyDiscount();
		log.info("Discount coupon is valid");
		try  {
		cp.verifyGrandTotalAfterdDiscount();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			log.error("Grand total is incorrect, discount not applied!");
		}
	}
}
