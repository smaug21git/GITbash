package hc.hms.Smoke;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import hc.hms.BaseclassUtility.BaseClass;
import hc.hms.FileUtility.excelFileUtility;
import hc.hms.Javautility.javaUtility;
import hc.hms.POM.DoctorModule.ManagePatient_searchPatient;
import hc.hms.POM.DoctorModule.addPatientPage;
import hc.hms.POM.DoctorModule.doctorLoginPage;
import hc.hms.POM.WelcomePage.welcomePage;

public class AddPatientTest extends BaseClass{
	
	@Test(groups = "smoke")
	public void addpatient() throws IOException, Throwable {
		
		javaUtility jutil= new javaUtility();
		int rno = jutil.togetRandomNumber();
		
		excelFileUtility eutil= new excelFileUtility();
		String Doc_username = eutil.toReadDataFromExcel("Doctor", 11, 2);
		String Doc_password = eutil.toReadDataFromExcel("Doctor", 11, 3);
		
		String Patient_name=eutil.toReadDataFromExcel("Doctor", 1, 2)+rno;
		String Patient_contactNumber=eutil.toReadDataFromExcel("Doctor", 1, 3);
		String Patient_email=eutil.toReadDataFromExcel("Doctor", 1, 4)+rno;
		String Patient_address=eutil.toReadDataFromExcel("Doctor", 1, 5);
		String Patient_age=eutil.toReadDataFromExcel("Doctor", 1, 6);
		String Patient_medicalHistory=eutil.toReadDataFromExcel("Doctor", 1, 7);
		
		welcomePage wp= new welcomePage(driver);
		doctorLoginPage dp= new doctorLoginPage(driver);
		addPatientPage ap= new addPatientPage(driver);
		ManagePatient_searchPatient msp= new ManagePatient_searchPatient(driver);
		
		
		
		wp.toScrollDownToLoginAsDoctor(driver);
		wutil.switchToTabOnUrl(driver, "hms/doctor/");
		
		dp.loginAsDoctor(Doc_username, Doc_password);
		ap.getpatientbtn().click();
		ap.getaddpatientbtn().click();
		
		ap.addNewPatient(Patient_name, Patient_contactNumber, Patient_email, Patient_address,
				Patient_age, Patient_medicalHistory);
		
		/*verify*/
		
		msp.search_patient(Patient_name);
		String diplayed_patientname = driver.findElement(By.xpath("//td[.='"+Patient_name+"']")).getText();
		
		Assert.assertEquals(Patient_name, diplayed_patientname);
		
		
		
	}

}
