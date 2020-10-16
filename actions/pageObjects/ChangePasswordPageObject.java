package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.ChangePasswordUI;

public class ChangePasswordPageObject extends AbstractPage {
	WebDriver driver;
	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setOldPassowrdTextbox(String oldPassword) {
		waitToElementClickable(driver, ChangePasswordUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToELement(driver, ChangePasswordUI.OLD_PASSWORD_TEXTBOX, oldPassword);
	}
	
	public void setNewPassowrdTextbox(String newPassword) {
		waitToElementClickable(driver, ChangePasswordUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToELement(driver, ChangePasswordUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}
	
	public void setConfirmPassowrdTextbox(String confirmPassword) {
		waitToElementClickable(driver, ChangePasswordUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToELement(driver, ChangePasswordUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}
	
	public void clickToChangePasswordButton() {
		waitToElementClickable(driver, ChangePasswordUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordUI.CHANGE_PASSWORD_BUTTON);
	}
	
	public String getChangePasswordSuccessMessage() {
		waitToElementVisible(driver, ChangePasswordUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
		return getElementText(driver, ChangePasswordUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
	}
	
	public HomePageObject clickToLogoutLink() {
		waitToElementVisible(driver, ChangePasswordUI.LOGOUT_LINK);
		clickToElement(driver, ChangePasswordUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	
}
