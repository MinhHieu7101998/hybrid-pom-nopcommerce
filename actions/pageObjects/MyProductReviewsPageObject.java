package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.MyProductReviewPageUI;

public class MyProductReviewsPageObject extends AbstractPage {
	WebDriver driver;
	public MyProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitleReview() {
		waitToElementVisible(driver, MyProductReviewPageUI.REVIEW_TITLE);
		return getElementText(driver, MyProductReviewPageUI.REVIEW_TITLE);
	}
	
	public String getTextReview() {
		waitToElementVisible(driver, MyProductReviewPageUI.REVIEW_TEXT);
		return getElementText(driver, MyProductReviewPageUI.REVIEW_TEXT);
	}
	
	public boolean isDisplayedRating() {
		waitToElementVisible(driver, MyProductReviewPageUI.RATING);
		return isElementDisplayed(driver, MyProductReviewPageUI.RATING);
	}

	public ProductPageObject clickToLinkProdcut() {
		waitToElementClickable(driver, MyProductReviewPageUI.LINK_PRODUCT_IS_REVIEWED);
		clickToElement(driver, MyProductReviewPageUI.LINK_PRODUCT_IS_REVIEWED);
		return PageGeneratorManager.getProductPage(driver);
	}
	
	
}
