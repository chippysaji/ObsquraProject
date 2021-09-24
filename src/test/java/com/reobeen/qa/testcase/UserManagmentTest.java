package com.reobeen.qa.testcase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obsquramainproject.constant.Constant;
import com.reobeen.qa.page.UserManagementPage;
import com.reobeen.qa.utility.ExcelRead;





public class UserManagmentTest extends BaseTest {
	 UserManagementPage userManagementPage;
	
	 @Test(priority=1)
	  public void verifyImportCustomerViewDetails() {
		 loginPage.doLogin(Constant.username, Constant.password);
		  userManagementPage = new UserManagementPage(driver);   
		  userManagementPage.importCustomerDetails();
		  String actualtitle = driver.getTitle();
		  System.out.print(actualtitle);
		  String expectedtitle = "Users - Reobeen HHC"; 
		 Assert.assertEquals(actualtitle, expectedtitle);
		  
	  }
  @Test(dataProvider = "newUser",priority=2)
 
  public void verifyNewUserDetails(String Surname , String Firstname,String Lastname,
			String Email,String Username, String Newpassword,String Password,String Percentage) throws InterruptedException  {
	 
	 
	  
	  userManagementPage = new UserManagementPage(driver); 
	 userManagementPage.newUserDetail(Surname, Firstname, Lastname, Email, Username, Newpassword, Password, Percentage);
			String actualtitle = driver.getTitle();
	 String expectedtitle = "Users - Reobeen HHC"; 
		Assert.assertEquals(actualtitle, expectedtitle);
	
  }
  @Test(priority=3)
  public void verifyNewUserEditDetails() {
	  userManagementPage = new UserManagementPage(driver);   
	  userManagementPage.newUserEditDetails();
	  boolean updatedDisplayed =	 userManagementPage.userUpdatedsuccessfullyIsDisplayed();
		 SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(updatedDisplayed);
			softAssert.assertAll();
  }
  
  
  @Test(priority=4)
  public void verifyDeleteUserDetails(){
	  userManagementPage = new UserManagementPage(driver);   
	  userManagementPage.deleteUserDetails();
	  boolean deletedDisplayed =	 userManagementPage.userdeletedsuccessfullyIsDisplayed();
		 SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(deletedDisplayed);
			softAssert.assertAll();
  }
  @Test(priority=5)
  public void verifyEditUserDetails() {
	  userManagementPage.editUserDetails();
	 String actualtitle = driver.getTitle();
	  String expectedtitle = "Roles - Reobeen HHC"; 
	 	Assert.assertEquals(actualtitle, expectedtitle);
  }
  
  
 @Test(dataProvider = "loginDatas",priority=6)
  public void verifySalesCommisionLink(String Sales_prefix , String Sales_firstname, String Sales_lastname, String Sales_email,
			String Sales_contact ,String Sales_address, String Sales_commision) {
	  
	  
	 
	  
	 userManagementPage.salesCommisionlink(Sales_prefix ,  Sales_firstname,  Sales_lastname,  Sales_email,
				 Sales_contact , Sales_address,  Sales_commision);

	boolean commisionDisplayed =	 userManagementPage.commisionAddedsuccessfullyIsDisplayed();
	 SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(commisionDisplayed);
		softAssert.assertAll();
 }
  @DataProvider
  public Object[][]newUser() throws InvalidFormatException, IOException {
	  
	  Object[][] data=ExcelRead.getDataFromExcel(Constant.newuserdetails, "NewUserDetails");
	  
    return data;   
}
  
  @DataProvider
  public Object[][]loginDatas() throws InvalidFormatException, IOException {
	  
	  Object[][] data=ExcelRead.getDataFromExcel(Constant.newsalesdetails, "SalesDetails");
	  
    return data;   
}
 
}
