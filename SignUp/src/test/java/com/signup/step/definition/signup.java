package com.signup.step.definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.openqa.selenium.By;

public class signup  {
	WebDriver driver = new ChromeDriver();
@Given("^I should be able to navigate to facebook$")
public void i_should_be_able_to_navigate_to_facebook() throws Throwable {
	System.setProperty("webdriver.chrome.driver","C://Users//Syed Sabbih//Desktop//chromedriver.exe");
	
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com");
}
	@Then("^I should be able to input First name into first name field$")

	
	public void i_should_be_able_to_input_First_name_into_first_name_field() throws Throwable {
	    
		driver.findElement(By.name("firstname")).sendKeys("Syed");
		
		
	}
	
	@Then("^I should be able to input last  name into last name field$")
public void i_should_be_able_to_input_last_name_into_last_name_field() throws Throwable {
	  
		driver.findElement(By.name("lastname")).sendKeys("Sabbih Ul Hasnain");
	}

	@Then("^I should be able to input email address$")
	public void i_should_be_able_to_input_email_address() throws Throwable {
	    
		driver.findElement(By.id("u_0_k")).sendKeys("syedsabbih7@hotmail.com");
	}

	@Then("^I should be able to input password$")
	public void i_should_be_able_to_input_password() throws Throwable {
	    
	
		driver.findElement(By.id("u_0_p")).sendKeys("1234567");
	}

	@Given("^Enter the month$")
	public void enter_the_month() throws Throwable {
		
		Select ddmonth= new Select(driver.findElement(By.name("birthday_month")));
				ddmonth.selectByVisibleText("Apr");
				ddmonth.selectByIndex(4);
				
				
	
}	



	
	}



