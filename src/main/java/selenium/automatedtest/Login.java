package selenium.automatedtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\omgill\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("nav-link-accountList")).click();
		
		driver.findElement(By.id("ap_email")).sendKeys("500076430@stu.upes.ac.in");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("passwd");
		driver.findElement(By.id("signInSubmit")).click();
		
		
		driver.close();
		
	}
}
