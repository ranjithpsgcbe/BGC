package com.cucumber.framework.runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:featurefile" },
		strict = true,
		monochrome = true,
		tags = { "@Test1","@Test2","@Test3","@Test4" },
		glue = {
		"classpath:com.cucumber.framework.stepdefinition",
		"classpath:com.cucumber.framework.helper" },
		plugin = {"html:target/cucumber-html-report","pretty",
		"com.cucumber.listener.ExtentCucumberFormatter:output/report.html","json:target/cucumber/cucumber.json"})
public class TestProductsRunner extends AbstractTestNGCucumberTests {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("./src/main/resources/extent-config.xml"));
		Reporter.setSystemInfo("User Name", "Ranjith");
		Reporter.setSystemInfo("Application Name", "Test App");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");   }

}
