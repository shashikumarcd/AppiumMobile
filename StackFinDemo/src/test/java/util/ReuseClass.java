package util;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ReuseClass {

	protected WebDriverWait wait;

	public boolean elementPresent1(MobileElement locator, AppiumDriver<MobileElement> driver) throws Exception {

		boolean result = !locator.isDisplayed();		
		System.out.println(result);
		return result;
	}	
	
	public boolean elementPresent(MobileElement locator, AppiumDriver<MobileElement> driver) throws Exception {

		boolean isDisplayed = locator.isDisplayed();		
		
		return isDisplayed;
	}
	public static void assertLinkNotPresent(AppiumDriver<MobileElement> driver, String text) {
		try {
			driver.findElement(By.linkText(text));
			fail("Link with text <" + text + "> is present");
		} catch (NoSuchElementException ex) { 
			/* do nothing, link is not present, assert is passed */ 
		}	
	}



	public boolean verifyElementAbsent(String locator, AppiumDriver<MobileElement> driver) throws Exception {
		try {
			driver.findElement(By.xpath(locator));
			System.out.println("Element Present");
			return false;

		} catch (NoSuchElementException e) {
			System.out.println("Element absent");
			return true;
		}
	}

	public void implicitwait(AppiumDriver<MobileElement> driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void explicitwait(By element,AppiumDriver<MobileElement> driver) {

		wait = new WebDriverWait(driver, 30);  
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));

		wait.until(ExpectedConditions.elementToBeSelected(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}


	public void clickWebelement(MobileElement element,AppiumDriver<MobileElement> driver) {

		try {

			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (ElementNotVisibleException exception) {

			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click(", element);
		}
	}


	public void SendKeys(String value, MobileElement element) {
        try {
            if(element.isDisplayed()) {                
                element.clear();            
                element.sendKeys(value);
            }
            else 
            {
                Assert.fail();
            }            

        } catch (Exception exc) {

            exc.getMessage();
        }
    }


	public void ClickButton(MobileElement element, AppiumDriver<MobileElement> driver) {
        
        wait = new WebDriverWait(driver, 30);  
        wait.until(ExpectedConditions.elementToBeClickable(element));
        if(element.isDisplayed())
        {
            element.click();
        }
        else
        {
            Assert.fail();
        }

    }
}
