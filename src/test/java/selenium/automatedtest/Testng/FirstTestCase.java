package selenium.automatedtest.Testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class FirstTestCase {

	WebDriver driver;
	
  @BeforeTest
  public void beforeTest() {
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\omgill\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		System.out.println("Hello World");
	    driver = new ChromeDriver();
		//Deleting all the cookies
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.amazon.in/");
  }

  @Test
  public void Test() {
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("alexa echo dot");
	  driver.findElement(By.id("nav-search-submit-button")).click();
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
