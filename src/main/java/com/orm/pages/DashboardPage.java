package com.orm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.orm.utils.ElementUtils;
import com.orm.utils.JavascriptUtils;

public class DashboardPage {

	WebDriver driver;
	ElementUtils eleUtil;

	By sidePanel = By.xpath("//*[@class='oxd-main-menu']/li");

	By viewMyDetails = By.xpath("//*[@aria-label='Sidepanel']//ul/li/a[contains(@href,'viewMyDetails')]");
	
	By sidePanelList=By.xpath("//*[@aria-label='Sidepanel']//ul/li");
	
	By pendingActions=By.xpath("//*[@class='orangehrm-todo-list']/div//p");
	
	By viewMyD=By.xpath("//a[contains(@href,'viewMyDetails')]");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtils(driver);
		

	}

	public String getPageTitle() {
		eleUtil.waitForElementToBeVisible(sidePanel, 20);
		String title = eleUtil.getPageTitle();
		return title;
	}
	
	
	public boolean verifySidePanelListItems(List<String> inputList) {
		eleUtil.waitForElementToBeVisible(sidePanelList, 20);
		List<WebElement> li=eleUtil.getElements(sidePanelList);
		List<String> sidePList=new ArrayList<String>();
		for(WebElement ele:li) {
			sidePList.add(ele.getText().trim());		
		}
		System.out.println("Actual :"+sidePList);
		System.out.println("Expeceted :"+inputList);
		if(inputList.equals(sidePList)) {
			System.out.println("Both list are equal");
			return true;
		}else {
			System.out.println("Both list are not equal");
			 return false;
		}
	
	}
	
	
	public List<String> verifyPendingActions() {
		
		List<WebElement> li=eleUtil.getElements(pendingActions);
		List<String> actions=new ArrayList<String>();
		if(li.size()>0) {
			
			for(WebElement ele:li) {
				actions.add(ele.getText());
			}
			
			return actions;
		}else {
			return null;
		}
	
	}
	
	
	public MyInfoPage doClickViewMyLink() {
		eleUtil.doClick(viewMyD);
		return new MyInfoPage(driver);
	}

}
