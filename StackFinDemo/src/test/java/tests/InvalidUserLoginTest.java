package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;

import components.BaseClass;
import io.appium.java_client.imagecomparison.FeatureDetector;
import io.appium.java_client.imagecomparison.FeaturesMatchingOptions;
import io.appium.java_client.imagecomparison.FeaturesMatchingResult;
import io.appium.java_client.imagecomparison.MatchingFunction;
import pages.LoginPage;
import pages.HomePage;

public class InvalidUserLoginTest extends BaseClass{
		
	@Test
	public void InvalidUserLogin() {
		try {
			
			HomePage homePage = new HomePage(driver);
			homePage.PerformSkip();			
			
			LoginPage loginPage = new LoginPage(driver);			
			loginPage.InValidLogin();	
			
			//Assert
			AssertJUnit.assertTrue(loginPage.proceedButtonPresent());
			
			//these 2 assert to check mail and password error message
			//Assert.assertTrue(loginPage.getCheckYourMailErrorMessage());			
			//Assert.assertEquals("Should be at least 8 characters long, must include an upper-case letter, one digit & one of these @$!%*?&#", loginPage.getPwdErrorMessage());
		
		} catch (Exception e) {			
			e.printStackTrace();
		}		 
	}	
}
