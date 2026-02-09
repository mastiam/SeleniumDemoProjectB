package com.orm.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;
	JavascriptUtils jsu;
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		jsu=new JavascriptUtils(driver);
	}
	
	
	public String getPageTitle() {	
		
		return driver.getTitle();
	}
	
	
	
	public WebElement getElement(By locator) {
		jsu.flashElement(driver.findElement(locator));
		return driver.findElement(locator);
	}
	
	public List<WebElement> getElements(By locator) {
		jsu.flashElement(driver.findElement(locator));
		return driver.findElements(locator);
	}
	
	public void dosendKeys(By locator, String value) {
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
		
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	
	public void doScrollAndClick(By locator) {
		jsu.scrollIntoView(getElement(locator));
		getElement(locator).click();
	}
	
	
	public void waitForElementToBeVisible(By loc, int timeOut) {
		// Implement explicit wait logic here
		jsu.waitForPageLoad();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(getElement(loc)));
	}
	
	
	

	
	
}
