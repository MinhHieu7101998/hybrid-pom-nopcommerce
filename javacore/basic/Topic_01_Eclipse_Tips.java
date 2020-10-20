package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Vo Minh Hieu
 *
 */
/**
 * @author Vo Minh Hieu
 *
 */
/**
 * @author Vo Minh Hieu
 *
 */
/**
 * @author Vo Minh Hieu
 *
 */
public class Topic_01_Eclipse_Tips {
	WebDriver driver;
	String source_path = System.getProperty("user.dir");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Vo Minh Hieu asd");
		String address = "Ho Chi Minh City";
		System.out.println(address);
		System.out.println(address);
		System.out.println(address);
		System.out.println(address);

	}

	/**
	 * @return address
	 */
	public void getAddress() {
		driver.findElement(By.xpath(""));
	}
	public void assertF() {
		Assert.assertFalse(true, "should be same");
	}
}
// Ctrl + D de xoa dong hoac khoi lenh
// Ctrl + Shift + F de format code cho dep hon
// Ctrl + Shift + O import/remove library
// F3 xem document cua function
// Ctrl + Shift + X duplicate dong/block
// Ctrl+ Shift + A de thu gon code, chi con cac ten ham
// alt + Shift + A de mo rong cac ham
// alt + Shift + J tao java doc