package tests;

import org.testng.Assert;

import components.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.MyProfilePage;

public class InviteFrndsTest extends BaseClass{


	public void inviteFrnds() {

		try {

			HomePage homePage = new HomePage(driver);
			homePage.PerformSkip();		

			LoginPage loginPage = new LoginPage(driver);		
			loginPage.ValidLogin();	

			MyProfilePage myprofile = new MyProfilePage(driver);
			myprofile.goToInviteFrnds();
			
			Assert.assertTrue(myprofile.shareInvitePresent());

		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	
	
}
