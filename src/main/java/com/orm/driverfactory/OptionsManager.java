package com.orm.driverfactory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;

	public OptionsManager(Properties prop) {
		System.out.println("OptionsManager - Properties object received");
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co=new ChromeOptions();
	
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
		co.addArguments("--incognito")	;
		}
		return co;
		
	}
	
	
	
	/*
	 * public ChromeOptions getChromeOptions() {
	 * System.out.println("Creating ChromeOptions based on Properties"); co = new
	 * ChromeOptions(); if (Boolean.parseBoolean(prop.getProperty("headless"))) {
	 * co.addArguments("--headless=new"); } if
	 * (Boolean.parseBoolean(prop.getProperty("incognito"))) {
	 * co.addArguments("--incognito"); }
	 * 
	 * 
	 * if(Boolean.parseBoolean(prop.getProperty("remote"))) { String browserVersion
	 * = prop.getProperty("browserversion"); co.setBrowserVersion(browserVersion);
	 * co.setPlatformName("linux"); co.setCapability("enableVNC", true);
	 * co.setCapability("name", "OpenAppTest - " + prop.getProperty("testname"));
	 * 
	 * }
	 * 
	 * return co; }
	 * 
	 * public FirefoxOptions getFirefoxOptions() {
	 * System.out.println("Creating FirefoxOptions based on Properties"); fo = new
	 * FirefoxOptions(); if (Boolean.parseBoolean(prop.getProperty("headless"))) {
	 * fo.addArguments("-headless"); } if
	 * (Boolean.parseBoolean(prop.getProperty("incognito"))) {
	 * fo.addArguments("-private"); }
	 * 
	 * if(Boolean.parseBoolean(prop.getProperty("remote"))) { String browserVersion
	 * = prop.getProperty("browserversion"); fo.setBrowserVersion(browserVersion);
	 * fo.setPlatformName("linux"); fo.setCapability("enableVNC", true);
	 * fo.setCapability("name", "OpenAppTest - " + prop.getProperty("testname"));
	 * 
	 * }
	 * 
	 * return fo; }
	 * 
	 * public EdgeOptions getEdgeOptions() {
	 * System.out.println("Creating EdgeOptions based on Properties"); eo = new
	 * EdgeOptions(); if (Boolean.parseBoolean(prop.getProperty("headless"))) {
	 * eo.addArguments("--headless=new"); } if
	 * (Boolean.parseBoolean(prop.getProperty("incognito"))) {
	 * eo.addArguments("-inprivate"); }
	 * 
	 * if(Boolean.parseBoolean(prop.getProperty("remote"))) { String browserVersion
	 * = prop.getProperty("browserversion"); eo.setBrowserVersion(browserVersion);
	 * eo.setPlatformName("linux"); eo.setCapability("enableVNC", true);
	 * eo.setCapability("name", "OpenAppTest - " + prop.getProperty("testname"));
	 * 
	 * }
	 * 
	 * return eo; }
	 */

}
