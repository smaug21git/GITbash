package hc.hms.Smoke;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import hc.hms.BaseclassUtility.BaseClass;
import hc.hms.POM.PatientModule.createNewAccountPage;
import hc.hms.POM.WelcomePage.welcomePage;

public class VerifycreateACbuttonTest extends BaseClass {
	
	@Test(groups = "smoke")
	public void verifycreateacbtn() throws InterruptedException {
		
		
		welcomePage wp= new welcomePage(driver);
		wp.toScrollDownToLoginAsPatient(driver);
		wutil.switchToTabOnUrl(driver, "hms/user-login.php");
	
		createNewAccountPage cna= new createNewAccountPage(driver);
		cna.getcreateacbtn().click();
		Thread.sleep(2000);
		
		/*verification*/
		 String SignUptxt = driver.findElement(By.xpath("//legend[contains(text(),'Sign Up')]")).getText();
		Assert.assertEquals(SignUptxt, "Sign Up","Actual and expected result are not same");
		
	}

}
