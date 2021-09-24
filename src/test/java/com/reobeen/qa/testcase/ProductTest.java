package com.reobeen.qa.testcase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obsquramainproject.constant.Constant;
import com.reobeen.qa.page.ProductPage;
import com.reobeen.qa.utility.ExcelRead;

public class ProductTest extends BaseTest {
  @Test(priority=1)
  public void verifyProductListDetails() {
	  loginPage.doLogin(Constant.username, Constant.password);
	 ProductPage productPage = new ProductPage(driver);
	 productPage.productListDetails();
	
	 boolean productDisplayed =	productPage.productLisIsDisplayed();
	 SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(productDisplayed);
		softAssert.assertAll();
  }
  
  
  @Test(dataProvider ="addProduct",priority=2)
  public void addNewProduct(String Product_Nam,String QuanNo,String Exc_Tax,String Inc_Tax) {
	  ProductPage productPage = new ProductPage(driver);
	  productPage.addNewProduct(Product_Nam,QuanNo, Exc_Tax,Inc_Tax);
	  boolean mesgDisplay = productPage.addNewProductMesgIsDisplayed();
	  SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(mesgDisplay);
		softAssert.assertAll();
  }
  
  
  @Test(dataProvider ="updateProduct",priority=3)
  public void verifyEditProductDetails(String QuantityNo) {
	  ProductPage productPage = new ProductPage(driver);
	  productPage.editProductDetails(QuantityNo);
	  boolean updatedMesgDisplay = productPage.productUpdatedMesgIsDisplayed();
	  SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(updatedMesgDisplay);
		softAssert.assertAll();
  }
  @Test(priority=4)
  public void verifyImportToCsv() {
	  ProductPage productPage = new ProductPage(driver);
	  productPage.importToCsv();
	  boolean printDisplay = productPage.csvIsDisplayed();
	  SoftAssert softAssert = new SoftAssert();
	  softAssert.assertTrue(printDisplay);
	  softAssert.assertAll();
	}
  
  @Test(priority=5)
  public void VerifyImportToExcel() {
	  ProductPage productPage = new ProductPage(driver);
	  productPage.importToExcel();
	  boolean printDisplay = productPage.excelIsDisplayed();
	  SoftAssert softAssert = new SoftAssert();
	  softAssert.assertTrue(printDisplay);
	  softAssert.assertAll();
	  
  }
 

  @Test(priority=6)
public void verifyImportToPdf() {
	  ProductPage productPage = new ProductPage(driver);
	  productPage.importToPdf();
	  boolean printDisplay = productPage.pdfIsDisplayed();
	  SoftAssert softAssert = new SoftAssert();
	  softAssert.assertTrue(printDisplay);
	  softAssert.assertAll();
	  
	  
  }
  @Test(priority=7)
  public void verifyVisibilityOfColoumn() {
	  ProductPage productPage = new ProductPage(driver);
	  productPage.visibilityOfColoumn();
	  boolean sellingPriceDisplay = productPage.sellingpriceIsDisplayed();
	  SoftAssert softAssert = new SoftAssert();
	  softAssert.assertTrue(sellingPriceDisplay);
	  softAssert.assertAll();
  }
  @Test(priority=8)
  public void verifyUnitLink() {
	  ProductPage productPage = new ProductPage(driver);
	  productPage.unitLink();
	  boolean mesgDisplayed = productPage.mesgIsDisplayed();
	  SoftAssert softAssert = new SoftAssert();
	  softAssert.assertTrue(mesgDisplayed);
	  softAssert.assertAll();
  }
  @Test(priority=9)
  public void verifyUnitEditDetails() {
	  ProductPage productPage = new ProductPage(driver);
	  productPage.unitEditDetails();
	  boolean updatedMesgDisplay = productPage.unitUpdatedMesgIsDisplayed();
	  SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(updatedMesgDisplay);
		softAssert.assertAll();
	  
  }
  
  @DataProvider
  public Object[][]addProduct() throws InvalidFormatException, IOException {
	  
	  Object[][] data=ExcelRead.getDataFromExcel(Constant.productpagedetails, "products");
	  
    return data;  
  }
  
  @DataProvider
  public Object[][]updateProduct() throws InvalidFormatException, IOException {
	  
	  Object[][] data=ExcelRead.getDataFromExcel(Constant.quantitydetails, "Quantity");
	  
    return data;  
  }
}
