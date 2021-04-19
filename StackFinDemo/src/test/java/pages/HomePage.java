package pages;

import java.io.File;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.imagecomparison.FeatureDetector;
import io.appium.java_client.imagecomparison.FeaturesMatchingOptions;
import io.appium.java_client.imagecomparison.FeaturesMatchingResult;
import io.appium.java_client.imagecomparison.MatchingFunction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.ReuseClass;
import util.TakeScreenShotForYou;

public class HomePage extends BasePage {


	ReuseClass reuseClass;

	@AndroidFindBy(accessibility ="Skip")
	private MobileElement skipButton;

	@AndroidFindBy(className="android.widget.ImageView")
	private MobileElement imageContent;
	
	@AndroidFindBy(id="android:id/content")
	private MobileElement imageContent1;
	

	@AndroidFindBy(accessibility ="Login")
	private MobileElement loginButton;

	public HomePage(AppiumDriver<MobileElement> driver) {		
		super(driver);
	}


	public LoginPage PerformSkip() {

		try {	
			reuseClass = new ReuseClass();
			if(reuseClass.elementPresent(imageContent, driver)) {
				
				//TakeScreenshot
				//TakeScreenShotForYou.takeScreenshot(driver);
				
				//improve Assert for Comparing image by taking screenshot with current image
				byte[] screenShot= Base64.encodeBase64(driver.getScreenshotAs(OutputType.BYTES));
				String fullpath = new File("src/test/resources/ScreenShots/homePage.jpg").getAbsolutePath();
						
				FeaturesMatchingResult result = driver
				        .matchImagesFeatures(screenShot, fullpath.getBytes(), new FeaturesMatchingOptions()
				                .withDetectorName(FeatureDetector.ORB)
				                .withGoodMatchesFactor(40)
				                .withMatchFunc(MatchingFunction.BRUTE_FORCE_HAMMING)
				                .withEnabledVisualization());
				Assert.assertEquals(result.getVisualization().length, result.getVisualization().length>0);
				Assert.assertEquals(result.getCount(), result.getCount()>0);
				Assert.assertEquals(result.getTotalCount(), result.getTotalCount()>0);
				Assert.assertFalse(result.getPoints1().isEmpty());
				Assert.assertNotNull(result.getRect1());
				Assert.assertFalse(result.getPoints2().isEmpty());
				Assert.assertNotNull(result.getRect2());
				
				LoginPage loginPage = new LoginPage(driver);			
				loginPage.InValidLogin();	
				
				
				
				reuseClass.implicitwait(driver);
				skipButton.click();		

				reuseClass.implicitwait(driver);

			}
			else
			{

			}		
		}catch (Exception e) {

			e.printStackTrace();
		}		
		LoginPage loginPage = new LoginPage(driver); 
		return loginPage;		 
	}


	public boolean isDisplayed() {
		return skipButton.isDisplayed();
	}

}
