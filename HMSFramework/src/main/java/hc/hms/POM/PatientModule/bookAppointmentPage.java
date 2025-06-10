package hc.hms.POM.PatientModule;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hc.hms.Webdriverutility.webdriverUtility;

public class bookAppointmentPage {

	/* initializing the elements of the webpage */
	WebDriver driver;
	webdriverUtility wutil = new webdriverUtility();

	public bookAppointmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	/* Locating the elements of the webpage using @FindBy annotation */
	@FindBy(name = "Doctorspecialization")
	private WebElement doctorSpecializationDropDown;

	@FindBy(id = "doctor")
	private WebElement doctorNameDropDown;

	@FindBy(name = "appdate")
	private WebElement dateTF;

	@FindBy(name = "apptime")
	private WebElement timeTF;
	
	

	/* providing getter methods for each elements of the webpage */

	public WebElement getDoctorSpecializationDropDown() {
		return doctorSpecializationDropDown;
	}

	public WebElement getDoctorNameDropDown() {
		return doctorNameDropDown;
	}

	public WebElement getDateTF() {
		return dateTF;
	}

	public WebElement getTimeTF() {
		return timeTF;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	@FindBy(name = "submit")
	private WebElement submitBtn;

	
	
	/**
	 * Business libreries
	 * 
	 * @param SPECIALIZATION
	 * @throws InterruptedException
	 */

	public void putAppointment(String specialization, String Doctorname) throws InterruptedException {
//
		WebElement specDD = getDoctorSpecializationDropDown();
	    wutil.toHandleDropDown(specialization,specDD);
		
	    getDoctorSpecializationDropDown().sendKeys(Keys.TAB);
	    
		getDoctorNameDropDown().click();
	  
		WebElement dNameDD = getDoctorNameDropDown();
		wutil.toHandleDropDown(Doctorname,dNameDD);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		getDateTF().click();
		driver.findElement(By.xpath("//tbody//tr//td[@class='day' and text()='25']")).click();
		
		driver.findElement(By.xpath("//label[contains(text(),'Time')]")).click();
		getSubmitBtn().click();
		Thread.sleep(2000);
		wutil.toHandleAlertPopupByAccept(driver);

	}

}
