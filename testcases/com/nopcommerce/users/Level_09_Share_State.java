package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Register_Account;

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

public class Level_09_Share_State extends AbstractTest {

	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Login() {

		LoginPage = homePage.clickToLoginLink();

		LoginPage.inputToEmailTextbox(Common_01_Register_Account.email);

		LoginPage.inputToPasswordTextbox(Common_01_Register_Account.password);

		homePage = LoginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());

	}

	@Test
	public void TC_02_View_My_Account() {
		
		CustomerInfoPage = homePage.clickTokMyAccountLink();

		Assert.assertTrue(CustomerInfoPage.isGenderMaleRadioButtonSelected());

		Assert.assertEquals(CustomerInfoPage.getFirstNameTextboxValue(), Common_01_Register_Account.firstName);

		Assert.assertEquals(CustomerInfoPage.getLastNameTextboxValue(), Common_01_Register_Account.lastName);

		Assert.assertEquals(CustomerInfoPage.getSelectedTextInDayDropdown(), "10");

		Assert.assertEquals(CustomerInfoPage.getSelectedTextInMonthDropdown(), "11");

		Assert.assertEquals(CustomerInfoPage.getSelectedTextInYearDropdown(), "1983");

		Assert.assertEquals(CustomerInfoPage.getEmailTextboxValue(), Common_01_Register_Account.email);

		Assert.assertEquals(CustomerInfoPage.getCompanyTextboxValue(), Common_01_Register_Account.companyName);

		Assert.assertTrue(CustomerInfoPage.isNewsletterRadioButtonSelected());
	}

	@Test
	public void TC_03_Switch_Page() {
		
		MyProductReviewsPage = CustomerInfoPage.openMyProductReviews(driver);

		OrdersPage = MyProductReviewsPage.openOrdersPage(driver);

		ChangePasswordPage = OrdersPage.openChangePasswordPage(driver);

		DownloadableProductsPage = ChangePasswordPage.openDownloadableProducts(driver);

		RewardPointsPage = DownloadableProductsPage.openRewardPoints(driver);

		BackInStockSubscriptionsPage = RewardPointsPage.openBackInStockSubscriptionsPage(driver);

		MyProductReviewsPage = BackInStockSubscriptionsPage.openMyProductReviews(driver);

		BackInStockSubscriptionsPage = MyProductReviewsPage.openBackInStockSubscriptionsPage(driver);

		ChangePasswordPage = BackInStockSubscriptionsPage.openChangePasswordPage(driver);

		AddressesPage = ChangePasswordPage.openAddressesPage(driver);
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
