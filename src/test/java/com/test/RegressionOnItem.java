package com.test;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.CheckOutInfoPage;
import com.pages.CheckOutOverFinal;
import com.pages.CheckOutPage;
import com.pages.CompletePage;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.pages.kartPage;
import com.utils.ConfigReader;
import com.utils.Log;

public class RegressionOnItem extends BaseTest{
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	ProductPage productPage;
	kartPage KartPage;
	CheckOutPage checkOutPage;
	CheckOutInfoPage infoPage;
	CheckOutOverFinal checkFinal;
	CompletePage finalPage;
	
	@BeforeMethod
	public void pageSetup() {
		loginPage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		productPage = new ProductPage(driver);
		KartPage = new kartPage(driver);
		checkOutPage = new CheckOutPage(driver);
		infoPage = new CheckOutInfoPage(driver);
		checkFinal = new CheckOutOverFinal(driver);
		finalPage = new CompletePage(driver);
	}
	
	@Test(groups="regression")
	public void RegOnItem01_validLogin() throws InterruptedException {
		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		Thread.sleep(1500);
		Assert.assertTrue(dashBoardPage.isHeaderVisible(), "Title MisMatch");
		Log.logger.info("Succesful login for Regression on Item");
	}
	
	@Test(groups="regression")
	public void RegOnItem02_selectItem() throws InterruptedException {
		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Thread.sleep(1000);
		dashBoardPage.isBikeLightAvailable();
		Thread.sleep(1000);
		Log.logger.info("Click Bike Light Option");
	}
	
	@Test(groups="regression")
	public void RegItem03_addKart() throws InterruptedException {
		RegOnItem02_selectItem();
		Thread.sleep(1500);
		Assert.assertTrue(productPage.productNameVisible(), "Product Missing");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(3000);
		productPage.clickAddCart();
		Thread.sleep(1000);
		productPage.clickKartBtn();
		Assert.assertTrue(KartPage.iscartItemDisplayed(), "No product is dispalyed");
	}
	
	@Test(groups="regression")
	public void RegItem04_checkOut() throws InterruptedException  {
		RegItem03_addKart();
		Thread.sleep(2500);
		KartPage.isCheckoutClicked();
		
	}
	
	@Test(groups="regression")
	public void RegItem05_CheckOutInfo() throws InterruptedException {
		RegItem04_checkOut();
		Assert.assertTrue(infoPage.isCeckInfoHaaderDisplayed(), "Info detail page missed");
		infoPage.sendFirstName();
		Thread.sleep(1000);
		infoPage.sendLastName();
		Thread.sleep(1000);
		infoPage.sendZipCode();
		Thread.sleep(2500);
		infoPage.clickContinueBtn();
	}
	
	@Test(groups="regression")
	public void RegItem06_CheckOutFinal() throws InterruptedException {
		RegItem05_CheckOutInfo();
		Assert.assertTrue(checkFinal.isCheckOutHeaderVisible(), "CheckOut overView not visible");
		Assert.assertTrue(checkFinal.isCheckOutHeaderVisible(), "Quantity not dispalyed");
		Thread.sleep(2500);
		checkFinal.clickFinishBtn();
	}
	
	@Test(groups="regression")
	public void RegItem07_FinalPage() throws InterruptedException {
		RegItem06_CheckOutFinal();
		Thread.sleep(1500);
		Assert.assertTrue(finalPage.iscmpltHeaderDisplayed(), "Header not dispalyed");
		Assert.assertTrue(finalPage.isFInalMsgDispalyed(), "Thank you for your order! not Shown");
	}
}
