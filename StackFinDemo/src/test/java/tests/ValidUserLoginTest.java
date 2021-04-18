package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import components.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.MyProfilePage;

public class ValidUserLoginTest extends BaseClass {

	@Test(priority=1)
	public void ValidUserLogin() {

		try {

			HomePage homePage = new HomePage(driver);			
			homePage.PerformSkip();	

			LoginPage loginPage = new LoginPage(driver);			
			loginPage.ValidLogin();	

			AssertJUnit.assertTrue(loginPage.personalInformationPresent());

		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}

	@Test(priority=2)
	public void Logout() {
		try {

			MyProfilePage myProfilePage = new MyProfilePage(driver);			
			myProfilePage.Logout();

			LoginPage loginPage = new LoginPage(driver);			
			AssertJUnit.assertTrue(loginPage.proceedButtonPresent());

		} catch (Exception e) {

			e.printStackTrace();
		}
	}	

}
