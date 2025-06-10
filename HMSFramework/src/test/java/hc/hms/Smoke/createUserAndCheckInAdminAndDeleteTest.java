package hc.hms.Smoke;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import hc.hms.BaseclassUtility.BaseClass;
import hc.hms.FileUtility.excelFileUtility;
import hc.hms.FileUtility.propertyFileUtility;
import hc.hms.POM.AdminModule.adminHomePage;
import hc.hms.POM.AdminModule.adminLoginPage;
import hc.hms.POM.PatientModule.createNewAccountPage;
import hc.hms.POM.PatientModule.patientLoginPage;
import hc.hms.POM.WelcomePage.welcomePage;
import hc.hms.Webdriverutility.UtilityClassObject;
import hc.hms.Webdriverutility.webdriverUtility;

@Listeners(hc.hms.Listenerutility.ListenerImplementClass.class)

public class createUserAndCheckInAdminAndDeleteTest extends BaseClass {

	@Parameters("BROWSER")
	@Test(groups = "system")
	public void createPatient() throws IOException, Throwable {
		
		propertyFileUtility putil = new propertyFileUtility();
		webdriverUtility wutil = new webdriverUtility();
		excelFileUtility eutil = new excelFileUtility();
		
		welcomePage wp= new welcomePage(driver);
		patientLoginPage plp = new patientLoginPage(driver);
		createNewAccountPage cnap = new createNewAccountPage(driver);
		adminLoginPage alp = new adminLoginPage(driver);
		adminHomePage ahp = new adminHomePage(driver);
		
		String FULL_NAME = eutil.toReadDataFromExcel("patient", 1, 2);
		String ADDRESS = eutil.toReadDataFromExcel("patient", 1, 3);
		String CITY = eutil.toReadDataFromExcel("patient", 1, 4);
		String PASSWORD = eutil.toReadDataFromExcel("patient", 1, 6);
		String ADMIN_USERNAME = putil.toReadDataFromPropertyFile("adminUserName");
		String ADMIN_PASSWORD = putil.toReadDataFromPropertyFile("adminPassword");
		
		
		UtilityClassObject.getTest().log(Status.PASS,"Application opened");
		wp.toScrollDownToLoginAsPatient(driver);
		Thread.sleep(3000);
		
		UtilityClassObject.getTest().log(Status.PASS,"Patient log in page opened");
		wutil.switchToTabOnUrl(driver, "hms/user-login.php");
		Thread.sleep(3000);
		
		plp.getCreateAccountLink().click();
		wutil.switchToTabOnUrl(driver, "hms/registration.php");
		UtilityClassObject.getTest().log(Status.PASS,"Patient registration page opened");
		Thread.sleep(3000);
		
		cnap.createNewAccount(FULL_NAME, ADDRESS, CITY, PASSWORD);
		UtilityClassObject.getTest().log(Status.PASS,"New Patient created");
		Thread.sleep(3000);
		//Doctor module
		wutil.switchToTabOnTitle(driver, "Hospital management System");
		wp.toScrollDownToLoginAsAdmin(driver);
		Thread.sleep(3000);
		UtilityClassObject.getTest().log(Status.PASS,"Admin login page opened");
		alp.LoginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
		Thread.sleep(3000);
		UtilityClassObject.getTest().log(Status.INFO, "Successfully logged in as Admin");
		ahp.getUsersTab().click();
		Thread.sleep(3000);
		ahp.getManageUsersTab().click();
		UtilityClassObject.getTest().log(Status.INFO, "Manage patients page opened");
		Thread.sleep(3000);
		
		Actions act= new Actions(driver);
		act.sendKeys(Keys.END).perform();
	
			try {
				driver.findElement(By.xpath("//tr/td[text()='"+FULL_NAME+"']/../td[9]/div/a/i[@class='fa fa-times fa fa-white']")).click();
				
			} catch (Exception e) {
				
			}
		
		Thread.sleep(3000);
		wutil.toHandleAlertPopupByAccept(driver);
		Thread.sleep(3000);
		UtilityClassObject.getTest().log(Status.INFO, "Registered user is removed");
		ahp.logoutAsAdmin();
		UtilityClassObject.getTest().log(Status.INFO, "logged out as admin");
		
		
	}
	
	
	
}
