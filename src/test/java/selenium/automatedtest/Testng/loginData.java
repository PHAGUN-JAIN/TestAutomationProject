package selenium.automatedtest.Testng;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class loginData {
//  @Test(dataProvider = "dp")
//  public void f(Integer n, String s) {
//  }

  @DataProvider(name="loginTestData")
  public static Object[][] dataP() {
	  
	  Object[][] data = new Object[3][4];
	  
	  data[0][0] = "abc";
	  data[0][1] = "abc123";
	  data[0][2] = "chrome";
	  data[0][3] = "98.0.4758.102";
	  
	  data[1][0] = "def";
	  data[1][1] = "def#009";
	  data[1][2] = "chromium brave";
	  data[1][3] = "1.35.103";
	  
	  data[2][0] = "xyz";
	  data[2][1] = "xyz698";
	  data[2][2] = "IE";
	  data[2][3] = "69.78.04";
	  
	  return data;
	  
//    return new Object[][] {
//      new Object[] { 1, "a" },
//      new Object[] { 2, "b" },
//    };
  }
  
  
  @DataProvider(name="loginData")
  public static Object[][] datalogin(){
	  Object[][] data = new Object[3][4];
	  
	  data[0][0] = "500076430@stu.upes.ac.in";
<<<<<<< HEAD
	  data[0][1] = "";
=======
	  data[0][1] = "Phagun#123";
>>>>>>> 9a8613aacd455540599f7da0b90af598c76152c0
	  data[0][2] = "chrome";
	  data[0][3] = "98.0.4758.102";
	  
	  data[1][0] = "PHAGUNJAIN@gmail.com";
	  data[1][1] = "def#009";
	  data[1][2] = "chromium brave";
	  data[1][3] = "1.35.103";
	  
	  data[2][0] = "littletoddler@outlook.com";
	  data[2][1] = "xyz698";
	  data[2][2] = "IE";
	  data[2][3] = "69.78.04";
	  
	return data;
	  
  }
}
