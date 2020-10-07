package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPage extends AbstracPage {
	
	private WebDriver driver;
	public CustomerInfoPage(WebDriver driver) {
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
	
	@FindBy(id="Newsletter")
	private WebElement newsletterCheckbox;
	
	@FindBy(id="save-info-button")
	private WebElement saveButton;
	
	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisible(driver, genderMaleRadio);
		return isElementSelected(driver, genderMaleRadio);
	}

	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, firstNameTextbox);
		return getElementAttribute(driver, firstNameTextbox, "value");
	}

	public String getLastNameTextboxValue() {
		waitToElementVisible(driver, lastNameTextbox);
		return getElementAttribute(driver, lastNameTextbox, "value");
	}

	public String getSelectedTextInDayDropdown() {
		waitToElementVisible(driver, dayDropdown);
		return getElementAttribute(driver, dayDropdown, "value");
	}

	public String getSelectedTextInMonthDropdown() {
		waitToElementVisible(driver, monthDropdown);
		return getElementAttribute(driver, monthDropdown, "value");
	}

	public String getSelectedTextInYearDropdown() {
		waitToElementVisible(driver, yearDropdown);
		return getElementAttribute(driver, yearDropdown, "value");
	}

	public String getEmailTextboxValue() {
		waitToElementVisible(driver, emailTextbox);
		return getElementAttribute(driver, emailTextbox, "value");
	}

	public String getCompanyTextboxValue() {
		waitToElementVisible(driver, companyTextbox);
		return getElementAttribute(driver, companyTextbox, "value");
	}

	public boolean isNewsletterRadioButtonSelected() {
		waitToElementVisible(driver, newsletterCheckbox);
		return isElementSelected(driver, newsletterCheckbox);
	}
}
