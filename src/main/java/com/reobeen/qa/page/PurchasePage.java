package com.reobeen.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reobeen.qa.utility.ElementUtil;
import com.reobeen.qa.utility.WaitUtil;

public class PurchasePage {
	ElementUtil eleutil ;
	WebDriver driver;
    WaitUtil waitutil;
	@FindBy(xpath="//a[@id='tour_step6_menu']")
	WebElement purchase;
	
	@FindBy(xpath="//li[@id='tour_step6']//ul//a[1]")
	WebElement listpurchase;
	
	@FindBy(xpath="//div[@class='box box-primary']//a[1]")
	WebElement addbutton;
	 
	@FindBy(xpath ="//*[text()=' Add new product ']")
	WebElement addnewproductbutton;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement  name;
	
	@FindBy(id="select2-unit_id-container")
	WebElement pleaseselect;
	
	@FindBy(xpath="//li[text()='Each']")
	WebElement dropdown;
	
	@FindBy(id="alert_quantity")
    WebElement alertquan;
	
	@FindBy(id="single_dpp")
	WebElement exctax;
	
	@FindBy(id="single_dpp_inc_tax")
	WebElement inctax;
	
	
    @FindBy(id="submit_quick_product")
    WebElement savebutton;
	
    @FindBy	(xpath="//div[contains(text(),'Product added successfully')]")
	WebElement productaddedsuccessfully;
	
    @FindBy(xpath="//div[@class='pull-right margin-left-10']//a")
    WebElement actionbutton;
    
    @FindBy(xpath="//ul[@class='dt-button-collection dropdown-menu']//li[2]")
    WebElement csv;
    
    @FindBy(xpath="//ul[@class='dt-button-collection dropdown-menu']//li[3]")
    WebElement excel;
    
    @FindBy(xpath="//ul[@class='dt-button-collection dropdown-menu']//li[6]")
    WebElement pdf;
	
	public PurchasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		eleutil = new ElementUtil (driver);
		
	}
	
	public void importToCsv() {
		eleutil.doClick(purchase);
		eleutil.actioncmt(listpurchase);
		eleutil.doClick(actionbutton);
		eleutil.doClick(csv);
		
	}
	public boolean csvIsDisplayed() {
		return eleutil.isDisplayed(csv);
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
	
	public void addNewPurchase(String nam, String alertquantity, 
			String exc_tax, String inc_tax) {
		
		eleutil.navigationRefresh();
	
		eleutil.doClick(addbutton);
	   // waitutil.waitforclickable(addnewproductbutton);
		eleutil.doClick(addnewproductbutton);
		eleutil.doClick(pleaseselect);
		eleutil.doClick(dropdown);
		eleutil.doSendkey(name, nam);
		eleutil.doSendkey(alertquan, alertquantity);
		eleutil.scrollView(exctax);
		eleutil.doSendkey(exctax, exc_tax);
		eleutil.doSendkey(inctax, inc_tax);
		eleutil.scrollView(savebutton);
		eleutil.doClick(savebutton);
	
		
	}

public boolean unitAddedMesgIsDisplayed() {
	
	return eleutil.isDisplayed(productaddedsuccessfully);
}
}
