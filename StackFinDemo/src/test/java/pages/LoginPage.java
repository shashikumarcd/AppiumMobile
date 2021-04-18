package pages;
import components.ReadWriteExcel;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import util.ReuseClass;

public class LoginPage extends BasePage{

	@AndroidFindBy(accessibility ="Create an Account")
	private MobileElement createAnAccountButton;

	@AndroidFindBy(accessibility ="Login")
	private MobileElement loginButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Email Address\")")
	private MobileElement emailAddressTxt;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Password\")")
	private MobileElement password;

	@AndroidFindBy(accessibility ="Proceed")
	private MobileElement proceedButton;

	@AndroidFindBy(className="android.widget.EditText")
	private AndroidElement enterPin;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Forgot your PIN?\")")
	private MobileElement forgotYourPinButton;	

	@AndroidFindBy(xpath="//*[contains(@text,'Sign out')]")
	private AndroidElement signOutButton;	

	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	private MobileElement permissionAllowButton;

	@AndroidFindBy(xpath ="//android.view.View[@content-desc=\"Should be at least 8 characters long, must include an upper-case letter, one digit & one of these @$!%*?&#\"]")
	private MobileElement pwdErrorMessage;

	@AndroidFindBy(accessibility ="Check your email address")
	private MobileElement checkMailErrorMessage;

	@AndroidFindBy(xpath ="//android.view.View[@content-desc=\"Profile Shashi Kumar CD shashikumar.cd@gmail.com +91 9742651135\"]")
	private MobileElement myProfile;
	
	@AndroidFindBy(accessibility ="Personal Information")
	private MobileElement personalInformation;

	String[] userDetails;
	ReadWriteExcel readWriteExcel;
	ReuseClass reuseClass = new ReuseClass();
	
	public LoginPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	//Valid user login 
	public MyProfilePage ValidLogin() {
		try {

			readWriteExcel = new ReadWriteExcel();			
			userDetails = readWriteExcel.ReadUserDetails(1);
			
			if(loginButton.isDisplayed()) {
				reuseClass.implicitwait(driver); loginButton.click();
			}

			reuseClass.implicitwait(driver);
			emailAddressTxt.clear();
			emailAddressTxt.sendKeys(userDetails[0]);			

			reuseClass.implicitwait(driver);
			password.clear();
			password.sendKeys(userDetails[1]);

			reuseClass.implicitwait(driver);
			proceedButton.click();

			reuseClass.implicitwait(driver);
			enterPin.clear();
			enterPin.sendKeys(userDetails[2]);

			reuseClass.implicitwait(driver);
			permissionAllowButton.click();

			reuseClass.implicitwait(driver);			

			//To Perform TouchAction using x and y coordinates, 
			//Go to Android Device > Settings > Developer options > Enable 'Pointer location'
			TouchAction touchAction = new TouchAction(driver);			
			touchAction.press(PointOption.point(360, 150)).release().perform();

			reuseClass.implicitwait(driver);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MyProfilePage myProfile = new MyProfilePage(driver);
		return myProfile;
	}

	//Invalid user login 
	public LoginPage InValidLogin(){

		try {

			reuseClass.implicitwait(driver);
			loginButton.click();

			reuseClass.implicitwait(driver);
			emailAddressTxt.sendKeys("shashikumar");

			reuseClass.implicitwait(driver);
			password.sendKeys("password");

			reuseClass.implicitwait(driver);
			proceedButton.click();

			reuseClass.implicitwait(driver);

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		  LoginPage loginPage = new LoginPage(driver); 
		  return loginPage;
	}

	
	//These are all getters to have access outside the class
	public String getSignoutText() {
		return signOutButton.getText();
	}
	public String getPwdErrorMessage() {
		return pwdErrorMessage.getText();
	}	
	public boolean getCheckYourMailErrorMessage() {
		return checkMailErrorMessage.isDisplayed();
	}
	public boolean proceedButtonPresent() {
		return proceedButton.isDisplayed();
	}
	public boolean myProfilePresent() {
		return myProfile.isDisplayed();
	}
	public boolean isDisplayed() {
		return loginButton.isDisplayed();
	}
	
	public boolean personalInformationPresent() {
		return personalInformation.isDisplayed();
	}
	

}
