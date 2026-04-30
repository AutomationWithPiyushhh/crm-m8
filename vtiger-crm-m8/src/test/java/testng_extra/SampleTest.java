package testng_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTest {
//	to execute same test script,
//	multiple times,
//	with the same set of data.... we go for ic
	
//	@Test(invocationCount = 5)
//	public void case1() {
//		Reporter.log("sample 1",true);
//	}
//	
//	@Test(invocationCount = 0)
//	public void case2() {
//		Reporter.log("sample 2",true);
//	}
//	
//	@Test
//	public void case3() {
//		Reporter.log("sample 3",true);
//	}
	

	@Test(invocationCount = 10, threadPoolSize = 3)
	public void chrome() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.quit();
	}
	
}
