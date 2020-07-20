package com.cucumber.framework.stepdefinition;

import com.cucumber.framework.PageObject.ContactPage;
import com.cucumber.framework.helper.LoggerHelper;
import com.cucumber.framework.helper.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class ContactSteps {

	private final Logger log = LoggerHelper.getLogger(ContactPage.class);
	ContactPage contactPage;
	
	@When("^As a user enter name \"([^\"]*)\"$")
	public void As_a_user_enter_name(String name) throws Throwable {
		contactPage = new ContactPage(TestBase.driver);
		contactPage.entername(name);

	}

	@And("^As a user enter jobtitle \"([^\"]*)\"$")
	public void As_a_user_enter_jobtitle(String jobtitle) throws Throwable {
		contactPage.enterJobTitile(jobtitle);

	}

	@And("^As a user enter number \"([^\"]*)\"$")
	public void As_a_user_enter_number(String number) throws Throwable {
		contactPage.enterContactNumber(number);

	}

	@And("^As a user enter email \"([^\"]*)\"$")
	public void As_a_user_enter_email(String email) throws Throwable {
		contactPage.enterEmailText(email);

	}

	@And("^As a user check the Mailing address checkBox$")
	public void As_a_user_check_the_Mailing_address_checkBox() throws Throwable {
		contactPage.checktheMailingAddress();

	}

	@And("^As a user check the same as contact person checkBox$")
	public void As_a_user_check_the_same_as_contact_person_checkBox() throws Throwable {
		contactPage.checktheSameContactPerson();

	}
	@And("^Verify the main contact details are prepopulated in Letter offer addressee \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void Verify_the_main_contact_details_are_prepopulated_in_address(String name, String jobtitle, String email ) throws Throwable {
		contactPage.VerifyPrepopulatedAddress(name,jobtitle,email);

	}


}
