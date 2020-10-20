package nop.jqueryuploadfile.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.JqueryUploadFilePageObject;
import pageObjects.PageGeneratorManager;

public class Level_01_UploadFile extends AbstractTest {
	WebDriver driver;
	String iphoneName = "iPhone.jpg";
	String samsungName = "Samsung.jpg";
	String sonyName = "Sony.jpg";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		JqueryUploadFilePage = PageGeneratorManager.getJqueryUploadFilePage(driver);

	}

	@Test
	public void TC_01_Upload_One_File_Per_Time() {
		JqueryUploadFilePage.uploadMultipleFiles(driver, iphoneName);
		JqueryUploadFilePage.sleepInSecond(3);
		Assert.assertTrue(JqueryUploadFilePage.isFileLoaded(iphoneName));
		JqueryUploadFilePage.clickToStartButton(iphoneName);
		Assert.assertTrue(JqueryUploadFilePage.isFileUploadSuccess(iphoneName));
		
		JqueryUploadFilePage.uploadMultipleFiles(driver, samsungName);
		JqueryUploadFilePage.sleepInSecond(3);
		Assert.assertTrue(JqueryUploadFilePage.isFileLoaded(samsungName));
		JqueryUploadFilePage.clickToStartButton(samsungName);
		Assert.assertTrue(JqueryUploadFilePage.isFileUploadSuccess(samsungName));
		
		JqueryUploadFilePage.uploadMultipleFiles(driver, sonyName);
		JqueryUploadFilePage.sleepInSecond(3);
		Assert.assertTrue(JqueryUploadFilePage.isFileLoaded(sonyName));
		JqueryUploadFilePage.clickToStartButton(sonyName);
		Assert.assertTrue(JqueryUploadFilePage.isFileUploadSuccess(sonyName));

	}

	@Test
	public void TC_02_Upload_Multiple_Files_Per_Time() {
		JqueryUploadFilePage.refreshCurrentPage(driver);
		JqueryUploadFilePage.uploadMultipleFiles(driver, iphoneName, samsungName);
		JqueryUploadFilePage.sleepInSecond(3);
		
		JqueryUploadFilePage.refreshCurrentPage(driver);
		
		JqueryUploadFilePage.uploadMultipleFiles(driver, iphoneName, samsungName, sonyName);
		JqueryUploadFilePage.sleepInSecond(3);
		Assert.assertTrue(JqueryUploadFilePage.isFileLoaded(iphoneName));
		Assert.assertTrue(JqueryUploadFilePage.isFileLoaded(samsungName));
		Assert.assertTrue(JqueryUploadFilePage.isFileLoaded(sonyName));
		JqueryUploadFilePage.clickToStartButton(iphoneName);
		JqueryUploadFilePage.clickToStartButton(samsungName);
		JqueryUploadFilePage.clickToStartButton(sonyName);
		Assert.assertTrue(JqueryUploadFilePage.isFileUploadSuccess(iphoneName));
		Assert.assertTrue(JqueryUploadFilePage.isFileUploadSuccess(samsungName));
		Assert.assertTrue(JqueryUploadFilePage.isFileUploadSuccess(sonyName));
		
	}
	@Test
	public void afterClass() {
		driver.quit();
	}
	JqueryUploadFilePageObject JqueryUploadFilePage;
}
