package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By productName = By.xpath("//div[text()='Sauce Labs Bike Light']");
	private By addCartBtn = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
	private By kartIcon = By.xpath("//a[@class='shopping_cart_link']");

	public boolean productNameVisible() {
		return driver.findElement(productName).isDisplayed();
	}
	
	public void clickAddCart() {
		driver.findElement(addCartBtn).click();
	}
	public void clickKartBtn() {
		driver.findElement(kartIcon).click();
	}
}
