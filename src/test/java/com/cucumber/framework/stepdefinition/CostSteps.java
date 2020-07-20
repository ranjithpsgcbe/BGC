package com.cucumber.framework.stepdefinition;

import com.cucumber.framework.PageObject.CostPage;
import com.cucumber.framework.helper.LoggerHelper;
import com.cucumber.framework.helper.TestBase;
import cucumber.api.java.en.And;
import org.apache.log4j.Logger;

public class CostSteps {
	private final Logger log = LoggerHelper.getLogger(CostSteps.class);
	CostPage costPage;

	@And("^As a user click on the office rental button$")
	public void As_a_user_click_on_the_office_rental_button() throws InterruptedException {
		costPage = new CostPage(TestBase.driver);
		costPage.clickontheOficeRentalButton();
	}

	@And("^As a user click on the Add new Item Button$")
	public void As_a_user_click_on_the_Add_new_Item_Button() throws Throwable {

		costPage.clickOntheAddNewItemButton();
	}

	@And("^As a user enter the Description$")
	public void As_a_user_enter_the_Description() throws Throwable {
		costPage.enterDescription();

	}

	@And("^As a user enter the rental duration$")
	public void As_a_user_enter_the_rental_duration() throws Throwable {
		costPage.enterRentalduration();

	}

	@And("^As a user enter the Estimate cost in billing currency$")
	public void As_a_user_enter_the_Estimate_cost_in_billing_currency() throws Throwable {
		costPage.enterBillingCurrenct();

	}

}
