package com.orm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orm.utils.ElementUtils;
import com.orm.utils.JavascriptUtils;

public class LoginPage {

	WebDriver driver;
	ElementUtils elementUtils;
	
	By username=By.name("username");
	By password=By.name("password");
	By loginBtn=By.xpath("//button[@type='submit']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtils=new ElementUtils(driver);
	
	}
	
	
	public DashboardPage doLogin(String user, String pass) {
		
		elementUtils.dosendKeys(username, user);
		elementUtils.dosendKeys(password, pass);
		elementUtils.doClick(loginBtn);	
		
		 return new DashboardPage(driver);
		
		 
		 //return new DashboardPage(driver);
	}
	
	
	public String getLoginPageTitle() {
		
		return elementUtils.getPageTitle();
	}
	
	
	
	
	
}
