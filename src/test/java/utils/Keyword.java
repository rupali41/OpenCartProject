package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Keyword {
	public static  RemoteWebDriver driver= null;
	 static JavascriptExecutor js = (JavascriptExecutor)  Keyword.driver;
	
	public static void openBrowser(String Brouser) {
		if(Brouser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(Brouser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(Brouser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			System.out.println("Enter valid brouser");
		}

	}
	public static void launchUrl(String url) {
		driver.get(url);

	}
	
	public static void sendText(WebElement element,String Text) {
		element.sendKeys(Text);
	}
	
	public static void clickOn(WebElement element) {
		element.click();
	}
	
	public static String  getTextFrom(WebElement element) {
		return element.getText();

	}
	
	public static void clickUsingJavaScript(WebElement element) {
		js.executeScript("arguments[0].click();", element);


	}

}
