package hc.hms.POM.DoctorModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hc.hms.Webdriverutility.webdriverUtility;

public class addPatientPage {

	WebDriver driver;
	webdriverUtility wutil = new webdriverUtility();
	

	public addPatientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[.=' Patients ']")
	private WebElement patientbtn;
	
	@FindBy(xpath = "//span[.=' Add Patient']")
	private WebElement addpatientbtn;
	
	@FindBy(name = "patname")
	private WebElement patientNameTF;
	
	@FindBy(name = "patcontact")
	private WebElement patientContactNoTF;
	
	@FindBy(name = "patemail")
	private WebElement patientEmailTF;
	
	@FindBy(name = "pataddress")
	private WebElement patientAddressTF;
	
	@FindBy(name = "patage")
	private WebElement patientAgeTF;
	
	@FindBy(name = "medhis")
	private WebElement medicalHistoryTF;
	
	@FindBy(xpath = "//label[@for='rg-female']")
	private WebElement femaleRadioBtn;
	
	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement maleRadioBtn;
	
	@FindBy(id = "submit")
	private WebElement addBtn;

	
	public WebElement getpatientbtn() {
		return patientbtn;
	}
	
	public WebElement getaddpatientbtn() {
		return addpatientbtn;
	}
	
    public WebElement getPatientNameTF() {
		return patientNameTF;
	}



	public WebElement getPatientContactNoTF() {
		return patientContactNoTF;
	}



	public WebElement getPatientEmailTF() {
		return patientEmailTF;
	}



	public WebElement getPatientAddressTF() {
		return patientAddressTF;
	}



	public WebElement getPatientAgeTF() {
		return patientAgeTF;
	}



	public WebElement getMedicalHistoryTF() {
		return medicalHistoryTF;
	}



	public WebElement getFemaleRadioBtn() {
		return femaleRadioBtn;
	}



	public WebElement getMaleRadioBtn() {
		return maleRadioBtn;
	}



	public WebElement getAddBtn() {
		return addBtn;
	}



public void addNewPatient(String patientName,String patientContactNo,String patientEmail,String patientAddress,String patientAge,String medicalHistory) throws InterruptedException{
	
	getPatientNameTF().sendKeys(patientName);
	getPatientContactNoTF().sendKeys(patientContactNo);
	getPatientEmailTF().sendKeys(patientEmail);
	getPatientAddressTF().sendKeys(patientAddress);
	getPatientAgeTF().sendKeys(patientAge);
	getMedicalHistoryTF().sendKeys(medicalHistory);
	getMaleRadioBtn().click();
	getAddBtn().click();

	
	}
	
	
	
	
	
	
}
