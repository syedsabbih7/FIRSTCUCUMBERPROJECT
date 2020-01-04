package com.signup.utilities;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class customutilities extends Base {

	public static void highlightElement(WebElement element) {

		if (isDemoMode==true) {

		try {

		for(int i =0;i<3;i++) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep((500));

		js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element,

		"color: red; border: 2px solid green;");

		Thread.sleep((500));

		js.executeScript("arguments[0].setAttribute('style', arguments[1];",element,"");

		}


		}catch(Exception e) {

		System.out.println("Error:"+e.getMessage());

		e.printStackTrace();


		}

		}


	}

	
	/***
	* This method starts Chrome browser
	*
	* @return
	*/
	public static WebDriver startChromeBrowser() {
	try {
	System.setProperty("webdriver.chrome.driver", "/resources/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize(); // maximize the browser window
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // wait for driver
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	} catch (Exception e) {
	System.out.println("Error: " + e.getMessage());
	e.printStackTrace();
	}
	return driver;
	}


	 /***
	* This method used for dynamic element search
	*
	* @param by
	* @return WebElement
	*/
	public static WebElement fluentWait(final By by) {
	WebElement targetElem = null;
	try {
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
	.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	targetElem = wait.until(new Function<WebDriver, WebElement>() {
	// @Override
	public WebElement apply(WebDriver driver) {
	return driver.findElement(by);
	}
	});
	} catch (Exception e) {
	System.out.println("Error: " + e.getMessage());
	e.printStackTrace();
	}
	return targetElem;
	}

	/***
	* This method prints the given string in the console
	*
	* @param stringValue
	*/
	public static void print(String stringValue) {
	System.out.println(stringValue);
	}

	/***
	* This method uploads given file. Note*: for windows test execution
	* environment, please use "\\" for the file path for other environment (Mac
	* OS, Linux), please use "/" for the file path
	*
	* @param by
	* @param absulatePathForFile
	*/
	public static void uploadFile(By by, String absolutePathForFile) {
	try {
	WebElement fileUploadElem = driver.findElement(by);
	fileUploadElem.sendKeys(absolutePathForFile);
	} catch (Exception e) {
	print("Error: " + e.getMessage());
	e.printStackTrace();
	}
	}

	/***
	* This method dynamically waits for the Visibility condition of given element
	*
	* @param by
	* @return
	*/
	public static WebElement waitForConditionVisibility(By by) {
	WebElement temp = null;
	try {
	WebDriverWait pageWait = new WebDriverWait(driver, 30);
	temp = pageWait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
	} catch (Exception e) {
	print("Error: " + e.getMessage());
	e.printStackTrace();
	}
	return temp;

	}

	/***
	* This method dynamically waits for the Presence condition of given element
	*
	* @param by
	* @return
	*/
	public static WebElement waitForConditionPresense(By by) {
	WebElement temp = null;
	try {
	WebDriverWait pageWait = new WebDriverWait(driver, 30);
	temp = pageWait.until(ExpectedConditions.presenceOfElementLocated(by));
	} catch (Exception e) {
	print("Error: " + e.getMessage());
	e.printStackTrace();
	}
	return temp;
	}

	 /***
	* This method switch back to original html content from iFrame section
	*/
	public static void switchToDefault() {
	try {
	driver.switchTo().defaultContent();
	} catch (Exception e) {
	print("Error: " + e.getMessage());
	e.printStackTrace();
	}
	}

	/***
	* This method switch the driver to iFrame section of the html source
	*
	* @param by
	*/
	public static void switchToIframe(By by) {
	try {
	WebElement iFrameElem = driver.findElement(by);
	driver.switchTo().frame(iFrameElem);
	} catch (Exception e) {
	print("Error: " + e.getMessage());
	e.printStackTrace();
	}
	}
}
