package com.reobeen.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reobeen.qa.utility.ElementUtil;
import com.reobeen.qa.utility.WaitUtil;

public class ContactPage {

	ElementUtil eleutil;
	WebDriver driver;
	WaitUtil waitutil;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitbutton;

	@FindBy(xpath = "//button[@data-role='end']")
	WebElement end;

	@FindBy(id = "tour_step4_menu")
	WebElement contact;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-modal pull-right']")
	WebElement add;

	@FindBy(xpath = "//i[@class='fa fa-star']")
	WebElement suppliers;

	@FindBy(xpath = "//i[@class='fa fa-list']//parent::span[1]")
	WebElement actionbutton;

	@FindBy(xpath = "//i[@class='fa fa-file-pdf-o']//parent::a[1]")
	WebElement pdf;

	@FindBy(xpath = "//i[@class='fa fa-download']")
	WebElement download;

	@FindBy(name = "contacts_csv")
	WebElement upload;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//li[@class='treeview active active-sub']//ul[@class='treeview-menu']//li[2]//a[1]")
	WebElement customer;

	@FindBy(xpath = "//table//tbody//tr[1]//td[8]//div[@class='btn-group']//button[1]//span[@class='caret']")
	WebElement action;

	@FindBy(xpath = "//section[@class='content']//div[1]//div[@class='box-header']//div[1]//i[@class='fa fa-plus']")
	WebElement addbut;

	@FindBy(id = "contact_type")
	WebElement contacttype;

	@FindBy(xpath = "//select[@id='contact_type']//option[3]")
	WebElement optnselect;

	@FindBy(id = "name")
	WebElement name;

	@FindBy(id = "mobile")
	WebElement mobileno;

	@FindBy(xpath = "//div[@class='modal-footer'][1]//button[@class='btn btn-primary']")
	WebElement save;

	@FindBy(xpath = "//table[@id='contact_table']//tbody//tr[1]//td[8]//button")
	WebElement action1;

	@FindBy(xpath = "//table[@id='contact_table']//tbody//tr[1]//td[8]//div//li[3]//a")
	WebElement delete;

	@FindBy(xpath = "//div[@class='swal-button-container']//button[@class='swal-button swal-button--confirm swal-button--danger']")
	WebElement okbutton;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li[2]//a[1]")
	WebElement editbutton;

	@FindBy(name = "name")
	WebElement editname;

	@FindBy(xpath = "//div[@class='modal-footer']//button[@type='submit']")
	WebElement updatebutton;

	@FindBy(xpath = "//input[@data-msg='Product added successfully']")
	WebElement addedmesg;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement mismatchmesg;

	@FindBy(xpath = "//div[contains(text(),'Contact updated successfully')]")
	WebElement contactupdatedsuccessfully;

	@FindBy(xpath = "//div[contains(text(),'Contact added successfully')]")
	WebElement contactaddedsuccessfully;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li[1]//a[@href='https://buffalocart.com/demo/billing/public/contacts/2']")
	WebElement view;

	@FindBy(xpath = "//section[@class='content no-print']//h3[1]//i[1]")
	WebElement contactinfo;

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		eleutil = new ElementUtil(driver);
		waitutil = new WaitUtil(driver);
	}

	public void copyContactDetails() throws InterruptedException {

		eleutil.doClick(contact);
		eleutil.actioncmt(suppliers);
		eleutil.doClick(actionbutton);
		eleutil.doClick(pdf);

	}

	public boolean copyContactDetailsIsDisplayed() {
		return eleutil.isDisplayed(pdf);

	}

	public void uploadContact() throws InterruptedException {
		eleutil.actioncmt(download);
		eleutil.doClick(download);
		eleutil.doSendkey(upload, "C:\\Excelfiles\\screensht\\uploadndownload.txt");
		eleutil.doClick(submit);
	}

	public boolean mismatchMessageIsDisplayed() {
		return eleutil.isDisplayed(mismatchmesg);
	}

	public void deleteCustomerDetails() {
		eleutil.navigationRefresh();
		eleutil.doClick(action1);
		eleutil.doClick(delete);
		waitutil.waitforVisibility(okbutton);
		eleutil.doClick(okbutton);

	}

	public void editCustomerDetails(String Editname) {
		eleutil.actioncmt(customer);
		eleutil.doClick(action1);
		eleutil.doClick(editbutton);
		eleutil.doclear(editname);
		eleutil.doSendkey(editname, Editname);
		eleutil.doClick(updatebutton);

	}

	public boolean contactUpdateIsDisplayed() {
		return eleutil.isDisplayed(contactupdatedsuccessfully);
	}

	public void viewContactDetails() {
		eleutil.navigationRefresh();
		eleutil.doClick(action1);
		eleutil.doClick(view);
		eleutil.navigationBack();
	}

	public void addCustomerDetails(String nam, String mobile) {

		eleutil.doClick(addbut);

		eleutil.doSendkey(name, nam);
		eleutil.scrollView(mobileno);
		eleutil.doSendkey(mobileno, mobile);
		eleutil.scrollView(save);
		eleutil.doClick(save);

	}

	public boolean contactAddedMesgIsDisplayed() {
		return eleutil.isDisplayed(contactaddedsuccessfully);
	}

}
