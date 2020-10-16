package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AddressesPageUI;

public class AddressesPageObject extends AbstractPage {
	WebDriver driver;
	public AddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToAddNewAddressLink() {
		waitToElementClickable(driver, AddressesPageUI.ADD_NEW_ADDRESS_LINK);
		clickToElement(driver, AddressesPageUI.ADD_NEW_ADDRESS_LINK);
	}
	
	public void setFirstName(String FirstName) {
		waitToElementClickable(driver, AddressesPageUI.ADDRESS_FIRST_NAME_TEXTBOX);
		sendkeyToELement(driver, AddressesPageUI.ADDRESS_FIRST_NAME_TEXTBOX, FirstName);
	}
	
	public void setLastName(String LastName) {
		waitToElementClickable(driver, AddressesPageUI.ADDRESS_LAST_NAME_TEXTBOX);
		sendkeyToELement(driver, AddressesPageUI.ADDRESS_LAST_NAME_TEXTBOX, LastName);
	}
	
	public void setEmail(String Email) {
		waitToElementClickable(driver, AddressesPageUI.ADDRESS_EMAIL_TEXTBOX);
		sendkeyToELement(driver, AddressesPageUI.ADDRESS_EMAIL_TEXTBOX, Email);
	}
	
	public void setCompanyName(String CompanyName) {
		waitToElementClickable(driver, AddressesPageUI.ADDRESS_COMPANY_NAME_TEXTBOX);
		sendkeyToELement(driver, AddressesPageUI.ADDRESS_COMPANY_NAME_TEXTBOX, CompanyName);
	}
	
	public void setCountryDropdown(String ContryName) {
		waitToElementClickable(driver, AddressesPageUI.ADDRESS_COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, AddressesPageUI.ADDRESS_COUNTRY_DROPDOWN, ContryName);
	}
	
	public void setCityName(String CityName) {
		waitToElementClickable(driver, AddressesPageUI.ADDRESS_CITY_TEXTBOX);
		sendkeyToELement(driver, AddressesPageUI.ADDRESS_CITY_TEXTBOX, CityName);
	}
	
	public void setAddress1(String Address1) {
		waitToElementClickable(driver, AddressesPageUI.ADDRESS_ADDRESS_1_TEXTBOX);
		sendkeyToELement(driver, AddressesPageUI.ADDRESS_ADDRESS_1_TEXTBOX, Address1);
	}
	
	public void setAddress2(String Address2) {
		waitToElementClickable(driver, AddressesPageUI.ADDRESS_ADDRESS_2_TEXTBOX);
		sendkeyToELement(driver, AddressesPageUI.ADDRESS_ADDRESS_2_TEXTBOX, Address2);
	}
	
	public void setZipCode(String ZipCode) {
		waitToElementClickable(driver, AddressesPageUI.ADDRESS_ZIP_TEXTBOX);
		sendkeyToELement(driver, AddressesPageUI.ADDRESS_ZIP_TEXTBOX, ZipCode);
	}
	
	public void setPhoneNumber(String PhoneNumber) {
		waitToElementClickable(driver, AddressesPageUI.ADDRESS_PHONE_NUMBER_TEXTBOX);
		sendkeyToELement(driver, AddressesPageUI.ADDRESS_PHONE_NUMBER_TEXTBOX, PhoneNumber);
	}
	
	public void setFaxNumber(String FaxNumber) {
		waitToElementClickable(driver, AddressesPageUI.ADDRESS_FAX_NUMBER_TEXTBOX);
		sendkeyToELement(driver, AddressesPageUI.ADDRESS_FAX_NUMBER_TEXTBOX, FaxNumber);
	}
	
	public void clickToSaveButton() {
		waitToElementClickable(driver, AddressesPageUI.ADDRESS_SAVE_BUTTON);
		clickToElement(driver, AddressesPageUI.ADDRESS_SAVE_BUTTON);
	}
	
	public String getTitleInfo() {
		waitToElementVisible(driver, AddressesPageUI.ADDRESS_TITLE_FIRST_ADD_LAST_NAME);
		return getElementText(driver, AddressesPageUI.ADDRESS_TITLE_FIRST_ADD_LAST_NAME);
	}
	
	public String getInfoName() {
		waitToElementVisible(driver, AddressesPageUI.ADDRESS_INFO_NAME);
		return getElementText(driver, AddressesPageUI.ADDRESS_INFO_NAME);
	}
	
	public String getInfoEmail() {
		waitToElementVisible(driver, AddressesPageUI.ADDRESS_INFO_EMAIL);
		return getElementText(driver, AddressesPageUI.ADDRESS_INFO_EMAIL);
	}
	
	public String getInfoPhoneNumber() {
		waitToElementVisible(driver, AddressesPageUI.ADDRESS_INFO_PHONE);
		return getElementText(driver, AddressesPageUI.ADDRESS_INFO_PHONE);
	}	
	
	public String getInfoFaxNumber() {
		waitToElementVisible(driver, AddressesPageUI.ADDRESS_INFO_FAX);
		return getElementText(driver, AddressesPageUI.ADDRESS_INFO_FAX);
	}
	
	public String getCompanyName() {
		waitToElementVisible(driver, AddressesPageUI.ADDRESS_INFO_COMPANY);
		return getElementText(driver, AddressesPageUI.ADDRESS_INFO_COMPANY);
	}
	
	public String getAddress1() {
		waitToElementVisible(driver, AddressesPageUI.ADDRESS_INFO_ADDRESS_1);
		return getElementText(driver, AddressesPageUI.ADDRESS_INFO_ADDRESS_1);
	}
	
	public String getAddress2() {
		waitToElementVisible(driver, AddressesPageUI.ADDRESS_INFO_ADDRESS_2);
		return getElementText(driver, AddressesPageUI.ADDRESS_INFO_ADDRESS_2);
	}
	
	public String getZipCodeAndCity() {
		waitToElementVisible(driver, AddressesPageUI.ADDRESS_INFO_ZIP_CODE);
		return getElementText(driver, AddressesPageUI.ADDRESS_INFO_ZIP_CODE);
	}
	
	public String getCountry() {
		waitToElementVisible(driver, AddressesPageUI.ADDRESS_INFO_COUNTRY);
		return getElementText(driver, AddressesPageUI.ADDRESS_INFO_COUNTRY);
	}
	
	
}
