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
		
		Assert.assertTrue(ProductsAdminPage.isValueDisplayedAtColumnNameByRowNumber("Product name", "1", "$100 Physical Gift Card"));
		Assert.assertTrue(ProductsAdminPage.isValueDisplayedAtColumnNameByRowNumber("Price", "4", "27.56"));
		Assert.assertTrue(ProductsAdminPage.isValueDisplayedAtColumnNameByRowNumber("Stock quantity", "2", ""));
		Assert.assertTrue(ProductsAdminPage.isValueDisplayedAtColumnNameByRowNumber("Product type", "5", "Simple"));
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	LoginAdminPageObject LoginAdminPage;
	DashboardAdminPageObject DashboardAdminPage;
	ProductsAdminPageObject ProductsAdminPage;
}
