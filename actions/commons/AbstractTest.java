package commons;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	private WebDriver driver;
	
	protected WebDriver getBrowserDriver(String browserName) {
		
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		
		if(browser == Browser.FIREFOX_UI ) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser == Browser.CHROME_UI) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options= new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(options);
		}else if(browser == Browser.FIREFOX_HEADLESS) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
		}else if(browser == Browser.CHROME_HEADLESS) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1366x768");
			driver = new ChromeDriver(options);
		}else if(browser == Browser.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().driverVersion("85.0.564.68").setup();
			driver = new EdgeDriver();
		}else if(browser == Browser.IE){
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		} else if(browser == Browser.SAFARI){
			driver = new SafariDriver();
		}else {
			throw new RuntimeException("Please input valid browser name!");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}
	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
}
