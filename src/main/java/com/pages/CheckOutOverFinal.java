package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutOverFinal {
	WebDriver driver;
	public CheckOutOverFinal(WebDriver driver) {
		this.driver=driver;
	}
	
	private By checkOutHearder = By.xpath("//span[@class='title']");
	private By qtyNo = By.xpath("//div[@class='cart_item']");
	private By finishBtn = By.xpath("//button[@id='finish']");
	
	
	public boolean isCheckOutHeaderVisible() {
		return driver.findElement(checkOutHearder).isDisplayed();
	}
	
	public boolean isQtyDispalyed() {
		return driver.findElement(qtyNo).isDisplayed();
	}
	
	public void clickFinishBtn() {
		driver.findElement(finishBtn).click();
	}
}
