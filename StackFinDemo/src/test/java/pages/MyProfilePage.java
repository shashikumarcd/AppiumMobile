package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.ReuseClass;


public class MyProfilePage extends BasePage{

	@AndroidFindBy(accessibility ="Login")
	private MobileElement loginButton;

	@AndroidFindBy(accessibility ="Personal Information")
	private MobileElement personalInformation;

	@AndroidFindBy(accessibility ="Invite Friends")
	private MobileElement inviteFrnds;

	@AndroidFindBy(accessibility ="Security Settings")
	private MobileElement securitySettings;

	@AndroidFindBy(accessibility ="Share Invite")
	private MobileElement shareInviteButton;

	@AndroidFindBy(xpath ="//*[text()=\"shashikumar.cd@gmail.com, Email\"]")
	private MobileElement getEmail;

	@AndroidFindBy(xpath ="//*[@id=\"android:id/content\"]/android.widget.FrameLayout[3]/android.view.View[6]/android.view.View")
	private MobileElement getEmail2;	

	@AndroidFindBy(accessibility ="Log out")
	private MobileElement logOutButton;

	@AndroidFindBy(accessibility ="Yes")
	private MobileElement logOutconfirm;

	ReuseClass reuseClass = new ReuseClass();
	
	public MyProfilePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}


	public void goToPersonalInformation() {

		try {

			personalInformation.click();
			reuseClass.implicitwait(driver);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void goToInviteFrnds() {

		try {

			inviteFrnds.click();
			reuseClass.implicitwait(driver);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void goToSecuritySettings() {

		try {

			securitySettings.click();
			reuseClass.implicitwait(driver);


		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public LoginPage Logout() {

		try {			
			  String command = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().description(\"Log out\"));";
			  MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(command));
			  
			  //Can be clicked on element button or click on signout using other page locator
			  //element.click();		 

			logOutButton.click();
			reuseClass.implicitwait(driver);
			
			logOutconfirm.click();
			reuseClass.implicitwait(driver);				
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}

	//These are all getters to have access outside the class
	public boolean shareInvitePresent() {
		return shareInviteButton.isDisplayed();
	}

	public boolean personalInformationPresent() {
		return personalInformation.isDisplayed();
	}

}
