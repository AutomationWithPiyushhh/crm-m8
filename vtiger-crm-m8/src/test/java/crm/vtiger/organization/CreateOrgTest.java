package crm.vtiger.organization;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebdriverUtility;
import object_repository.CreateOrgPage;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OrgPage;
import object_repository.VerifyOrgPage;

public class CreateOrgTest extends BaseClass {
	
	@Test
	public void createOrganizationTest() throws IOException, InterruptedException {
//		Get data from properties file

//		opening browser		
		
//		login
		
//		create organization
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrgPage op = new OrgPage(driver);
		op.getPlusIcon().click();

//		fill form
		CreateOrgPage cop = new CreateOrgPage(driver);
		WebElement orgField = cop.getOrgField();
		FileUtility fUtil = new FileUtility();
		String orgName = fUtil.getDataFromExcelFile("org", 2, 0) + JavaUtility.generateRandomNumber();
		orgField.sendKeys(orgName);
		cop.getSaveBtn().click();

//		verify product
		VerifyOrgPage vop = new VerifyOrgPage(driver);	
		String actOrgName = vop.getActOrgName().getText();
		Assert.assertEquals(actOrgName, orgName);

//		logout

//		browser close	
	}
}
