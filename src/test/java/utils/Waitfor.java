package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Waitfor {
	static WebDriverWait wait = null;
	static {
		wait = new WebDriverWait(Keyword.driver, Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(200));
		wait.ignoring(NoSuchElementException.class);

	}

	public static void visiblityOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void elementToBeClicable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForStaleness(WebElement element) {
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	

}
