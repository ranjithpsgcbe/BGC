package com.cucumber.framework.stepdefinition;

import com.cucumber.framework.PageObject.EligiblePage;
import com.cucumber.framework.helper.LoggerHelper;
import com.cucumber.framework.helper.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

public class ElegibleSteps {
	private final Logger log = LoggerHelper.getLogger(ElegibleSteps.class);
	EligiblePage eligiblePage;

	@And("^As a user select the applicant is registered in singapore \"([^\"]*)\"$")
	public void asAUserSelectTheApplicantIsRegisteredInSingaporeValue(String value1) {
		eligiblePage = new EligiblePage(TestBase.driver);
		eligiblePage.ApplicantInSG(value1);
	}

	@And("^As a user select the applicant group sales turnover less than or equal to SG100m \"([^\"]*)\"$")
	public void applicant_group_sales_turnover_less_than_or_equal_to_SG100m(String value2) throws Throwable {
		eligiblePage.TurnOverLessOrEq100(value2);

	}

	@And("^As a user select the applicant have at lest 30 percentage local equity \"([^\"]*)\"$")
	public void As_a_user_select_the_applicant_have_at_lest_30_percentage_local_equity(String value3) throws Throwable {
		eligiblePage.AplicantAtLeast30Percentage(value3);

	}

	@And("^As a user select the target market that applying for a new market \"([^\"]*)\"$")
	public void As_a_user_select_the_target_market_that_applying_for_a_new_market(String value4) throws Throwable {
		eligiblePage.ApplyNewMarket(value4);

	}

	@And("^As a user select the applicant has not started work and payment and agreement \"([^\"]*)\"$")
	public void As_a_user_select_the_applicant_has_not_started_work_and_payment_and_agreement(String value5) throws Throwable {
		eligiblePage.TrueFOrTHisProject(value5);

	}

	@And("^As a user click on the Save Button$")
	public void As_a_user_click_on_the_Save_Button() throws Throwable {
		eligiblePage.ClickOnSaveButton();

	}

	@And("^As a user click on the Next Button$")
	public void As_a_user_click_on_the_Next_Button() throws Throwable {
		eligiblePage.ClickOnNextButton();

	}

	@And("^As a user click on the warning Message$")
	public void As_a_user_click_on_the_warning_Message() throws Throwable {
		eligiblePage.ClickOnWarningMessage();

	}

	@Then("^Verify the InputValue \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void Verify_the_InputValue(String Value1,String Value2,String Value3,String Value4,String Value5) throws Throwable {
		eligiblePage.VerifyInputValue(Value1,Value2,Value3,Value4,Value5);

	}


}
