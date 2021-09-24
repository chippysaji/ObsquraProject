package com.reobeen.qa.testcase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.reobeen.qa.page.ContactPage;
import com.reobeen.qa.page.HomePage;
import com.reobeen.qa.page.LoginPage;
import com.reobeen.qa.utility.ElementUtil;
import com.reobeen.qa.utility.WaitUtil;

public class BaseTest {
	HomePage homePage;
	LoginPage loginPage;
	ContactPage contactPage;

	WaitUtil waitUtil;
	ElementUtil eleutil;
	WebDriver driver;

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void beforeTest(String Browser) {
		String path = System.getProperty("user.dir");
		System.out.println(ElementUtil.getPropertyValue("chromepath"));
		System.out.print("browser");
		
		if (Browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", path + ElementUtil.getPropertyValue("chromepath"));

			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", path + ElementUtil.getPropertyValue("iepath"));
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://buffalocart.com/demo/billing/public/home");

		waitUtil = new WaitUtil(driver);
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		contactPage = new ContactPage(driver);
		eleutil = new ElementUtil(driver);

	}

	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == iTestResult.FAILURE) {
			takeScreenShotOnFailure(iTestResult.getName());
		}
	}

	public String takeScreenShotOnFailure(String name) throws IOException {
		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "\\Screenshots\\" + name + dateName + ".png";
		File finalDestination = new File(destination);

		FileUtils.copyFile(source, finalDestination);
		return destination;

	}

	@AfterTest
	public void after() {
		driver.close();

	}

}
