package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_01_Register extends AbstractTest {
	WebDriver driver;
	String invalidEmail, emailConstant;
	String firstName, lastName, companyName, email, password, invalidPassword;
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
	}
	
	public void TC_01_Register_With_Empty_Data() {
		homePage = new HomePageObject(driver);
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorFirstNameText(), "First name is required.");
		
		Assert.assertEquals(registerPage.getErrorLastNameText(), "Last name is required.");
		
		Assert.assertEquals(registerPage.getErrorEmailText(), "Email is required.");
		
		Assert.assertEquals(registerPage.getErrorPasswordText(), "Password is required.");
		
		Assert.assertEquals(registerPage.getErrorConfirmPasswordText(), "Password is required.");
		
	}
	public void TC_02_Register_With_Invalid_Email() {
		homePage = new HomePageObject(driver);
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.inputToEmailTextbox(invalidEmail);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorEmailText(), "Wrong email");
	}
	public void TC_03_Register_With_Exist_Email() {
		homePage = new HomePageObject(driver);
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderMaleRadioButton();
		
		registerPage.inputToFirstNameTextbox(firstName);
		
		registerPage.inputToLastNameTextbox(lastName);
		
		registerPage.selectDayDropdown("7");
		
		registerPage.selectMonthDropdown("August");
		
		registerPage.selectYearDropdown("1980");
		
		registerPage.inputToEmailTextbox(emailConstant);
		
		registerPage.inputToCompanyNameTextbox(companyName);
		
		registerPage.inputToPasswordTextbox(password);
		
		registerPage.inputToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		homePage  = registerPage.clickToLogoutLink();
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderMaleRadioButton();
		
		registerPage.inputToFirstNameTextbox(firstName);
		
		registerPage.inputToLastNameTextbox(lastName);
		
		registerPage.selectDayDropdown("7");
		
		registerPage.selectMonthDropdown("August");
		
		registerPage.selectYearDropdown("1980");
		
		registerPage.inputToEmailTextbox(emailConstant);
		
		registerPage.inputToCompanyNameTextbox(companyName);
		
		registerPage.inputToPasswordTextbox(password);
		
		registerPage.inputToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorEmailExists(), "The specified email already exists");
	}
	
	public void TC_04_Register_With_Password_Less_Six_Characters() {
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
		
		registerPage.inputToPasswordTextbox(invalidPassword);
		
		registerPage.inputToConfirmPasswordTextbox(invalidPassword);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorPasswordLessSixCharatersAboveMessage(), "Password must meet the following rules:");
		Assert.assertEquals(registerPage.getErrorPasswordLessSixCharatersBelowMessage(), "must have at least 6 characters");
	}
	
	public void TC_05_Register_With_Password_Different_Confirm_Password() {
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
		
		registerPage.inputToConfirmPasswordTextbox(invalidPassword);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorPasswordAndConfirmPasswordDoNotMatch(), "The password and confirmation password do not match.");
		
	}
	
	@Test
	public void TC_06_Register_With_Email_And_Password_Valid() {
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
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	HomePageObject homePage;
	RegisterPageObject registerPage;
}
