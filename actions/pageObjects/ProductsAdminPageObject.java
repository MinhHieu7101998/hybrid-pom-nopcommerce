package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.ProductsAdminPageUI;

public class ProductsAdminPageObject extends AbstractPage {
	WebDriver driver;

	public ProductsAdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void sendKeyToProductNameTextbox(String productName) {
		waitToElementVisible(driver, ProductsAdminPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToELement(driver, ProductsAdminPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	public void clickToSearchButton() {
		waitToElementClickable(driver, ProductsAdminPageUI.SEARCH_BUTTON);
		clickToElement(driver, ProductsAdminPageUI.SEARCH_BUTTON);
		waitToAjaxLoadinIconInvisible(driver);

	}
	public boolean isValueDisplayedAtColumnNameByRowNumber(String columnName, String rowNumber, String value) {
		waitToElementVisible(driver, ProductsAdminPageUI.DYNAMIC_COLUMN_NAME, columnName);
		String columnIndex = String.valueOf(countElementSize(driver, ProductsAdminPageUI.DYNAMIC_COLUMN_NAME, columnName) + 1);

		waitToElementVisible(driver, ProductsAdminPageUI.DYNAMIC_VALUE_AT_COLUMN_NAME_AND_ROW_NUMBER, rowNumber, columnIndex, value);
		return isElementDisplayed(driver, ProductsAdminPageUI.DYNAMIC_VALUE_AT_COLUMN_NAME_AND_ROW_NUMBER, rowNumber, columnIndex, value);
	}
}
