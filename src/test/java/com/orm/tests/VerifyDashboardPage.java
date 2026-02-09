package com.orm.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.orm.BaseTest.BaseTest;
import com.orm.driverfactory.DriverFactory;
import com.orm.listeners.ExtentReportListeners;
import com.orm.pages.DashboardPage;

public class VerifyDashboardPage extends BaseTest {

	@BeforeClass
	public void beforeCls() {
		dashboardPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifySidePanelLinks() {

	List<String> inputVal=Arrays.asList("Admin","PIM","Leave","Time","Recruitment","My Info","Performance",
			"Dashboard","Directory","Maintenance","Claim","Buzz");
	if(dashboardPage.verifySidePanelListItems(inputVal))
		Assert.assertEquals(true, true,"Side panel list is as expected");
	else
		Assert.assertEquals(false, true,"Side panel list is not as expected");
		
	
	
	try {
			Thread.sleep(15000);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentReportListeners.getExtentTest().info(
				MediaEntityBuilder.createScreenCaptureFromPath(DriverFactory.getScreenshot()).build());

	}
	

	@Test(priority=2)
	public void verifyPendingActions() {
	//dashboardPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));


	
	if(dashboardPage.verifyPendingActions()!=null)
		System.out.println(dashboardPage.verifyPendingActions());
	else
		System.out.println("Action items are null");
	
	
	
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
