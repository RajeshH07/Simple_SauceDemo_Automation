package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {

	WebDriver driver;
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By header = By.xpath("//div[@class='app_logo']");
	private By subHeader = By.xpath("//span[@class='title']");
	
	public boolean isHeaderVisible() {
		return driver.findElement(header).isDisplayed();
	}
}
