package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
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

@Epic("Regression Test")
@Feature("Register and Login Tests")
public class Level_08_Log_ReportNG_Extent_Report extends AbstractTest{
	
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
	@Description("User 01 - Register to system and verify register success")
	@Story("Register to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_Register() {
		
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Register - Step 01: Click to 'Register' link ");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 02: Click to 'Gender male' radio button");
		registerPage.clickToGenderMaleRadioButton();
		
		log.info("Register - Step 03: Input to all required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.selectDayDropdown("7");
		registerPage.selectMonthDropdown("August");
		registerPage.selectYearDropdown("1980");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToCompanyNameTextbox(companyName);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register - Step 04: Click to 'Register' button submit");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 05: Verify rigister success message displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Register = Step 06: Click to 'Logout' link");
		homePage = registerPage.clickToLogoutLink();
		
	}
	
	@Description("User 02 - Login to system and verify login success")
	@Story("Login to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_02_Login() {
		log.info("Login - Step 01: Click to 'Login' link");
		LoginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Input to 'Email' textbox");
		LoginPage.inputToEmailTextbox(email);
		
		log.info("Login - Step 03: Input to 'Password' textbox");
		LoginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 04: Click to 'Login' button");
		homePage = LoginPage.clickToLoginButton();
		
		log.info("Login - Step 05: Verify 'My Account' link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("Login - Step 05: Verify 'Logout' link displayed");
		verifyTrue(homePage.isLogoutLinkDisplayed());
		
	}
	
	@Description("User 03 - Verify my account")
	@Story("Verify")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_03_View_My_Account() {
		
		log.info("View my account - Step 01: Click to 'My Account' link");
		CustomerInfoPage = homePage.clickTokMyAccountLink();
		
		log.info("View my account - Step 02: Verify 'Gender Male' is selected");
		verifyTrue(CustomerInfoPage.isGenderMaleRadioButtonSelected());
		
		log.info("View my account - Step 03: Verify 'First name' textox");
		verifyEquals(CustomerInfoPage.getFirstNameTextboxValue(),firstName);
		
		log.info("View my account - Step 04: Verify 'Last name' textbox");
		verifyEquals(CustomerInfoPage.getLastNameTextboxValue(),lastName);
		
		log.info("View my account - Step 04: Verify 'Day' dropdown");
		verifyEquals(CustomerInfoPage.getSelectedTextInDayDropdown(),"10");
		
		log.info("View my account - Step 06: Verify 'Month' dropdown");
		verifyEquals(CustomerInfoPage.getSelectedTextInMonthDropdown(),"11");
		
		log.info("View my account - Step 07: Verify 'Year' dropdown");
		verifyEquals(CustomerInfoPage.getSelectedTextInYearDropdown(),"1982");
		
		log.info("View my account - Step 08: Verify 'Email' textbox");
		verifyEquals(CustomerInfoPage.getEmailTextboxValue(),email);
		
		log.info("View my account - Step 09: Verify 'Company name' textbox");
		verifyEquals(CustomerInfoPage.getCompanyTextboxValue(),companyName);
		
		log.info("View my account - Step 10: Verify 'Newsletter' radio button selected");
		verifyFalse(CustomerInfoPage.isNewsletterRadioButtonSelected());
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
