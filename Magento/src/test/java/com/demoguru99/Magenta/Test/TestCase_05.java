package com.demoguru99.Magenta.Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoguru99.Magenta.Pages.HomePage;
import com.demoguru99.Magenta.Pages.TVPage;
import com.demoguru99.Magenta.Util.BrowserUtilities;
import com.demoguru99.Magenta.Util.ConfigurationReader;
import com.demoguru99.Magenta.Util.Driver;
import com.demoguru99.Magenta.Util.EmailIdGenerator;

public class TestCase_05 extends TestBase{

	@Test
	public static void Test_Account()

	{
		//Load the Home Page
		HomePage ap = new HomePage();
		
		//Using email generator class to generate the name and email
		String newemail = EmailIdGenerator.mail;
		
		//Using the createNewAccount method to create new account using the details acquired above
		ap.createNewAccount(EmailIdGenerator.fname, EmailIdGenerator.lname, newemail, "password");
		
		//Storing the email generated in Email.Configuration file for later use
		ConfigurationReader.SetProperty("email", newemail);
		
		//Asserting account creation success message
		BrowserUtilities.waitForElementToAppear(By.xpath("//li[@class='success-msg']/ul[..]/li[..]/span"));
		String thankYouMsg = Driver.getDriver().findElement(By.xpath("//li[@class='success-msg']/ul[..]/li[..]/span")).getText();
		Assert.assertEquals(thankYouMsg, ConfigurationReader.getProperty("thankYouMsg"), "Thank you msg not found!");
		
		//Clicking on TV link
		BrowserUtilities.waitForElementToAppear(ap.lnkTv);
		ap.lnkTv.click();
		
		//Add the first TV to wishlist
		TVPage tp = new TVPage();
		BrowserUtilities.waitForElementToClick(tp.btnWishlist);
		tp.btnWishlist.click();
		
		//Verify wishlist addition message
		Assert.assertEquals(tp.msgSuccess.getText(), "LG LCD has been added to your wishlist. Click here to continue shopping.");
		
		//Click on the share wishlist link
		BrowserUtilities.waitForElementToClick(tp.btnShareWishlist);
		tp.btnShareWishlist.click();
		
		//Enter email id in the text box andclick on share wishlist
		BrowserUtilities.waitForElementToAppear(tp.txtEmailAddress);
		tp.txtEmailAddress.sendKeys("prites@oml.com");
		BrowserUtilities.waitForElementToClick(tp.btnShareWishlist);
		tp.btnShareWishlist.click();
		
		//Verify successful message after share wishlist is done
		BrowserUtilities.waitForElementToAppear(By.xpath("//span[contains(text(),'Your Wishlist has been shared.')]"));
		Assert.assertEquals((Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Your Wishlist has been shared.')]")).getText()), "Your Wishlist has been shared.");
	}
}