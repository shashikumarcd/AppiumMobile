package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.ReuseClass;

public class HomePage extends BasePage {


	ReuseClass reuseClass;

	@AndroidFindBy(accessibility ="Skip")
	private MobileElement skipButton;

	@AndroidFindBy(className="android.widget.ImageView")
	private MobileElement imageContent;       

	@AndroidFindBy(accessibility ="Login")
	private MobileElement loginButton;

	public HomePage(AppiumDriver<MobileElement> driver) {		
		super(driver);
	}


	public LoginPage PerformSkip() {

		try {	
			reuseClass = new ReuseClass();
			if(reuseClass.elementPresent(imageContent, driver)) {

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
