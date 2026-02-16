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
		Assert.assertTrue(driver.getTitle().contains("Swag Labs"), "Title Mismatched");
		Log.logger.info("Application Launched Successfully");
	}
	@Test(groups="smoke")
	public void Smoke02_ValidLogin() {
		loginPage.login(
				ConfigReader.getProperty("username"),
				ConfigReader.getProperty("password"));
		Assert.assertTrue(dashBoardPage.isHeaderVisible(), "Header is not visible");
		Log.logger.info("Dash Board Page is Visible");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
