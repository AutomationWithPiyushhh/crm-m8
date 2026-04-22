package crm.vtiger.organization;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebdriverUtility;
import object_repository.LoginPage;

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

		WebdriverUtility wdUtil = new WebdriverUtility(driver);

		wdUtil.maxWin();
		wdUtil.waitForPageLoad();
		
//		login
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
//		WebElement un = lp.getUn();
//		un.sendKeys(USERNAME);
//
//		WebElement pwd = lp.getPwd();
//		pwd.sendKeys(PASSWORD);
//
//		WebElement loginBtn = lp.getLoginBtn();
//		loginBtn.click();		
		
		lp.login(USERNAME, PASSWORD);
		
//		create organization
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

//		fill form
		WebElement orgField = driver.findElement(By.name("accountname"));

		
		String orgName = fUtil.getDataFromExcelFile("org", 2, 0) + JavaUtility.generateRandomNumber();
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
		
		
		wdUtil.hover(profileIcon);

		driver.findElement(By.linkText("Sign Out")).click();

//		browser close		
		Thread.sleep(3000);
		driver.quit();
	}
}
