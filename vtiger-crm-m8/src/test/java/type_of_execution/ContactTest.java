package type_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ContactTest {

	@Test
	public void createContactTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("Create Contact");
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void modifyContactTest()  throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		System.out.println("Modify Contact");
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void deleteContactTest()  throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		System.out.println("Delete Contact");
		Thread.sleep(3000);
		driver.quit();
	}
}
