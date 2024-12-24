package TestCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import page_object.HomePage;
import page_object.RegistrationPage;
import utils.Keyword;
import utils.ListenersDemo;
@Listeners(ListenersDemo.class)
public class Registration_Test extends BaseTest {
	@Test(priority = 0)
	public void verifyUserSuccesfully_RegisterOrNot() {
		HomePage hp = new HomePage();
		hp.clickMyAccount();
		hp.clickRegister();
		RegistrationPage registrationPage = new RegistrationPage();
		registrationPage.enterFirstName(registrationPage.randomString());
		registrationPage.enterLastName(registrationPage.randomString());
		registrationPage.enterEmail(registrationPage.randomString() + "@gmail.com");
		registrationPage.enterPhone(registrationPage.randomNumber());
		String password = registrationPage.randomAlphaNumeric();
		registrationPage.enterPassword(password);
		registrationPage.enterconfirmPassword(password);
		registrationPage.selectCheckbox();
		registrationPage.clickContinue();
		if (registrationPage.getConfirmationMessage().contains("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
			System.out.println(registrationPage.getConfirmationMessage());

		} else {

			Assert.fail();

		}

	}

	@Test(priority = 1)
	public void verifyUserEnter_AlredyRegisterEmailId_thenItGetErrorMsg() {
		HomePage hp = new HomePage();
		hp.clickMyAccount();
		hp.clickRegister();
		RegistrationPage registrationPage = new RegistrationPage();
		registrationPage.enterFirstName("janavi");
		registrationPage.enterLastName("patel");
		registrationPage.enterEmail("janvipatel54@gmail.com");
		registrationPage.enterPhone("9875325465");
		registrationPage.enterPassword("janu@11");
		registrationPage.enterconfirmPassword("janu@11");
		registrationPage.selectCheckbox();
		registrationPage.clickContinue();
		String WarningMsg = "Warning: E-Mail Address is already registered!";
		String getmsg = registrationPage.getErrorMsg();
		Assert.assertEquals(getmsg, WarningMsg);
		System.out.println(registrationPage.getErrorMsg());

	}

	@Test(priority = 2)
	public void verifyUserEnter_BlankName_ErrormsgShouldDisplay() {
		HomePage hp = new HomePage();
		hp.clickMyAccount();
		hp.clickRegister();
		RegistrationPage registrationPage = new RegistrationPage();
		registrationPage.enterFirstName("");
		String FirstName = registrationPage.getFirstname();
		registrationPage.enterLastName(registrationPage.randomString());
		registrationPage.enterEmail(registrationPage.randomString() + "@gmail.com");
		registrationPage.enterPhone(registrationPage.randomNumber());
		String password = registrationPage.randomAlphaNumeric();
		registrationPage.enterPassword(password);
		registrationPage.enterconfirmPassword(password);
		registrationPage.selectCheckbox();
		registrationPage.clickContinue();
		String blankEmailMsg = "First Name must be between 1 and 32 characters!";
		if (FirstName.length() == 0) {
			String getErrorMsg = registrationPage.getBlank_NameMsg();
			Assert.assertEquals(blankEmailMsg, getErrorMsg);
			System.out.println(registrationPage.getBlank_NameMsg());

		}

	}
	@Test(priority = 3)
	public void verifyuserEnter_InvalidEmail() {
		HomePage hp = new HomePage();
		hp.clickMyAccount();
		hp.clickRegister();
		RegistrationPage registrationPage = new RegistrationPage();
		registrationPage.enterFirstName(registrationPage.randomString());
		registrationPage.enterLastName(registrationPage.randomString());
		registrationPage.enterEmail(registrationPage.randomString()+"@gmail");
		registrationPage.enterPhone(registrationPage.randomNumber());
		String password = registrationPage.randomAlphaNumeric();
		registrationPage.enterPassword(password);
		registrationPage.enterconfirmPassword(password);
		registrationPage.selectCheckbox();
		registrationPage.clickContinue();
		String InvalidGmailmsg="E-Mail Address does not appear to be valid!";
		String getmsg=registrationPage.get_InvalidEmailMsg();
		Assert.assertEquals(InvalidGmailmsg, getmsg);
		System.out.println(registrationPage.get_InvalidEmailMsg());
	}
	
	@Test(priority = 4)
	public void verifyUserStart_FirstNameFrom_Number() {
		HomePage hp = new HomePage();
		hp.clickMyAccount();
		hp.clickRegister();
		RegistrationPage registrationPage = new RegistrationPage();
		registrationPage.enterFirstName(registrationPage.randomNumber());
		registrationPage.enterLastName(registrationPage.randomString());
		registrationPage.enterEmail(registrationPage.randomString() + "@gmail.com");
		registrationPage.enterPhone(registrationPage.randomNumber());
		String password = registrationPage.randomAlphaNumeric();
		registrationPage.enterPassword(password);
		registrationPage.enterconfirmPassword(password);
		registrationPage.selectCheckbox();
		registrationPage.clickContinue();
		if (registrationPage.getConfirmationMessage().contains("Your Account Has Been Created!")) {
			Assert.assertTrue(false);
			
		} 
	}
}