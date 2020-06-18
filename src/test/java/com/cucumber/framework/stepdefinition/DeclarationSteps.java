package com.cucumber.framework.stepdefinition;

import com.cucumber.framework.PageObject.DeclarationPage;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.TestBase.TestBase;
import cucumber.api.java.en.And;
import org.apache.log4j.Logger;

public class DeclarationSteps {
	private final Logger log = LoggerHelper.getLogger(DeclarationSteps.class);
	DeclarationPage declarationPage;

	@And("^As a user select the Declare and acknowledge$")
	public void As_a_user_select_the_Declare_and_acknowledge() {
		declarationPage = new DeclarationPage(TestBase.driver);
		declarationPage.selectDeclare();
	}

	@And("^As a user check the acknowledge checkBox$")
	public void As_a_user_check_the_acknowledge_checkBox() throws Throwable {

		declarationPage.clickOntheacknowledgement();
	}

	@And("^As a user click on the Review button$")
	public void As_a_user_click_on_the_Review_button() throws Throwable {
		declarationPage.clickOntheReviewButton();

	}

	@And("^Verify the mandatory input missing and number of error$")
	public void Verify_the_mandatory_input_missing_and_number_of_error() throws Throwable {
		declarationPage.verifymandatoryInputMissing();

	}

	@And("^As a user check the Final acknowledge checkBox$")
	public void As_a_user_check_the_Final_acknowledge_checkBox() throws Throwable {
		declarationPage.clickOnruthfulness_check();

	}

	@And("^As a user should click on the submit Button$")
	public void As_a_user_should_click_on_the_submit_Button() throws Throwable {
		declarationPage.clickOnSubmitButton();

	}

	@And("^As a user Click on the MyGrand menu$")
	public void As_a_user_Click_on_the_MyGrand_menu() throws Throwable {
		declarationPage.clickOnMyGrantButton();

	}

	@And("^As a user click on the processing Tab$")
	public void As_a_user_click_on_the_processing_Tab() throws Throwable {
		declarationPage.clickOnProcessingButton();

	}

	@And("^verify the RefID$")
	public void verify_the_RefID() throws Throwable {
		declarationPage.VerifyRefID();

	}

}
