package type_of_execution;

import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generic_utility.JavaUtility;

public class OpenBrowser {
	
	WebDriver driver;
	
//	@Parameters("browser")
//	@Test
	public void openBro(String bro) throws InterruptedException {
//		String bro = "firefox";
		
		if (bro.equals("chrome")) {
			driver = new ChromeDriver();
		}else if (bro.equals("edge")) {
			driver = new EdgeDriver();
		}else if (bro.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Thread.sleep(10000);
		driver.quit();
	}
	
	
	
	
	@Test
	public void dyn_xpath() {

		String orgName = "awp_" + JavaUtility.generateRandomNumber();
		System.out.println(orgName);
		
		String xpath = "//a[text()='" + orgName + "']";
		System.out.println(xpath);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
