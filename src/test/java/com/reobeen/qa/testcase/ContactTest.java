package com.reobeen.qa.testcase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obsquramainproject.constant.Constant;
import com.reobeen.qa.page.ContactPage;
import com.reobeen.qa.utility.ExcelRead;



public class ContactTest extends BaseTest {
  @Test(groups= {"SanityTest"},priority=1)
  public void verifyContactDetails() throws InterruptedException {
	  loginPage.doLogin(Constant.username, Constant.password);
	 
	contactPage.copyContactDetails();  
	  boolean copyContactDisplayed = contactPage.copyContactDetailsIsDisplayed();
	  SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(copyContactDisplayed );
		softAssert.assertAll();
  }
  @Test(priority=2)
  
  public void verifyUploadContact() throws InterruptedException {
          contactPage.uploadContact();
          boolean mesgDisplayed = contactPage.mismatchMessageIsDisplayed();
    	  SoftAssert softAssert = new SoftAssert();
    		softAssert.assertTrue(mesgDisplayed );
    		softAssert.assertAll();
  }
  
  
  @Test(dataProvider ="editDetails",priority=3)
  public void verifyEditCustomerDetails(String Edit_name) {
	
	contactPage.editCustomerDetails(Edit_name);
	boolean contactUpdateDisplayed = contactPage.contactUpdateIsDisplayed();
	  SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(contactUpdateDisplayed);
		softAssert.assertAll();
	
  }

  @Test(priority=4)
  public void verifyDeleteCustomerDetails() {
	  
	 contactPage.deleteCustomerDetails();
		String actualtitle = driver.getTitle();
		 String expectedtitle = "Customers - Reobeen HHC"; 
			Assert.assertEquals(actualtitle, expectedtitle);
  }
  @Test(priority=5)
  public void verifyViewContactDetails() {
	  contactPage.viewContactDetails();
	  String actualtitle = driver.getTitle();
		 String expectedtitle = "Customers - Reobeen HHC"; 
			Assert.assertEquals(actualtitle, expectedtitle);
	  
  }
 @Test(dataProvider = "customerDetails",priority=6)
  public void verifyCustomerDetails(String Nam,String Mobileno) {
	 
	 contactPage.addCustomerDetails(Nam,Mobileno);
	boolean contactAddedDisplayed = contactPage.contactAddedMesgIsDisplayed();
	  SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(contactAddedDisplayed);
		softAssert.assertAll();
  }

 
 
 @DataProvider
 public Object[][]editDetails() throws InvalidFormatException, IOException {
	  
	  Object[][] data=ExcelRead.getDataFromExcel(Constant.customereditdetails, "editedDetails");
	  
   return data;    
 }
 @DataProvider
 public Object[][]customerDetails() throws InvalidFormatException, IOException {
	  
	  Object[][] data=ExcelRead.getDataFromExcel(Constant.customerdetails, "customers");
	  
   return data;    
 }
 
}

