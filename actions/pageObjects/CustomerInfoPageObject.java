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

	

	
}
