package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPages {
	
    public WebDriver driver;
    @FindBy(className = "signin")
    private WebElement signinLink;

    @FindBy(linkText = "Create Account")
    private WebElement createAccountLink;

    public LandingPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSignInLink() {
        signinLink.click();
    }

    public void clickOnCreateAccountLink() {
        createAccountLink.click();
    }
}

	
	
	


