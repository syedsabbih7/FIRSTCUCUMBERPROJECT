package com.signup;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/resources/Features",

plugin = {"pretty", "json:target/cucumber.json", "html:target/site/cucmber-pretty"}

)

public class Runner {

	
	
}
