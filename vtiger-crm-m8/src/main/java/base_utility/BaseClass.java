package base_utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import generic_utility.FileUtility;
import generic_utility.WebdriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class BaseClass {
	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();

		WebdriverUtility wdUtil = new WebdriverUtility(driver);

		wdUtil.maxWin();
		wdUtil.waitForPageLoad();
	}

	@BeforeMethod
	public void login() throws IOException {
		FileUtility fUtil = new FileUtility();

		String URL = fUtil.getDataFromPropFile("url");
		String USERNAME = fUtil.getDataFromPropFile("un");
		String PASSWORD = fUtil.getDataFromPropFile("pwd");

		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}

	@AfterMethod
	public void logout() {
		WebdriverUtility wdUtil = new WebdriverUtility(driver);
		HomePage hp = new HomePage(driver);
		WebElement profileIcon = hp.getProfileIcon();
		wdUtil.hover(profileIcon);
		hp.getSignOutLink().click();
	}

	@AfterClass
	public void closeBro() {
		driver.quit();
	}
}
