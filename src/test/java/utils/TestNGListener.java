package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import base.BaseClass;

public class TestNGListener extends BaseClass implements ITestListener{
	
	ExtentReports extent;//create a blank HTML report
	
	ExtentTest test;//represents each @Test annotation as a separate test in the report
	
	//this will ensure that repots are generated to the specific test case running parallely
	static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	@Override
	public void onStart(ITestContext context) {
		String reportpath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
		reporter.config().setReportName("District Automation Execution Report");
		reporter.config().setDocumentTitle("District.in Report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("QA Name", "Parth");
		extent.setSystemInfo("Enviroment", ConfigReader.get("env"));
	}
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test case passed successfully");
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		String path = ScreenshotUtils.capture(driver, result.getName());
		extentTest.get().addScreenCaptureFromPath(path, "Failed test screenshot");
		LoggerUtils.fail("Screenshot captured for failed test case: " + result.getName());
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Test case skipped");
		
	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	
	}

}
