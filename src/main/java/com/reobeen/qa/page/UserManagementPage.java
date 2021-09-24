package com.reobeen.qa.page;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.reobeen.qa.utility.ElementUtil;
import com.reobeen.qa.utility.WaitUtil;

public class UserManagementPage {
	WebDriver driver;
	ElementUtil eleutil;
	WaitUtil waitutil;
	
	 @FindBy(name="username")
		WebElement username;
		
		@FindBy(name = "password")
		WebElement password;
		
		@FindBy(xpath = "//button[@type='submit']")
		WebElement submitbutton;
		
		@FindBy(xpath ="//button[@data-role='end']")
		WebElement end;
		
		@FindBy(xpath="//span[@class='title']")
		WebElement userdropdown;
		
		@FindBy(xpath="//i[@class='fa fa-user']")
		WebElement user;
		
		@FindBy(xpath="//i[@class='fa fa-briefcase']")
		WebElement brief;
		
		@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
		WebElement add;
		
		@FindBy(name = "surname")
		WebElement surnam;
		
		@FindBy(name="first_name")
		WebElement fisrtnam;
		
		@FindBy(name="last_name")
		WebElement lastnam;
		
		@FindBy(id = "email")
		WebElement emails;
		
		@FindBy(id="username")
		WebElement uname;
		
		@FindBy(name="password")
		WebElement newpass;
		
	
		@FindBy(id = "confirm_password")
		WebElement pass;
	
       @FindBy(name= "cmmsn_percent")
       WebElement percent;
       
    
       
       @FindBy(id="submit_user_button")
       WebElement save;
       
    
       
       @FindBy(xpath ="//table[@id='roles_table']//tbody//tr[2]//a")
       WebElement roleseditbutton;
       
       @FindBy(xpath="//div[@class='row check_group']//div[2]//div[1]//div[1]")
       WebElement tickselected;
       
       @FindBy(xpath="//div[@class='col-md-12']//button[1]")
       WebElement roleupdatebutton;
       
       @FindBy(xpath = "//input[@class='form-control input-sm']")
       WebElement search;
       
       @FindBy(xpath="//ul[@class='sidebar-menu']//li[2]//ul[1]//li[3]//a[1]//i[@class='fa fa-handshake-o']")
       WebElement sales;
       @FindBy(xpath="//section[@class='content']//div[1]//div[@class='box-header']//div[1]//button[@type='button']")
     WebElement salesadd;
       
       @FindBy(id="surname")
       WebElement salesprefix;
       
       @FindBy(id="first_name")
       WebElement salesfirstname;
       
       @FindBy(id="last_name")
       WebElement saleslastname;
       
       @FindBy(id="email")
       WebElement salesemail;
       
       @FindBy(id="contact_no")
       WebElement salescontactno;
       
       @FindBy(id="address")
       WebElement salesaddress;
       
       @FindBy(id="cmmsn_percent")
       WebElement salescommision;
       
       @FindBy(xpath="//form[@id='sale_commission_agent_form']//div[@class='modal-footer']//button[1]")
       WebElement salessavebutton;
       
       @FindBy(xpath="//input[contains(text(),'User added successfully')]")
	   WebElement useraddedsuccessfully;
       
       @FindBy	(xpath="//div[contains(text(),'Commission agent added successfully')]")
   	WebElement commisionaddedsuccessfully;
       
       @FindBy(xpath="//table[@id='users_table']//tbody//td[5]//a[1]")
       WebElement usereditbutton;
       
       @FindBy(xpath="//input[@name='is_active']")
       WebElement tickactive;
       
       @FindBy(id="submit_user_button")
       WebElement userupdatebutton;
       
       @FindBy(xpath="//div[contains(text(),'User updated successfully')]")
	   WebElement userupdatedsuccessfully;
       
       @FindBy(xpath="//table[@id='users_table']//tbody//tr[1]//td[5]//button//i")
       WebElement deleteuserbutton;
       
       @FindBy(xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
       WebElement okbutton;
       
       @FindBy	(xpath="//div[contains(text(),'User deleted successfully')]")
      	WebElement userdeletedsuccessfully;
       
       @FindBy(xpath="//div[@class='dt-buttons btn-group']//a")
       WebElement actionbutton;
       
       @FindBy(xpath="//ul[@class='dt-button-collection dropdown-menu']//li[2]")
       WebElement csv;
       
		public UserManagementPage(WebDriver driver) {
			this.driver = driver;
			eleutil = new ElementUtil(driver);
			PageFactory.initElements(driver, this);
		}

		public void importCustomerDetails() {
			eleutil.doClick(userdropdown);
		    eleutil.actioncmt(user);
		    waitutil.waitforVisibility(actionbutton);
			eleutil.doClick(actionbutton);
			eleutil.doClick(csv);
		}

			public void newUserDetail(String surname , String firstname,String lastname,
					String email,String username, String newpassword,String password,String percentage) throws InterruptedException {
				
				eleutil.navigationRefresh();
			    eleutil.doClick(add);
			  		   
			    eleutil.doSendkey(surnam, surname);
			    eleutil.doSendkey(fisrtnam, firstname);
			    eleutil.doSendkey(lastnam, lastname);
			    eleutil.doSendkey(emails, email);
			    eleutil.doSendkey(uname, username);
			    eleutil.doSendkey(newpass, newpassword);
			    eleutil.doSendkey(pass, password);
			    eleutil.doSendkey(percent, percentage);
				eleutil.doClick(save);
			
			}
			public void newUserEditDetails() {
				eleutil.doClick(usereditbutton);
				eleutil.doClick(tickactive);
				eleutil.doClick(userupdatebutton);
				}
			public boolean userUpdatedsuccessfullyIsDisplayed() {
				
				return eleutil.isDisplayed(userupdatedsuccessfully);
			}
			
			
			public void deleteUserDetails(){
				
				eleutil.doClick(deleteuserbutton);
				eleutil.doClick(okbutton);
			}
public boolean userdeletedsuccessfullyIsDisplayed() {
				
				return eleutil.isDisplayed(userdeletedsuccessfully);
			}
			
			public void editUserDetails() {
				
				eleutil.actioncmt(brief);
				eleutil.doClick(roleseditbutton);
				eleutil.doClick(tickselected);
				eleutil.scrollView(roleupdatebutton);
				eleutil.doClick(roleupdatebutton);
				
			  
			}
		public void salesCommisionlink(String Salesprefix , String Salesfirstname, String Saleslastname, String Salesemail,
				String Salescontactno ,String Salesaddress, String Salecommision) {
			    eleutil.actioncmt(sales);
			    eleutil.doClick(salesadd);
			    eleutil.doSendkey(salesprefix, Salesprefix);
			    eleutil.doSendkey(salesfirstname, Salesfirstname);
			    eleutil.doSendkey(saleslastname, Saleslastname);
			    eleutil.doSendkey(salesemail, Salesemail);
			    eleutil.doSendkey(salescontactno, Salescontactno);
			    eleutil.doSendkey(salesaddress, Salesaddress);
			    eleutil.doSendkey(salescommision, Salecommision);
			    eleutil.doClick(salessavebutton);
			 
			    
}
		public boolean commisionAddedsuccessfullyIsDisplayed() {
			
			return eleutil.isDisplayed(commisionaddedsuccessfully);
		}

}

		
			

