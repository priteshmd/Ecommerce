package com.demoguru99.Magenta.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoguru99.Magenta.Util.Driver;

public class SamsungPage {

	public SamsungPage()
	{
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//span[@id='product-price-3']")
	public WebElement samsungPrice;
	
	static String price = "";
	public String getSamsungPrice()
	{
		price = samsungPrice.getText();
		return price;
	}
}
