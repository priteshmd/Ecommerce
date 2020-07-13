package com.demoguru99.Magenta.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.demoguru99.Magenta.Util.BrowserUtilities;
import com.demoguru99.Magenta.Util.Driver;

public class Checkout {

	public Checkout()
	{
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (id = "billing:firstname")
	public WebElement txtFirstName;
	
	@FindBy (id ="billing:lastname")
	public WebElement txtLastName;
	
	@FindBy (id="billing:street1")
	public WebElement txtAddress;
	
	@FindBy (id="billing:city")
	public WebElement txtCity;
	
	@FindBy (id = "billing:region_id")
	public WebElement selRegion;
	
	@FindBy (id = "billing:postcode")
	public WebElement txtZipCode;
	
	@FindBy (id = "billing:country_id")
	public WebElement selCountry;
	
	@FindBy (id = "billing:telephone")
	public WebElement txtxTelephone;
	
	@FindBy (id="billing:use_for_shipping_yes")
	public WebElement radioShipTothisAddress;
	
	@FindBy (xpath ="//div[@id='billing-buttons-container']/button[@title='Continue']")
	public WebElement btnContinueAfterBilling;
	
	@FindBy (xpath = "//div[@id='shipping-method-buttons-container']/button['Continue']")
	public WebElement btnContinueAfterShipping;
	
	@FindBy (id = "p_method_checkmo")
	public WebElement radioCheckMoney;
	
	@FindBy (xpath = "//div[@id='payment-buttons-container']/button[@class='button']")
	public WebElement btnContinueAfterPayment;
	
	@FindBy (xpath = "//button['submit']/span/span[contains(text(),'Place Order')]")
	public WebElement btnPlaceOrder;
	
	@FindBy (xpath = "//div[@class='page-title']/h1")
	public WebElement msgOrderSuccess1;
	
	@FindBy (xpath = "//h2[@class='sub-title']")
	public WebElement msgOrderSuccess2;
	
	@FindBy (xpath = "//div[..]//p[contains(.,'Your order #')]/a")
	public WebElement txtOrderId;
	
	@FindBy (id = "billing-address-select")
	public WebElement selectAddress;
	
	
	public void enterBillingInfo(String address, String city,String region,  String zip, String Country, String telephone) throws InterruptedException {
		if(selectAddress.isDisplayed())
		{
			BrowserUtilities.waitForElementToAppear(selectAddress);
			BrowserUtilities.selectByVisibleText(selectAddress, "New Address");
		}
			txtAddress.clear();		
			txtAddress.sendKeys(address);
			txtCity.clear();
			txtCity.sendKeys(city);
			BrowserUtilities.selectByVisibleText(selRegion, region);
			BrowserUtilities.scrollDown();
			txtZipCode.clear();
			txtZipCode.sendKeys(zip);
	//		Thread.sleep(3000);
			BrowserUtilities.selectByVisibleText(selCountry, Country);
			BrowserUtilities.scrollDown();
			BrowserUtilities.waitForElementToAppear(txtxTelephone);
			txtxTelephone.clear();
			txtxTelephone.sendKeys(telephone);
	//		Thread.sleep(1500);
			radioShipTothisAddress.isSelected();
			BrowserUtilities.scrollDown();
			BrowserUtilities.waitForElementToClick(btnContinueAfterBilling);
			btnContinueAfterBilling.click();
	//		Thread.sleep(1500);
			BrowserUtilities.waitForElementToClick(btnContinueAfterShipping);
			btnContinueAfterShipping.click();
			
	}
	
	public void enterPaymentInfo() throws InterruptedException
	{
		BrowserUtilities.waitForElementToClick(radioCheckMoney);
		BrowserUtilities.waitForElementToClick(btnContinueAfterPayment);
		radioCheckMoney.click();
		btnContinueAfterPayment.click();
//		Thread.sleep(1000);
		BrowserUtilities.scrollDown();
		BrowserUtilities.waitForElementToClick(btnPlaceOrder);
		btnPlaceOrder.click();
//		Thread.sleep(1500);

	}
	
	public String verifyOrder(String m1, String m2)
	{
		//String url = Driver.getDriver().getCurrentUrl();
		String OrderId = null;
		BrowserUtilities.pageUrlContains("success");

			BrowserUtilities.waitForElementToAppear(msgOrderSuccess1);
			String msg1 = msgOrderSuccess1.getText();
			Assert.assertEquals(msg1, m1);
			BrowserUtilities.waitForElementToAppear(msgOrderSuccess2);
			String msg2 = msgOrderSuccess2.getText();
			Assert.assertEquals(msg2, m2);
			OrderId = txtOrderId.getText();
	
			
		
		return OrderId;
				
	}
	
}
