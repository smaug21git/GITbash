package doctor;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BASEclassUtility.Baseclass;
import POMclass.AdminAddDoctorPage;
import POMclass.AdminLoginPage;
import WebdriverUtility.WebDriverUtility;

public class DoctorLoginPage extends Baseclass{
	
	@Test
	public void logintoDoctorModule() {
		
	
		driver.get("http://49.249.28.218:8081/AppServer/Hospital_Management_System/hms/admin/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		AdminLoginPage alp= new AdminLoginPage(driver);
		alp.loginAsAdmin("admin", "Test@12345");
		
		//add doc
		driver.findElement(By.xpath("//span[.=' Doctors ']")).click();
		driver.findElement(By.xpath("//span[.=' Add Doctor']")).click();
		
		AdminAddDoctorPage adp= new AdminAddDoctorPage(driver);
		
		 adp.getDoctorNameTxtFld().sendKeys("AAAAA");
		Select s= new Select(driver.findElement(By.name("Doctorspecialization")));
		s.selectByVisibleText("Dentist");
		
		
		
		adp.createDoctor("banasankari", "10", "990099900", "doctor3@gmail.com", "doctor22", "doctor22");
		
		driver.switchTo().alert().accept();
		
		//logout
		driver.findElement(By.xpath("//img[@src='assets/images/images.jpg']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Log Out')]")).click();
		
		
	}

}
