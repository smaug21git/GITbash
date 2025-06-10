package hc.hms.POM.DoctorModule;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePatient_searchPatient {
	/* initializing of managepatient page */
	public WebDriver driver;
	public ManagePatient_searchPatient(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	/* finding elements of the manage patient page using @Findby annotation*/
	
	@FindBy(xpath = "//span[.=' Search ']")
	private WebElement searchnavBtn;
	
	@FindBy(name = "searchdata")
	private WebElement searchtxtfield;
	
	@FindBy(name = "search")
	private WebElement searchbtn;
	
	/*providing getter methods for the given manage patient page*/
	
	public WebElement getsaechnavbtn()
	{
		return searchnavBtn;
	}
	
	public WebElement getsearchtxtfield()
	{
		return searchtxtfield;
	}
	
	public WebElement getsearchbtn()
	{
		return searchbtn;
	}
	
	/*
	 * business lib*/
	
	public void search_patient(String name) {
		
		getsaechnavbtn().click();
		getsearchtxtfield().sendKeys(name,Keys.ENTER);
		
	}


}
