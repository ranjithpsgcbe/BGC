package com.cucumber.framework.helper;

import com.cucumber.framework.browser.*;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.configreader.PropertyFileReader;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

	private final Logger log = LoggerHelper.getLogger(TestBase.class);
	
	public static WebDriver driver;

	public WebDriver getBrowserObject(BrowserType bType) throws Exception {
		try {
			log.info(bType);


			switch (bType) {

			case Chrome:

				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				return chrome.getChromeDriver(chrome.getChromeCapabilities());

			case Firefox:

				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				return firefox.getFirefoxDriver(firefox.getFirefoxCapabilities());

			case HtmlUnitDriver:
				HtmlUnitBrowser htmlUnit = HtmlUnitBrowser.class.newInstance();
				return htmlUnit.getHtmlUnitDriver(htmlUnit.getHtmlUnitDriverCapabilities());

			case Iexplorer:
				IExploreBrowser iExplore = IExploreBrowser.class.newInstance();
				return iExplore.getIExplorerDriver(iExplore.getIExplorerCapabilities());
			default:
				throw new Exception(" Driver Not Found : " + new PropertyFileReader().getBrowser());
			}
		} catch (Exception e) {
			log.equals(e);
			throw e;
		}
	}
	
	public void setUpDriver(BrowserType bType) throws Exception {
		
		driver = getBrowserObject(bType);
		log.debug("InitializeWebDrive : " + driver.hashCode());
		driver.manage().timeouts().pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ObjectRepo.reader.getImplicitWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Before()
	public void before() throws Exception {
		ObjectRepo.reader = new PropertyFileReader();
		setUpDriver(ObjectRepo.reader.getBrowser());
		log.info(ObjectRepo.reader.getBrowser());
	}

	@After()
	public void after() throws Exception {
		driver.quit();
		log.info("");
	}
}
