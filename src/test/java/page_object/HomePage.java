package page_object;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Keyword;

public class HomePage  {
	
	@FindBy(xpath="//span[text()='My Account']")
	private static WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	private static WebElement registration;
	
	@FindBy(xpath= "//a[text()='Login']")
	 private  WebElement login ;

	public HomePage() {
		PageFactory.initElements(Keyword.driver, this);
		
	}

	public void clickMyAccount() {
		myAccount.click();
	}

	public void clickRegister() {
		registration.click();
	}

	public void clickOnLogin() {
		login.click();
	}

}
