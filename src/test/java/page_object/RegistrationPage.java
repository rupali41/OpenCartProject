package page_object;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.utility.RandomString;
import utils.Keyword;
import utils.Waitfor;

public class RegistrationPage {

	public RegistrationPage() {
		PageFactory.initElements(Keyword.driver, this);

	}

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//input[@name=\"telephone\"]")
	WebElement phoneno;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@name=\"confirm\"]")
	WebElement confirmpassword;

	@FindBy(xpath = "//input[@name=\"agree\"]")
	WebElement checkbox;

	@FindBy(xpath = "//input[@value=\"Continue\"]")
	WebElement continueButton;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement confirmationMessage;

	@FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]")
	WebElement already_Register_msg;
	
	@FindBy(xpath="//div[text()='First Name must be between 1 and 32 characters!']")
	private static WebElement blankfirst_name;
	
	@FindBy(xpath="//div[text()='E-Mail Address does not appear to be valid!']")
	private static WebElement Invalid_email;

	public void enterFirstName(String name) {
		Keyword.sendText(firstName, name);

	}

	public void enterLastName(String lastNameText) {
		Keyword.sendText(lastName, lastNameText);
	}

	public void enterEmail(String emailText) {
		Keyword.sendText(email, emailText);
	}

	public void enterPhone(String phonenumber) {
		Keyword.sendText(phoneno, phonenumber);
	}

	public void enterPassword(String pass) {
		Keyword.sendText(password, pass);
	}

	public void enterconfirmPassword(String pass) {
		Keyword.sendText(confirmpassword, pass);
	}

	public void selectCheckbox() {
		Keyword.clickOn(checkbox);
	}

	public void clickContinue() {
		Keyword.clickOn(continueButton);

	}
	
	public String  get_InvalidEmailMsg() {
		Waitfor.visiblityOfElement(Invalid_email);
		return Keyword.getTextFrom(Invalid_email);
	}
	
	public String  getBlank_NameMsg() {
		Waitfor.visiblityOfElement(blankfirst_name);
		return Keyword.getTextFrom(blankfirst_name);
	}

	public String getConfirmationMessage() {
		Waitfor.visiblityOfElement(confirmationMessage);
		return Keyword.getTextFrom(confirmationMessage);
	}
	
	public String getErrorMsg() {
		Waitfor.visiblityOfElement(already_Register_msg);
		return Keyword.getTextFrom(already_Register_msg);

	}
	
	public String getFirstname() {
		return Keyword.getTextFrom(firstName);
	}
	
	public  String randomString() {
		String generatedString =RandomStringUtils.randomAlphabetic(4);
		return generatedString;
	}
	
	public  String randomNumber() {
		String generatednumber =RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public  String randomAlphaNumeric() {
		String generatedString =RandomStringUtils.randomAlphabetic(3);
		String generatednumber =RandomStringUtils.randomNumeric(4);
		return (generatedString+"@"+ generatednumber);
	}
	
	

	

}
