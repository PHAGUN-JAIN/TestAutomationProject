package selenium.automatedtestFirefox;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTestCase {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\omgill\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		String title, actualURL ;
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
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
