package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends AbstracPage {
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	private WebElement emailTextbox;
	
	@FindBy(id="Password")
	private WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement loginButton;
	
	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, emailTextbox);
		senkeyToELement(driver, emailTextbox, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, passwordTextbox);
		senkeyToELement(driver, passwordTextbox, password);
		
	}

	public void clickToLoginButton() {
		waitToElementClickable(driver, loginButton);
		clickToElement(driver,  loginButton);
	}
}
