import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPage{
	
	
	  @Test 
	  public void testLogin()
 { 
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.saucedemo.com/");
	  driver.manage().window().maximize();
	  driver.findElement(By.id("user-name")).sendKeys("standard_user");
	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  driver.findElement(By.id("login-button")).click(); 


// 1.	Get title of the login page
//2.	Assert 
	  String title1 = driver.getTitle();// it returns page title 
	  System.out.println(title1);
	  //String title2 = driver.findElement(By.className("app_logo")).getText();
	  //System.out.println(title2); 
	  assertEquals(title1,"Swag Labs"); 
 }
}