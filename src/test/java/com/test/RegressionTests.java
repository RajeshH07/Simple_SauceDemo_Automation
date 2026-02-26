package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.utils.ConfigReader;
import com.utils.Log;

public class RegressionTests extends BaseTest {


	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	
	@BeforeMethod
	public void pageSetup() {
		loginPage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
	}
	
	@Test(groups="regression")
	public void Reg01_inValidUser() {
		loginPage.login("invalidUser", ConfigReader.getProperty("password"));
		Assert.assertTrue(loginPage.isErrorMsgVisible(), "Invalid UserName Entered");
		Log.logger.info("Inavlid User Name");
		//StepLogger.pass("Invalid UserName");
	}
	
	@Test(groups="regression")
	public void Reg02_invalidPassword() {
		loginPage.login(ConfigReader.getProperty("username"), "inValidPassword");
		Assert.assertTrue(loginPage.isErrorMsgVisible(), "Entered invalid Password");
		Log.logger.info("Inavlid Password");
		//StepLogger.pass("Inavlid Password");
	}
	
	@Test(groups="regression")
	public void Reg03_ValidCredentials() {
		loginPage.login(
				ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		Assert.assertTrue(dashBoardPage.isHeaderVisible(), "Logged in Successfully");
		Log.logger.info("User Logged In Successfully");
		//StepLogger.pass("Logged In Successfully");
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
}
