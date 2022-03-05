package selenium.automatedtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\omgill\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		
		WebElement RegisterBtn = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[3]/div[13]/div[2]/div/a"));
		RegisterBtn.click();
		
		WebElement usr_name = driver.findElement(By.id("ap_customer_name"));
		usr_name.sendKeys("Jainsaheb__");
		
		WebElement p_no = driver.findElement(By.id("ap_phone_number"));
		p_no.sendKeys("123456789");
		
		WebElement mail = driver.findElement(By.id("ap_email"));
		mail.sendKeys("johndoe@doe.com");
		
		WebElement passwd = driver.findElement(By.id("ap_password"));
		passwd.sendKeys("pass123456");
		
		WebElement contino = driver.findElement(By.id("continue"));
		contino.click();
		
	//	driver.close();
		
	}

}
