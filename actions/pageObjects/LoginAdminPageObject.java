package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginAdminPageUI;

public class LoginAdminPageObject extends AbstractPage {
	WebDriver driver;

	public LoginAdminPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public DashboardAdminPageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginAdminPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginAdminPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboardAdminPage(driver);
	}
}
