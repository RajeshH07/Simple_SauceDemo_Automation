package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class kartPage {
	WebDriver driver;
	public kartPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By cartItemName = By.xpath("//div[@class='inventory_item_name']");
	private By checkOutBtn = By.xpath("//button[@id='checkout']");
	
	public boolean iscartItemDisplayed() {
		return driver.findElement(cartItemName).isDisplayed();
	}
	
	public void isCheckoutClicked() {
		driver.findElement(checkOutBtn).click();
	}
	
	
}
