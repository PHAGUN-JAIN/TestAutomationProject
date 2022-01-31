package selenium.automatedtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThirdTestCase {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\omgill\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.get("https://www.amazon.in/");
		
		WebElement searchbar = driver.findElement(By.id("twotabsearchtextbox"));
//		searchbar.sendKeys("fliphone 3");
//		
//		driver.findElement(By.id("nav-search-submit-button")).click();
//		driver.findElement(By.partialLinkText("Samsung Galaxy Z Flip3 5G")).click();

		searchbar.sendKeys("Echoshow");

		driver.findElement(By.id("nav-search-submit-button")).click();


		driver.findElement(By.linkText("All new Echo Show 5 (2nd Gen, 2021 release) - Smart speaker with 5.5\" screen, crisp sound and Alexa (Black)"));

		Boolean isDisplayed = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div/a/span[1]/span[2]/span[2]")).isDisplayed();


		if(isDisplayed == true) {
			System.out.println("Test passed!!!");
		}
	}
}
