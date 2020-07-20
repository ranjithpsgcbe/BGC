package com.cucumber.framework.helper;

import com.cucumber.framework.utility.DateTimeHelper;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;
import java.io.IOException;


public class GenericHelper{
	private WebDriver driver;
	private static final Logger log = LoggerHelper.getLogger(GenericHelper.class);
	public GenericHelper(WebDriver driver) {
		this.driver = driver;
		log.debug("DropDownHelper : " + this.driver.hashCode());
	}
	public String readValueFromElement(WebElement element) {

		if (null == element){
			log.info("weblement is null");
			return null;
		}

		boolean displayed = false;
		try {
			displayed = isDisplayed(element);
		} catch (Exception e) {
			log.error(e);
			return null;
		}

		if (!displayed)
			return null;
		String text = element.getText();
		log.info("weblement valus is.."+text);
		System.out.println("weblement valus is.."+text);
		return text;
	}
	

	public String readValueFromInput(WebElement element) {
		if (null == element)
			return null;
		if (!isDisplayed(element))
			return null;
		String value = element.getAttribute("value");
		log.info("weblement valus is.."+value);
		System.out.println("weblement valus is.."+value);
		return value;
	}
	
	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is displayed.."+element);
			return true;
		} catch (Exception e) {
			log.info(e);
			return false;
		}
	}
	
	protected boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is displayed.."+element);
			return false;
		} catch (Exception e) {
			log.error(e);
			return true;
		}
	}
	public void ValidateRadioButton(WebElement element) {
		try {
			String str = element.getAttribute("checked");
			if (str.equalsIgnoreCase("true")) {
				System.out.println("Radio Button is selected");
			}
			//Reporter.addStepLog(Status.PASS + "Radio Button is selected");
		}catch (NullPointerException e){
			System.out.println("Radio Button is not selected");
		}
	}
	


	public String takeScreenShot(String name) throws IOException {

		if (driver instanceof HtmlUnitDriver) {
			log.fatal("HtmlUnitDriver Cannot take the ScreenShot");
			return "";
		}

		File destDir = new File(("./screenshots/") + DateTimeHelper.getCurrentDate());
		if (!destDir.exists())
			destDir.mkdir();

		File destPath = new File(destDir.getAbsolutePath() + System.getProperty("file.separator") + name + ".jpg");
		try {
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), destPath);
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
		log.info(destPath.getAbsolutePath());
		return destPath.getAbsolutePath();
	}

}
