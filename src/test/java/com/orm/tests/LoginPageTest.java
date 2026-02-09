package com.orm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.orm.BaseTest.BaseTest;
import com.orm.driverfactory.DriverFactory;
import com.orm.listeners.ExtentReportListeners;
import com.orm.pages.DashboardPage;

public class LoginPageTest extends BaseTest {

	
	@Test(priority=1)
	public void loginTest() {
	dashboardPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentReportListeners.getExtentTest().info(
				MediaEntityBuilder.createScreenCaptureFromPath(DriverFactory.getScreenshot()).build());
	//addScreenshot();
	}
	
	
	@Test(priority=2, dependsOnMethods="loginTest")
	public void verifyDashboardTitleTest() {
		//dashboardPage=new DashboardPage(driver);
		String title=dashboardPage.getPageTitle();
		if(title.equals("OrangeHRM")) {
			System.out.println("Login Test Passed");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Login Test Failed");
			Assert.assertTrue(false);
		}
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ExtentReportListeners.getExtentTest().info(
				MediaEntityBuilder.createScreenCaptureFromPath(DriverFactory.getScreenshot()).build());
	}
	
	
	
}
