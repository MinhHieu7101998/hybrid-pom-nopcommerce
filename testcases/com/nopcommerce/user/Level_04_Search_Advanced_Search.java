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
import pageObjects.SearchPageObject;

public class Level_04_Search_Advanced_Search extends AbstractTest {
	WebDriver driver;
	String firstName, lastName, companyName, email, password;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		firstName = "Ronaldo";
		lastName = "de Lima";
		companyName = "football";
		email = "Ronaldo" + getRandomNumber() + "@gmail.com";
		password = "1234567";
	}

	@Test
	public void TC_01_Search_With_Empty_Data() {
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

		searchPage = homePage.clickToSearchLinkInFooter();

		searchPage.clickToSearchKeywordButton();

		Assert.assertEquals(searchPage.getWarningText(), "Search term minimum length is 3 characters");
	}

	@Test
	public void TC_02_Search_With_Data_Not_Exist() {

		searchPage.inputSearchKeywordTextbox("Macbook Pro 2050");

		searchPage.clickToSearchKeywordButton();

		Assert.assertEquals(searchPage.getNoResultText(), "No products were found that matched your criteria.");
	}

	@Test
	public void TC_03_Search_With_Product_Name_Relatively() {

		searchPage.inputSearchKeywordTextbox("Lenovo");

		searchPage.clickToSearchKeywordButton();

		Assert.assertEquals(searchPage.getProductName_1(), "Lenovo IdeaCentre 600 All-in-One PC");

		Assert.assertEquals(searchPage.getProductName_2(), "Lenovo Thinkpad X1 Carbon Laptop");
	}

	@Test
	public void TC_04_Search_With_Product_Name_Absolute() {
		searchPage.inputSearchKeywordTextbox("ThinkPad X1 Carbon");

		searchPage.clickToSearchKeywordButton();

		Assert.assertTrue(searchPage.isDisplayedOnlyProduct());

	}

	@Test
	public void TC_05_Advanced_Search_With_Parent_Categories() {

		searchPage.inputSearchKeywordTextbox("Apple Macbook Pro");

		searchPage.clickToAdvancedSearchCheckbox();

		searchPage.selectItemInCategoryDropdown("Computers");

		searchPage.clickToSearchKeywordButton();

		Assert.assertEquals(searchPage.getNoResultText(), "No products were found that matched your criteria.");

	}

	@Test
	public void TC_06_Advanced_Search_With_Sub_Categories() {

		searchPage.inputSearchKeywordTextbox("Apple Macbook Pro");

		searchPage.clickToAdvancedSearchCheckbox();

		searchPage.selectItemInCategoryDropdown("Computers");

		searchPage.clickToAutomaticallySearchButton();

		searchPage.clickToSearchKeywordButton();

		Assert.assertEquals(searchPage.getProductTitle(), "Apple MacBook Pro 13-inch");
	}

	@Test
	public void TC_07_Advanced_Search_With_Incorrect_Manufacturer() {

		searchPage.inputSearchKeywordTextbox("Apple Macbook Pro");

		searchPage.clickToAdvancedSearchCheckbox();

		searchPage.selectItemInCategoryDropdown("Computers");

		searchPage.clickToAutomaticallySearchButton();

		searchPage.selectItemInManufacturerDropdown("HP");

		searchPage.clickToSearchKeywordButton();

		Assert.assertEquals(searchPage.getNoResultText(), "No products were found that matched your criteria.");

	}

	@Test
	public void TC_08_Advanced_Search_With_Correct_Manufacturer() {

		searchPage.inputSearchKeywordTextbox("Apple Macbook Pro");

		searchPage.clickToAdvancedSearchCheckbox();

		searchPage.selectItemInCategoryDropdown("Computers");

		searchPage.clickToAutomaticallySearchButton();

		searchPage.selectItemInManufacturerDropdown("Apple");

		searchPage.clickToSearchKeywordButton();

		Assert.assertTrue(searchPage.isDisplayedOnlyProduct());

		Assert.assertEquals(searchPage.getProductTitle(), "Apple MacBook Pro 13-inch");

	}

	@Test
	public void TC_09_Advanced_Search_With_Valid_Price_Range() {

		searchPage.inputSearchKeywordTextbox("Apple Macbook Pro");

		searchPage.clickToAdvancedSearchCheckbox();

		searchPage.selectItemInCategoryDropdown("Computers");

		searchPage.clickToAutomaticallySearchButton();

		searchPage.selectItemInManufacturerDropdown("Apple");

		searchPage.inputPriceFromTextbox("1000");

		searchPage.inputPriceToTextbox("2000");

		searchPage.clickToSearchKeywordButton();

		Assert.assertTrue(searchPage.isDisplayedOnlyProduct());

		Assert.assertEquals(searchPage.getProductTitle(), "Apple MacBook Pro 13-inch");
	}

	@Test
	public void TC_10_Advanced_Search_With_Price_Range_Smaller_Product_Price() {

		searchPage.inputSearchKeywordTextbox("Apple Macbook Pro");

		searchPage.clickToAdvancedSearchCheckbox();

		searchPage.selectItemInCategoryDropdown("Computers");

		searchPage.clickToAutomaticallySearchButton();

		searchPage.selectItemInManufacturerDropdown("Apple");

		searchPage.inputPriceFromTextbox("1000");

		searchPage.inputPriceToTextbox("1700");

		searchPage.clickToSearchKeywordButton();

		Assert.assertEquals(searchPage.getNoResultText(), "No products were found that matched your criteria.");
	}

	@Test
	public void TC_11_Advanced_Search_With_Price_Range_Bigger_Product_Price() {

		searchPage.inputSearchKeywordTextbox("Apple Macbook Pro");

		searchPage.clickToAdvancedSearchCheckbox();

		searchPage.selectItemInCategoryDropdown("Computers");

		searchPage.clickToAutomaticallySearchButton();

		searchPage.selectItemInManufacturerDropdown("Apple");

		searchPage.inputPriceFromTextbox("1900");

		searchPage.inputPriceToTextbox("5000");

		searchPage.clickToSearchKeywordButton();

		Assert.assertEquals(searchPage.getNoResultText(), "No products were found that matched your criteria.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	SearchPageObject searchPage;
}
