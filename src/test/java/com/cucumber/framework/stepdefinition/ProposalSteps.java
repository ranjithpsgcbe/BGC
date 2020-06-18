package com.cucumber.framework.stepdefinition;

import com.cucumber.framework.PageObject.ContactPage;
import com.cucumber.framework.PageObject.ProposalPage;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.TestBase.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class ProposalSteps {

	private final Logger log = LoggerHelper.getLogger(ContactPage.class);
	ProposalPage proposalPage;
	
	@When("^As a user enter Project Title$")
	public void As_a_user_enter_Project_Title() throws Throwable {
		proposalPage = new ProposalPage(TestBase.driver);
		proposalPage.enterProjectTitile();

	}

	@And("^As a user enter Start Date$")
	public void As_a_user_enter_Start_Date() throws Throwable {
		proposalPage.enterStartDate();

	}

	@And("^As a user enter End Date$")
	public void As_a_user_enter_End_Date() throws Throwable {
		proposalPage.enterEndDate();

	}

	@And("^As a user enter Project Description$")
	public void As_a_user_enter_Project_Description() throws Throwable {
		proposalPage.enterProjectDescription();

	}

	@And("^As a user select Activity from dropdownbox$")
	public void As_a_user_select_Activity_from_dropdownbox() throws Throwable {
		proposalPage.selectactivitydropdown();

	}

	@And("^As a user check the Target Market checkBox$")
	public void As_a_user_check_the_Target_Market_checkBox() throws Throwable {
		proposalPage.selectMarketdropdown();

	}

	@And("^As a user click on the target market outside Singapore$")
	public void As_a_user_click_on_the_target_market_outside_Singapore() throws Throwable {
		proposalPage.checkOutsideMarket();

	}


}
