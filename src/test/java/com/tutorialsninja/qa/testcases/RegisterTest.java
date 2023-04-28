package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorailsninja.qa.testbase.TestBase;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends TestBase {

    public RegisterTest() throws Exception {
        super();
    }

    public WebDriver driver;
    public SoftAssert softassert = new SoftAssert();
    public Select select;

    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
        driver.findElement(By.linkText("Register")).click();
    }

    @Test(priority = 1, invocationCount = 10)
    public void enterRegisterAccountByEnteringAllValidFields() {
        driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("Firstname"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("Lastname"));
        String email = Utilities.generateNameforEmailWithTimeStamp() + "@example.com";
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("Telephone"));
        driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("Password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataprop.getProperty("Passwordconfirm"));
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        String actualAvailableMessage = driver.findElement(By.id("content p:nth-of-type(1)")).getText();
        String expectedAvailableMessage = dataprop.getProperty("actualAvailableMessage");
        softassert.assertTrue(actualAvailableMessage.contains(expectedAvailableMessage));
        WebElement proofofAccountCreation = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        if(proofofAccountCreation.isDisplayed()) {
            driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
        }
    }

    @Test(priority = 2)
    public void enterRegisterAccountBySkippingAllValidFields() {
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.cssSelector("btn.btn-primary")).click();
        WebElement errorAlert = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible"));
        String actualErrorMessage = errorAlert.getText();
        String expectedErrorMessage = "Warning: You must agree to the Privacy Policy!";
        softassert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}