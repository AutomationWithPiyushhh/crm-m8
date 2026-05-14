package learning_listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.JavaUtility;

public class Listener_Implementation implements ISuiteListener, ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
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

	@Override
	public void onTestStart(ITestResult result) {
//		test = report.createTest("methodName"); // need to replace "methodname" with actual method name
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName); // need to replace "methodname" with actual method name
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Passed...");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Failed....");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Skipped...");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

}
