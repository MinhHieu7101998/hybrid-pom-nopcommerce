package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegisterPage extends AbstracPage {
	
	private WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="gender-male")
	private WebElement genderMaleRadio;
	
	@FindBy(id="FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(id="LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(name="DateOfBirthDay")
	private WebElement dayDropdown;
	
	@FindBy(name="DateOfBirthMonth")
	private WebElement monthDropdown;
	
	@FindBy(name="DateOfBirthYear")
	private WebElement yearDropdown;
	
	@FindBy(id="Email")
	private WebElement emailTextbox;
	
	@FindBy(id="Company")
	private WebElement companyTextbox;
	
	@FindBy(id="Password")
	private WebElement passwordTextbox;
	
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(id="register-button")
	private WebElement registerButton;
	
	@FindBy(className="result")
	private WebElement registerSuccessMessage;
	
	@FindBy(className="ico-logout")
	private WebElement logoutLink;
	
	
	public void clickToGenderMaleRadioButton() {
		waitToElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitToElementVisible(driver, firstNameTextbox);
		senkeyToELement(driver, firstNameTextbox, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisible(driver, lastNameTextbox);
		senkeyToELement(driver, lastNameTextbox, lastName);
	}

	public void selectDayDropdown(String day) {
		waitToElementClickable(driver, dayDropdown);
		selectItemInDropdown(driver, dayDropdown, day);
	}
	
	public void selectMonthDropdown(String month) {
		waitToElementClickable(driver, monthDropdown);
		selectItemInDropdown(driver, monthDropdown, month);
	}
	
	public void selectYearDropdown(String year) {
		waitToElementClickable(driver, yearDropdown);
		selectItemInDropdown(driver, yearDropdown, year);
		
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, emailTextbox);
		senkeyToELement(driver, emailTextbox, email);
	}

	public void inputToCompanyNameTextbox(String companyName) {
		waitToElementVisible(driver, companyTextbox);
		senkeyToELement(driver, companyTextbox, companyName);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, passwordTextbox);
		senkeyToELement(driver, passwordTextbox, password);
	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitToElementVisible(driver, confirmPasswordTextbox);
		senkeyToELement(driver, confirmPasswordTextbox, password);
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getRegisterSuccessMessage() {
		waitToElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public void clickToLogoutLink() {
		waitToElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}
}
