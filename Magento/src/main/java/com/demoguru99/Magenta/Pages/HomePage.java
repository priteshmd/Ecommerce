package com.demoguru99.Magenta.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoguru99.Magenta.Util.Driver;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//a[text() = 'Mobile']")
	public WebElement lnkMobile;
	
	@FindBy (xpath = "//a[text() = 'TV']")
	public WebElement lnkTv;
	
	@FindBy(xpath = "//span[text()='Account']")
	public WebElement lnkAccount;
	
	@FindBy (linkText = "My Account")
	public WebElement lnkMyAccount;
	
	@FindBy (xpath = "//span[contains(text(),'Create an Account')]")
	public WebElement lnkCreateAccount;
	
	public AccountPage createNewAccount(String firstName, String LastName, String email, String password)
	{
		lnkAccount.click();
		lnkMyAccount.click();
		lnkCreateAccount.click();
		
		//AccountPage ap = new AccountPage();
		return new AccountPage().registerNewUser(firstName, LastName, email, password);
		
		//return AccountPage.registerNewUser(null, null, null, null);
		
	}
	
	public AccountPage goToLoginPage(String email, String password)
	{
		lnkAccount.click();
		lnkMyAccount.click();
		
		return (new AccountPage().Login(email, password));
	}
}
