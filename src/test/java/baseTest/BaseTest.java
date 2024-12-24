package baseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import properties_file.Read_prop;
import utils.Keyword;

public class BaseTest {
	

	@BeforeMethod
	public void setUpTest() {
		Keyword.openBrowser(Read_prop.GetBrowserName());
		Keyword.launchUrl(Read_prop.GetUrl());
		Keyword.driver.manage().window().maximize();
	
	}
	
	@AfterMethod
	public void closeWindows() {
		Keyword.driver.quit();

	}
	
	

}
