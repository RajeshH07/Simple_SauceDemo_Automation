package com.base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.utils.ConfigReader;

public class BaseTest {
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
//		ChromeOptions options = new ChromeOptions();
//		Map<String, Object> prefs =new HashMap<>();
//		prefs.put("profile.password_manager_leak_detectation", false);
//		prefs.put("profiles.credentials_enable_services", false);
		
	//	options.setExperimentalOption("prefs", prefs);
		
		driver = new ChromeDriver();
		driver.get(ConfigReader.getProperty("url"));
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null)
			driver.quit();
	}
}
