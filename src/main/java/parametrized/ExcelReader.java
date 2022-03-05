package parametrized;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelReader {

	public static void main(String[] args) throws IOException {
		// Excel file 2 column username & password
		String username = "";
		String password = "";
		// how to read Excel file
		
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\omgill\\Desktop\\ExcelReaderTA.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("login");
			int rowCount = sheet.getLastRowNum();
			for(int i=1;i<=rowCount;i++) {
				XSSFRow row = sheet.getRow(i); 
				if(row.getCell(0).getCellType()==CellType.NUMERIC) {
					username = row.getCell(0).getRawValue();}
				else {
					username = row.getCell(0).toString();
				}
				password = row.getCell(1).getRawValue();
				login (username,password);
				}
			wb.close();
			fis.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
//		login(username, password);

	}
	public static void login(String username, String password) {
		System.out.println("Running TC with username " + username + " password " + password);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\omgill\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // to maximize the window
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("nav-signin-tooltip")).click();
		
		WebElement email = driver.findElement(By.id("ap_email"));
		email.sendKeys(username);
		WebElement continueButton = driver.findElement(By.id("continue"));
		continueButton.click();
		WebElement passwd = driver.findElement(By.id("ap_password"));
		passwd.sendKeys(password);
		driver.findElement(By.id("signInSubmit")).submit();
		driver.close();
	}
}