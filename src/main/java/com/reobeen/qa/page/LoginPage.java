package com.reobeen.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reobeen.qa.utility.ElementUtil;

public class LoginPage {
	
	ElementUtil eleutil ;
		WebDriver driver;
		 @FindBy(id="username")
		WebElement user;
		
		@FindBy(name = "password")
		WebElement password;
		
		@FindBy(xpath = "//button[@type='submit']")
		WebElement submitbutton;
		
		@FindBy(xpath ="//button[@data-role='end']")
		WebElement end;
		
		
//Initializing the page object
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		eleutil = new ElementUtil (driver);
			}

	public boolean usernameIsDisplayed()  {
		
		return eleutil.isDisplayed(user);
		}
		    
	public boolean passwordIsDisplayed() {
		return eleutil.isDisplayed(password);
	}
	
	public void doLogin(String uname , String pass) {

		
		eleutil.doSendkey(user, uname);
		eleutil.doSendkey(password, pass);
		eleutil.doClick(submitbutton);
		eleutil.doClick(end);
	}
	
	

}
