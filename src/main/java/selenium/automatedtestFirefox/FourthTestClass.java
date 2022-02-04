package selenium.automatedtestFirefox;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FourthTestClass {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		int testCounter =0;
		System.setProperty("webdriver.gecko.driver","C:\\Users\\omgill\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://amazon.in/");
		
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		searchBar.sendKeys("echo show");
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("All new Echo Show 5 (2nd Gen, 2021 release) - Smart speaker with 5.5\" screen, crisp sound and Alexa (Black)")).click();
		
		ArrayList<String> chromeTabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(chromeTabs.get(1));
		
		WebElement articleTitle = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[4]/div[11]/div[4]/div[3]/div/h1/span"));
		System.out.println(articleTitle.getText());
		boolean contains = articleTitle.getText().contains("Echo Show");
		// 1
		WebElement articleprice = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[4]/div[11]/div[4]/div[15]/div[1]/div[1]/span[2]/span[2]/span[2]"));
		if(contains) {
			contains = articleprice.getText().contains("6,499");
			testCounter++;
		}
		// 2
		WebElement buyBtn = driver.findElement(By.id("buy-now-button"));
		if(contains) {
			contains = buyBtn.isDisplayed();
			testCounter++;
		}
		// 3
		WebElement amznChoice = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[4]/div[11]/div[4]/div[9]/div/span[1]/span[1]"));
		if(contains) {
			contains = amznChoice.getText().contains("Amazon");
			testCounter++;
		}
		System.out.println(amznChoice.getText());
		// 4
		WebElement stockCheck = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[4]/div[11]/div[1]/div[5]/div/div/div/div/form/div/div/div/div/div[2]/div/div[4]/div/div[1]/span"));
		if(contains) {
			contains = stockCheck.getText().contains("In stock");
			testCounter++;
		}
		// 5
		WebElement seller = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[4]/div[11]/div[1]/div[5]/div/div/div/div/form/div/div/div/div/div[2]/div/div[12]/div/div/a[1]/span"));
		if(contains) {
			contains = seller.getText().contentEquals("Appario Retail Private Ltd");
			testCounter++;
		}
		// 6 
//		WebElement rating = driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/div/div/div/div[1]/span"));
//		
//		if(contains) {
//			contains = rating.getText().contains("4");
//			testCounter++;
//		}
		
		
		if(contains) {
			System.out.println("Passed!!");
		}
		else {
			System.out.println("Failed!!");
		}
		System.out.println("No. of Tests passed: " + testCounter);
		
		driver.switchTo().window(chromeTabs.get(0));
		driver.quit();
	}

}
