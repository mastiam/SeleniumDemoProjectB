package com.orm.driverfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	//static WebDriver driver;
	Properties prop;
	OptionsManager op;
	
	private static ThreadLocal<WebDriver> tdl=new ThreadLocal<WebDriver>();
	
	
	
	public WebDriver initDriver() {
		String browser=prop.getProperty("browser");
		System.out.println("Browser property loaded from prop :"+browser);
		
		switch (browser.toLowerCase()) {
		case "chrome":
			op=new OptionsManager(prop);
			tdl.set(new ChromeDriver(op.getChromeOptions()));
			//driver = new ChromeDriver(op.getChromeOptions());
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			return tdl.get();
			
		case "firefox":
			tdl.set(new FirefoxDriver());
			//driver = new FirefoxDriver();
			getDriver().manage().window().maximize();
			return tdl.get();
		case "edge":
			tdl.set(new EdgeDriver());
			return getDriver();
		default:
			System.out.println("Please pass the correct browser: " + browser);
			return null;
		}
		
	}
	
	
	public Properties iniProperties() {
		
		String userdir=System.getProperty("user.dir"); //C:\Work\WSSeleniumProject\SeleniumPOMProject
		
		System.out.println(userdir);
		 prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(userdir+"/src/test/resources/qaenv.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
	
	public static String getScreenshot() {

		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;

	}
	
	
	public static WebDriver getDriver() {
		return tdl.get();
	}
	
	

	
	
}
