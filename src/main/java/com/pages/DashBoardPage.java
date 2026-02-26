package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {

	WebDriver driver;
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By header = By.xpath("//div[@class='app_logo']");
	private By backPack = By.xpath("//div[text()='Sauce Labs Backpack']");
	private By bikeLight = By.xpath("//div[text()='Sauce Labs Bike Light']");
	
	public boolean isHeaderVisible() {
		return driver.findElement(header).isDisplayed();
	}
	
	public void isBackPackAvailable() {
		 driver.findElement(backPack).click();
	}
	
	public void isBikeLightAvailable() {
		driver.findElement(bikeLight).click();
	}
}
