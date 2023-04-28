package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorailsninja.qa.testbase.TestBase;
import com.tutorials.qa.testData.SupplyTestDataFromDataProviderAndExcel;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends TestBase {
	public LoginTest() throws Exception {
		super();
	}
	
	public static WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
	 driver =  initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
	 
	 driver.findElement(By.linkText("My Account")).click();
	 driver.findElement(By.linkText("Login")).click();
	
	}

	@Test(priority =1, dataProvider = "TutorialsninjaDataProviderSupply", dataProviderClass = SupplyTestDataFromDataProviderAndExcel.class)
	public void verifyTutorialsninjaLoinWithValidUsernameAndValidPassword(String username, String passwrod) throws Exception {
		
			driver.findElement(By.id("input-email")).sendKeys(username);
	        driver.findElement(By.id("input-password")).sendKeys(passwrod);
	        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	        driver.findElement(By.linkText("Logout")).click();
	        softassert.assertTrue(driver.findElement(By.cssSelector("a.btn.btn-primary")).isDisplayed());
	        softassert.assertAll();
	           
	}
	
	@Test(priority =2)
	public void verifyTutorialsninjaLoinWithInValidUsernameAndInValidPassword() throws Exception {
	
			driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
	        driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
	        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	        driver.findElement(By.linkText("Logout")).click();
	         
	        String actualWarningMessage = driver.findElement(By.className("div.alert alert-danger alert-dismissible")).getText();
	        String expectedWaringMessage = dataprop.getProperty("tempIssueWarningMessage");
	        softassert.assertTrue(actualWarningMessage.contains(expectedWaringMessage), "Waring Message is not correct");
	        softassert.assertAll();
	   	        
}
	@Test(priority =3)
	public void verifyTutorialsninjaLoinWithValidUsernameAndInValidPassword() throws Exception {
	
			driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
			driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
	        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	        driver.findElement(By.linkText("Logout")).click();
	      
	        String actualWarningMessage = driver.findElement(By.className("div.alert alert-danger alert-dismissible")).getText();
	        String expectedWaringMessage = dataprop.getProperty("wrongCrentialsMessage");
	        softassert.assertTrue(actualWarningMessage.contains(expectedWaringMessage), "Waring Message is not correct");
	        softassert.assertAll();
	         	        
}
	@Test(priority =4)
	public void verifyTutorialsninjaLoinWithEmtysernameAndValidPassword() throws Exception {
	
	        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
	        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	        driver.findElement(By.linkText("Logout")).click();
	        Alert alert = driver.switchTo().alert();
	        String actualAlertText = alert.getText();
	        String expectedAlertText = dataprop.getProperty("alertUsername");
	        
	       softassert.assertEquals(actualAlertText, expectedAlertText);
	       if(actualAlertText.equals(actualAlertText)) {
	    	   alert.accept();
	       }else {
	    	   alert.dismiss();
	       }
}	

	@Test(priority =5)
	public void verifyTutorialsninjaLoinWithCorrectUsernameAndEmptyPassword() throws Exception {
		
			driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
	        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	        driver.findElement(By.linkText("Logout")).click();
	        
	        Alert alert = driver.switchTo().alert();
	        String actualAlertText = alert.getText();
	        String expectedAlertText = dataprop.getProperty("alertPassword");
	        
	       softassert.assertEquals(actualAlertText, expectedAlertText);
	       if(actualAlertText.equals(actualAlertText)) {
	    	   alert.accept();
	       }else {
	    	   alert.dismiss();
	       }
	    softassert.assertAll();
	}
	@Test(priority =6)
	public void verifyTutorialsninjaLoinWithEmptyUsernameAndEmptyPassword() throws Exception {
		
	        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	        driver.findElement(By.linkText("Logout")).click();
	       
	        Alert alert = driver.switchTo().alert();
	        String actualAlertText = alert.getText();
	        String expectedAlertText = dataprop.getProperty("alertUsername");
	        
	       softassert.assertEquals(actualAlertText, expectedAlertText);
	       if(actualAlertText.equals(actualAlertText)) {
	    	   alert.accept();
	       }else {
	    	   alert.dismiss();
	       }
}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
	
	
	
	