package week4.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
	
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement searchbox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchbox.sendKeys("oneplus 9 pro");
		searchbox.sendKeys(Keys.ENTER);
		String price=driver.findElement(By.xpath("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']//span[@class='a-price-whole']")).getText();		
		System.out.println("First product price is "+price);
		//int productprict=Integer.parseInt(price);
		
		//First product rating
		driver.findElement(By.xpath("(//i[contains(@class, 'aok-align-bottom')])")).click();
		Thread.sleep(1000);
		WebElement ratingelement=driver.findElement(By.xpath("//span[contains(@class, 'a-text-beside-button a-text-bold')]"));
		String rating=ratingelement.getText();
		System.out.println(rating);
		
		//Click the 1st product
		driver.findElement(By.xpath("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']//span[@class='a-size-medium a-color-base a-text-normal'][1]")).click();
		
		Thread.sleep(2000);
		//6. Take a screen shot of the product displayed
		
			Set<String> windowHandles = driver.getWindowHandles();
			Iterator<String> iterator = windowHandles.iterator();
			String parentid=iterator.next();
			String childid=iterator.next();
			driver.switchTo().window(childid);
			File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("./screenshot/picture3.png"));
			
		
			//7. Click 'Add to Cart' button
			driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
			//Thread.sleep(3000);
			
			
			//8. Get the cart subtotal and verify if it is correct.
				WebElement cartpriceEle = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-price a-text-bold']"));
				
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
				wait.until(ExpectedConditions.visibilityOf(cartpriceEle));
				String cartprice=cartpriceEle.getText();
				//int cartprice1=(int)Float.parseFloat(cartprice);
				
				if(price==cartprice) {
					System.out.println("Cart subtotal price is equal to the product price");
				}
				else 
				
					System.out.println("Cart price is not equal to the product price");
					
			//9.close the browser
			
			driver.quit();
		
		
	}

}
