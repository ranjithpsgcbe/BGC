package com.cucumber.framework.PageObject;

import java.io.IOException;
import java.util.List;

import com.aventstack.extentreports.Status;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.genericHelper.GenericHelper;
import com.cucumber.listener.Reporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.Wait.WaitHelper;
import org.testng.Assert;

public class ContactPage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(ContactPage.class);
	WaitHelper waitHelper;
	GenericHelper genericHelper;

	@FindBy(id = "react-contact_info-name")
	WebElement NameText;

	@FindBy(id = "react-contact_info-designation")
	WebElement JobTitleText;

	@FindBy(id = "react-contact_info-phone")
	WebElement ContactNumText;

	@FindBy(id = "react-contact_info-primary_email")
	WebElement EmailText;

	@FindBy(id = "react-contact_info-correspondence_address-copied")
	WebElement MailingAddressCheckBox;

	@FindBy(id = "react-contact_info-copied")
	WebElement SameContactPersonCheckBox;

	@FindBy(xpath = "//*[@id='react-contact_info-offeree_name']")
	WebElement getName;

	@FindBy(xpath = "//*[@id='react-contact_info-offeree_designation']")
	WebElement getJobTitle;

	@FindBy(xpath = "//*[@id='react-contact_info-offeree_email']")
	WebElement getEmail;


	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		genericHelper = new GenericHelper(driver);
		//waitHelper.waitForElement(driver, catalogTextObj,ObjectRepo.reader.getExplicitWait());
	}

	public void entername(String name) {
		waitHelper.waitForElement(driver, NameText, ObjectRepo.reader.getExplicitWait());
		log.info("enter name");
		NameText.sendKeys(name);
		Reporter.addStepLog(Status.PASS+" Enter name :"+ name);

	}

	public void enterJobTitile(String jobtitle) {
		log.info("enter Job Titile");
		JobTitleText.sendKeys(jobtitle);
		Reporter.addStepLog(Status.PASS+" Enter jobtitle :"+ jobtitle);

	}

	public void enterContactNumber(String number) {
		log.info("enter Contact Number");
		ContactNumText.sendKeys(number);
		Reporter.addStepLog(Status.PASS+" Enter number :"+ number);

	}

	public void enterEmailText(String email) {
		log.info("enter Email Text");
		EmailText.sendKeys(email);
		Reporter.addStepLog(Status.PASS+" Enter email :"+ email);

	}

	public void checktheMailingAddress() {
		log.info("check on the MailingAddress");
		MailingAddressCheckBox.click();
		Reporter.addStepLog(Status.PASS+" Click on the MailingAddress");

	}

	public void checktheSameContactPerson() throws IOException {
		log.info("check on the SameContactPerson");
		SameContactPersonCheckBox.click();
		Reporter.addStepLog(Status.PASS+" check on the SameContactPerson");
		genericHelper.takeScreenShot("ContactPage");
	}

	public void VerifyPrepopulatedAddress(String name, String jobtitle, String email) {

		String name1 = getName.getAttribute("value");
		String job = getJobTitle.getAttribute("value");
		String mailid = getEmail.getAttribute("value");
		log.info("VerifyText+++++" + name1 + "+++++" + job + "+++++" + mailid);
		try {
			Assert.assertEquals(name, name1);
			Reporter.addStepLog(Status.PASS + " Expected :"+name1+"Actual :"+name);
		}catch (Exception e){
			Reporter.addStepLog(Status.FAIL + " Expected :"+name1+"Actual :"+name);
		}
		try {
			Assert.assertEquals(jobtitle, job);
			Reporter.addStepLog(Status.PASS + " Expected :"+job+"Actual :"+jobtitle);
		}catch (Exception e){
			Reporter.addStepLog(Status.FAIL + " Expected :"+job+"Actual :"+jobtitle);
		}
		try {
			Assert.assertEquals(email, mailid);
			Reporter.addStepLog(Status.PASS + " Expected :"+mailid+"Actual :"+email);
		}catch (Exception e){
			Reporter.addStepLog(Status.FAIL + " Expected :"+mailid+"Actual :"+email);
		}



	}

}

