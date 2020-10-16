package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderMaleRadioButton() {
		waitToElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitToElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToELement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisible(driver, RegisterPageUI.LASTNAME_TEXBOX);
		sendkeyToELement(driver, RegisterPageUI.LASTNAME_TEXBOX, lastName);
	}

	public void selectDayDropdown(String day) {
		waitToElementClickable(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.DAY_DROPDOWN, day);
	}
	
	public void selectMonthDropdown(String month) {
		waitToElementClickable(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, month);
	}
	
	public void selectYearDropdown(String year) {
		waitToElementClickable(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, year);
		
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToELement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToCompanyNameTextbox(String companyName) {
		waitToElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendkeyToELement(driver, RegisterPageUI.COMPANY_TEXTBOX, companyName);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToELement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitToElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToELement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisterSuccessMessage() {
		waitToElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public HomePageObject clickToLogoutLink() {
		waitToElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	public String getErrorFirstNameText() {
		waitToElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
	}
	
	public String getErrorLastNameText() {
		waitToElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
	}
	
	public String getErrorEmailText() {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	public String getErrorPasswordText() {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}
	
	public String getErrorConfirmPasswordText() {
		waitToElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}
	
	public String getErrorEmailExists() {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_EXISTS_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_EXISTS_ERROR_MESSAGE);
	}
	
	public String getErrorPasswordLessSixCharatersAboveMessage() {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_LESS_SIX_CHARATERS_ABOVE_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_LESS_SIX_CHARATERS_ABOVE_MESSAGE);
	}
	
	public String getErrorPasswordLessSixCharatersBelowMessage() {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_LESS_SIX_CHARATERS_BELOW_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_LESS_SIX_CHARATERS_BELOW_MESSAGE);
	}
	
	public String getErrorPasswordAndConfirmPasswordDoNotMatch() {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_DIFFERENCE_CONFIRM_PASSWORD_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_DIFFERENCE_CONFIRM_PASSWORD_MESSAGE);
	}
}
