package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_01_Register_Login_Page_Object{
	String projectFolderPath = System.getProperty("user.dir");
	WebDriver driver;
	String firstName, lastName, companyName, email, password;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectFolderPath +"\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
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
	
	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
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
