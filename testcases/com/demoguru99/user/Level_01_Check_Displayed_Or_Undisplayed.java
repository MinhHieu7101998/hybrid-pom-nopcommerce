package com.demoguru99.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.DemoGuru99HomePageObject;

public class Level_01_Check_Displayed_Or_Undisplayed extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
	}
	
	@Test
	public void TC_01_Check_Displayed_Or_UnDisplayed() {
		DemoGuru99HomePage = new DemoGuru99HomePageObject(driver);
		
		Assert.assertTrue(DemoGuru99HomePage.footerMyAccountLinkDisplayed());
		
		Assert.assertTrue(DemoGuru99HomePage.headerMyAccountLinkUndisplayed());
		
		Assert.assertTrue(DemoGuru99HomePage.errorMessageAtSubscribeTextboxUndisplayed());
		
		DemoGuru99HomePage.clickToSubscribeButton();
		
		Assert.assertTrue(DemoGuru99HomePage.errorMessageAtSubscribeTextboxDisplayed());
		
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	DemoGuru99HomePageObject DemoGuru99HomePage;
}
