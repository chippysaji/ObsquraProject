package com.reobeen.qa.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsquramainproject.constant.Constant;

public class WaitUtil {
	WebDriver driver;

	public WaitUtil(WebDriver driver) {
		this.driver = driver;

	}

	public void waitforPageTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, Constant.timeout);
		wait.until(ExpectedConditions.titleIs(title));

	}

	public void waitforVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Constant.timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitAndAcceptAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Constant.timeout);
		Alert al = wait.until(ExpectedConditions.alertIsPresent());
		al.accept();
	}

	public void waitforclickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Constant.timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
