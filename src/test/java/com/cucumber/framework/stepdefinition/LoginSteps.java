package com.cucumber.framework.stepdefinition;

import com.cucumber.framework.PageObject.LoginPage;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.LoggerHelper;
import com.cucumber.framework.helper.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class LoginSteps {
	private final Logger log = LoggerHelper.getLogger(LoginSteps.class);

	LoginPage loginpage;
	
	@Given("^I am on the homepage$")
	public void I_am_on_the_homepage() throws Throwable {
       TestBase.driver.get(ObjectRepo.reader.getWebsite());
	}

	@When("^As a user enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void As_a_user_enter_nric_name_uen(String nric,String name, String uen) throws Throwable {
		loginpage= new LoginPage(TestBase.driver);
		loginpage.enteruserdcredential(nric,name,uen);
	}
	@And("^As a user Select the Role and click on the login button$")
	public void As_a_user_Select_the_Role_and_click_on_the_login_button() throws Throwable {
		loginpage.clickOnLoginButton();
	}

	@And("^As a user click on New Grand Button$")
	public void As_a_user_click_on_New_Grand_Button() throws Throwable {
		loginpage.clickOnNewGrandButton();
	}

	@And("^As a user select Sector and Development and Function area$")
	public void As_a_user_select_Secto_and_Development_and_Function_area() throws Throwable {
		loginpage.clickOnSelectorButton();
		loginpage.SelectDevelopmentAreaButton();
		loginpage.SelectFuntionalAreaButton();
		loginpage.clickOnApplyButton();
	}

	@And("^As a user click on the proceed button$")
	public void As_a_user_click_on_the_proceed_button() throws Throwable {
		loginpage.clickOnProceedButton();
	}


}
