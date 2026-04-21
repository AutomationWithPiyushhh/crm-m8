package pom_extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Facebook {

//	initialization
	public Facebook(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	declaration
	@FindBy(name = "email")
	private WebElement un;
	
	public WebElement getUn() {
		return un;
	}
	
	@FindBy(name = "password")
	private WebElement pwd;
	
	public WebElement getPwd() {
		return pwd;
	}
	
	
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
		Facebook fb = new Facebook(driver);
		
		
		WebElement un = fb.getUn();
		driver.navigate().refresh();
		un.sendKeys("admin");
		
		Thread.sleep(3000);
		driver.quit();
	}
}
