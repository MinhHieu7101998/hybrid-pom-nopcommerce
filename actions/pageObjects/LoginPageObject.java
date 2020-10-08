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
		senkeyToELement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXRBOX);
		senkeyToELement(driver, LoginPageUI.PASSWORD_TEXRBOX, password);
		
	}

	public HomePageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,  LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
