package com.reobeen.qa.page;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.reobeen.qa.utility.ElementUtil;

public class HomePage {

	WebDriver driver;
	ElementUtil eleutil;
	
	 @FindBy(name="username")
		WebElement username;
		
		@FindBy(name = "password")
		WebElement password;
		
		@FindBy(xpath = "//button[@type='submit']")
		WebElement submitbutton;
		
		@FindBy(xpath ="//button[@data-role='end']")
		WebElement end;
		
		@FindBy(xpath="//span[@class='logo-lg']")
		WebElement logo;
	
	@FindBy(xpath = "//div[@class='btn-group pull-right']//label[2]")
	WebElement infobutton;
	
	@FindBy(xpath="//div[@class='btn-group pull-right']//label[4]")
	WebElement infobutton2;
	
	@FindBy(xpath="//section[@class='content-header']//h1")
	WebElement welcometext;
	
	@FindBy(xpath = "//span[text()='Aju Mathew']")
	WebElement prof;
	
	@FindBy(xpath = "//a[@href='https://buffalocart.com/demo/billing/public/user/profile']")
	WebElement profile;
	
	@FindBy(xpath = "//li[@class='dropdown user user-menu open']//ul//li[2]//div[2]")
	WebElement logout;
	
	@FindBy(xpath="//div[@class='navbar-custom-menu']//a[1]//strong")
	WebElement pos;
	
	@FindBy(xpath = "//form[@id='add_pos_sell_form']//div[2]//button[1]")
	WebElement plusbutton;
	
	@FindBy(id="name")
	WebElement nam;
	
	@FindBy(id="contact_id")
	WebElement contactid;
	
	@FindBy(id="tax_number")
	WebElement taxno;
	
	@FindBy(id="opening_balance")
	WebElement openingbal;
	
	@FindBy(id="mobile")
	WebElement mobileno;
	
	@FindBy(xpath="//form[@id='quick_add_contact']//div[@class='modal-footer']//button[1]")
	 WebElement savebutton;
	
	@FindBy(xpath="//form[@id='add_pos_sell_form']//div[2]//div[2]//button[1]")
	WebElement addbutton2;
	
	@FindBy(name="name")
	WebElement productname;
	
	@FindBy(id="select2-unit_id-container")
	WebElement producttype;
	
	@FindBy(xpath="//li[text()='Each']")
	WebElement unitdropdown;
	
	@FindBy(name="single_dpp_inc_tax")
	WebElement inctax;
	
	@FindBy(id="single_dpp")
	WebElement exctax;
	
	@FindBy(id="submit_quick_product")
	WebElement productsavebutton;
	
	@FindBy(id="search_product")
	WebElement searchproduct;
	
	@FindBy(id="full_screen")
	WebElement fullscren;
	
	@FindBy(xpath="//div[@id='product_list_body']//div[3]")
	WebElement brand;
	
	 @FindBy	(xpath="//div[contains(text(),'Product out of stock')]")
		WebElement productoutofstockmesg;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String logo() {
		return eleutil.getTextMethod(logo);//
	}
	
	public void infoCheck() {
		eleutil.doClick(infobutton);
		eleutil.doClick(infobutton2);
		
	}
	public String welcomeText() {
	
	return	eleutil.getTextMethod(welcometext);
	}
	
	
	
	public void posWalkInCustomerDetails(String name,String taxn_o,String opening_bal,String mobile_no) {
		eleutil.doClick(pos);
		eleutil.doClick(plusbutton);
	eleutil.doSendkey(nam, name);
	eleutil.doSendkey(taxno, taxn_o);
	eleutil.doSendkey(openingbal, opening_bal);
	eleutil.doSendkey(mobileno, mobile_no);
	eleutil.doClick(savebutton);
	eleutil.navigationRefresh();
	
	
	}
	
public boolean usernameIsDisplayed()  {
		
	return eleutil.isDisplayed(searchproduct);
}


public void searchBrandAvailability() {
	eleutil.doClick(brand);

}

public boolean productOutOfStockIsDisplayed() {
	return eleutil.isDisplayed(productoutofstockmesg);
}

	public void posAddNewProduct(String productName, String excTax, String incTax) {
		eleutil.doClick(addbutton2);

		eleutil.doClick(unitdropdown);
        eleutil.doClick(producttype);
        eleutil.doSendkey(productname, productName);
        eleutil.scrollView(exctax);
        eleutil.doSendkey(exctax, excTax);
         eleutil.doSendkey(inctax, incTax);
         eleutil.scrollView(productsavebutton);
	    eleutil.doClick(productsavebutton);
	}


    public void doSignout() {
    	eleutil.navigationBack();
		eleutil.doClick(prof); 
		eleutil.actioncmt(logout);
		
	}
	
	
}
