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

public class DemoTest {


	@BeforeSuite
	public void repConfig() {
	}

	@Test
	public void case1() {
		
	}

	@Test
	public void case2() {
		
		Assert.assertTrue(false);
		
	}

	@Test(dependsOnMethods = "case2")
	public void case3() {
		System.out.println("this is not going to execute because it is skipped");
		
	}

	@AfterSuite
	public void repBackup() {
	}
}