import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SauceDemobyID{
	
	
	  @Test public void testLogin()
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
// 3.	Assert these two texts 
	  
	  @Test public void testtwoTexts()
 { 
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.saucedemo.com/");
	  
	  String userText =
	  driver.findElement(By.xpath("//div[@id=\"login_credentials\"]/h4")).getText(); 
                 //System.out.println(userText); 
	  String passwordText =
	  driver.findElement(By.xpath("//div[@class=\"login_password\"]/h4")).getText()
	  ; // System.out.println(passwordText);
	  
	  assertEquals(userText,"Accepted usernames are:");
	  assertEquals(passwordText,"Password for all users:");
 }
	  
//4.	Get the “Accepted” from first string and “users” from second string.

	  @Test public void testPartialText()
 {
	  
	  WebDriver driver = new ChromeDriver(); driver.manage().window().maximize();
	  driver.get("https://www.saucedemo.com/");
	  
	  String userText
	  =driver.findElement(By.xpath("//div[@id=\"login_credentials\"]/h4")).getText(); 
                  String passwordText =
	  driver.findElement(By.xpath("//div[@class=\"login_password\"]/h4")).getText();
	  
	  String userSubstr = userText.substring(0,8); System.out.println(userSubstr);
	  String passwordSubstr = passwordText.substring(17,22);
	  System.out.println(passwordSubstr); 
}
	  
//5.	Print all the 6 items.

	  @Test public void printSixItems()
 { 
	  WebDriver driver = new ChromeDriver(); //
	  driver.manage().window().maximize();
	  driver.get("https://www.saucedemo.com/");
	  driver.findElement(By.id("user-name")).sendKeys("standard_user");
	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  driver.findElement(By.id("login-button")).click(); List<WebElement> menuList
	  = driver.findElements(By.className("inventory_item_name"));
                  for (WebElement eachMenu : menuList)
		 { 
			System.out.println(eachMenu.getText());
			 String sampleString ="Sauce Labs Onesie";
	  		if(eachMenu.getText().equals(sampleString))
			 {
				 String itemPrice=driver.findElement(By.className("inventory_item_price")).getText();
	  			System.out.println("Price is" + itemPrice); 
			}
		 }
 }
	 
	
	// 6.	Verify that the “Sauce Labs Onesie” price is “7.99”.
	@Test
	public void verifyPrice() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		List<WebElement> menuList = driver.findElements(By.className("inventory_item_name"));
		for (WebElement eachMenu : menuList) 
		{
			// System.out.println(eachMenu.getText());
			String smallItem = eachMenu.getText();
			// System.out.println(smallItem);
			String sampleString = "Sauce Labs Onesie";
			Thread.sleep(2000);
			if (smallItem.equals(sampleString))
			{
				String itemPrice = driver.findElement(By.className("inventory_item_price")).getText();
				System.out.println("Price is" + itemPrice);
				String sauceLabOnesiePrice = itemPrice.substring(1);
				System.out.println(sauceLabOnesiePrice);
				//assertEquals(sauceLabOnesiePrice,"7.99");
			}
		}
		
	}
	
}