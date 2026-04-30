package testng_extra;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoTest {
	
//	to change the order of execution we will go for priority
//	lesser the value = earlier the execution
//	default value => Zero
	
//	@Test(priority = -1)
//	public void createCity() {
//		Reporter.log("created Noida", true);
//		
//	}
//
//	@Test
//	public void modifyCity() {
//		Assert.assertTrue(false);
//		Reporter.log("Noida => SmartNoida", true);
//	}
//
//	@Test(priority = 1)
//	public void deleteCity() {
//		Reporter.log("deleted SmartNoida", true);
//	}
	
	@Test(priority = 1)
	public void createCity() {
		Reporter.log("created Noida", true);
		
	}

	@Test(dependsOnMethods = "createCity")
	public void modifyCity() {
		Assert.assertTrue(false);
		Reporter.log("Noida => SmartNoida", true);
	}

	@Test(dependsOnMethods = {"modifyCity", "createCity"}, alwaysRun = true)
	public void deleteCity() {
		Reporter.log("deleted SmartNoida", true);
	}

}
