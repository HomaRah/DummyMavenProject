package com.tutorialsninja.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.util.Assert;
import com.tutorailsninja.qa.testbase.TestBase;

public class SearchTest extends TestBase {

	
	public SearchTest () throws Exception {
		super();
	}
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	
	
	@BeforeMethod
	public void setUp() {
		
		
	}
	 @Test

	    public void tSearchTest() throws Exception{

		 driver =  initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		 driver.findElement(By.linkText("search")).sendKeys.sendKeys(prop.getProperty("sera"));
		 driver.findElement(By.linkText("Login")).click();
		
			

	        HomePage homePage = new HomePage(driver);

	      
	        homePage.enterSearchKeyword("iPhone");

	        homePage.clickSearchButton();

	        Assert.assertTrue(homePage.isSearchResultsPageDisplayed(), "Search failed!");

	    }

	   

	    @AfterTest

	    public void tearDown() {

	       

	        driver.quit();

	    }
		@Override
		public WebDriver initializeBrowserAndOpenApplication(String browserName) {
			// TODO Auto-generated method stub
			return super.initializeBrowserAndOpenApplication(browserName);
		}

	}




