package co.listners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.base.BaseTest;
import com.utils.ExtentManager;
import com.utils.Log;
import com.utils.ScreenshotUtils;
import com.utils.StepLogger;

public class TestListners implements ITestListener {

	private ExtentReports extent = ExtentManager.getReport();
	//private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest  =
				extent.createTest(result.getMethod().getMethodName());
		StepLogger.setTest(extentTest);
		Log.logger.info("TEST STARTED: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		StepLogger.pass("Test Passed");
		}
	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver =
				((BaseTest) result.getInstance()).driver;
		String screenshotPath =
				ScreenshotUtils.captureScreenshot(driver ,result.getMethod().getMethodName());
		StepLogger.fail("Test Failed: " + result.getThrowable().getMessage());	      
		StepLogger.info("Screenshot captured");
		StepLogger.fail("Refer screenshot below");
		StepLogger.info("Screenshot Path: " + screenshotPath);
        System.out.println("Screenshot saved at: " + screenshotPath);

	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		Log.logger.info("TEST EXECUTION FINISHED");
	}
}
