package crm.vtiger.organization;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebdriverUtility;
import object_repository.CreateOrgPage;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OrgPage;
import object_repository.VerifyOrgPage;

public class CreateOrgTest {
	
	@Test
	public void createOrganizationTest() throws IOException, InterruptedException {
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
		lp.login(USERNAME, PASSWORD);
		
//		create organization
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrgPage op = new OrgPage(driver);
		op.getPlusIcon().click();

//		fill form
		CreateOrgPage cop = new CreateOrgPage(driver);
		WebElement orgField = cop.getOrgField();

		String orgName = fUtil.getDataFromExcelFile("org", 2, 0) + JavaUtility.generateRandomNumber();
//		String orgName = "awp";
		orgField.sendKeys(orgName);

		cop.getSaveBtn().click();

//		verify product
		VerifyOrgPage vop = new VerifyOrgPage(driver);	
		String actOrgName = vop.getActOrgName().getText();

//		if (actOrgName.equals("abc"+orgName)) {
//			Reporter.log("Organization created successfullyy !!!!");
//		} else {
//			Reporter.log("Better luck next time... Dingeshhh");
//		}

//		boolean status = actOrgName.equals(orgName);
//		Assert.assertTrue(status);
		
		Assert.assertEquals(actOrgName, orgName);

//		logout
		WebElement profileIcon = hp.getProfileIcon();
		wdUtil.hover(profileIcon);
		
		hp.getSignOutLink().click();		

//		browser close	
		Thread.sleep(3000);
		driver.quit();
	}
}
