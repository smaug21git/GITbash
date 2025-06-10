package hc.hms.BaseclassUtility;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import hc.hms.FileUtility.DataBaseUtility;
import hc.hms.FileUtility.excelFileUtility;
import hc.hms.FileUtility.propertyFileUtility;
import hc.hms.Webdriverutility.UtilityClassObject;
import hc.hms.Webdriverutility.webdriverUtility;

public class BaseClass {

	public WebDriver driver = null;
	public static WebDriver sDriver = null;
	propertyFileUtility putil = new propertyFileUtility();
	excelFileUtility eutil = new excelFileUtility();
	public webdriverUtility wutil = new webdriverUtility();
	DataBaseUtility dutil = new DataBaseUtility();

	@BeforeSuite
	public void dataBaseConnection() {
		System.out.println("<==========Connected to DB==========>");
		dutil.getDbConnectionWithCredentials();
	}

	

	@BeforeClass
	public void toLaunchBrowser() throws Throwable {
		
	}

	@BeforeMethod(groups = { "system", "integration", "smoke" })
	public void toGetIntoUrl() throws Throwable {


		String BROWSER = putil.toReadDataFromPropertyFile("browser");

		System.out.println("====================Launching to Browser=========================");
		
		if (BROWSER.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.contains("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.contains("firefox")) {
			driver = new FirefoxDriver();
		}
		wutil.toMaximize(driver);
		wutil.implicitWait(driver);

		sDriver = driver;
		UtilityClassObject.setDriver(driver);

		String URL = putil.toReadDataFromPropertyFile("url");
		driver.get(URL);

	}

	@AfterMethod(groups = { "system", "integration", "smoke" })
	public void toCloseBrowser() {
		
		System.out.println("================Closing the Browser========================");
		//driver.quit();
	}

	@AfterClass
	public void toClose() {

	}


	@AfterSuite
	public void ExtentReportFlush() {
		System.out.println("Closing the DB connection");

	}

}
