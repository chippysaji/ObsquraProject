package com.reobeen.qa.testcase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obsquramainproject.constant.Constant;
import com.reobeen.qa.page.PurchasePage;
import com.reobeen.qa.utility.ExcelRead;

public class PurchaseTest extends BaseTest {
	@Test
	public void verifyImportToCsv() {
	loginPage.doLogin(Constant.username, Constant.password);

		  PurchasePage purchasePage = new PurchasePage(driver); 
			  purchasePage.importToCsv();
			  boolean csvDisplayed = purchasePage.csvIsDisplayed();
			  SoftAssert softAssert = new SoftAssert();
				softAssert.assertTrue(csvDisplayed);
				softAssert.assertAll();
	}
	@Test(priority=2)
	public void verifyImportToExcel() {
		

		  PurchasePage purchasePage = new PurchasePage(driver); 
			  purchasePage.importToExcel();
			  boolean excelDisplayed = purchasePage.excelIsDisplayed();
			  SoftAssert softAssert = new SoftAssert();
				softAssert.assertTrue(excelDisplayed);
				softAssert.assertAll();
	}
	
	@Test(priority=3)
	public void verifyImportToPdf() {
		

		
		
		
		  PurchasePage purchasePage = new PurchasePage(driver); 
			  purchasePage.importToPdf();
			  boolean pdfDisplayed = purchasePage.pdfIsDisplayed();
			  SoftAssert softAssert = new SoftAssert();
				softAssert.assertTrue(pdfDisplayed);
				softAssert.assertAll();
	}
	@Test(dataProvider ="addPurchase",priority=4)
  
  public void verifyAddNewPurchase(String nam_, String alertquantity_, 
			String exc_tax_, String inc_tax_) {
	  
	  PurchasePage purchasePage = new PurchasePage(driver); 
		  purchasePage.addNewPurchase( nam_,  alertquantity_, exc_tax_, inc_tax_);
		  boolean unitaddedDisplay = purchasePage.unitAddedMesgIsDisplayed();
		  SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(unitaddedDisplay);
			softAssert.assertAll();
	  }
  
  @DataProvider
  public Object[][]addPurchase() throws InvalidFormatException, IOException {
	  
	  Object[][] data=ExcelRead.getDataFromExcel(Constant.addnewpurchase, "NewPurchase");
	  
    return data;  
  }

  }

