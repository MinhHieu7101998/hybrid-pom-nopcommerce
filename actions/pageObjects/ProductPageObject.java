package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.ProductPageUI;

public class ProductPageObject extends AbstractPage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getCurrentUrl() {
		return getCurrentPageUrl(driver);
	}

	public ProductReviewPageObject clickToAddYourReviewLink() {
		waitToElementClickable(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK);
		return PageGeneratorManager.getProductReviewPage(driver);
	}
}
