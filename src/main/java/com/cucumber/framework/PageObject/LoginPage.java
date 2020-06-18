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

import java.io.IOException;


public class LoginPage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	GenericHelper genericHelper;

	@FindBy(xpath = "//*[@id='login-button']/span")
	WebElement Login_btn;

	@FindBy(name = "CPUID")
	WebElement NRIC_txt;

	@FindBy(name = "CPUID_FullName")
	WebElement Name_txt;

	@FindBy(name = "CPEntID")
	WebElement UEN_txt;

	@FindBy(name = "CPRole")
	WebElement Role_dropdown;

	@FindBy(css = ":nth-child(8) > button")
	WebElement user_login_btn;

	@FindBy(xpath = "//*[@id='dashboard-menubox-app-apply-grant']/section/div/div[2]/h4")
	WebElement New_Grand_btn;

	@FindBy(xpath = "//*[@id='grant-wizard']/div[1]/div/div[3]/div[3]/div/label/div/div")
	WebElement Selectot_btn;

	@FindBy(xpath = "//*[@id='grant-wizard']/div[1]/div/div/div[1]/div/label/div/span")
	WebElement DevelopmentAreaButton;

	@FindBy(xpath = "//*[@id='grant-wizard']/div[1]/div/div/div[1]/div/label/div/span")
	WebElement FunctionalAreaButton;

	@FindBy(id = "go-to-grant")
	WebElement ApplyButton;

	@FindBy(id = "keyPage-form-button")
	WebElement ProceedButton;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		genericHelper = new GenericHelper(driver);

	}

	public void enteruserdcredential(String nric, String name, String uen) throws IOException {
		log.info("clicked on Login Button...");
		Login_btn.click();
		Reporter.addStepLog(Status.PASS+"  click On Login Button" );
		log.info("entering nric...." + nric);
		this.NRIC_txt.clear();
		this.NRIC_txt.sendKeys(nric);
		Reporter.addStepLog(Status.PASS+"  entering nric...." + nric );
		log.info("entering name...." + name);
		this.Name_txt.clear();
		this.Name_txt.sendKeys(name);
		Reporter.addStepLog(Status.PASS+"  entering name...." + name );
		log.info("entering uen...." + uen);
		this.UEN_txt.clear();
		this.UEN_txt.sendKeys(uen);
		Reporter.addStepLog(Status.PASS+"  entering uen...." + uen );

	}

	public void selectRole() throws IOException {
		//log.info("Select Role.."+email);
		//Role_dropdown.sendKeys("Acceptor");

	}

	public void clickOnLoginButton() throws IOException {
		log.info("click On Login Button");
		user_login_btn.click();
		Reporter.addStepLog(Status.PASS+"  click On Login Button" );
		genericHelper.takeScreenShot("UserEnterDetailsPage");
	}

	public void clickOnNewGrandButton() throws IOException {
		log.info("click On NewGrand Button");
		waitHelper.waitForElement(driver, New_Grand_btn, 15000);
		genericHelper.takeScreenShot("MyGrantPage");
		New_Grand_btn.click();
		Reporter.addStepLog(Status.PASS+"  click On NewGrand Button" );
		genericHelper.takeScreenShot("Selector");

	}

	public void clickOnSelectorButton() {
		log.info("click On Selector Button");
		waitHelper.waitForElement(driver, Selectot_btn, ObjectRepo.reader.getExplicitWait());
		Selectot_btn.click();
		Reporter.addStepLog(Status.PASS+"  click On Selector Button" );

	}

	public void SelectDevelopmentAreaButton() throws IOException {
		log.info("click On DevelopmentArea Button");
		genericHelper.takeScreenShot("DevelopmentAreaButton");
		DevelopmentAreaButton.click();
		Reporter.addStepLog(Status.PASS+"  click On DevelopmentArea Button" );

	}

	public void SelectFuntionalAreaButton() throws IOException {
		log.info("click On Functional Button");
		genericHelper.takeScreenShot("FunctionalAreaButton");
		FunctionalAreaButton.click();
		Reporter.addStepLog(Status.PASS+"  click On Functional Button" );
		genericHelper.takeScreenShot("Selector");

	}

	public void clickOnApplyButton() {
		log.info("click On Apply Button");
		ApplyButton.click();
		Reporter.addStepLog(Status.PASS+"  click On Apply Button" );
	}

	public void clickOnProceedButton() throws IOException {
		log.info("click On Proceed Button");
		genericHelper.takeScreenShot("ProceedingPage");
		ProceedButton.click();
		Reporter.addStepLog(Status.PASS+"  click On Proceed Button" );
	}


}