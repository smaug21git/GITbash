package hc.hms.Smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import hc.hms.BaseclassUtility.BaseClass;
import hc.hms.Javautility.javaUtility;
import hc.hms.POM.PatientModule.createNewAccountPage;
import hc.hms.POM.WelcomePage.welcomePage;

public class VerifyemailtxtFieldTest extends BaseClass {
	@Test
	public void verifyemailtextfield() throws InterruptedException {
		
		javaUtility jutil= new javaUtility();
		int rno = jutil.togetRandomNumber();
		
		welcomePage wp= new welcomePage(driver);
		wp.toScrollDownToLoginAsPatient(driver);
		wutil.switchToTabOnUrl(driver, "hms/user-login.php");
	
		createNewAccountPage cna= new createNewAccountPage(driver);
		cna.getcreateacbtn().click();
		cna.getEmailTF().sendKeys("test"+rno+"@gmail.com", Keys.TAB) ;
		Thread.sleep(3000);
		
		/*verification */
		 boolean valid_email = driver.findElement(By.xpath("//span[.=' Email available for Registration .']")).isDisplayed();
		
		Assert.assertTrue(valid_email);
	}

}
