package pageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstracPage {
	protected void waitToElementClickable(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	protected void clickToElement(WebDriver driver,WebElement element) {
		if(driver.toString().toLowerCase().contains("edge")) {
			sleepInMiliSecond(500);
		}
		element.click();
	}
	protected void sleepInMiliSecond(long milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	protected void waitToElementVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	protected boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	protected void senkeyToELement(WebDriver driver, WebElement element, String value) {
		element.clear();
		if(driver.toString().toLowerCase().contains("edge") || driver.toString().toLowerCase().contains("chrome")) {
			sleepInMiliSecond(500);
		}
		element.sendKeys(value);
	}
	protected void selectItemInDropdown(WebDriver driver, WebElement element, String itemValue) {
		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}
	protected String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}
	protected boolean isElementSelected(WebDriver driver, WebElement element) {
		return element.isSelected();
	}
	protected String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}
	private WebDriverWait explicitWait;
	private Select select;
}

