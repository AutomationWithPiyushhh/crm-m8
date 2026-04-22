package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://facebook.com/");

//		old approach
// 		WebElement un; // declaration
//		un = driver.findElement(By.name("email")); // initialization
//		driver.navigate().refresh();
//		
////		re-initialize
////		un = driver.findElement(By.name("email"));
//		un.sendKeys("admin"); // utilization

//		new approach
//		utilization
		
		LoginFBPage fb = new LoginFBPage(driver);

		WebElement un = fb.getUn();
		WebElement pwd = fb.getPwd();
		WebElement lb = fb.getLoginButton();

		un.sendKeys("admin");
		pwd.sendKeys("password");
		lb.click();

		Thread.sleep(3000);
		driver.quit();
	}
}
