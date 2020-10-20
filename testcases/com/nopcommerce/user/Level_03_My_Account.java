package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AddressesPageObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyProductReviewsPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.ProductPageObject;
import pageObjects.ProductReviewPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_My_Account extends AbstractTest {
	WebDriver driver;
	String invalidEmail, emailConstant, newPassword;
	String firstName, lastName, companyName, email, password, invalidPassword;
	String titleReview, textReview;
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		invalidEmail ="automation.gmail.com";
		firstName = "Ronaldo";
		lastName = "de Lima";
		companyName = "football";
		email ="Ronaldo" + getRandomNumber() + "@gmail.com";
		password = "1234567";
		invalidPassword = "12345";
		emailConstant = email;
		newPassword ="123456789";
		titleReview = "Minh Hieu";
		textReview = "A B C X Y Z";
	}
	
	@Test
	public void TC_01_Update_Customer_Info() {
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

		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);
		
		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		CustomerInfoPage = homePage.clickTokMyAccountLink();
		
		CustomerInfoPage.setGenderIsFemale();
		
		CustomerInfoPage.setFirstName("Automation");
		
		CustomerInfoPage.setLastName("FC");
		
		CustomerInfoPage.setDayDropdown("1");
		
		CustomerInfoPage.setMonthDropwdown("January");
		
		CustomerInfoPage.setYearDropwdown("1922");
		
		CustomerInfoPage.setEmail("automationfc.vn@gmail.com");
		
		CustomerInfoPage.setCompanyName("Automation FC");
		
		CustomerInfoPage.clickToSaveButton();
		
		Assert.assertTrue(CustomerInfoPage.isGenderFemaleRadioSelected());
		
		Assert.assertEquals(CustomerInfoPage.getFirstNameTextboxValue(), "Automation");
		
		Assert.assertEquals(CustomerInfoPage.getLastNameTextboxValue(), "FC");
		
		Assert.assertEquals(CustomerInfoPage.getSelectedTextInDayDropdown(), "1");
		
		Assert.assertEquals(CustomerInfoPage.getSelectedTextInMonthDropdown(), "1");
		
		Assert.assertEquals(CustomerInfoPage.getSelectedTextInYearDropdown(), "1922");
		
		Assert.assertEquals(CustomerInfoPage.getEmailTextboxValue(), "automationfc.vn@gmail.com");
		
		Assert.assertEquals(CustomerInfoPage.getCompanyTextboxValue(), "Automation FC");
	}
	
	@Test
	public void TC_02_Add_Addresses() {
		
		CustomerInfoPage.openLinkWithPageName(driver, "Addresses");
		
		AddressesPage = PageGeneratorManager.getAddressesPage(driver);
		
		AddressesPage.clickToAddNewAddressLink();
		
		AddressesPage.setFirstName("Automation");
		
		AddressesPage.setLastName("FC");
		
		AddressesPage.setEmail("automationfc.vn@gmail.com");
		
		AddressesPage.setCompanyName("Automation FC");
		
		AddressesPage.setCountryDropdown("Viet Nam");
		
		AddressesPage.setCityName("Da Nang");
		
		AddressesPage.setAddress1("123/04 Le Lai");
		
		AddressesPage.setAddress2("234/05 Hai Phong");
		
		AddressesPage.setZipCode("550000");
		
		AddressesPage.setPhoneNumber("0123456789");
		
		AddressesPage.setFaxNumber("0987654321");
		
		AddressesPage.clickToSaveButton();
		
		Assert.assertEquals(AddressesPage.getTitleInfo(), "Automation FC");
		
		Assert.assertEquals(AddressesPage.getInfoEmail(), "Email: automationfc.vn@gmail.com");
		
		Assert.assertEquals(AddressesPage.getInfoPhoneNumber(), "Phone number: 0123456789");
		
		Assert.assertEquals(AddressesPage.getInfoFaxNumber(), "Fax number: 0987654321");
		
		Assert.assertEquals(AddressesPage.getCompanyName(), "Automation FC");
		
		Assert.assertEquals(AddressesPage.getAddress1(), "123/04 Le Lai");
		
		Assert.assertEquals(AddressesPage.getAddress2(), "234/05 Hai Phong");
		
		Assert.assertEquals(AddressesPage.getZipCodeAndCity(), "Da Nang, 550000");
		
		Assert.assertEquals(AddressesPage.getCountry(), "Viet Nam");
		
	}
	
	@Test
	public void TC_03_Change_Password() {
		AddressesPage.openLinkWithPageName(driver, "Change password");
		
		ChangePasswordPage = PageGeneratorManager.getChangePasswordPage(driver);
		
		ChangePasswordPage.setOldPassowrdTextbox(password);
		
		ChangePasswordPage.setNewPassowrdTextbox(newPassword);
		
		ChangePasswordPage.setConfirmPassowrdTextbox(newPassword);
		
		ChangePasswordPage.clickToChangePasswordButton();
		
		homePage = ChangePasswordPage.clickToLogoutLink();
		
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox("automationfc.vn@gmail.com");
		
		loginPage.inputToPasswordTextbox(password);
		
		loginPage.clickToLoginButton();

		Assert.assertTrue(loginPage.getErrorValidEmailAndInvalidPasswordAboveMessage().contains("Login was unsuccessful. Please correct the errors and try again."));

		Assert.assertEquals(loginPage.getErrorValidEmailAndInvalidPassowrdBelowMessage(), "The credentials provided are incorrect");
		
		loginPage.inputToEmailTextbox("automationfc.vn@gmail.com");
		
		loginPage.inputToPasswordTextbox(newPassword);
		
		homePage = loginPage.clickToLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
	}
	@Test
	public void TC_04_Add_Review_In_My_Product_Reviews() {
		
		ProductPage = homePage.clickToProductComputerPage();
		
		ProductReviewPage =  ProductPage.clickToAddYourReviewLink();
		
		ProductReviewPage.inputTitlteReviewTextbox(titleReview);
		
		ProductReviewPage.inputTextReviewTextbox(textReview);
		
		ProductReviewPage.clickToRatingBadRaidoButton();
		
		ProductReviewPage.clickToSubmitReview();
		
		CustomerInfoPage = ProductReviewPage.clickToMyAccountLink();
		
		CustomerInfoPage.openLinkWithPageName(driver, "My product reviews");
		
		MyProductReviewsPage = PageGeneratorManager.getMyProductReviewsPage(driver);
		
		Assert.assertEquals(MyProductReviewsPage.getTitleReview(), titleReview);
		
		Assert.assertEquals(MyProductReviewsPage.getTextReview(), textReview);
		
		Assert.assertTrue(MyProductReviewsPage.isDisplayedRating());
		
		ProductPage = MyProductReviewsPage.clickToLinkProdcut();
		
		Assert.assertEquals(ProductPage.getCurrentUrl(), "https://demo.nopcommerce.com/build-your-own-computer");
		
	}
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
	
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInfoPageObject CustomerInfoPage;
	AddressesPageObject AddressesPage;
	ChangePasswordPageObject ChangePasswordPage;
	MyProductReviewsPageObject MyProductReviewsPage;
	ProductPageObject ProductPage;
	ProductReviewPageObject ProductReviewPage;
}
