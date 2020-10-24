package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

public class Level_10_Page_Element_Component extends AbstractTest{
	
	WebDriver driver;
	String firstName, lastName, companyName, email, password;
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		firstName = "Ronaldo";
		lastName = "de Lima";
		companyName = "football";
		email ="Ronaldo" + getRandomNumber() + "@gmail.com";
		password = "1234567";
	}
	@Test
	public void TC_01_Register() {
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderMaleRadioButton();
		
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);
		
		registerPage.inputToTextboxByID(driver, "LastName", lastName);
		
		registerPage.inputToTextboxByID(driver, "Email", email);
		
		registerPage.inputToTextboxByID(driver, "Company", companyName);
		
		registerPage.inputToTextboxByID(driver, "Password", password);
		
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);
		
		registerPage.selectItemDropdownByName(driver, "DateOfBirthDay", "7");
		
		registerPage.selectItemDropdownByName(driver, "DateOfBirthMonth", "August");
		
		registerPage.selectItemDropdownByName(driver, "DateOfBirthYear", "1980");
		
		registerPage.clickToButtonByValue(driver, "Register");
		
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		homePage = registerPage.clickToLogoutLink();
		
	}
	
	@Test
	public void TC_02_Login() {
		
		LoginPage = homePage.clickToLoginLink();
		
		LoginPage.inputToTextboxByID(driver, "Email", email);
		
		LoginPage.inputToTextboxByID(driver, "Password", password);
		
		homePage = LoginPage.clickToLoginButton();
		
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		verifyTrue(homePage.isLogoutLinkDisplayed());
		
	}
	
	@Test
	public void TC_03_View_My_Account() {
		
		CustomerInfoPage = homePage.clickTokMyAccountLink();
		
		verifyTrue(CustomerInfoPage.isCheckboxOrRadioButtonSelectedByID(driver, "gender-male"));
		
		verifyEquals(CustomerInfoPage.getValueTextboxByID(driver, "FirstName"), firstName);
		
		verifyEquals(CustomerInfoPage.getValueTextboxByID(driver, "LastName"), lastName);
		
		verifyEquals(CustomerInfoPage.getValueTextboxByID(driver, "Email"), email);
		
		verifyEquals(CustomerInfoPage.getValueTextboxByID(driver, "Company"), companyName);
		
		verifyEquals(CustomerInfoPage.getValueDropdownByName(driver, "DateOfBirthDay"), "7");
		
		verifyEquals(CustomerInfoPage.getValueDropdownByName(driver, "DateOfBirthMonth"), "August");
		
		verifyEquals(CustomerInfoPage.getValueDropdownByName(driver, "DateOfBirthYear"), "1980");
		
		verifyTrue(CustomerInfoPage.isCheckboxOrRadioButtonSelectedByID(driver, "Newsletter"));
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
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
