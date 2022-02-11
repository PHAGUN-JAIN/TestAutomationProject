package selenium.automatedtest.Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondTestCase {
	WebDriver driver;
	String PASSWORD = "password";
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\omgill\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
	}
	@Test
	public void test() {
		driver.findElement(By.id("nav-link-accountList")).click();
		
		driver.findElement(By.id("ap_email")).sendKeys("500076430@stu.upes.ac.in");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("signInSubmit")).click();

		String title = driver.getTitle();
		String actualURL = driver.getCurrentUrl();
		System.out.println("The title of the page is => " + title);
		System.out.println("The current url is => " + actualURL);
	 }
	 @AfterTest
	 public void afterTest() {
		 driver.close();
	 }
}
