 package com.orm.listeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.orm.driverfactory.DriverFactory;


public class ExtentReportListeners implements ITestListener {

	private static ExtentSparkReporter extentSparkReporter;
	private static ExtentReports extentReports= initializeReports();
	public static ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	
	
	private static synchronized ExtentReports initializeReports() {
		
		String path = "." + "/Reports/ExtentReport.html";
			
		extentSparkReporter = new ExtentSparkReporter(path);
		ExtentReports extentReports1 = new ExtentReports();
		extentReports1.attachReporter(extentSparkReporter);
		return extentReports1;
	}
	
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
		extentTestThread.set(test);//01234-signup,213213 -order
		System.out.println("Created ExtentTest for thread: " + extentTestThread.get());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTestThread.get().pass("Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		getExtentTest().info(
				MediaEntityBuilder.createScreenCaptureFromPath(DriverFactory.getScreenshot()).build());
		
		extentTestThread.get().fail("Test Failed: " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentReportListeners.getExtentTest().info(
				MediaEntityBuilder.createScreenCaptureFromPath(DriverFactory.getScreenshot()).build());
		extentTestThread.get().skip("Test Skipped :"+result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		extentTestThread.get().warning("Test Failed but within success percentage: " + result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		extentTestThread.get().fail("Test Failed due to timeout: " + result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReports.flush();
		extentTestThread.remove();
	}

	public static  ExtentTest getExtentTest() {
		System.out.println("Getting ExtentTest for thread: " + extentTestThread.get());
		return extentTestThread.get();
	}
	
	
	
	
}
