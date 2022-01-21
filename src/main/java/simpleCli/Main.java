package simpleCli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
	public static void main(String[] args) {
		
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\omgill\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		System.out.println("Hello World");
		WebDriver driver = new ChromeDriver();
		
		//Deleting all the cookies
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("alexa echo dot");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
	}

}
