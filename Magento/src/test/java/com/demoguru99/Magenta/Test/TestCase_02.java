package com.demoguru99.Magenta.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoguru99.Magenta.Pages.HomePage;
import com.demoguru99.Magenta.Pages.IphonePage;
import com.demoguru99.Magenta.Pages.MobilePage;
import com.demoguru99.Magenta.Pages.SamsungPage;
import com.demoguru99.Magenta.Pages.XperiaPage;
import com.demoguru99.Magenta.Util.BrowserUtilities;
import com.demoguru99.Magenta.Util.ConfigurationReader;
import com.sun.java.swing.plaf.windows.resources.windows;

public class TestCase_02 extends TestBase {

	@Test
	public void TestProduct01CostDetailPage()
	{
		

		HomePage hm = new HomePage();
		hm.lnkMobile.click();
		MobilePage mp = new MobilePage();
		String pr1 = mp.getproductPrice(ConfigurationReader.getProperty("product1"));
		String pr2 = mp.getproductPrice(ConfigurationReader.getProperty("product2"));
		String pr3 = mp.getproductPrice(ConfigurationReader.getProperty("product3"));
		//System.out.println(pr1 +"\n"+ pr2+"\n" +pr3);
		
		mp.lnkSonyXperia.click();
		XperiaPage xp = new XperiaPage();
		String prd1 = xp.getXperiaPrice();
		Assert.assertEquals(prd1, pr1, "Prices do not match");
	
//		BrowserUtilities.pageNavigateBack();
//		
//		mp.lnkIphone.click();
//		IphonePage ip = new IphonePage();
//		String prd2 = ip.getIphonePrice();		
//		Assert.assertEquals(prd2, pr2, "Prices do not match");
//		
//		BrowserUtilities.pageNavigateBack();
//		
//		mp.lnkSamsung.click();
//		SamsungPage sp = new SamsungPage();
//		String prd3 = sp.getSamsungPrice();
//		
//		Assert.assertEquals(prd3, pr3, "Prices do not match");
	}
}
