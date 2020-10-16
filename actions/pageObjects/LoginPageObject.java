package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToELement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXRBOX);
		sendkeyToELement(driver, LoginPageUI.PASSWORD_TEXRBOX, password);
		
	}

	public HomePageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,  LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public String getErrorEmptyEmailMessage() {
		waitToElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	public String getErrorInvalidEmailMessage() {
		waitToElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	public String getErrorEmailNotExistsAboveMessage() {
		waitToElementVisible(driver, LoginPageUI.ERROR_EMAIL_MESSAGE_ABOVE);
		return getElementText(driver, LoginPageUI.ERROR_EMAIL_MESSAGE_ABOVE);
	}
	
	public String getErrorEmailNotExistsBelowMessage() {
		waitToElementVisible(driver, LoginPageUI.ERROR_EMAIL_MESSAGE_BELOW);
		return getElementText(driver, LoginPageUI.ERROR_EMAIL_MESSAGE_BELOW);
	}
	
	public String getErrorValidEmailAndEmptyPasswordAboveMessage() {
		waitToElementVisible(driver, LoginPageUI.ERROR_EMAIL_MESSAGE_ABOVE);
		return getElementText(driver, LoginPageUI.ERROR_EMAIL_MESSAGE_ABOVE);
	}
	
	public String getErrorValidEmailAndEmptyPassowrdBelowMessage() {
		waitToElementVisible(driver, LoginPageUI.ERROR_EMAIL_MESSAGE_BELOW);
		return getElementText(driver, LoginPageUI.ERROR_EMAIL_MESSAGE_BELOW);
	}
	
	public String getErrorValidEmailAndInvalidPasswordAboveMessage() {
		waitToElementVisible(driver, LoginPageUI.ERROR_EMAIL_MESSAGE_ABOVE);
		return getElementText(driver, LoginPageUI.ERROR_EMAIL_MESSAGE_ABOVE);
	}
	
	public String getErrorValidEmailAndInvalidPassowrdBelowMessage() {
		waitToElementVisible(driver, LoginPageUI.ERROR_EMAIL_MESSAGE_BELOW);
		return getElementText(driver, LoginPageUI.ERROR_EMAIL_MESSAGE_BELOW);
	}
}
