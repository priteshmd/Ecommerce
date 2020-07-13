package com.demoguru99.Magenta.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoguru99.Magenta.Util.Driver;

public class MobilePage extends HomePage{
	
	public MobilePage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
	@FindBy (xpath="//select[@title='Sort By']")
	public  WebElement btnSelect;
	
	@FindBy (className = "product-image") 
	public  List<WebElement> product;
	
	@FindBy (xpath = "//a[contains(text(),'Sony Xperia')]")
	public  WebElement lnkSonyXperia;
	
	@FindBy (xpath = "//a[contains(text(),'IPhone')]")
	public  WebElement lnkIphone;
	
	@FindBy (xpath = "//a[contains(text(),'Samsung Galaxy')]")
	public  WebElement lnkSamsung;
	
	@FindBy (xpath = "//span[@id='product-price-1']/span[..]")
	public  WebElement productPrice1;
	
	@FindBy (xpath = "//span[@id='product-price-2']/span[..]")
	public  WebElement productPrice2;
	
	@FindBy (xpath = "//span[@id='product-price-3']")
	public  WebElement productPrice3;
	
	@FindBy (xpath = "//a[contains(@title, 'Xperia')]//following-sibling::div/div['actions']/button")
	public WebElement btnXperiaAddToCart;
	
	@FindBy (xpath = "//a[contains(@title, 'IPhone')]//following-sibling::div/div['actions']/button")
	public WebElement btnIphoneAddToCart;
	
	@FindBy (xpath = "//a[contains(@title, 'Samsung')]//following-sibling::div/div['actions']/button")
	public WebElement btnSamsungAddToCart;

	@FindBy (xpath = "//div[..]/h2/*[contains(text(),'Sony')]/../../div['actions']/ul[..]/li/a[@class='link-compare']")
	public WebElement lnkSonyCompare;
	
	@FindBy (xpath = "//div[..]/h2/*[contains(text(),'IPhone')]/../../div['actions']/ul[..]/li/a[@class='link-compare']")
	public WebElement lnkIphoneCompare;
	
	@FindBy (xpath = "//div[..]/h2/*[contains(text(),'Samsung')]/../../div['actions']/ul[..]/li/a[@class='link-compare']")
	public WebElement lnkSamsungCompare;
	
	@FindBy (xpath = "//li['success-msg']/ul/li/span")
	public WebElement msgSuccess;
	
	@FindBy (xpath = "//span[(text()='Compare')]")
	public WebElement btnCompare;
	
	@FindBy (xpath = "//span[contains(text(),'Close Window')]")
	public WebElement closePopup;
	
	
	public  String price = "";
	
	public String getproductPrice(String productName)
	{
		WebElement p;
		switch(productName)
		{
			case "Sony Xperia":
			p = productPrice1;
			break;
			
			case "IPhone":
			p = productPrice2;
			break;
				
			case "Samsung Galaxy":
			p = productPrice3;
			break;	
			
			default:
			p = productPrice1;
		
		}
		price = p.getText();
		return price;
	}
	
	public CartPage addToCart(String productName)
	{
		WebElement p;
		switch(productName)
		{
			case "Sony Xperia":
			p = btnXperiaAddToCart;
			break;
			
			case "IPhone":
			p = btnIphoneAddToCart;
			break;
				
			case "Samsung Galaxy":
			p = btnSamsungAddToCart;
			break;	
			
			default:
			p = btnXperiaAddToCart;		
		}
		
		p.click();
		return new CartPage();
	}
	
	
	
}
