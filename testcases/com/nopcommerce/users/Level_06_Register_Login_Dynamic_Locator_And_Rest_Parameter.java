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
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointsPageObject;

public class Level_06_Register_Login_Dynamic_Locator_And_Rest_Parameter extends AbstractTest{
	
	WebDriver driver;
	String firstName, lastName, companyName, email, password;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		
		driver = getBrowserDriver(browserName);
		
		firstName = "Ronaldo";
		lastName = "de Lima";
		companyName = "football";
		email ="Ronaldo" + getRandomNumber() + "@gmail.com";
		password = "1234567";
	}
	@Test
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
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		homePage = registerPage.clickToLogoutLink();
		
	}
	
	@Test
	public void TC_02_Login() {
		LoginPage = homePage.clickToLoginLink();
		
		LoginPage.inputToEmailTextbox(email);
		
		LoginPage.inputToPasswordTextbox(password);
		
		homePage = LoginPage.clickToLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
		
	}
	
	@Test
	public void TC_03_View_My_Account() {
		CustomerInfoPage = homePage.clickTokMyAccountLink();
		
		Assert.assertTrue(CustomerInfoPage.isGenderMaleRadioButtonSelected());
		
		Assert.assertEquals(CustomerInfoPage.getFirstNameTextboxValue(),firstName);
		
		Assert.assertEquals(CustomerInfoPage.getLastNameTextboxValue(),lastName);
		
		Assert.assertEquals(CustomerInfoPage.getSelectedTextInDayDropdown(),"7");
		
		Assert.assertEquals(CustomerInfoPage.getSelectedTextInMonthDropdown(),"8");
		
		Assert.assertEquals(CustomerInfoPage.getSelectedTextInYearDropdown(),"1980");
		
		Assert.assertEquals(CustomerInfoPage.getEmailTextboxValue(),email);
		
		Assert.assertEquals(CustomerInfoPage.getCompanyTextboxValue(),companyName);
		
		Assert.assertTrue(CustomerInfoPage.isNewsletterRadioButtonSelected());
	}
	
	@Test
	public void TC_04_Switch_Page() {
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
	
	@Test
	public void TC_05_Switch_Page_Solution_1() {
		DownloadableProductsPage = (DownloadableProductsPageObject) AddressesPage.openLinkByPageName(driver, "Downloadable products");
		
		ChangePasswordPage = (ChangePasswordPageObject) DownloadableProductsPage.openLinkByPageName(driver, "Change password");
		
		CustomerInfoPage = (CustomerInfoPageObject) ChangePasswordPage.openLinkByPageName(driver, "Customer info");
		
		OrdersPage = (OrdersPageObject) CustomerInfoPage.openLinkByPageName(driver, "Orders");
		
		BackInStockSubscriptionsPage = (BackInStockSubscriptionsPageObject) OrdersPage.openLinkByPageName(driver, "Back in stock subscriptions");
		
		MyProductReviewsPage = (MyProductReviewsPageObject) BackInStockSubscriptionsPage.openLinkByPageName(driver, "My product reviews");
		
		RewardPointsPage= (RewardPointsPageObject) MyProductReviewsPage.openLinkByPageName(driver, "Reward points");
		
		CustomerInfoPage = (CustomerInfoPageObject) RewardPointsPage.openLinkByPageName(driver, "Customer info");
		
	}
	
	@Test
	public void TC_06_Switch_Page_Solution_2() {
		CustomerInfoPage.openLinkWithPageName(driver, "Addresses");
		AddressesPage = PageGeneratorManager.getAddressesPage(driver);
		
		AddressesPage.openLinkWithPageName(driver, "Orders");
		OrdersPage = PageGeneratorManager.getOrdersPage(driver);
		
		OrdersPage.openLinkWithPageName(driver, "Downloadable products");
		DownloadableProductsPage = PageGeneratorManager.getDownloadableProductsPage(driver);
		
		DownloadableProductsPage.openLinkWithPageName(driver, "Back in stock subscriptions");
		BackInStockSubscriptionsPage = PageGeneratorManager.getBackInStockSubscriptionsPage(driver);
		
		BackInStockSubscriptionsPage.openLinkWithPageName(driver, "Reward points");
		RewardPointsPage = PageGeneratorManager.getRewardPointsPage(driver);
		
		RewardPointsPage.openLinkWithPageName(driver, "Change password");
		ChangePasswordPage = PageGeneratorManager.getChangePasswordPage(driver);
		
		ChangePasswordPage.openLinkWithPageName(driver, "My product reviews");
		MyProductReviewsPage = PageGeneratorManager.getMyProductReviewsPage(driver);
		
		MyProductReviewsPage.openLinkWithPageName(driver, "Customer info");
		CustomerInfoPage = PageGeneratorManager.getCustomerInfoPage(driver);
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
