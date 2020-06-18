package com.cucumber.framework.PageObject;

import com.aventstack.extentreports.Status;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.DropDown.DropDownHelper;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.Wait.WaitHelper;
import com.cucumber.listener.Reporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProposalPage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(ProposalPage.class);
	WaitHelper waitHelper;
	DropDownHelper dropDownHelper;

	@FindBy(id = "react-project-title")
	WebElement ProjectTitile;

	@FindBy(id = "react-project-start_date")
	WebElement StartDate;

	@FindBy(id = "react-project-end_date")
	WebElement EndDate;

	@FindBy(id = "react-project-description")
	WebElement ProjectDescription;

	@FindBy(xpath = "//*[@id='react-select-project-activity--value']/div[1]")
	WebElement Activity;
	@FindBy(css = ".Select-menu-outer")
	WebElement Dropdownvalue;
	@FindBy(css = "#react-select-project-primary_market--value > div.Select-placeholder")
	WebElement TargetMarket;


	@FindBy(css = "#react-project-is_first_time_expand-true")
	WebElement OutsideMarketCheckBox;


	public ProposalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(driver, catalogTextObj,ObjectRepo.reader.getExplicitWait());
	}

	public void enterProjectTitile() {
		waitHelper.waitForElement(driver, ProjectTitile, ObjectRepo.reader.getExplicitWait());
		log.info("enter ProjectTitile");
		ProjectTitile.sendKeys(ObjectRepo.reader.getprojectTitile());
		Reporter.addStepLog(Status.PASS+"  enter ProjectTitile :" +ObjectRepo.reader.getprojectTitile());

	}

	public void enterStartDate() {
		log.info("enter Start Date");
		StartDate.sendKeys(ObjectRepo.reader.getStardate());
		Reporter.addStepLog(Status.PASS+"  enter Start Date :" +ObjectRepo.reader.getStardate());
	}

	public void enterEndDate() {
		log.info("enter EndDate");
		EndDate.sendKeys(ObjectRepo.reader.getEndDate());
		Reporter.addStepLog(Status.PASS+"  enter EndDate Date :" +ObjectRepo.reader.getEndDate());

	}

	public void enterProjectDescription() {
		log.info("enter Project Description");
		ProjectDescription.sendKeys(ObjectRepo.reader.getProjectDescription());
		Reporter.addStepLog(Status.PASS+"  enter Project Description :" +ObjectRepo.reader.getProjectDescription());
	}

	public void selectactivitydropdown() throws InterruptedException {
		log.info("select activity dropdown");
		Activity.click();
		Thread.sleep(400);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
		Reporter.addStepLog(Status.PASS+"  select activity dropdown");

	}

	public void selectMarketdropdown() throws InterruptedException {
		log.info("select Market dropdown");
		TargetMarket.click();
		Thread.sleep(400);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
		Reporter.addStepLog(Status.PASS+"  select Market dropdown");

	}

	public void checkOutsideMarket() {
		log.info("check Outside Market");
		OutsideMarketCheckBox.click();
		Reporter.addStepLog(Status.PASS+"  check Outside Market");


	}


}