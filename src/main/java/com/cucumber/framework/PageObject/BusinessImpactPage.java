package com.cucumber.framework.PageObject;

import com.aventstack.extentreports.Status;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.GenericHelper;
import com.cucumber.framework.helper.LoggerHelper;
import com.cucumber.framework.helper.WaitHelper;
import com.cucumber.listener.Reporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BusinessImpactPage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(BusinessImpactPage.class);
	WaitHelper waitHelper;

	GenericHelper genericHelper;

	@FindBy(id="react-project_impact-fy_end_date_0")
	WebElement FYENDDateText;

	@FindBy(id="react-project_impact-overseas_sales_0")
	WebElement OverseaseSaleText1;

	@FindBy(id="react-project_impact-overseas_sales_1")
	WebElement OverseaseSaleText2;

	@FindBy(id="react-project_impact-overseas_sales_2")
	WebElement OverseaseSaleText3;

	@FindBy(id="react-project_impact-overseas_sales_3")
	WebElement OverseaseSaleText4;

	@FindBy(id="react-project_impact-overseas_investments_0")
	WebElement OverseaseInvestText1;

	@FindBy(id="react-project_impact-overseas_investments_1")
	WebElement OverseaseInvestText2;

	@FindBy(id="react-project_impact-overseas_investments_2")
	WebElement OverseaseInvestText3;

	@FindBy(id="react-project_impact-overseas_investments_3")
	WebElement OverseaseInvestText4;

	@FindBy(id="react-project_impact-rationale_remarks")
	WebElement RationalProjectionText;

	@FindBy(id="react-project_impact-benefits_remarks")
	WebElement BenifitsText;


	public BusinessImpactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		genericHelper = new GenericHelper(driver);

	}

	public void enteFYENDDateText(){
		waitHelper.waitForElement(driver, FYENDDateText, ObjectRepo.reader.getExplicitWait());
		log.info("enter FYENDDateText");
		FYENDDateText.sendKeys(ObjectRepo.reader.getFYENDDateText());
		Reporter.addStepLog(Status.PASS+" Enter FYENDDateText :"+ObjectRepo.reader.getFYENDDateText());

	}

	public void enterOverseaseSaleText(){
		log.info("enter Oversease Sale Text");
		OverseaseSaleText1.sendKeys(ObjectRepo.reader.getOverseaseSaleText1());
		Reporter.addStepLog(Status.PASS+" Enter OverseaseSaleText1 :"+ObjectRepo.reader.getOverseaseSaleText1());
		OverseaseSaleText2.sendKeys(ObjectRepo.reader.getOverseaseSaleText2());
		Reporter.addStepLog(Status.PASS+" Enter OverseaseSaleText2 :"+ObjectRepo.reader.getOverseaseSaleText2());
		OverseaseSaleText3.sendKeys(ObjectRepo.reader.getOverseaseSaleText3());
		Reporter.addStepLog(Status.PASS+" Enter OverseaseSaleText3 :"+ObjectRepo.reader.getOverseaseSaleText3());
		OverseaseSaleText4.sendKeys(ObjectRepo.reader.getOverseaseSaleText4());
		Reporter.addStepLog(Status.PASS+" Enter OverseaseSaleTex4 :"+ObjectRepo.reader.getOverseaseSaleText4());
	}

	public void enterOverseaseInvestText(){
		log.info("enter Oversease Invest Text");
		OverseaseInvestText1.sendKeys(ObjectRepo.reader.getOverseaseInvestText1());
		Reporter.addStepLog(Status.PASS+" Enter OverseaseInvestText1 :"+ObjectRepo.reader.getOverseaseInvestText1());
		OverseaseInvestText2.sendKeys(ObjectRepo.reader.getOverseaseInvestText2());
		Reporter.addStepLog(Status.PASS+" Enter OverseaseInvestTex2 :"+ObjectRepo.reader.getOverseaseInvestText2());
		OverseaseInvestText3.sendKeys(ObjectRepo.reader.getOverseaseInvestText3());
		Reporter.addStepLog(Status.PASS+" Enter OverseaseInvestText3 :"+ObjectRepo.reader.getOverseaseInvestText3());
		OverseaseInvestText4.sendKeys(ObjectRepo.reader.getOverseaseInvestText4());
		Reporter.addStepLog(Status.PASS+" Enter OverseaseInvestText4 :"+ObjectRepo.reader.getOverseaseInvestText4());

	}

	public void enterRationalProjectionText(){
		log.info("enter Rational ProjectionText");
		RationalProjectionText.sendKeys(ObjectRepo.reader.getRationalProjectionText());
		Reporter.addStepLog(Status.PASS+" Enter RationalProjectionText :"+ObjectRepo.reader.getRationalProjectionText());

	}

	public void enterBenifitsText() throws IOException {
		log.info("enter Benifits Text");
		BenifitsText.sendKeys(ObjectRepo.reader.getBenifitsText());
		Reporter.addStepLog(Status.PASS+" Enter BenifitsText :"+ObjectRepo.reader.getBenifitsText());
		genericHelper.takeScreenShot("BusinessImpactPacge");

	}

}
