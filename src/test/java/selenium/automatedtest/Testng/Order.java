package selenium.automatedtest.Testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Order {

	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
	}
	@Test
	public void test() {
		System.out.println("Test Method");
	}
	@Test
	public void test2() {
		System.out.println("Test 2");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Test");
	}
	@BeforeMethod
	public void beforeMethod1()
	{
		System.out.println("Before Method 1");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	
	@Test
	public void test3()
	{
		System.out.println("Test3 Method");
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite");
	}
}
