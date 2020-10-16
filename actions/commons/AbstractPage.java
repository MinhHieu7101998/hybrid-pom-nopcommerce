package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.AddressesPageObject;
import pageObjects.BackInStockSubscriptionsPageObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.DownloadableProductsPageObject;
import pageObjects.MyProductReviewsPageObject;
import pageObjects.OrdersPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RewardPointsPageObject;
import pageUIs.AbstractPageUI;

public class AbstractPage {
	private JavascriptExecutor jsExecutor;
	private WebDriverWait explicitWait;
	private Actions action;
	private WebElement element;
	private List<WebElement> elements;
	private Select select;

	protected void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	protected String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getCurrentPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	protected void cancleAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	protected String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	protected void setTextAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	protected void waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	protected void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentTitleWindows = getCurrentPageTitle(driver);
			if (currentTitleWindows.equals(title)) {
				break;
			}
		}
	}

	protected void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	protected WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	protected List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	protected By getByXpath(String locator) {
		return By.xpath(locator);
	}

	protected void clickToElement(WebDriver driver, String locator) {
		if(driver.toString().toLowerCase().contains("edge")) {
			sleepInMiliSecond(500);
		}
		element = getElement(driver, locator);
		element.click();
	}
	protected void clickToElement(WebDriver driver, String locator, String... dynamicValues) {
		locator = castRestParamter(locator, dynamicValues);
		if(driver.toString().toLowerCase().contains("edge")) {
			sleepInMiliSecond(500);
		}
		element = getElement(driver, locator);
		element.click();
	}

	protected void sendkeyToELement(WebDriver driver, String locator, String value) {
		element = getElement(driver, locator);
		element.clear();
		if(driver.toString().toLowerCase().contains("edge") || driver.toString().toLowerCase().contains("chrome")) {
			sleepInMiliSecond(500);
		}
		element.sendKeys(value);
	}
	protected void sendkeyToELement(WebDriver driver, String locator, String value, String... dynamicValues) {
		locator = castRestParamter(locator, dynamicValues);
		element = getElement(driver, locator);
		element.clear();
		if(driver.toString().toLowerCase().contains("edge") || driver.toString().toLowerCase().contains("chrome")) {
			sleepInMiliSecond(500);
		}
		element.sendKeys(value);
	}

	protected void selectItemInDropdown(WebDriver driver, String locator, String itemValue) {
		element = getElement(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}

	protected String getFirstSelectedTextDropdown(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	protected boolean isDropdownMultiple(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		Select select = new Select(element);
		return select.isMultiple();
	}

	protected void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		elements = getElements(driver, childItemLocator);

		for (WebElement item : elements) {
			if (item.getText().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	protected void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void sleepInMiliSecond(long milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		element = getElement(driver, locator);
		return element.getAttribute(attributeName);
	}

	protected String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	protected String getElementText(WebDriver driver, String locator, String... dynamicValues) {
		locator = castRestParamter(locator, dynamicValues);
		return getElement(driver, locator).getText();
	}

	protected int countElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}

	protected void checkToCheckbox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void unCheckToCheckbox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	protected boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}
	protected boolean isElementDisplayed(WebDriver driver, String locator, String... dynamicValues) {
		locator = castRestParamter(locator, dynamicValues);
		return getElement(driver, locator).isDisplayed();
	}

	protected boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}

	protected boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}

	protected void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}

	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	protected void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}

	protected void rightClickToElment(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}

	protected void hoverMouseToElment(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}

	protected void clickAndHoldToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.clickAndHold(getElement(driver, locator)).perform();
	}

	protected void drapAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}

	protected void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	protected Object executeForBrowser(WebDriver driver, String javaSript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaSript);
	}

	protected boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	protected void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	protected void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);

	}

	protected void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	protected void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	protected void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	protected void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	protected boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
		if (status) {
			return true;
		}
		return false;
	}

	protected void waitToElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	protected void waitToElementVisible(WebDriver driver, String locator, String... dynamicValues) {
		locator = castRestParamter(locator, dynamicValues);
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	protected void waitToElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	protected void waitToElementInvisible(WebDriver driver, String locator, String... dynamicValues) {
		locator = castRestParamter(locator, dynamicValues);
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}

	protected void waitToElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	protected void waitToElementClickable(WebDriver driver, String locator, String... dynamicValues) {
		locator = castRestParamter(locator, dynamicValues);
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public MyProductReviewsPageObject openMyProductReviews(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.MY_PRODUCT_REVIEWS);
		clickToElement(driver, AbstractPageUI.MY_PRODUCT_REVIEWS);
		return PageGeneratorManager.getMyProductReviewsPage(driver);
	}
	public OrdersPageObject openOrdersPage(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.ORDERS_LINK);
		clickToElement(driver, AbstractPageUI.ORDERS_LINK);
		return PageGeneratorManager.getOrdersPage(driver);
	}
	public BackInStockSubscriptionsPageObject openBackInStockSubscriptionsPage(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
		clickToElement(driver, AbstractPageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
		return PageGeneratorManager.getBackInStockSubscriptionsPage(driver);
	}
	public ChangePasswordPageObject openChangePasswordPage(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, AbstractPageUI.CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getChangePasswordPage(driver);
	}
	public DownloadableProductsPageObject openDownloadableProducts(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.DOWNLOADABLE_PRODUCTS_LINK);
		clickToElement(driver, AbstractPageUI.DOWNLOADABLE_PRODUCTS_LINK);
		return PageGeneratorManager.getDownloadableProductsPage(driver);
	}
	public AddressesPageObject openAddressesPage(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.ADDRESSES_LINK);
		clickToElement(driver, AbstractPageUI.ADDRESSES_LINK);
		return PageGeneratorManager.getAddressesPage(driver);
	}
	public RewardPointsPageObject openRewardPoints(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.REWARD_POINTS_LINK);
		clickToElement(driver, AbstractPageUI.REWARD_POINTS_LINK);
		return PageGeneratorManager.getRewardPointsPage(driver);
	}
	
	protected String castRestParamter(String locator, String... dynamicValues) {
		return locator = String.format(locator, (Object[]) dynamicValues);
	}
	
	public AbstractPage openLinkByPageName(WebDriver driver, String pageName) {
		waitToElementClickable(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getCustomerInfoPage(driver);
		case "Addresses":
			return PageGeneratorManager.getAddressesPage(driver);
		case "Orders":
			return PageGeneratorManager.getOrdersPage(driver);
		case "Downloadable products":
			return PageGeneratorManager.getDownloadableProductsPage(driver);
		case "Back in stock subscriptions":
			return PageGeneratorManager.getBackInStockSubscriptionsPage(driver);
		case "Reward points":
			return PageGeneratorManager.getRewardPointsPage(driver);
		case "Change password":
			return PageGeneratorManager.getChangePasswordPage(driver);
		default:
			return PageGeneratorManager.getMyProductReviewsPage(driver);
		}
	}
	public void openLinkWithPageName(WebDriver driver, String pageName) {
		waitToElementClickable(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
	}
}
