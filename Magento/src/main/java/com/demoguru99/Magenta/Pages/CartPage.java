package com.demoguru99.Magenta.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.demoguru99.Magenta.Util.BrowserUtilities;
import com.demoguru99.Magenta.Util.Driver;

public class CartPage {
	
	public CartPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//input[@title='Qty' and @data-cart-item-id='MOB001']")
	public WebElement txtquantity;
	
	@FindBy (xpath = "//input[@title='Qty' and @data-cart-item-id='TV001']")
	public WebElement txtquantityOfTV;
	
	@FindBy (xpath = "//input[@title='Qty' and @data-cart-item-id='MOB001']//following-sibling::button[@title='Update']")
	public WebElement btnUpdate;
	
	@FindBy (xpath = "//input[@title='Qty' and @data-cart-item-id='TV001']//following-sibling::button[@title='Update']")
	public WebElement btnUpdateQtyforTV;
	
	@FindBy (xpath = "//ul['messages']/li/ul/li/span")
	public WebElement errorMsgTop;
	
	@FindBy (xpath = "//p[@class='item-msg error']")
	public WebElement errorMsgItem;
	
	@FindBy (xpath = "//button['@id=empty-cart-button' and @title='Empty Cart']")
	public WebElement btnEmptyCart;
	
	@FindBy (xpath = "//div['page-title']/h1")
	public WebElement errorMsgEmpty;
	
	@FindBy (name = "country_id")
	public WebElement selCountry;
	
	@FindBy (name = "region_id")
	public WebElement selRegion;
	
	@FindBy (id = "postcode")
	public WebElement txtZip;
	
	@FindBy (xpath = "//span[contains(text(),'Estimate')]")
	public WebElement lnkEstimate;
	
	@FindBy (name = "estimate_method")
	public WebElement radiobtnRate;
	
	@FindBy (xpath = "//button[@name='do'][@value='Update Total']")
	public WebElement btnUpdateTotal;
	
	@FindBy (xpath = "//label[contains(text(),'Fixed')]/span")
	public WebElement txtShippingCost;

	@FindBy (xpath = "//td[contains(text(),'Subtotal')]/following-sibling::td[..]/span")
	public WebElement txtSubTotal;
	
	@FindBy (xpath = "//td[@class='a-right']/strong[text()='Grand Total']/../following-sibling::td[..]/strong")
	public WebElement txtGrandTotal;

	@FindBy (xpath = "//li[@class='method-checkout-cart-methods-onepage-bottom']/button[..]/span/span[contains(text(),'Proceed to Checkout')]")
	public WebElement btnProceedToCheckout;
	
	@FindBy(id = "coupon_code")
	public WebElement txtCouponCode;
	
	@FindBy(xpath = "//span[contains(text(),'Apply')]")
	public WebElement lnkApplyCoupon;
	
	@FindBy(xpath = "//tbody/tr/td[contains(text(),'Discount')]/../td/span[@class='price']")
	public WebElement txtDiscount;
	
	public double shippingRate = 0;
	public double subTotal = 0;
	public double grandTotal = 0;
	public double discount = 0;
	
	public void updateCart(String q)
	{
		txtquantity.clear();
		txtquantity.sendKeys(q);
		btnUpdate.click();
	}
	
	public boolean verifyEstimateShipping(String country, String region, String zip) throws NumberFormatException
	{
		BrowserUtilities.selectByVisibleText(selCountry, country);
		BrowserUtilities.selectByVisibleText(selRegion, region);
		BrowserUtilities.waitForElementToAppear(txtZip);
		txtZip.clear();
		txtZip.sendKeys(zip);
		BrowserUtilities.waitForElementToClick(lnkEstimate);
		lnkEstimate.click();
		BrowserUtilities.waitForElementToAppear(txtShippingCost);
		String rate = txtShippingCost.getText().substring(1);
		shippingRate = Double.parseDouble(rate);
		return shippingRate == 5.00;
	}
	
	public void updateTotal() throws InterruptedException
	{
		BrowserUtilities.waitForElementToClick(radiobtnRate);
		radiobtnRate.click();
		BrowserUtilities.waitForElementToClick(btnUpdateTotal);
		btnUpdateTotal.click();
		BrowserUtilities.scrollDown();
	}
	
	public boolean verifyTotal()
	{
		subTotal = getSubTotal();
		grandTotal= getGrandTotal();
		System.out.println("subtotal:" +subTotal + " grand total :" + grandTotal);
		if(subTotal + shippingRate == grandTotal)
		{
			return true;
		}
		return false;
	}
	
	public Double getGrandTotal()
	{
		BrowserUtilities.waitForElementToAppear(txtGrandTotal);
		grandTotal = Double.parseDouble(txtGrandTotal.getText().substring(1).replaceAll(",", ""));
		return grandTotal;
	}
	public Double getSubTotal()
	{
		BrowserUtilities.waitForElementToAppear(txtSubTotal);
		subTotal = Double.parseDouble(txtSubTotal.getText().substring(1).replaceAll(",", ""));
		return subTotal;
	}
	public Double getDiscount()
	{
		BrowserUtilities.waitForElementToAppear(txtDiscount);
		discount = Double.parseDouble(txtDiscount.getText().substring(2).replaceAll(",", ""));
		return discount;
	}
	
	public void applyCouponCode(String code)
	{
		txtCouponCode.clear();
		txtCouponCode.sendKeys(code);
		lnkApplyCoupon.click();
	}

	public void verifyDiscount() throws InterruptedException {
		
		BrowserUtilities.scrollDown();
		discount = getDiscount();
		Assert.assertTrue(discount == getSubTotal() * 0.05);
	}
	public void verifyGrandTotalAfterdDiscount() throws InterruptedException {
		
		BrowserUtilities.scrollDown();
		discount = getDiscount();
		Assert.assertTrue(getGrandTotal() == getSubTotal() - getDiscount(),"Discount generated but not applied on Grand Total");
	}
	public Checkout proceedToCheckout()
	{
		BrowserUtilities.waitForElementToClick(btnProceedToCheckout);
		btnProceedToCheckout.click();
		return new Checkout();
	}
	
	
}
