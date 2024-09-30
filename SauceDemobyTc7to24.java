
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SauceDemobyTc7to24 {
	@Test
	public void verifyPrice() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		// driver.manage().window().fullscreen();

		List<WebElement> menuList = driver.findElements(By.className("inventory_item_name"));

		for (WebElement eachMenu : menuList) {
			// System.out.println(eachMenu.getText());
			String smallItem = eachMenu.getText();
			// System.out.println(smallItem);
			String sampleString = "Sauce Labs Onesie";
			if (smallItem.equals(sampleString)) {
				System.out.println("string is " + smallItem.equals(sampleString));
				Thread.sleep(3000);
	//7.	Click on add to cart for “Sauce Labs Onesie”.
				driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
	//8.	Verify the text gets changed to “remove”.

				String removeText = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-onesie']")).getText();
				assertEquals(removeText, "Remove");
			}

		}
//9.	Change the dropdown to “Low to high”.

		WebElement dropdownValues = driver.findElement(By.className("product_sort_container"));
		Select objSelect = new Select(dropdownValues);
		objSelect.selectByValue("lohi");

//10.	Verify that the first item is “Sauce Labs Onesie”.

		List<WebElement> menuList2 = driver.findElements(By.className("inventory_item_name"));
		for (WebElement eachMenu2 : menuList2) 
		{
			System.out.println(eachMenu2.getText());

		}
		System.out.println("First element after dropdown changed is " + menuList2.get(0).getText());

//11.	Click on the cart icon.

		driver.findElement(By.className("shopping_cart_link")).click();

//11.	Click on the cart icon.
		String cartQuantity = driver.findElement(By.className("cart_quantity")).getText();
		assertEquals(cartQuantity, "1");

//13.	Click on “Checkout”
		driver.findElement(By.id("checkout")).click();

//14.	Send values to the 2 fields.

		driver.findElement(By.id("first-name")).sendKeys("Monali");
		driver.findElement(By.id("last-name")).sendKeys("Khandode");

//15.	Click on “Continue”.
		driver.findElement(By.id("continue")).click();


//16.	Verify the text “Error: Postal Code is required”.

		String errorMsg = driver.findElement(By.xpath("//div[@class=\"error-message-container error\"]/h3")).getText();
		assertEquals(errorMsg, "Error: Postal Code is required");

//17.	Send values for “Postal Code”.

		driver.findElement(By.id("postal-code")).sendKeys("440022");

//18.	Click on “Continue”. 

		driver.findElement(By.id("continue")).click();

//19.	Verify the title.
		String titleOnCheckout = driver.findElement(By.id("item_2_title_link")).getText();
		assertEquals(titleOnCheckout, "Sauce Labs Onesie");

//20.	Verify the addition: $7.99 + $0.64 = $8.63.
		
		 String subTotal = driver.findElement(By.className("summary_subtotal_label")).getText();
		 String subTotalWithoutSign=subTotal.substring(13);
		// System.out.println(subTotalWithoutSign);
		 double itemTotal = Double.parseDouble(subTotalWithoutSign);
		 //System.out.println(itemTotal);
		 
		 String taxText = driver.findElement(By.className("summary_tax_label")).getText(); 
		 String taxValue = taxText.substring(6);
		 //System.out.println(taxValue);
		 double tax = Double.parseDouble(taxValue); 
		 double totalPrice = itemTotal + tax; 
		 String totalText = Double.toString(totalPrice); 

//21.	Verify total is: “8.63”.
		 String summaryTotal = driver.findElement(By.className("summary_total_label")).getText().substring(8);
		 assertEquals(summaryTotal,totalText);

//22.	Click on “finish”
		 
		driver.findElement(By.id("finish")).click();

//23.	Assert text “Thank you for your order!”.

		String thankText = driver.findElement(By.className("complete-header")).getText();
		assertEquals(thankText, "Thank you for your order!");

//24.	Assert button text “Back Home”.

		String backButtonText = driver.findElement(By.id("back-to-products")).getText();
		assertEquals(backButtonText, "Back Home");

	}

}