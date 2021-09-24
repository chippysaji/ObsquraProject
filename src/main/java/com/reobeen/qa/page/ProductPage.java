package com.reobeen.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reobeen.qa.utility.ElementUtil;
import com.reobeen.qa.utility.WaitUtil;

public class ProductPage {
	ElementUtil eleutil ;
	WebDriver driver;
	WaitUtil waitutil;
	
	@FindBy(id="tour_step5_menu")
	WebElement productlink;
	
	@FindBy(xpath="//li[@id='tour_step5']//ul//a[1]")
	WebElement listproduct;
	
	@FindBy(xpath="//table[@id='product_table']//tbody//tr[1]//td[1]")
	WebElement checkbox;
	
	@FindBy(id="deactivate-selected")
	WebElement deactivatebutton;
	
	@FindBy(xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
	WebElement okbutton;
	
	@FindBy(xpath="//div[@class='nav-tabs-custom']//a[1]//i[1]")
	WebElement tabselected;
	
	@FindBy(xpath="//div[@id='product_list_tab']//a[1]")
	WebElement addbutton;
	
	@FindBy(id="name")
	WebElement productname;
	
	@FindBy(id="select2-unit_id-container")
	WebElement unitdropdown;
	
	@FindBy(xpath="//li[text()='Each']")
	WebElement unittype;
	
	@FindBy(id="alert_quantity")
	WebElement quantity;
	
	@FindBy(id="single_dpp")
	WebElement exctax;
	
	@FindBy(name="single_dpp_inc_tax")
	WebElement inctax;
	
	@FindBy(xpath="//div[@class='text-center']//button[3]")
	WebElement savebutton;
	
	@FindBy(xpath="//tr[@class='odd']//td[12]//button[1]")
	WebElement actionbutton;
	
	@FindBy(xpath="//tr[@class='odd']//td[12]//ul[1]//li[3]//a[1]")
	WebElement editbutton;
	
	@FindBy(id="alert_quantity")
	WebElement editquantity;
	
	@FindBy(xpath="//div[@class='btn-group']//button[3]")
	WebElement updatebutton;
	
	@FindBy(xpath="//div[@class='pull-right margin-left-10']//a")
	WebElement actbutton;
	
	@FindBy(xpath="//ul[@class='dt-button-collection dropdown-menu']//li[2]//a")
	WebElement importcsv;
	
	@FindBy(xpath="//ul[@class='dt-button-collection dropdown-menu']//li[3]//a")
	WebElement excel;
	
	@FindBy(xpath="//ul[@class='dt-button-collection dropdown-menu']//li[6]//a")
	WebElement pdf;
	
	@FindBy(xpath="//ul[@class='dt-button-collection dropdown-menu']//li[5]//a")
	WebElement visibility;
	
	@FindBy(xpath="//table[@id='product_table']//thead//th[4]")
	WebElement sellingprice;
	
	@FindBy(xpath="//li[@id='tour_step5']//li[8]//a")
	WebElement unitlink;
	
	@FindBy(xpath="//table[@id='unit_table']//tbody//td[4]//button[2]")
	WebElement deletebutton;
	
	@FindBy(xpath="//div[@class='swal-modal']//button[@class='swal-button swal-button--confirm swal-button--danger']")
	WebElement okbutton1;
	
	@FindBy(xpath="//section[@class='content']//div[@class='box box-primary']//h3")
	WebElement mesgdisplay;
	
	@FindBy(xpath="//div[contains(text(),'Product added successfully')]")
	   WebElement addedmesg;
	
	@FindBy	(xpath="//div[contains(text(),'Product updated successfully')]")
	WebElement productupdatedsuccessfully;
	
	@FindBy(xpath="//table[@id='unit_table']//tbody//tr[2]//button[1]//i")
	WebElement unitedit;
	
	@FindBy(xpath="id=short_name")
	WebElement uniteditname;
	
	@FindBy(xpath="//div[@class='modal-footer']//button[@class='btn btn-primary']")
	WebElement unitupdate;
	
	@FindBy	(xpath="//div[contains(text(),'Unit updated successfully')]")
	WebElement unitupdatedsuccessfully;
	
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		eleutil = new ElementUtil (driver);
		waitutil = new WaitUtil(driver);
		
			}
	
	
	public void productListDetails() {
		eleutil.doClick(productlink);
		eleutil.doClick(listproduct);
		eleutil.doClick(checkbox);
		eleutil.doClick(deactivatebutton);
		eleutil.doClick(okbutton);
		
	}
	
public boolean productLisIsDisplayed()  {
		
		return eleutil.isDisplayed(tabselected);
		}

public void addNewProduct(String ProductNam,String Quan,String ExcTax,String IncTax) {
	eleutil.doClick(addbutton);
	eleutil.doSendkey(productname, ProductNam);
	eleutil.doSendkey(quantity, Quan);
	eleutil.doClick(unitdropdown);
	eleutil.doClick(unittype);
	eleutil.scrollView(exctax);
	eleutil.doSendkey(exctax, ExcTax);
	eleutil.doSendkey(inctax, IncTax);
	eleutil.scrollView(savebutton);
	eleutil.doClick(savebutton); 
	}
public boolean addNewProductMesgIsDisplayed() {
	//waitutil.waitforVisibility(addedmesg);
	return eleutil.isDisplayed(addedmesg);
}
public void editProductDetails(String Quantity) {
	eleutil.doClick(actionbutton);
	eleutil.doClick(editbutton);
	eleutil.doClick(unitdropdown);
	eleutil.doClick(unittype);
	eleutil.doclear(editquantity);
	eleutil.doSendkey(editquantity, Quantity);
	eleutil.scrollView(exctax);
	
	eleutil.doClick(updatebutton);
}
public boolean productUpdatedMesgIsDisplayed() {
	
	return eleutil.isDisplayed(productupdatedsuccessfully);
}


public void importToCsv() {
	eleutil.doClick(actbutton);
	eleutil.doClick(importcsv);
	
}


public boolean csvIsDisplayed() {
	
	return eleutil.isDisplayed(importcsv);
}


public void importToExcel() {

	eleutil.doClick(excel);
	
}
public boolean excelIsDisplayed() {
	return eleutil.isDisplayed(excel);
}

public void importToPdf() {
	
	eleutil.doClick(pdf);
	
}
public boolean pdfIsDisplayed() {
	return eleutil.isDisplayed(pdf);
}

public void visibilityOfColoumn() {
	eleutil.doClick(visibility);
	
}
public boolean sellingpriceIsDisplayed() {
	return eleutil.isDisplayed(sellingprice);
}
public void unitLink() {
	eleutil.actioncmt(unitlink);
	eleutil.doClick(unitlink);
	eleutil.doClick(deletebutton);
	eleutil.doClick(okbutton1);
}
public boolean mesgIsDisplayed() {
	return eleutil.isDisplayed(mesgdisplay);
}

public void unitEditDetails() {
	eleutil.doClick(unitedit);
	eleutil.doClick(unitupdate);
}

public boolean unitUpdatedMesgIsDisplayed() {
	
	return eleutil.isDisplayed(unitupdatedsuccessfully);
}




}