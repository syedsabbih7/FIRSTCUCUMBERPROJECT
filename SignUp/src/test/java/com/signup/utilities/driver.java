package com.signup.utilities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;



public class driver{

	public static WebDriver driver;

	@Before
	public void setDriver() {

		if(driver==null) {

			customutilities.startChromeBrowser();
		
            driver=customutilities.startChromeBrowser();

			System.setProperty("webdriver.chrome.driver","C://Users//Syed Sabbih//Desktop//chromedriver.exe");
			driver= new ChromeDriver();
            
		    
		}
		
		Base.driver= driver;
	}

		public static WebDriver getDriver() {


			return driver;

		}
		
		@After
		
		public void tearDown(Scenario scenario) {
			
			if (scenario.isFailed()) {
				
				final byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(
						
						
						OutputType.BYTES);
				
				
						
			}
		}

	}

