package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import components.BaseClass;
import io.appium.java_client.imagecomparison.FeatureDetector;
import io.appium.java_client.imagecomparison.FeaturesMatchingOptions;
import io.appium.java_client.imagecomparison.FeaturesMatchingResult;
import io.appium.java_client.imagecomparison.MatchingFunction;
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
