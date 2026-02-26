package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutInfoPage {
	 WebDriver driver;
	 public CheckOutInfoPage(WebDriver driver) {
		 this.driver=driver;
	 }
	 
	 private By checkInfoHeader = By.xpath("//span[@class='title']");
	 private By firstName = By.xpath("//input[@id='first-name']");
	 private By lastName = By.xpath("//input[@id='last-name']");
	 private By zipCode = By.xpath("//input[@id='postal-code']");
	 private By continueBtn = By.xpath("//input[@id='continue']");
	 
	 
	 
	 public boolean isCeckInfoHaaderDisplayed() {
		 return driver.findElement(checkInfoHeader).isDisplayed();
	 }
	 
	 public void sendFirstName() {
		 driver.findElement(firstName).sendKeys("Raju");
	 }
	 public void sendLastName() {
		 driver.findElement(lastName).sendKeys("Tester");
	 }
	 public void sendZipCode() {
		 driver.findElement(zipCode).sendKeys("123456");
	 }
	 public void clickContinueBtn() {
		 driver.findElement(continueBtn).click();
	 }
}
