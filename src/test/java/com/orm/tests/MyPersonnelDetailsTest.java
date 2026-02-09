package com.orm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.orm.BaseTest.BaseTest;
import com.orm.driverfactory.DriverFactory;
import com.orm.listeners.ExtentReportListeners;
import com.orm.pages.DashboardPage;

public class MyPersonnelDetailsTest extends BaseTest {

	@BeforeClass
	public void beforeCls() {
		dashboardPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@Test(priority=1)
	public void viewMyLinkClick() {
	
	myInfoPage=dashboardPage.doClickViewMyLink();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=2, dependsOnMethods="viewMyLinkClick")
	public void verifyPersonalDetailsTab() {
		//dashboardPage=new DashboardPage(driver);
		ExtentReportListeners.getExtentTest().info(
				MediaEntityBuilder.createScreenCaptureFromPath(DriverFactory.getScreenshot()).build());
		if(myInfoPage.verifyPersonalDetailsTab(10)) {
			Assert.assertTrue(true);
		}
		else {
			
			Assert.assertTrue(false);
		}
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
