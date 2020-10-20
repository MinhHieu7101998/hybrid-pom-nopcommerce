package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.DashboardAdminPageUI;

public class DashboardAdminPageObject extends AbstractPage {
	WebDriver driver;

	public DashboardAdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCatalogButton() {
		waitToElementClickable(driver, DashboardAdminPageUI.CATALOG_BUTTON);
		clickToElement(driver, DashboardAdminPageUI.CATALOG_BUTTON);

	}
	
	public ProductsAdminPageObject clickToProductsButton() {
		waitToElementClickable(driver, DashboardAdminPageUI.PRODUCTS_BUTTON);
		clickToElement(driver, DashboardAdminPageUI.PRODUCTS_BUTTON);
		waitToAjaxLoadinIconInvisible(driver);
		return PageGeneratorManager.getProductsAdminPage(driver);
	}

}
