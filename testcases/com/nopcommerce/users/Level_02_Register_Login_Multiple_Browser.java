package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_02_Register_Login_Multiple_Browser extends AbstractTest{
	
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
		
		homePage = new HomePageObject(driver);
		
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
		
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
		
		registerPage.clickToLogoutLink();
		
		homePage = new HomePageObject(driver);
	}
	
	@Test
	public void TC_02_Login() {
		homePage.clickToLoginLink();
		
		LoginPage = new LoginPageObject(driver);

		LoginPage.inputToEmailTextbox(email);
		
		LoginPage.inputToPasswordTextbox(password);
		
		LoginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
		
	}
	
	@Test
	public void TC_03_View_My_Account() {
		homePage.clickTokMyAccountLink();
		
		CustomerInfoPage = new CustomerInfoPageObject(driver);
		
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
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject LoginPage;
	CustomerInfoPageObject CustomerInfoPage;
}	
