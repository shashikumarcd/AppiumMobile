package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TakeScreenShotForYou {

	
	public static void takeScreenshot(AppiumDriver<MobileElement> driver) {		
		try {
			File screenShot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot,new File("src/test/resources/ScreenShots/homePage.jpg"));
		} catch (IOException e) {			
			e.printStackTrace();
			e.getMessage();			
		}
	}
}
