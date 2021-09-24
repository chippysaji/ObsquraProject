package com.reobeen.qa.testcase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obsquramainproject.constant.Constant;
import com.reobeen.qa.page.HomePage;
import com.reobeen.qa.utility.ExcelRead;

public class HomeTest extends BaseTest {

  @Test(priority=1)
  public void verifySignIn() throws InterruptedException {
	loginPage.doLogin(Constant.username, Constant.password);
  }
  @Test(priority=2)
  public void verifyPageLogo() {
	String currentlogo =  homePage.logo();
	String expectedlogo = ("Reobeen HHC");
	  SoftAssert sa = new SoftAssert();
		 sa.assertEquals(currentlogo, expectedlogo);
		 sa.assertAll();
  }
 
@Test(priority=3)
public void verifyInfoCheck() {
	homePage.infoCheck();
	String currentweltext =  homePage.welcomeText();
	String expectedweltext = ("Welcome Aju,");
	  SoftAssert sa = new SoftAssert();
		 sa.assertEquals(currentweltext, expectedweltext);
		 sa.assertAll();
	
	
}
 
  @Test(dataProvider = "loginData",priority=4)
  
  public void verifyPosWalkInCustomerDetails(String name,String taxn__o,
		  String opening__bal,String mobile__no) {
	 
	  homePage.posWalkInCustomerDetails( name, taxn__o, opening__bal,mobile__no);
	  boolean searchisDisplayed =	homePage.usernameIsDisplayed();
	  
	  SoftAssert softAssert = new SoftAssert();
	  softAssert.assertTrue(searchisDisplayed);
	  softAssert.assertAll();

  }
 
  @Test( priority=5)
  public void verifySearchBrandAvailability() {
  homePage.searchBrandAvailability();
  boolean productOutOfStockDisplayed = homePage.productOutOfStockIsDisplayed();
  SoftAssert softAssert = new SoftAssert();
	softAssert.assertTrue(productOutOfStockDisplayed);
	softAssert.assertAll();
  }
 
  @Test(priority=6)
  public void verifyDoSignout() {
	homePage.doSignout();
		
	    String actualtitle = driver.getTitle();
        String expectedtitle = "Login - Demo POS"; 
	Assert.assertEquals(actualtitle, expectedtitle);
  }

 
	 
 
  
  @DataProvider
  public Object[][]loginData() throws InvalidFormatException, IOException {
	  
	  Object[][] data=ExcelRead.getDataFromExcel(Constant.walkincustomerdetails, "CustomerDetails");
	  
    return data;   
    } 


}
