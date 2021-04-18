package tests;

import components.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.MyProfilePage;

public class SecuritySettingsTest extends BaseClass{

	public void SecuritySett() {

		try {

			HomePage homePage = new HomePage(driver);
			homePage.PerformSkip();		

			LoginPage loginPage = new LoginPage(driver);		
			loginPage.ValidLogin();	

			MyProfilePage myprofile = new MyProfilePage(driver);
			myprofile.goToSecuritySettings();



		} catch (Exception e) {			
			e.printStackTrace();
		}	
	}

}
