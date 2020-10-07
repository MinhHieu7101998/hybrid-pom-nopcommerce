package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage extends AbstracPage{
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup()
	@FindBy(className="ico-logout")
	private WebElement logoutLink;
	
	@CacheLookup()
	@FindBy(className="ico-account")
	private WebElement myAccountLink;
	
	@CacheLookup()
	@FindBy(className="ico-register")
	private WebElement registerLink;
	
	@CacheLookup()
	@FindBy(className="ico-login")
	private WebElement loginLink;
	
	public void clickToRegisterLink() {
		waitToElementClickable(driver, registerLink);
		clickToElement(driver,  registerLink);
	}

	public void clickToLoginLink() {
		waitToElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, logoutLink);
		return isElementDisplayed(driver, logoutLink);
	}

	public void clickTokMyAccountLink() {
		waitToElementClickable(driver, myAccountLink);
		clickToElement(driver,  myAccountLink);
	}
}
