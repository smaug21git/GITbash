package hc.hms.Listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import hc.hms.BaseclassUtility.BaseClass;
import hc.hms.Webdriverutility.UtilityClassObject;


public class ListenerImplementClass implements ITestListener , ISuiteListener{
	
	//For Extent Reports 👇
		public ExtentSparkReporter esr;
		public ExtentReports report;
		public ExtentTest test;

	public void onStart(ISuite suite) {
		System.out.println("report configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		esr = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		esr.config().setDocumentTitle("Repo Test Suite Result");
		esr.config().setReportName("Repo Report");
		esr.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Version", "133.0.6943.142 (Official Build) (64-bit)");
	}

	public void onFinish(ISuite suite) {
		System.out.println("report backup");
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("==========="+result.getMethod().getMethodName()+"============START===========");
		test = report.createTest(result.getMethod().getMethodName());
		
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+"============START===========");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("========="+result.getMethod().getMethodName()+"=========END========");
		test.log(Status.INFO,result.getMethod().getMethodName()+"========COMPLETED===========");
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sDriver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromBase64String(src, testName +"_" + time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"========FAILED=========");
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
}
