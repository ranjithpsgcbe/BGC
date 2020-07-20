package com.cucumber.framework.PageObject;

import com.aventstack.extentreports.Status;
import com.cucumber.framework.configreader.ObjectRepo;


import com.cucumber.framework.helper.*;
import com.cucumber.listener.Reporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class EligiblePage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(EligiblePage.class);
	WaitHelper waitHelper;

	GenericHelper genericHelper;
	BrowserHelper browserHelper;
	AlertHelper alertHelper;





	@FindBy(css="input[id=react-eligibility-sg_registered_check-true]")
	public WebElement ApplicantInSG_Yes;

	@FindBy(css="input[id=react-eligibility-sg_registered_check-false]")
	public WebElement ApplicantInSG_No;


	@FindBy(css="input[id=react-eligibility-turnover_check-true]")
	public WebElement TurnOverLessOrEq100_Yes;

	@FindBy(css="input[id=react-eligibility-turnover_check-false]")
	public WebElement TurnOverLessOrEq100_No;


	@FindBy(css="input[id=react-eligibility-global_hq_check-true]")
	public WebElement AplicantAtLeast30Percentage_Yes;

	@FindBy(css="input[id=react-eligibility-global_hq_check-false]")
	public WebElement AplicantAtLeast30Percentage_No;


	@FindBy(css="input[id=react-eligibility-new_target_market_check-true]")
	WebElement ApplyNewMarket_Yes;

	@FindBy(css="input[id=react-eligibility-new_target_market_check-false]")
	WebElement ApplyNewMarket_No;


	@FindBy(css="input[id=react-eligibility-started_project_check-true]")
	WebElement TrueFOrTHisProject_Yes;

	@FindBy(css="input[id=react-eligibility-started_project_check-false]")
	WebElement TrueFOrTHisProject_No;

	@FindBy(id="next-btn")
	WebElement NextButton;

	@FindBy(id="save-btn")
	WebElement SaveButton;

	@FindBy(css=".eligibility-advice > span:nth-child(1) > a:nth-child(1)")
	WebElement WarningMessage;





	public EligiblePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		genericHelper = new GenericHelper(driver);
		browserHelper = new BrowserHelper(driver);
		alertHelper = new AlertHelper(driver);


	}

	public void ApplicantInSG(String value1){
		waitHelper.waitForElement(driver, ApplicantInSG_Yes, ObjectRepo.reader.getExplicitWait());
		log.info("Is the applicant registered in Singapore?  :"+value1);
		if (value1.equalsIgnoreCase("Yes")){
			ApplicantInSG_Yes.click();
			ApplicantInSG_Yes.click();
			Reporter.addStepLog(Status.PASS+"Is the applicant registered in Singapore?  :"+value1);
		}else if(value1.equalsIgnoreCase("No")){
			waitHelper.waitForElement(driver, ApplicantInSG_No, ObjectRepo.reader.getExplicitWait());
			log.info("Is the applicant registered in Singapore?  :"+value1);
			ApplicantInSG_No.click();
			ApplicantInSG_No.click();
			Reporter.addStepLog(Status.PASS+"Is the applicant registered in Singapore?  :"+value1);

		}
	}

	public void TurnOverLessOrEq100(String value2){
		log.info("Is the applicant's group sales turnover less than or equal to S$100m :"+value2);
		if (value2.equalsIgnoreCase("Yes")){
			TurnOverLessOrEq100_Yes.click();
			Reporter.addStepLog(Status.PASS+"Is the applicant's group sales turnover less than or equal to S$100m :"+value2);
		}else if(value2.equalsIgnoreCase("No")){
			log.info("Is the applicant's group sales turnover less than or equal to S$100m :"+value2);
			TurnOverLessOrEq100_No.click();
			Reporter.addStepLog(Status.PASS+"Is the applicant's group sales turnover less than or equal to S$100m :"+value2);

		}
	}

	public void AplicantAtLeast30Percentage(String value3){
		log.info("Does the applicant have at least 30% local equity?   :"+value3);
		if (value3.equalsIgnoreCase("Yes")){
			AplicantAtLeast30Percentage_Yes.click();
			Reporter.addStepLog(Status.PASS+"Does the applicant have at least 30% local equity?   :"+value3);
		}else if(value3.equalsIgnoreCase("No")){
			log.info("Does the applicant have at least 30% local equity?   :"+value3);
			AplicantAtLeast30Percentage_No.click();
			Reporter.addStepLog(Status.PASS+"Does the applicant have at least 30% local equity?   :"+value3);
		}
	}

	public void ApplyNewMarket(String value4){
		log.info("Is the target market that you are applying for a new market?  :"+value4);
		if (value4.equalsIgnoreCase("Yes")){
			ApplyNewMarket_Yes.click();
			Reporter.addStepLog(Status.PASS+"Click on the MailingAddress");
		}else if(value4.equalsIgnoreCase("No")){
			log.info("Is the target market that you are applying for a new market?  :"+value4);
			ApplyNewMarket_No.click();
			Reporter.addStepLog(Status.PASS+"Click on the MailingAddress");
		}
	}

	public void TrueFOrTHisProject(String value5) throws IOException {
		log.info("the applicant has not started work and payment and agreement  :"+value5);
		if (value5.equalsIgnoreCase("Yes")){
			TrueFOrTHisProject_Yes.click();
			Reporter.addStepLog(Status.PASS+"the applicant has not started work and payment and agreement  :"+value5);
		}else if(value5.equalsIgnoreCase("No")){
			log.info("the applicant has not started work and payment and agreement  :"+value5);
			TrueFOrTHisProject_No.click();
			Reporter.addStepLog(Status.PASS+"the applicant has not started work and payment and agreement  :"+value5);
		}
		genericHelper.takeScreenShot("EligiblePage");
	}

	public void ClickOnSaveButton(){
		log.info("Click on SAve Button");
		SaveButton.click();
		Reporter.addStepLog(Status.PASS+"Click on the SaveButton");

	}

	public void ClickOnNextButton(){
		log.info("Click on Next Button");
		NextButton.click();
		Reporter.addStepLog(Status.PASS+"Click on the NextButton");

	}

	public void ClickOnWarningMessage() throws InterruptedException, IOException {
		log.info("Click on Warning message and verify");
		waitHelper.waitForElement(driver, ObjectRepo.reader.getExplicitWait(), WarningMessage);
		browserHelper.getWindowHandlens();
		WarningMessage.click();
		browserHelper.SwitchToWindow(0);
		String ActualURL= driver.getCurrentUrl();
		browserHelper.switchToParentWithChildClose();
		Assert.assertEquals(ActualURL, ObjectRepo.reader.getExpectedUrl());
		Reporter.addStepLog(Status.PASS+"Expected :"+ObjectRepo.reader.getExpectedUrl()+"  Actual :"+ActualURL);

	}

	public void VerifyInputValue(String Value1,String Value2,String Value3,String Value4,String Value5){
		log.info("Click on Next Button");

		try {
			browserHelper.refresh();
		} catch (UnhandledAlertException f) {
			try {
				alertHelper.AcceptAlertIfPresent();
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
			}
		}
		if (Value1.equalsIgnoreCase("Yes")){
			genericHelper.ValidateRadioButton(ApplicantInSG_Yes);
			Reporter.addStepLog(Status.PASS+"Radoi Button is selected :"+Value1);
		}else if(Value1.equalsIgnoreCase("No")){
			genericHelper.ValidateRadioButton(ApplicantInSG_No);
			Reporter.addStepLog(Status.PASS+"Radoi Button is selected :"+Value1);
		}
		if (Value2.equalsIgnoreCase("Yes")){
			genericHelper.ValidateRadioButton(TurnOverLessOrEq100_Yes);
			Reporter.addStepLog(Status.PASS+"Radoi Button is selected :"+Value2);
		}else if(Value2.equalsIgnoreCase("No")){
			genericHelper.ValidateRadioButton(TurnOverLessOrEq100_No);
			Reporter.addStepLog(Status.PASS+"Radoi Button is selected :"+Value2);
		}
		if (Value3.equalsIgnoreCase("Yes")){
			genericHelper.ValidateRadioButton(AplicantAtLeast30Percentage_Yes);
			Reporter.addStepLog(Status.PASS+"Radoi Button is selected :"+Value3);
		}else if(Value3.equalsIgnoreCase("No")){
			genericHelper.ValidateRadioButton(AplicantAtLeast30Percentage_No);
			Reporter.addStepLog(Status.PASS+"Radoi Button is selected :"+Value3);
		}
		if (Value4.equalsIgnoreCase("Yes")){
			genericHelper.ValidateRadioButton(ApplyNewMarket_Yes);
			Reporter.addStepLog(Status.PASS+"Radoi Button is selected :"+Value4);
		}else if(Value4.equalsIgnoreCase("No")){
			genericHelper.ValidateRadioButton(ApplyNewMarket_No);
			Reporter.addStepLog(Status.PASS+"Radoi Button is selected :"+Value4);
		}
		if (Value5.equalsIgnoreCase("Yes")){
			genericHelper.ValidateRadioButton(TrueFOrTHisProject_Yes);
			Reporter.addStepLog(Status.PASS+"Radoi Button is selected :"+Value5);
		}else if(Value5.equalsIgnoreCase("No")){
			genericHelper.ValidateRadioButton(TrueFOrTHisProject_No);
			Reporter.addStepLog(Status.PASS+"Radoi Button is selected :"+Value5);
		}

	}




}
