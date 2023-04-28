package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorailsninja.qa.testbase.TestBase;

public class RegisterTest extends TestBase {

	
	public RegisterTest() throws Exception {
		super();
	}


	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	public Select select;
	
	@BeforeMethod
	public void setUp() {
		driver =initializeBrowserAndOpenApplication (prop.getProperty("browserName"));
		driver.findElement(By.linkText("Register")).click();
		
}
    @Test (priority = 1, invocationCount = 10)
	public void enterAllValidFields() {
                               																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				
    	
    	WebDriver driver = new ChromeDriver();

        driver.manage().deleteAllCookies();

        driver.manage().window().maximize();

        driver.get("http://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[@class = 'caret']/preceding-sibling::span[1]")).click();

        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.xpath("//input[@id = 'input-firstname']")).sendKeys(dataprop.getProperty("Firstname"));

        driver.findElement(By.xpath("//input[@id = 'input-lastname']")).sendKeys(dataprop.getProperty("Lastname"));

        driver.findElement(By.xpath("//input[@id = 'input-email']")).sendKeys(dataprop.getProperty("E-mail"));

        driver.findElement(By.xpath("//input[@id = 'input-telephone']")).sendKeys(dataprop.getProperty("Telephone"));

        driver.findElement(By.xpath("//input[@id = 'input-password']")).sendKeys(dataprop.getProperty("Password"));

        driver.findElement(By.xpath("//input[@id = 'input-confirm']")).sendKeys(dataprop.getProperty("Passwordconfirm"));
        
        driver.findElement(By.xpath("//input[@name = 'agree']")).click();
        
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        String actualAvailableMessage = driver.findElement(By.id("a.btn.btn-primary")).getText();
        String expectedAvailableMessage = dataprop.getProperty("actualAvailableMessage");
        softassert.assertTrue(actualAvailableMessage.contains(expectedAvailableMessage));
        

        WebElement proofofAccountCreation = driver.findElement(By.xpath("//h1[contains(text(),Your Account Has Been Created!')]"));

        if(proofofAccountCreation.isDisplayed()) {

          driver.findElement(By.cssSelector("a.btn.btn-primary")).click();

}
    	driver.findElement(By.name("agree")).click();

    	driver.findElement(By.cssSelector("btn btn-primary")).click();
                    
	}




	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}