package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Keyword;

public class LoginPage  {
	WebDriverWait wait;

	public LoginPage() {
		PageFactory.initElements(Keyword.driver, this);

	}

	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement UserName_ForLogin;

	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement password_ForLogin;

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement success_login;

	@FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]")
	WebElement Error_Msg;

	@FindBy(xpath = "//input[@value=\"Login\"]")
	WebElement login_Button;

	public void EnterUserName(String Username) {
		UserName_ForLogin.sendKeys(Username);

	}

	public void EnterPassword(String PassWord) {
		password_ForLogin.sendKeys(PassWord);

	}
	public void ClearUserName() {
		UserName_ForLogin.clear();;

	}

	public void ClearPassword() {
		password_ForLogin.clear();

	}
	

	public void ClickLogin() {
		login_Button.click();

	}

	public String getConfirm_Login() {

		try {
	        if (success_login.isDisplayed()) {
	            return "Login successful";
	        }
	    } catch (Exception e) {
	        // Capture and return the error message when login fails
	        String msg = wait.until(ExpectedConditions.visibilityOf(Error_Msg)).getText();
	        System.out.println("Error: " + msg);
	        return "Login failed: " + msg;
	    }
		return "Unknown login status";
		
		

	}

}
