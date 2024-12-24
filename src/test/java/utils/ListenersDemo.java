package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersDemo implements  ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result) {
		 String timestamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm a").format(new Date());
		File screenshot= Keyword.driver.getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "/Sceenshots/" + result.getName()+"_"+timestamp+ ".png";
		
		 try {
			FileUtils.copyFile(screenshot, new File(screenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ITestListener.super.onTestFailure(result);
	}

}
