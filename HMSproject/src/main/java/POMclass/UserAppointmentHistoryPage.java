package com.hrm.POMclass;

public class UserAppointmentHistoryPage {
	
	 private WebDriver driver;

	    public UserAppointmentHistoryPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver,this);
	    }
	    @FindBy(xpath = "//table[@class='table table-hover']/thead/following-sibling::tbody//tr//td[contains(.,'Active')]")
	    private WebElement appointmentHistoryList;
	    @FindBy(xpath = "//a[@title='Cancel Appointment']")
	    private WebElement cancelButton;
	    @FindBy(xpath = "//p[contains(.,'Your appointment canceled !!')]")
	    private WebElement appointmentCancellationText;

	    public WebElement getAppointmentCancellationText() {
	        return appointmentCancellationText;
	    }

	    public WebElement getCancelButton() {
	        return cancelButton;
	    }

	    public WebElement getAppointmentHistoryList() {
	        return appointmentHistoryList;
	    }

}
