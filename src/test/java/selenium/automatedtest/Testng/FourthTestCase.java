package selenium.automatedtest.Testng;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FourthTestCase {
	int testCounter =0;
	boolean contains;
	WebDriver driver;
	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\omgill\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://amazon.in/");
	}
	
	@Test
	public void test() {
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		searchBar.sendKeys("echo show");
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("All new Echo Show 5 (2nd Gen, 2021 release) - Smart speaker with 5.5\" screen, crisp sound and Alexa (Black)")).click();
	}
	@Test
	public void test1() {
		ArrayList<String> chromeTabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(chromeTabs.get(1));
	}
	@Test
	public void test2() {
		WebElement articleTitle = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[4]/div[11]/div[4]/div[3]/div/h1/span"));
		System.out.println(articleTitle.getText());
		contains = articleTitle.getText().contains("Echo Show");
	}
	@Test
	public void test3() {
		WebElement articleTitle = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[4]/div[11]/div[4]/div[3]/div/h1/span"));
		System.out.println(articleTitle.getText());
		boolean contains = articleTitle.getText().contains("Echo Show");
	}
	@Test
	public void test4() {
		WebElement articleprice = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[4]/div[11]/div[4]/div[15]/div[1]/div[1]/span[2]/span[2]/span[2]"));
		if(contains) {
			contains = articleprice.getText().contains("6,499");
			testCounter++;
		}
	}
	@Test
	public void test5() {
		WebElement buyBtn = driver.findElement(By.id("buy-now-button"));
		if(contains) {
			contains = buyBtn.isDisplayed();
			testCounter++;
		}
	}
	@Test
	public void test6() {
		WebElement amznChoice = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[4]/div[11]/div[4]/div[9]/div/span[1]/span[1]"));
		if(contains) {
			contains = amznChoice.getText().contains("Amazon");
			testCounter++;
		}
		System.out.println(amznChoice.getText());
	}
	@Test
	public void test7() {
		WebElement stockCheck = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[4]/div[11]/div[1]/div[5]/div/div/div/div/form/div/div/div/div/div[2]/div/div[4]/div/div[1]/span"));
		if(contains) {
			contains = stockCheck.getText().contains("In stock");
			testCounter++;
		}
	}
	@Test
	public void test8() {
		WebElement seller = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[4]/div[11]/div[1]/div[5]/div/div/div/div/form/div/div/div/div/div[2]/div/div[12]/div/div/a[1]/span"));
		if(contains) {
			contains = seller.getText().contentEquals("Appario Retail Private Ltd");
			testCounter++;
		}
	}
	@Test
	public void test9() {
		if(contains) {
			System.out.println("Passed!!");
		}
		else {
			System.out.println("Failed!!");
		}
		System.out.println("No. of Tests passed: " + testCounter);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
