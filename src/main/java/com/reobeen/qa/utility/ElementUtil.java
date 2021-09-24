package com.reobeen.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.obsquramainproject.constant.Constant;










public class ElementUtil {
 static Properties prop = new Properties();
WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	public void doSendkey(WebElement element ,String value)
	{
		element.clear();
		element.sendKeys(value);
	}
	
	public void doClick(WebElement element)
	{
		element.click();
	}
	
	
	public void scrollView(WebElement element ) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView();",element);
	}
	
public void actioncmt(WebElement element) {
	Actions action = new Actions (driver);
	  action.moveToElement(element).click().build().perform();
	
}

public boolean isDisplayed(WebElement element) {
	return element.isDisplayed();
	
}
public ElementUtil()   {
	File src=new File(Constant.propertyfilepath);

	try {
		FileInputStream fis=new FileInputStream(src);
		prop=new Properties();
		prop.load(fis);

	} catch (Exception e) {
		System.out.println("Exception is "+e.getMessage());
	}
}
	

public static String getPropertyValue(String key)
	{

	String propertyFile=System.getProperty("user.dir")+"\\properties\\config.properties";
	FileInputStream fis=null;
	try {
		fis = new FileInputStream (propertyFile);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	try {
		prop.load(fis);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	String value=prop.get(key).toString();
	return value;
	}





public void select(WebElement element ,int index) {
	Select multi = new Select(element);
	multi.selectByIndex(index);
}



public void navigationRefresh() {
	driver.navigate().refresh();
}

public void navigationBack() {
	driver.navigate().back();
}

public void alertaccept(WebElement element) {
	 Alert al = driver.switchTo().alert();
      al.accept();
	   
}
public void alertdismiss(WebElement element) {
	Alert al = driver.switchTo().alert();
    al.dismiss();
}

public void doclear(WebElement element) {
	element.clear();
}

public String getTextMethod(WebElement element) {
	return element.getText();
}
}
	
	
	

		
	


