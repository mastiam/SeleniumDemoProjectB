package com.orm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orm.utils.ElementUtils;

public class MyInfoPage {

	
	By personalDetails=By.xpath("//*[@class='orangehrm-tabs']//div");
	
	WebDriver driver;
	ElementUtils eu;
	public MyInfoPage(WebDriver driver) {
		this.driver=driver;
		eu=new ElementUtils(driver);
	}
	
	
	public boolean verifyPersonalDetailsTab(int length) {
		eu.waitForElementToBeVisible(personalDetails, 25);
		List<WebElement> pd=eu.getElements(personalDetails);
		if(pd.size()==length) {
			return true;
		}else {
			return false;
		}
		
	}

	
	
	
	
	
	
}
