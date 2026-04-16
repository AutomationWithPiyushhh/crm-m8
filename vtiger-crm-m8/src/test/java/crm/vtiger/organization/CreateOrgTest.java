package crm.vtiger.organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;

public class CreateOrgTest {
	public static void main(String[] args) throws InterruptedException, IOException {
//		Get data from properties file
		FileUtility fUtil = new FileUtility();

		String BROWSER = fUtil.getDataFromPropFile("bro");
		String URL = fUtil.getDataFromPropFile("url");
		String USERNAME = fUtil.getDataFromPropFile("un");
		String PASSWORD = fUtil.getDataFromPropFile("pwd");

//		opening browser		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		login
		driver.get(URL);

		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys(USERNAME);

		WebElement pwd = driver.findElement(By.name("user_password"));
		pwd.sendKeys(PASSWORD);

		WebElement loginBtn = driver.findElement(By.id("submitButton"));
		loginBtn.click();

//		create organization
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

//		fill form
		WebElement orgField = driver.findElement(By.name("accountname"));

		
		String orgName = fUtil.getDataFromExcelFile("org", 2, 0);
//		String orgName = "awp";
		orgField.sendKeys(orgName);

		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

//		verify product
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		if (actOrgName.equals(orgName)) {
			System.out.println("Organization created successfullyy !!!!");
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
