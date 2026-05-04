package type_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LeadTest {

	@Test
	public void createLeadTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("Create Lead");
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void modifyLeadTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("Modify Lead");
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void deleteLeadTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("Delete Lead");
		Thread.sleep(3000);
		driver.quit();
	}
}
