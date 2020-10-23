package com.nopcommerce.commons;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.AbstractTest;
import pageObjects.AddressesPageObject;
import pageObjects.BackInStockSubscriptionsPageObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.DownloadableProductsPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyProductReviewsPageObject;
import pageObjects.OrdersPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointsPageObject;

public class Common_01_Register_Account extends AbstractTest{
	
	WebDriver driver;
	public static String  email, password, firstName, lastName, companyName;
	@Parameters({"browser", "url"})
	@BeforeTest
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		firstName = "Ronaldo";
		lastName = "de Lima";
		companyName = "football";
		email ="Ronaldo" + getRandomNumber() + "@gmail.com";
		password = "1234567";
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderMaleRadioButton();
		
		registerPage.inputToFirstNameTextbox(firstName);
		
		registerPage.inputToLastNameTextbox(lastName);
		
		registerPage.selectDayDropdown("7");
		
		registerPage.selectMonthDropdown("August");
		
		registerPage.selectYearDropdown("1980");
		
		registerPage.inputToEmailTextbox(email);
		
		registerPage.inputToCompanyNameTextbox(companyName);
		
		registerPage.inputToPasswordTextbox(password);
		
		registerPage.inputToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		homePage = registerPage.clickToLogoutLink();
		
		removeDriver();
	}
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject LoginPage;
	CustomerInfoPageObject CustomerInfoPage;
	MyProductReviewsPageObject MyProductReviewsPage;
	OrdersPageObject OrdersPage;
	ChangePasswordPageObject ChangePasswordPage;
	DownloadableProductsPageObject DownloadableProductsPage;
	RewardPointsPageObject RewardPointsPage;
	BackInStockSubscriptionsPageObject BackInStockSubscriptionsPage;
	AddressesPageObject AddressesPage;
	
}	
