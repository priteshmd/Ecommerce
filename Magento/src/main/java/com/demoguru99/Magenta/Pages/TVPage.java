package com.demoguru99.Magenta.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoguru99.Magenta.Util.Driver;

public class TVPage
{
	
	public TVPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
	@FindBy (xpath="//a[contains(@title,'LG LCD')]/../div[@class='product-info']/div['actions']/ul/li/a[text()='Add to Wishlist']")
	public  WebElement btnWishlist;
	
	@FindBy (xpath = "//li[@class='success-msg']//ul//li//span[contains(text(),'LG')]")
	public WebElement msgSuccess;
	
	@FindBy (xpath = "//span[contains(text(),'Share Wishlist')]")
	public WebElement btnShareWishlist;
	
	@FindBy (xpath = "//textarea[@id='email_address']")
	public WebElement txtEmailAddress;
	
	
	
	
	
}
