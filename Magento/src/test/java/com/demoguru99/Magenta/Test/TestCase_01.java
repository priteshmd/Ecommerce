package com.demoguru99.Magenta.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoguru99.Magenta.Helper.DropdownSelector;
import com.demoguru99.Magenta.Pages.HomePage;
import com.demoguru99.Magenta.Pages.MobilePage;
import com.demoguru99.Magenta.Util.Driver;

public class TestCase_01 extends TestBase{

	@Test (priority = 1)
	public void TestVerifyTitle() {

		
		Assert.assertEquals(Driver.getDriver().getTitle(), "Home page");	
	
	}
	
	@Test  (priority = 2)
	public void TestMobileLink() {
		

		HomePage hp = new HomePage();
		hp.lnkMobile.click();
		MobilePage mp = new MobilePage();
		Assert.assertEquals(Driver.getDriver().getTitle(), "Mobile");
		ArrayList<String> al1 = new ArrayList<String>();
		al1.add(mp.product.get(0).getAttribute("title"));
		al1.add(mp.product.get(1).getAttribute("title"));
		al1.add(mp.product.get(2).getAttribute("title"));
		//System.out.println("First List:\n"+al1);
		Collections.sort(al1);	
		//System.out.println("After Sorting List:\n"+al1);

		DropdownSelector.selectByName(mp.btnSelect, "Name");
		ArrayList<String> al2 = new ArrayList<String>();
		
		al2.add(mp.product.get(0).getAttribute("title"));
		al2.add(mp.product.get(1).getAttribute("title"));
		al2.add(mp.product.get(2).getAttribute("title"));
		//System.out.println("Second List:\n"+al2);

		//System.out.println("VERDICT====="+al1.equals(al2));
		Assert.assertEquals(al1.equals(al2), true, "List does not matched");
	
	}
}
