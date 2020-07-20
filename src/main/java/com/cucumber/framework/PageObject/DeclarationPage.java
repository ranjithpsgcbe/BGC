package com.cucumber.framework.PageObject;

import com.aventstack.extentreports.Status;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.LoggerHelper;
import com.cucumber.framework.helper.WaitHelper;
import com.cucumber.framework.helper.GenericHelper;
import com.cucumber.listener.Reporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class DeclarationPage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(DeclarationPage.class);
	WaitHelper waitHelper;
	GenericHelper genericHelper;

	public String Refid;

	@FindBy(id="react-declaration-criminal_liability_check-false")
	WebElement Declare1;

	@FindBy(id="react-declaration-civil_proceeding_check-false")
	WebElement Declare2;

	@FindBy(id="react-declaration-insolvency_proceeding_check-false")
	WebElement Declare3;

	@FindBy(id="react-declaration-project_incentives_check-false")
	WebElement Declare4;

	@FindBy(id="react-declaration-other_incentives_check-false")
	WebElement Declare5;

	@FindBy(id="react-declaration-project_commence_check-false")
	WebElement Declare6;

	@FindBy(id="react-declaration-related_party_check-false")
	WebElement Declare7;

	@FindBy(id="react-declaration-covid_safe_check-true")
	WebElement Declare8;

	@FindBy(id="react-declaration-covid_safe_ques_check-true")
	WebElement Declare9;

	@FindBy(id="react-declaration-consent_acknowledgement_check")
	WebElement acknowledgement;

	@FindBy(id="review-btn")
	WebElement ReviewButton;

	@FindBy(id="react-declaration-info_truthfulness_check")
	WebElement truthfulness_check;

	@FindBy(id="submit-btn")
	WebElement SubmitButton;

	@FindBy(xpath="//div[@id='js-app']/div/div[2]/div[2]/div/div/div/section/div[2]/div[2]/table/tbody/tr/td[2]")
	WebElement getRefID_submit;

	@FindBy(xpath="//a[contains(text(),'My Grants')]")
	WebElement MyGrantButton;

	@FindBy(xpath="//a[contains(@href, '#processing')]")
	WebElement ProcessingButton;

	@FindBy(css="#db-apps-processing > tbody > tr:nth-child(1) > td:nth-child(1)")
	WebElement getRefID_Processing;

	@FindBy(css=".active > .menu-text")
	WebElement ActiveTab;

	@FindBy(xpath="//span[@class='label label-error']")
	WebElement ErrorCount;

	@FindBy(id="react-contact_info-offeree_email-alert")
	WebElement ErrorMessage;





	public DeclarationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		genericHelper = new GenericHelper(driver);
		}

	public void selectDeclare(){
		waitHelper.waitForElement(driver, Declare1, ObjectRepo.reader.getExplicitWait());
		log.info("select multiple Declare Button");
		Declare1.click();
		Reporter.addStepLog(Status.PASS+"  Declare1 : NO" );
		Declare2.click();
		Reporter.addStepLog(Status.PASS+"  Declare2 : NO" );
		Declare3.click();
		Reporter.addStepLog(Status.PASS+"  Declare3 : NO" );
		Declare4.click();
		Reporter.addStepLog(Status.PASS+"  Declare4 : NO" );
		Declare5.click();
		Reporter.addStepLog(Status.PASS+"  Declare5 : NO" );
		Declare6.click();
		Reporter.addStepLog(Status.PASS+"  Declare6 : NO" );
		Declare7.click();
		Reporter.addStepLog(Status.PASS+"  Declare7 : NO" );
		Declare8.click();
		Reporter.addStepLog(Status.PASS+"  Declare8 : Yes" );
		Declare9.click();
		Reporter.addStepLog(Status.PASS+"  Declare9 : Yes" );
	}

	public void clickOntheacknowledgement() throws IOException {
		log.info("click On acknowledgement Button");
		acknowledgement.click();
		Reporter.addStepLog(Status.PASS+"  click On acknowledgement Button" );
		genericHelper.takeScreenShot("DeclarePage");

	}

	public void clickOntheReviewButton() {
		log.info("click On Review Button");

		ReviewButton.click();
		Reporter.addStepLog(Status.PASS+"  click On Review Button" );


	}

	public void verifymandatoryInputMissing() throws InterruptedException {
		log.info("verify mandatory Input Missing");
		Thread.sleep(2000);
		String activetab = genericHelper.readValueFromElement(ActiveTab);
		String counterror = genericHelper.readValueFromElement(ErrorCount);
		String Errormsg = genericHelper.readValueFromElement(ErrorMessage);

		log.info("Verify  "+activetab+"++++"+counterror+"++++"+Errormsg);
		Reporter.addStepLog(Status.PASS+"  Error Active Tab : "+activetab );
		Reporter.addStepLog(Status.PASS+"  Error Count : "+ counterror );
		try {
			Assert.assertEquals(Errormsg, "Oops, that doesn't seem like a valid email address");
			Reporter.addStepLog(Status.PASS+"  Expected : Oops, that doesn't seem like a valid email address"+"Actual :"+Errormsg );
		}catch (Exception e){
			Reporter.addStepLog(Status.FAIL+"  Expected : Oops, that doesn't seem like a valid email address"+"Actual :"+Errormsg );
			}
	}


	public void clickOnruthfulness_check(){
		log.info("click On truthfulness check");
		truthfulness_check.click();
		Reporter.addStepLog(Status.PASS+"  click On truthfulness check" );

	}

	public void clickOnSubmitButton() throws IOException {
		log.info("click On Submit Button");
		SubmitButton.click();
		Reporter.addStepLog(Status.PASS+"  click On Submit Button" );
		 Refid = genericHelper.readValueFromElement(getRefID_submit);
		genericHelper.takeScreenShot("SubmitPage");

	}

	public void clickOnMyGrantButton() throws IOException {
		log.info("click On MyGrant Button");
		waitHelper.waitForElement(driver, MyGrantButton,15000);
		MyGrantButton.click();
		Reporter.addStepLog(Status.PASS+"  click On MyGrant Button" );
		genericHelper.takeScreenShot("MyGrantPage");
	}

	public void clickOnProcessingButton(){
		log.info("click On Processing Button");
		waitHelper.waitForElement(driver, ObjectRepo.reader.getExplicitWait(), ProcessingButton);
		ProcessingButton.click();
		Reporter.addStepLog(Status.PASS+"  click On Processing Button" );


	}

	public void VerifyRefID() throws InterruptedException {
		log.info("Verify RefID"+Refid);
		waitHelper.waitForElement(driver, getRefID_Processing, ObjectRepo.reader.getExplicitWait());
		WebElement element = getRefID_Processing;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		String Refid_Processing = genericHelper.readValueFromElement(getRefID_Processing);
		try {
			Assert.assertEquals(Refid, Refid_Processing);
			Reporter.addStepLog(Status.PASS + "  Expected : " +Refid_Processing + "Actual :" + Refid);
		}catch (Exception e){
			Reporter.addStepLog(Status.FAIL + "  Expected : " +Refid_Processing + "Actual :" + Refid);
		}

	}

}
