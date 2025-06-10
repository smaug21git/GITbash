package BASEclassUtility;

/**
 * 
 * @author SANU
 * 
 *         contains TestNG configuration annotations. contains actions like
 *         connect to database, close the database connection, launching the
 *         browser, login to application,logout of application
 *
 */

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import Fileutility.ExcelUtility;
import Fileutility.PropertyUtility;
import ListnetUtility.ListenerUtility;
import WebdriverUtility.JavaUtility;
import WebdriverUtility.ThreadLocalUtility;
import WebdriverUtility.WebDriverUtility;


public class Baseclass {
	ExcelUtility elib= new ExcelUtility();
	PropertyUtility plib= new PropertyUtility();
	ListenerUtility llib= new ListenerUtility();
	JavaUtility jlib= new JavaUtility();
	ThreadLocalUtility tlib= new ThreadLocalUtility();
	WebDriverUtility wlib= new WebDriverUtility();

	public WebDriver driver = null; // =============> if we make this static it will not take part in parallel
									// execution

	public static WebDriver sdriver = null;

	@BeforeSuite(groups = { "SmokeTest", "RegressionTest" })
	public void beforesuit() {
		System.out.println("============DB connection=====");
		
	}

	@BeforeTest(groups = { "SmokeTest", "RegressionTest" })
	public void beforetest() {

	}
	@Parameters("BROWSER")
	@BeforeClass(groups = { "SmokeTest", "RegressionTest" })

	public void beforeclass(@Optional("chrome") String browser) throws IOException {
		System.out.println("=====launch Browser=========");
		
		String BROWSER = browser;
		

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;

		ThreadLocalUtility.setDriver(driver);
	}

	@BeforeMethod(groups = { "SmokeTest", "RegressionTest" })
	public void loginpage() throws Throwable {
		
		System.out.println("======HMS HOME PAGE=========");

	 

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(17));
		driver.manage().window().maximize();
		driver.get("http://49.249.28.218:8081/AppServer/Hospital_Management_System/");

		

	}

	@AfterMethod(groups = { "SmokeTest", "RegressionTest" })
	public void aftermethod() {
		System.out.println("=====AFTER METHOD=======");
		
	}

	@AfterClass(groups = { "SmokeTest", "RegressionTest" })
	public void afterclass() {

		//driver.quit();
	}

	@AfterTest(groups = { "SmokeTest", "RegressionTest" })
	public void aftertest() {

	}

	@AfterSuite(groups = { "SmokeTest", "RegressionTest" })
	public void aftersuit() throws SQLException {
		

	}

}
