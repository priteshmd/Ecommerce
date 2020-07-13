package com.demoguru99.Magenta.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoguru99.Magenta.Util.BrowserUtilities;
import com.demoguru99.Magenta.Util.Driver;

public class AccountPage extends HomePage{

	public AccountPage() {
 		PageFactory.initElements(Driver.getDriver(), this);
	}
	

	
	@FindBy (id = "firstname")
	public  WebElement txtFirstName;
	
	@FindBy (id = "middlename")
	public WebElement txtMiddleName;
	
	@FindBy (id = "lastname")
	public  WebElement txtLastName;
	
	@FindBy (id = "email_address")
	public  WebElement txtEmail;
	
	@FindBy (id = "password")
	public  WebElement txtPassword;
	
	@FindBy (id = "confirmation")
	public  WebElement txtConfirmPwd;
	
	@FindBy (xpath = "//span[contains(text(),'Register')]")
	public  WebElement btnRegister;
	
	@FindBy (id = "email")
	public  WebElement txtLoginId;
	
	@FindBy (id = "pass")
	public  WebElement txtLoginPassword;
	
	@FindBy (xpath = "//button[@id='send2']")
	public WebElement btnLogin;
	
	@FindBy (xpath = "//a[@class='link-reorder']")
	public WebElement lnkReorder;
	
	@FindBy (xpath = "//div[@class='block-content']//a[contains(text(),'My Wishlist')]")
	public WebElement lnkWishList;
	
	@FindBy (xpath = "//div[@class='cart-cell']/button[@title = 'Add to Cart']")
	public WebElement btnAddToCart;
	
	@FindBy (xpath = "//td[@class='status']//em[contains(text(),'Pending')]")
	public WebElement txtOrderStatus;
	
	@FindBy (xpath = "//a[contains(text(),'My Orders')]")
	public WebElement lnkMyOrders;
	
	@FindBy (xpath = "//span[@class='nobr']//a[contains(text(),'View Order')]")
	public WebElement lnkViewOrder;
	
	@FindBy (xpath = "//a[@class='link-print']")
	public WebElement lnkPrintOrder;
	
	@FindBy (xpath = "//*[@id=\"sidebar\"]//print-preview-button-strip//cr-button[1]")
	public WebElement btnPrint;
	
	public AccountPage registerNewUser(String firstName, String LastName, String email, String password )
	{
		//HomePage.createNewAccount();
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
		txtLastName.clear();
		txtLastName.sendKeys(LastName);
		txtEmail.clear();
		txtEmail.sendKeys(email);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		txtConfirmPwd.clear();
		txtConfirmPwd.sendKeys(password);
		btnRegister.click();
		
		return (new AccountPage());
	}
	
	public AccountPage Login(String email, String password)
	{
		txtLoginId.clear();
		txtLoginId.sendKeys(email);
		txtLoginPassword.clear();
		txtLoginPassword.sendKeys(password);
		
		btnLogin.click();
		
		return new AccountPage();
	}
	
	public CartPage ReOrderProduct()
	{
		lnkReorder.click();
		return new CartPage();
	}

	public CartPage addWishlistItemToCart() {
		
		BrowserUtilities.waitForElementToClick(lnkWishList);
		lnkWishList.click();
		BrowserUtilities.waitForElementToClick(btnAddToCart);
		btnAddToCart.click();
		
		return new CartPage();
	}
	
	
}
