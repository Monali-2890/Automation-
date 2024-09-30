import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SauceDemobyXpathTestCase6to24{
	@Test
	public void verifyPrice() throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.xpath("//input[@id=\'user-name\']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id=\'password\']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id=\'login-button']")).click();
		// driver.manage().window().fullscreen();

		List<WebElement> inventoryItemList = driver.findElements(By.xpath("//div[@class=\'inventory_item_name \']"));

		for(WebElement eachItem : inventoryItemList)
		{
			System.out.println(eachItem.getText());
		
			String smallItem = eachItem.getText();
			//System.out.println(smallItem);
			String sampleString = "Sauce Labs Onesie";
			if (smallItem.equals(sampleString))
			{
				System.out.println("string is " + smallItem.equals(sampleString));
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id=\'add-to-cart-sauce-labs-onesie\']")).click();
				String removeText = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-onesie']")).getText();
				assertEquals(removeText, "Remove");
			}

		}
		WebElement dropdownValues = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select objSelect = new Select(dropdownValues);
	    objSelect.selectByValue("lohi");
	    
	
	    List<WebElement> menuList2 =driver.findElements(By.xpath("//div[@class='inventory_item_name ']")); 
	    for(WebElement eachMenu2 : menuList2) 
	    { 
	    	System.out.println(eachMenu2.getText());
 
	    }
	    System.out.println("First element after dropdown changed is " +menuList2.get(0).getText());
 
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		String cartQuantity = driver.findElement(By.xpath("//div[@class='cart_quantity']")).getText();
		assertEquals(cartQuantity, "1");
		 
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Monali");
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Khandode");
		driver.findElement(By.xpath("//input[@id='continue']")).click(); 
		String errorMsg =driver.findElement(By.xpath("//div[@class=\"error-message-container error\"]/h3")).getText();
		assertEquals(errorMsg, "Error: Postal Code is required");
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("440022");
		driver.findElement(By.xpath("//input[@id='continue']")).click(); 
		String titleOnCheckout =driver.findElement(By.xpath("//a[@id='item_2_title_link']")).getText();
		assertEquals(titleOnCheckout, "Sauce Labs Onesie");
		 
		String subTotal =
		driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();
		String subTotalWithoutSign=subTotal.substring(13);
		//System.out.println(subTotalWithoutSign); 
		double itemTotal =Double.parseDouble(subTotalWithoutSign);
		//System.out.println(itemTotal);
		 
		String taxText =
		driver.findElement(By.xpath("//div[@class='summary_tax_label']")).getText(); 
		String
		taxValue = taxText.substring(6); 
		System.out.println(taxValue); 
		double tax =
		Double.parseDouble(taxValue);
		double totalPrice = itemTotal + tax; 
		String totalText = Double.toString(totalPrice); 
		String summaryTotal =
		driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText().substring(8);
		assertEquals(summaryTotal,totalText);
		
		driver.findElement(By.xpath("//button[@id='finish']")).click(); 
		String thankText =
		driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
		assertEquals(thankText, "Thank you for your order!");
		
		String backButtonText =
		driver.findElement(By.xpath("//button[@id='back-to-products']")).getText();
		assertEquals(backButtonText, "Back Home");
		 }
 
}