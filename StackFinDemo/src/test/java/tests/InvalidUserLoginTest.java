package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import components.BaseClass;
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
