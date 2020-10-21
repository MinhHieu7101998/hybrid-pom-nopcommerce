package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointsPageObject;

public class Level_07_Custom_Assert_And_Verify extends AbstractTest {

	WebDriver driver;
	String firstName, lastName, companyName, email, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		firstName = "Ronaldo";
		lastName = "de Lima";
		companyName = "football";
		email = "Ronaldo" + getRandomNumber() + "@gmail.com";
		password = "1234567";
	}

	public void TC_01_Register() {

		homePage = new HomePageObject(driver);

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
		
		// Failded
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");

		// Pass
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		// Failed
		Assert.assertTrue(false);
		
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_02_Login() {
		
		homePage = new HomePageObject(driver);

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
		
		
		//Pass
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		homePage = registerPage.clickToLogoutLink();
		
		LoginPage = homePage.clickToLoginLink();

		LoginPage.inputToEmailTextbox(email);

		LoginPage.inputToPasswordTextbox(password);

		homePage = LoginPage.clickToLoginButton();
		
		
		// Failed
		verifyTrue(false);
		
		// Pass
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		// Pass
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
		
		//Failed
		verifyFalse(true);
		
		//Failed
		verifyEquals(firstName, "Maradona");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
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
