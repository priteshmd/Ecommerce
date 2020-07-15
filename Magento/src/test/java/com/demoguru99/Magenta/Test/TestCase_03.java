package com.demoguru99.Magenta.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoguru99.Magenta.Pages.CartPage;
import com.demoguru99.Magenta.Pages.HomePage;
import com.demoguru99.Magenta.Pages.MobilePage;
import com.demoguru99.Magenta.Util.ConfigurationReader;

public class TestCase_03 extends TestBase{

	@Test
	public void TestCartFunction()
	{


		HomePage hp = new HomePage();
		log.info("Opened Home page");
		hp.lnkMobile.click();
		
		MobilePage mp = new MobilePage();
		log.info("Opened Mobile page");
		mp.addToCart(ConfigurationReader.getProperty("product1"));
		log.info("Product added to cart");
		CartPage cp = new CartPage();
		cp.updateCart("1000");
		
		//System.out.println(cp.errorMsgTop.getText());
		Assert.assertEquals(cp.errorMsgTop.getText(), ConfigurationReader.getProperty("errorMsgTop"));
		//System.out.println(cp.errorMsgItem.getText());
		Assert.assertEquals(cp.errorMsgItem.getText(),  ConfigurationReader.getProperty("errorMsgItem"));
		
		cp.btnEmptyCart.click();
		Assert.assertEquals(cp.errorMsgEmpty.getText(), ConfigurationReader.getProperty("errorMsgEmpty"));
		log.info("Assertion success, cart empty");

	}
}
