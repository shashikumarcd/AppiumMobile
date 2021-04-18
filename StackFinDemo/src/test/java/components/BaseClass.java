package components;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	protected AppiumDriver<MobileElement> driver;

	//OnetimeSetup
	@BeforeTest
	public AppiumDriver<MobileElement> Setup() {

		try {

			//These are the capabilities to launch stackfinance android app	
			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ShashiCD");
			caps.setCapability(MobileCapabilityType.UDID, "64f9d45d7ce5");		
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
			caps.setCapability("appPackage", "co.stackfinance.stackfinanceapp");            
			caps.setCapability("appActivity","co.stackfinance.stackfinanceapp.MainActivity");

			//Disable Keyboard in the device
			caps.setCapability("unicodeKeyboard", true);
			caps.setCapability("resetKeyboard", true);

			URL url = new URL("http:127.0.0.1:4745/wd/hub");		
			driver = new AppiumDriver<MobileElement>(url, caps);

			Thread.sleep(8000);

		}catch(Exception exp) {

			System.out.println("Cause is :"+exp.getCause());
			System.out.println("Message is :"+exp.getMessage());
			exp.printStackTrace();


		}
		return driver;
	}

	//OneTimeTearDown
	@AfterTest
	public void Teardown() {

		this.driver.quit();
	}




}
