package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {
	WebDriver driver;
	public CompletePage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By cmpltHeader = By.xpath("//span[@class='title']");
	private By finalMsg = By.xpath("//h2[@class='complete-header']");
	
	
	public boolean iscmpltHeaderDisplayed() {
		return driver.findElement(cmpltHeader).isDisplayed();
	}
	public boolean isFInalMsgDispalyed() {
		return driver.findElement(finalMsg).isDisplayed();
	}
}
