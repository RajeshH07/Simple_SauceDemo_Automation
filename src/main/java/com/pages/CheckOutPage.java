package com.pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckOutPage {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By item1 = By.xpath("//div[text()='Sauce Labs Bike Light']");
	private By checkOutBtn = By.xpath("//button[text()='Checkout']");
	
	
	public boolean isItemVisible() {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver.findElement(item1).isDisplayed();
		 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       //return wait.until(ExpectedConditions.visibilityOfElementLocated(item1)).isDisplayed();
	}
	
	public void clickCheck() {
		driver.findElement(checkOutBtn).click();
	}
}
