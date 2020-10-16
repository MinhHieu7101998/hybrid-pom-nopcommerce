package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.ProductReviewPageUI;

public class ProductReviewPageObject extends AbstractPage {
	WebDriver driver;

	public ProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputTitlteReviewTextbox(String titleReview) {
		waitToElementClickable(driver, ProductReviewPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToELement(driver, ProductReviewPageUI.REVIEW_TITLE_TEXTBOX, titleReview);
	}
	
	public void inputTextReviewTextbox(String reviewText) {
		waitToElementClickable(driver, ProductReviewPageUI.REVIEW_TEXT_TEXTBOX);
		sendkeyToELement(driver, ProductReviewPageUI.REVIEW_TEXT_TEXTBOX, reviewText);
	}
	
	public void clickToRatingBadRaidoButton() {
		waitToElementClickable(driver, ProductReviewPageUI.RATING_BAD_RADIO_BUTTON);
		clickToElement(driver, ProductReviewPageUI.RATING_BAD_RADIO_BUTTON);
	}
	
	public void clickToRatingNotGoodRaidoButton() {
		waitToElementClickable(driver, ProductReviewPageUI.RATING_NOT_GOOD_RADIO_BUTTON);
		clickToElement(driver, ProductReviewPageUI.RATING_NOT_GOOD_RADIO_BUTTON);
	}
	public void clickToRatingNotBadAlsoNotGoodRaidoButton() {
		waitToElementClickable(driver, ProductReviewPageUI.RATING_NOT_BAD_ALSO_NOT_GOOD_RADIO_BUTTON);
		clickToElement(driver, ProductReviewPageUI.RATING_NOT_BAD_ALSO_NOT_GOOD_RADIO_BUTTON);
	}
	public void clickToRatingGoodRaidoButton() {
		waitToElementClickable(driver, ProductReviewPageUI.RATING_GOOD_RADIO_BUTTON);
		clickToElement(driver, ProductReviewPageUI.RATING_GOOD_RADIO_BUTTON);
	}
	public void clickToRatingExcellentRaidoButton() {
		waitToElementClickable(driver, ProductReviewPageUI.RATING_EXCELLENT_RADIO_BUTTON);
		clickToElement(driver, ProductReviewPageUI.RATING_EXCELLENT_RADIO_BUTTON);
	}
	public void clickToSubmitReview() {
		waitToElementClickable(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public CustomerInfoPageObject clickToMyAccountLink() {
		waitToElementClickable(driver, ProductReviewPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, ProductReviewPageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInfoPage(driver);
	}
}
