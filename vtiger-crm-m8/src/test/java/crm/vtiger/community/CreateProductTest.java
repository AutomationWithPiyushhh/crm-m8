package crm.vtiger.community;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateProductTest {
	public static void main(String[] args) throws InterruptedException {
//		opening browser		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		login
		driver.get("http://localhost:8888");

		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys("admin");

		WebElement pwd = driver.findElement(By.name("user_password"));
		pwd.sendKeys("password");

		WebElement loginBtn = driver.findElement(By.id("submitButton"));
		loginBtn.click();

//		create product
		driver.findElement(By.linkText("Products")).click();

		driver.findElement(By.cssSelector("img[alt='Create Product...']")).click();

//		fill form
		WebElement prodField = driver.findElement(By.name("productname"));

		String prodName = "selenium";
		prodField.sendKeys(prodName);

		driver.findElement(By.cssSelector("input[type='submit']")).click();

//		verify product
		String actProdName = driver.findElement(By.id("dtlview_Product Name")).getText();

		if (actProdName.equals(prodName)) {
			System.out.println("product created successfullyy !!!!");
		} else {
			System.out.println("Better luck next time... Dingeshhh");
		}

//		logout
		WebElement profileIcon = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		profileIcon.click();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
//		browser close		
		Thread.sleep(3000);
		driver.quit();
	}
}
