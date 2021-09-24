package com.reobeen.qa.testcase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obsquramainproject.constant.Constant;
import com.reobeen.qa.page.LoginPage;
import com.reobeen.qa.utility.ExcelRead;



public class LoginTest extends BaseTest {
	
	

	
  @Test(dataProvider = "loginData",groups= {"SanityTest"},priority=2)
  public void verifyLogin(String Username,String Password)  throws InterruptedException {
	  
	 loginPage.doLogin(Username , Password);
	String actualtitle = driver.getTitle();
 String expectedtitle = "Home - Reobeen HHC"; 
	Assert.assertEquals(actualtitle, expectedtitle);
	 
	 }
  @Test(priority=1)
	public void verifyFieldDisplay() throws InterruptedException {
	boolean usernameDisplayed =	loginPage.usernameIsDisplayed();
	boolean passwordDisplayed = loginPage.passwordIsDisplayed();
	SoftAssert softAssert = new SoftAssert();
	softAssert.assertTrue(usernameDisplayed);
	softAssert.assertTrue(passwordDisplayed);
	softAssert.assertAll();
  
  }
 
   @DataProvider
  public Object[][]loginData() throws InvalidFormatException, IOException {
	  
	  Object[][] data=ExcelRead.getDataFromExcel(Constant.logindetails, "LoginDetails");
	  
    return data;   

}
}


