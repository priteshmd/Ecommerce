package com.demoguru99.Magenta.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoguru99.Magenta.Util.Driver;

public class XperiaPage {

	public XperiaPage()
	{
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//span[@id='product-price-1']/span[..]")
	public WebElement xperiaPrice;

	static String price = "";
	public String getXperiaPrice()
	{
		price = xperiaPrice.getText();
		return price;
	}
}
