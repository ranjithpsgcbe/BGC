package com.cucumber.framework.stepdefinition;

import com.cucumber.framework.PageObject.BusinessImpactPage;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.TestBase.TestBase;
import cucumber.api.java.en.And;
import org.apache.log4j.Logger;

public class BusinessImpactSteps {
	private final Logger log = LoggerHelper.getLogger(BusinessImpactSteps.class);
	BusinessImpactPage businessImpactPage;

	@And("^As a user enter FY End Date$")
	public void As_a_user_enter_FY_End_Date() {
		businessImpactPage = new BusinessImpactPage(TestBase.driver);
		businessImpactPage.enteFYENDDateText();
	}

	@And("^As a user enter Overseas sale for Next three years$")
	public void As_a_user_enter_Overseas_sale_for_Next_three_years() throws Throwable {
		businessImpactPage.enterOverseaseSaleText();

	}

	@And("^As a user enter Overseas Investment for Next three years$")
	public void As_a_user_enter_Overseas_Investment_for_Next_three_years() throws Throwable {
		businessImpactPage.enterOverseaseInvestText();

	}

	@And("^As a user enter Rational for project$")
	public void As_a_user_enter_Rational_for_project() throws Throwable {
		businessImpactPage.enterRationalProjectionText();

	}

	@And("^As a user enter Non tangile Benifits$")
	public void As_a_user_enter_Non_tangile_Benifits() throws Throwable {
		businessImpactPage.enterBenifitsText();

	}

}
