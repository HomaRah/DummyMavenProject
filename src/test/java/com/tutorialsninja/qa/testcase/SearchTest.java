package com.tutorialsninja.qa.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorailsninja.qa.testbase.TestBase;
import com.tutorialsninja.qa.pages.LandingPage;

public class SearchTest extends TestBase {

    public SearchTest() throws Exception {
        super();
    }

    public WebDriver driver;
    public SoftAssert softassert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
    }

    @Test
    public void searchTest() throws Exception {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnSignInLink();
        landingPage.enterSearchKeyword("iPhone");
        landingPage.clickSearchButton();
        softassert.assertTrue(landingPage.isSearchResultsPageDisplayed(), "Search failed!");
        softassert.assertAll();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Override
    public WebDriver initializeBrowserAndOpenApplication(String browserName) {
        return super.initializeBrowserAndOpenApplication(browserName);
    }

}


