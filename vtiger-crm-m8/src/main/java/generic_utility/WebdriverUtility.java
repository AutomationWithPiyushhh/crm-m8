package generic_utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebdriverUtility {
	
	WebDriver driver;
	Actions act;
	
	public WebdriverUtility(WebDriver driver) {
		act = new Actions(driver);
		this.driver = driver;
	}
	
	public void maxWin() {
		driver.manage().window().maximize();
	}
	
	public void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void hover(WebElement element) {
		act.moveToElement(element).build().perform();
	}
	
	public void doubleClick(WebElement element) {
		act.doubleClick(element).build().perform();		
	}
}

