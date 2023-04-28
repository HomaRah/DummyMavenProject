package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	
	    public WebDriver driver;
	    
	    @FindBy(id= "input-emailn")
	    private WebElement usernameTextBox;


	    public LoginPage1(WebDriver driver2) {
			
		}

		public void LoginPages(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void enterUername1(String username) {
	      usernameTextBox.sendKeys();
	    }

			
		}


