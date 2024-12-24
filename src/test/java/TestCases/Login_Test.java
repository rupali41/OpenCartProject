package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import baseTest.Data_ProviderClass;
import page_object.HomePage;
import page_object.LoginPage;

public class Login_Test  {
	@Test(dataProvider = "login_Data", dataProviderClass = Data_ProviderClass.class)
	public void Login_Opencart(String email,String Password) {
		HomePage hp = new HomePage();
		hp.clickMyAccount();
		hp.clickOnLogin();
		LoginPage  lg = new LoginPage ();
		
		lg.EnterUserName(email);
		lg.EnterPassword(Password);
		lg.ClickLogin();
		lg.getConfirm_Login();
		String loginMessage = lg.getConfirm_Login();

	    Assert.assertTrue(loginMessage.equals("Login successful"));
		    
		  
		   
	}

}
