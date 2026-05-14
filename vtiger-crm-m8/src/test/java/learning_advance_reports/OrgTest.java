package learning_advance_reports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.JavaUtility;

public class OrgTest {

	ExtentReports report;

	@BeforeSuite
	public void repConfig() {
//		configuration
		String time = JavaUtility.generateTime();
		ExtentSparkReporter spark = new ExtentSparkReporter("./advance_reports/" + time + ".html");

		spark.config().setDocumentTitle("VTiger CRM | Automation Test Results");
		spark.config().setReportName("QA Automation Regression Suite Execution Report");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(spark);

		report.setSystemInfo("Project Name", "VTiger CRM Automation");
		report.setSystemInfo("Tester", "QA Automation Engineer");
		report.setSystemInfo("Automation Tool", "Selenium WebDriver");
		report.setSystemInfo("Framework", "TestNG Hybrid Framework");
	}

	@Test
	public void createOrgTest() {

//		report generation
		ExtentTest test = report.createTest("createOrgTest");

		WebDriver driver = null;

		try {
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

			driver.get("http://localhost:8888/");

			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("password");
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();

			boolean status = driver.findElement(By.partialLinkText("Home")).isDisplayed();

			Assert.assertTrue(status, "Login failed...");
			test.log(Status.PASS, "User logged into VTiger CRM successfully");

		} catch (Exception e) {
			test.log(Status.FAIL, "Test case failed due to : " + e.getMessage());
			throw e;
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}

	@Test
	public void modifyOrgTest() {
		ExtentTest test = report.createTest("modifyOrgTest");

		WebDriver driver = null;

		try {
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

			driver.get("http://localhost:8888/");

			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("password");
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();

			boolean status = driver.findElement(By.partialLinkText("Home")).isDisplayed();

			Assert.assertTrue(status, "Login failed...");
			test.log(Status.PASS, "User logged into VTiger CRM successfully");

		} catch (Exception e) {
			test.log(Status.FAIL, "Test case failed due to : " + e.getMessage());
			throw e;
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}

	@Test
	public void deleteOrgTest() {

		ExtentTest test = report.createTest("deleteOrgTest");

		WebDriver driver = null;

		try {
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

			driver.get("http://localhost:8888/");

			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("password");
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();

			boolean status = driver.findElement(By.partialLinkText("Home")).isDisplayed();

			Assert.assertTrue(status, "Login failed...");
			test.log(Status.PASS, "User logged into VTiger CRM successfully");

		} catch (Exception e) {
			test.log(Status.FAIL, "Test case failed due to : " + e.getMessage());
			throw e;
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}

	@AfterSuite
	public void repBackup() {
		report.flush();
	}
}