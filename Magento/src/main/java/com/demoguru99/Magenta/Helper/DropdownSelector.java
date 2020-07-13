package com.demoguru99.Magenta.Helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelector {

	public static void selectByValue(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public static void selectByIndex(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public static void selectByName(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
}
