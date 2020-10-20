package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import demoGuru99PageUIs.DemoGuru99HomePageUI;

public class DemoGuru99HomePageObject extends AbstractPage{
	WebDriver driver;
	
	public DemoGuru99HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean footerMyAccountLinkDisplayed() {
		waitToElementVisible(driver, DemoGuru99HomePageUI.FOOTER_MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, DemoGuru99HomePageUI.FOOTER_MY_ACCOUNT_LINK);
	}

	public boolean headerMyAccountLinkUndisplayed() {
		return isElementUndisplayed(driver, DemoGuru99HomePageUI.HEADER_MY_ACCOUNT_LINK);
	}

	public boolean errorMessageAtSubscribeTextboxUndisplayed() {
		return isElementUndisplayed(driver, DemoGuru99HomePageUI.ERROR_MESSAGE_AT_SUBCRIBE_TEXTBOX) ;
	}

	public void clickToSubscribeButton() {
		waitToElementClickable(driver, DemoGuru99HomePageUI.SUBSCRIBE_BUTTON);
		clickToElement(driver, DemoGuru99HomePageUI.SUBSCRIBE_BUTTON);
	}

	public boolean errorMessageAtSubscribeTextboxDisplayed() {
		waitToElementVisible(driver, DemoGuru99HomePageUI.ERROR_MESSAGE_AT_SUBCRIBE_TEXTBOX);
		return isElementDisplayed(driver, DemoGuru99HomePageUI.ERROR_MESSAGE_AT_SUBCRIBE_TEXTBOX);
	}

	
	
}
