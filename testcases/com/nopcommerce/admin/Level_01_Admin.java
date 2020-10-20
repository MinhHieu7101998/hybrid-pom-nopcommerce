package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.DashboardAdminPageObject;
import pageObjects.LoginAdminPageObject;
import pageObjects.ProductsAdminPageObject;

public class Level_01_Admin extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
	}
	
	@Test
	public void TC_01_Search_With_Product_Name() {
		LoginAdminPage = new LoginAdminPageObject(driver);
		
		DashboardAdminPage = LoginAdminPage.clickToLoginButton();
		
		DashboardAdminPage.clickToCatalogButton();
		
		ProductsAdminPage = DashboardAdminPage.clickToProductsButton();
		
		ProductsAdminPage.sendKeyToProductNameTextbox("Lenovo");
		
		ProductsAdminPage.clickToSearchButton();
		
		Assert.assertTrue(ProductsAdminPage.isValueDisplayedAtColumnNameByRowNumber("Product name", "1", "Lenovo IdeaCentre 600 All-in-One PC"));
		Assert.assertTrue(ProductsAdminPage.isValueDisplayedAtColumnNameByRowNumber("Product name", "2", "Lenovo Thinkpad X1 Carbon Laptop"));
		
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	LoginAdminPageObject LoginAdminPage;
	DashboardAdminPageObject DashboardAdminPage;
	ProductsAdminPageObject ProductsAdminPage;
}
