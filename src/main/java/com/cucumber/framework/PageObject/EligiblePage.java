package com.cucumber.framework.PageObject;

import com.aventstack.extentreports.Status;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.Wait.WaitHelper;
import com.cucumber.framework.helper.genericHelper.GenericHelper;
import com.cucumber.listener.Reporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class EligiblePage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(EligiblePage.class);
	WaitHelper waitHelper;

	GenericHelper genericHelper;
	


	
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

	}
	
	public void ApplicantInSG(String value1){
		waitHelper.waitForElement(driver, ApplicantInSG_Yes, ObjectRepo.reader.getExplicitWait());
		log.info("Is the applicant registered in Singapore?  :"+value1);
		if (value1.equalsIgnoreCase("Yes")){
			ApplicantInSG_Yes.click();
			Reporter.addStepLog(Status.PASS+"Is the applicant registered in Singapore?  :"+value1);
		}else if(value1.equalsIgnoreCase("No")){
			waitHelper.waitForElement(driver, ApplicantInSG_No, ObjectRepo.reader.getExplicitWait());
			log.info("Is the applicant registered in Singapore?  :"+value1);
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
		Thread.sleep(500);
		//browserHelper.getWindowHandlens();
		String parentHandle = driver.getWindowHandle();
		WarningMessage.click();
		Reporter.addStepLog(Status.PASS+"Click on the WarningMessage");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		Thread.sleep(500);
		String ActualURL= driver.getCurrentUrl();
		genericHelper.takeScreenShot("NewWindow");
		driver.close(); // close newly opened window when done with it
		Reporter.addStepLog(Status.PASS+"Current Window Closed");
		driver.switchTo().window(parentHandle);
		try {
			Assert.assertEquals(ActualURL, "https://www.smeportal.sg/content/smeportal/en/moneymatters.html#saText");
			Reporter.addStepLog(Status.PASS+"Expected :"+"https://www.smeportal.sg/content/smeportal/en/moneymatters.html#saText"+"  Actual :"+ActualURL);

		}catch (Exception e){
			Reporter.addStepLog(Status.FAIL+"Expected :"+"https://www.smeportal.sg/content/smeportal/en/moneymatters.html#saText"+"  Actual :"+ActualURL);
		}
	}




}
