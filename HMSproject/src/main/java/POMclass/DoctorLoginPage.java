package com.hrm.POMclass;

public class DoctorLoginPage {
	
	 private WebDriver driver;

	    public DoctorLoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver,this);
	    }
	    @FindBy(name = "username")
	    private WebElement usernameTxtFld;

	    @FindBy(name = "password")
	    private WebElement passwordTxtFld;

	    @FindBy(name = "submit")
	    private WebElement loginBtn;

	    public WebElement getUsernameTxtFld() {
	        return usernameTxtFld;
	    }

	    public WebElement getPasswordTxtFld() {
	        return passwordTxtFld;
	    }

	    public WebElement getLoginBtn() {
	        return loginBtn;
	    }

	    // Login Method
	    public void loginAsDoctor(String username, String password) {
	        getUsernameTxtFld().sendKeys(username);
	        getPasswordTxtFld().sendKeys(password);
	        getLoginBtn().click();
	    }

}
