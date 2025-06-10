package com.hrm.POMclass;

public class UserBookAppointmentsPage {
	
	private WebDriver driver;

    public UserBookAppointmentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "Doctorspecialization")
    private WebElement doctorSpecializationDrpDwn;

    @FindBy(name = "doctor")
    private WebElement doctorsDrpDwn;

    @FindBy(name = "fees")
    private WebElement feesDrpDwn;

    @FindBy(xpath = "//input[@name='appdate']")
    private WebElement dateTxtFld;

    @FindBy(xpath = "//input[@name='apptime']")
    private WebElement timeTxtFld;

    @FindBy(name = "submit")
    private WebElement submitBtn;

    public WebElement getDoctorSpecializationDrpDwn() {
        return doctorSpecializationDrpDwn;
    }

    public WebElement getDoctorsDrpDwn() {
        return doctorsDrpDwn;
    }

    public WebElement getFeesDrpDwn() {
        return feesDrpDwn;
    }

    public WebElement getDateTxtFld() {
        return dateTxtFld;
    }

    public WebElement getTimeTxtFld() {
        return timeTxtFld;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

}
