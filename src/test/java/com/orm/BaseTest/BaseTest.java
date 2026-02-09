package com.orm.BaseTest;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.orm.driverfactory.DriverFactory;
import com.orm.listeners.ExtentReportListeners;
import com.orm.pages.DashboardPage;
import com.orm.pages.LoginPage;
import com.orm.pages.MyInfoPage;


public class BaseTest {

	
	DriverFactory df;
	protected Properties prop;
	//protected static WebDriver driver;
	protected LoginPage loginPage;
	protected DashboardPage dashboardPage;
	protected MyInfoPage myInfoPage;
	@BeforeTest
	public void beforeTest() {
		
		System.out.println("Before Test - Launch the Browser");
		df=new DriverFactory();
		prop=df.iniProperties();
		df.initDriver();
		getCurDriver().get(prop.getProperty("url"));
		loginPage=new LoginPage(getCurDriver());
		
		
	}

	
	
	
	

	@AfterTest
	public void afterTest() {
		System.out.println("After Test - Delete all Cookies");
		getCurDriver().quit();
	}
	
	
public WebDriver getCurDriver() {
	return DriverFactory.getDriver();
}
	
	
	
	
	
	
}
