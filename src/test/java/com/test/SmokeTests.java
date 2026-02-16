package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.utils.ConfigReader;
import com.utils.Log;

public class SmokeTests extends BaseTest{
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	
	@BeforeMethod
	public void pagesetUp() {
		loginPage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
	}
	
	@Test(groups="smoke")
	public void Smoke01_Launch() {
		//Assert.assertTrue(driver.getTitle().contains("Swag Labs"), "Title Mismatched");
		Assert.assertTrue(false, "Force flase");
		Log.logger.info("Application Launched Successfully");
		//StepLogger.info("Application Launched");
	}
	@Test(groups="smoke")
	public void Smoke02_ValidLogin() {
		loginPage.login(
				ConfigReader.getProperty("username"),
				ConfigReader.getProperty("password"));
		Assert.assertTrue(dashBoardPage.isHeaderVisible(), "Header is not visible");
		Log.logger.info("Dash Board Page is Visible");
		//StepLogger.info("Dash Board page is Visible");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
