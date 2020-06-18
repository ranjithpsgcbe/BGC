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

public class CostPage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(CostPage.class);
	WaitHelper waitHelper;
	GenericHelper genericHelper;

	@FindBy(xpath = "//*[@id='react-project_cost-office_rentals-accordion-header']")
	WebElement OficeRentalButton;

	@FindBy(id = "react-project_cost-office_rentals-add-item")
	WebElement AddNewItemButton;

	@FindBy(id = "react-project_cost-office_rentals-0-description")
	WebElement DescriptionText;

	@FindBy(id = "react-project_cost-office_rentals-0-rental_duration")
	WebElement RentalText;

	@FindBy(id = "react-project_cost-office_rentals-0-amount_in_billing_currency")
	WebElement BillingCurrenctText;


	public CostPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		genericHelper = new GenericHelper(driver);

	}

	public void clickontheOficeRentalButton() {
		log.info("click On Rental Button");
		waitHelper.waitForElement(driver, OficeRentalButton, ObjectRepo.reader.getExplicitWait());

		OficeRentalButton.click();
		Reporter.addStepLog(Status.PASS+"  click On Rental Button");

	}

	public void clickOntheAddNewItemButton() {
		log.info("click On AddNewItem Button");
		AddNewItemButton.click();
		Reporter.addStepLog(Status.PASS+"  click On AddNewItem Button");

	}

	public void enterDescription() {
		log.info("enter Description");
		DescriptionText.sendKeys(ObjectRepo.reader.getCost_DescriptionText());
		Reporter.addStepLog(Status.PASS+"  click On AddNewItem Button");

	}

	public void enterRentalduration() {
		log.info("enter Rental duration");
		RentalText.sendKeys(ObjectRepo.reader.getCost_RentalText());
		Reporter.addStepLog(Status.PASS+"  Enter Rental duration");

	}

	public void enterBillingCurrenct() throws IOException {
		log.info("enter Billing Currenct");
		BillingCurrenctText.sendKeys(ObjectRepo.reader.getCost_BillingCurrenctText());
		Reporter.addStepLog(Status.PASS+"  Enter Billing Currenct");
		genericHelper.takeScreenShot("CostPage");

	}

}

