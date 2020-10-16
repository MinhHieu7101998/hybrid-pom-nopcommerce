package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends AbstractPage {
	WebDriver driver;
	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisible(driver, CustomerInfoPageUI.GENDER_MALE_RADIO_BUTTON);
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO_BUTTON);
	}

	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitToElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getSelectedTextInDayDropdown() {
		waitToElementVisible(driver, CustomerInfoPageUI.DAY_DROPDOWN);
		return getElementAttribute(driver, CustomerInfoPageUI.DAY_DROPDOWN, "value");
	}

	public String getSelectedTextInMonthDropdown() {
		waitToElementVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		return getElementAttribute(driver, CustomerInfoPageUI.MONTH_DROPDOWN, "value");
	}

	public String getSelectedTextInYearDropdown() {
		waitToElementVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		return getElementAttribute(driver, CustomerInfoPageUI.YEAR_DROPDOWN, "value");
	}

	public String getEmailTextboxValue() {
		waitToElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyTextboxValue() {
		waitToElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, "value");
	}

	public boolean isNewsletterRadioButtonSelected() {
		waitToElementVisible(driver, CustomerInfoPageUI.NEWSLETTER_CHECKBOX);
		return isElementSelected(driver, CustomerInfoPageUI.NEWSLETTER_CHECKBOX);
	}
	
	public void setGenderIsFemale() {
		waitToElementClickable(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO_BUTTON);
	}
	
	public void setFirstName(String newFirstName) {
		waitToElementClickable(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToELement(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, newFirstName);
	}
	
	public void setLastName(String newLastName) {
		waitToElementClickable(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		sendkeyToELement(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, newLastName);
	}
	
	public void setDayDropdown(String day) {
		waitToElementClickable(driver, CustomerInfoPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, CustomerInfoPageUI.DAY_DROPDOWN, day);
	}
	
	public void setMonthDropwdown(String month) {
		waitToElementClickable(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN, month);
	}
	
	public void setYearDropwdown(String year) {
		waitToElementClickable(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN, year);
	}
	
	public void setEmail(String newEmail) {
		waitToElementClickable(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		sendkeyToELement(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, newEmail);
	}
	
	public void setCompanyName(String newCompanyName) {
		waitToElementClickable(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		sendkeyToELement(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, newCompanyName);
	}
	
	public void clickToSaveButton() {
		waitToElementClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
	}
	
	public boolean isGenderFemaleRadioSelected() {
		waitToElementVisible(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO_BUTTON);
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO_BUTTON);
	}
}
