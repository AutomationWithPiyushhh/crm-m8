package type_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrgTest {

	@Test
	public void createOrgTest() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
		System.out.println("Create Org");
        Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void modifyOrgTest() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
		System.out.println("Modify Org");
        Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void deleteOrgTest() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
		System.out.println("Delete Org");
        Thread.sleep(3000);
		driver.quit();
	}
}
