package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_02_Login extends AbstractTest {
	WebDriver driver;
	String invalidEmail;
	String firstName, lastName, companyName, email, password;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		invalidEmail = "automation.gmail.com";
		firstName = "Ronaldo";
		lastName = "de Lima";
		companyName = "football";
		email = "Ronaldo" + getRandomNumber() + "@gmail.com";
		password = "1234567";
	}

	public void TC_01_Login_With_Empty_Email_And_Empty_Password() {
		homePage = new HomePageObject(driver);

		loginPage = homePage.clickToLoginLink();

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorEmptyEmailMessage(), "Please enter your email");
	}

	public void TC_02_Login_With_Invalid_Email() {
		homePage = new HomePageObject(driver);

		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorInvalidEmailMessage(), "Wrong email");
	}

	public void TC_03_Login_With_Email_Not_Exists() {
		homePage = new HomePageObject(driver);

		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);

		loginPage.inputToPasswordTextbox(password);

		loginPage.clickToLoginButton();

		Assert.assertTrue(loginPage.getErrorEmailNotExistsAboveMessage().contains("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertEquals(loginPage.getErrorEmailNotExistsBelowMessage(), "No customer account found");

	}

	public void TC_04_Login_With_Valid_Email_And_Empty_Password() {
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

		loginPage.clickToLoginButton();

		Assert.assertTrue(loginPage.getErrorValidEmailAndEmptyPasswordAboveMessage().contains("Login was unsuccessful. Please correct the errors and try again."));

		Assert.assertEquals(loginPage.getErrorValidEmailAndEmptyPassowrdBelowMessage(), "The credentials provided are incorrect");

	}

	public void TC_05_Login_With_Valid_Email_And_Invalid_Password() {
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
		
		loginPage.inputToPasswordTextbox(companyName);

		loginPage.clickToLoginButton();

		Assert.assertTrue(loginPage.getErrorValidEmailAndInvalidPasswordAboveMessage().contains("Login was unsuccessful. Please correct the errors and try again."));

		Assert.assertEquals(loginPage.getErrorValidEmailAndInvalidPassowrdBelowMessage(), "The credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_With_Valid_Email_And_Valid_Password() {
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
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
}
