package selenium.onlineClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginScript {
	private static final CharSequence EMAIL = "";
	private static final CharSequence PASSWORD = "";

	public static void main(String[] args) {
		
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\omgill\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		System.out.println("Login script");
		WebDriver driver = new ChromeDriver();
		
		//Deleting all the cookies
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://learn.upes.ac.in/webapps/login/");
		
		//CASE
		driver.findElement(By.id("agree_button")).click();
		driver.findElement(By.id("user_id")).sendKeys(EMAIL);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("entry-login")).click();
		
	}

}
