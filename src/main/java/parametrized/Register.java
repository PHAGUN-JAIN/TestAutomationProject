package parametrized;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {

	public static void register(String name, String pno, String email, String password) {
		
		System.out.println("Name " + name);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\omgill\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		
		WebElement RegisterBtn = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[3]/div[3]/div[2]/div/div[1]/div/div/a"));
		RegisterBtn.click();
		
		WebElement usr_name = driver.findElement(By.id("ap_customer_name"));
		usr_name.sendKeys(name);
		
		WebElement p_no = driver.findElement(By.id("ap_phone_number"));
		p_no.sendKeys(pno);
		
		WebElement mail = driver.findElement(By.id("ap_email"));
		mail.sendKeys(email);
		
		WebElement passwd = driver.findElement(By.id("ap_password"));
		passwd.sendKeys(password);
		
		WebElement contino = driver.findElement(By.id("continue"));
		contino.click();
		
		driver.close();
	}
	
	public static void main(String[] args) throws IOException {
		
		String username="";
		String phno = "";
		String mail = "";
		String password="";
		
		
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\omgill\\Desktop\\ExcelReaderTA.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("register");
			int rowCount = sheet.getLastRowNum();
			for(int i=1;i<=rowCount;i++) {
				XSSFRow row = sheet.getRow(i); 
				
				username = row.getCell(0).getRawValue();
				phno = row.getCell(1).getRawValue();
				mail = row.getCell(2).getRawValue();
				password = row.getCell(3).getRawValue();
				
				register(username, phno, mail, password);
				}
			wb.close();
			fis.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
