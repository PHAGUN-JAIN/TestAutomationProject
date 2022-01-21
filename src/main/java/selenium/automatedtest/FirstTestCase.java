package selenium.automatedtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTestCase {
	public static void main(String[] args) {
		
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\omgill\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		System.out.println("Hello World");
		WebDriver driver = new ChromeDriver();
		String title, actualURL ;
		//Deleting all the cookies
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.amazon.in/");
		
		//first test-case
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("alexa echo dot");
		driver.findElement(By.id("nav-search-submit-button")).click();
		title = driver.getTitle();
		actualURL = driver.getCurrentUrl();
		System.out.println("The title of the page is => " + title);
		System.out.println("The current url is => " + actualURL);
		
		driver.close();
	}

}
