package com.demoguru99.Magenta.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoguru99.Magenta.Util.Driver;

public class DashBoard {

	public DashBoard() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//div[@class='block-content']//a[contains(text(),'My Wishlist')]")
	public WebElement lnkWishList;
	
	@FindBy (xpath = "//div[@class='cart-cell']/button[@title = 'Add to Cart']")
	public WebElement btnAddToCart;
	
	
}
