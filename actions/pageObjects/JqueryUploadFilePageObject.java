package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import jQueryUploadUIs.JqueryUploadFilePageUI;

public class JqueryUploadFilePageObject extends AbstractPage{
	WebDriver driver;

	public JqueryUploadFilePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoaded(String fileName) {
		waitToElementVisible(driver, JqueryUploadFilePageUI.DYNAMIC_FILE_NAME, fileName);
		return isElementDisplayed(driver, JqueryUploadFilePageUI.DYNAMIC_FILE_NAME, fileName);
	}	

	public void clickToStartButton(String fileName) {
		waitToElementClickable(driver, JqueryUploadFilePageUI.DYNAMIC_START_BUTTON, fileName);
		clickToElement(driver, JqueryUploadFilePageUI.DYNAMIC_START_BUTTON, fileName);
	}

	public boolean isFileUploadSuccess(String fileName) {
		waitToElementVisible(driver, JqueryUploadFilePageUI.DYNAMIC_UPLOAD_SUCCESS_LINK, fileName);
		return isElementDisplayed(driver, JqueryUploadFilePageUI.DYNAMIC_UPLOAD_SUCCESS_LINK, fileName);
	}
	public void clickToUploadSuccessLinkImage(String fileName) {
		waitToElementClickable(driver, JqueryUploadFilePageUI.DYNAMIC_UPLOAD_SUCCESS_IMAGE_LINK,fileName);
		clickToElement(driver, JqueryUploadFilePageUI.DYNAMIC_UPLOAD_SUCCESS_IMAGE_LINK,fileName);
	}
	public boolean isCompareImageUploaded(String fileName) throws IOException {
		waitToElementVisible(driver, JqueryUploadFilePageUI.IPHONE_OPENED_IMAGE);
		return compareImageAshot(driver, JqueryUploadFilePageUI.IPHONE_OPENED_IMAGE, fileName);
	}
}
