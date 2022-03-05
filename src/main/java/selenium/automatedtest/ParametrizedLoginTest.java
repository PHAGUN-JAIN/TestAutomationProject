package selenium.automatedtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParametrizedLoginTest {
	
	public static void main() throws IOException{
	
		String username="";
		String password="";
		
		
		
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\omgill\\Desktop\\ExcelReaderTA.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("login");
			int rowCount = sheet.getLastRowNum();
			for(int i=1;i<rowCount;i++) {
				XSSFRow row = sheet.getRow(i); 
				if(row.getCell(0).getCellType()==CellType.NUMERIC)
					username = row.getCell(0).getRawValue();
				else
					username = row.getCell(0).toString();
				
				password = row.getCell(1).getRawValue();
				login (username,password);
				}
		
		
		

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		login(username, password);
	}
	
	public static void login(String usr_name, String passwd) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\omgill\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("nav-link-accountList")).click();
		
		driver.findElement(By.id("ap_email")).sendKeys(usr_name);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(passwd);
		driver.findElement(By.id("signInSubmit")).click();
		
		
		driver.close();
		
	}

}
