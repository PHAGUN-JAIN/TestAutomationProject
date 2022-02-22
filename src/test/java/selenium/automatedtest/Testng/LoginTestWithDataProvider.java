package selenium.automatedtest.Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestWithDataProvider {
	
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
	
	  @Test(dataProviderClass=loginData.class, dataProvider="loginData")
	  public void loginTest(String email, String passwd, String browser, String version){
		  
			driver.findElement(By.id("nav-link-accountList")).click();
			
			driver.findElement(By.id("ap_email")).sendKeys(email);
			driver.findElement(By.id("continue")).click();
			driver.findElement(By.id("ap_password")).sendKeys(passwd);
			driver.findElement(By.id("signInSubmit")).click();
			
			System.out.println("browser	" + browser);
			System.out.println("vrsn	" + version);
	  }
	  
	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  }

}
