package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.SearchPageUI;

public class SearchPageObject extends AbstractPage {
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchKeywordButton() {
		waitToElementClickable(driver, SearchPageUI.SEARCH_KEYWORD_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_KEYWORD_BUTTON);
	}

	public String getWarningText() {
		waitToElementVisible(driver, SearchPageUI.WARNING_TEXT);
		return getElementText(driver, SearchPageUI.WARNING_TEXT);
	}

	public void inputSearchKeywordTextbox(String keyword) {
		waitToElementClickable(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		sendkeyToELement(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX, keyword);
	}

	public String getNoResultText() {
		waitToElementVisible(driver, SearchPageUI.NO_RESULT_TEXT);
		return getElementText(driver, SearchPageUI.NO_RESULT_TEXT);
	}

	public String getProductName_1() {
		waitToElementVisible(driver, SearchPageUI.PRODUCT_NAME_1);
		return getElementText(driver, SearchPageUI.PRODUCT_NAME_1);
	}

	public String getProductName_2() {
		waitToElementVisible(driver, SearchPageUI.PRODUCT_NAME_2);
		return getElementText(driver, SearchPageUI.PRODUCT_NAME_2);
	}

	public boolean isDisplayedOnlyProduct() {
		waitToElementVisible(driver, SearchPageUI.ONLY_PRODUCT_NAME);
		return isElementDisplayed(driver, SearchPageUI.ONLY_PRODUCT_NAME);
	}

	public void clickToAdvancedSearchCheckbox() {
		if (!isElementSelected(driver, SearchPageUI.SEARCH_ADVANCED_CHECKBOX)) {
			waitToElementClickable(driver, SearchPageUI.SEARCH_ADVANCED_CHECKBOX);
			clickToElement(driver, SearchPageUI.SEARCH_ADVANCED_CHECKBOX);
		}
	}

	public void selectItemInCategoryDropdown(String productName) {
		waitToElementClickable(driver, SearchPageUI.CATEGORY_DROPDOWN);
		selectItemInDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN, productName);
	}

	public void clickToAutomaticallySearchButton() {
		if (!isElementSelected(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX)) {
			waitToElementClickable(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
			clickToElement(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
		}
	}
	
	public String getProductTitle() {
		waitToElementVisible(driver, SearchPageUI.ONLY_PRODUCT_NAME);
		return getElementText(driver, SearchPageUI.ONLY_PRODUCT_NAME);
	}
	
	public void selectItemInManufacturerDropdown(String manufacturerName) {
		waitToElementClickable(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWN, manufacturerName);
	}
	
	public void inputPriceFromTextbox(String priceFrom) {
		waitToElementClickable(driver, SearchPageUI.PRICE_FROM_TEXTBOX);
		sendkeyToELement(driver, SearchPageUI.PRICE_FROM_TEXTBOX, priceFrom);
	}
	
	public void inputPriceToTextbox(String priceTo) {
		waitToElementClickable(driver, SearchPageUI.PRICE_TO_TEXTBOX);
		sendkeyToELement(driver, SearchPageUI.PRICE_TO_TEXTBOX, priceTo);
	}
}
