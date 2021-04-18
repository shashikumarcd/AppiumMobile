package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import components.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.MyProfilePage;

public class PersonalInformationTest extends BaseClass{

	
	@Test(priority=1)	
	public void PersonalInfo() {
		
		try {
			
			HomePage homePage = new HomePage(driver);
			homePage.PerformSkip();		
			
			LoginPage loginPage = new LoginPage(driver);		
			loginPage.ValidLogin();	
			
			MyProfilePage myprofile = new MyProfilePage(driver);
			myprofile.goToPersonalInformation();
			
			
			
		} catch (Exception e) {			
			e.printStackTrace();
		}	
	}

}
