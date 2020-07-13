package com.demoguru99.Magenta.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoguru99.Magenta.Util.Driver;

public class IphonePage {

	public IphonePage()
	{
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//span[@id='product-price-2']/span[..]")
	public WebElement iphonePrice;
	
	static String price = "";
	public String getIphonePrice()
	{
		price = iphonePrice.getText();
		return price;
	}
}
