package com.cucumber.framework.configreader;

import com.cucumber.framework.configuration.browser.BrowserType;

public interface ConfigReader {
	public String getprojectTitile();
	public String getStardate();
	public String getEndDate();
	public String getProjectDescription();
	public String getActivity();
	public String getTargetMarket();
	public String getWebsite();
	public int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	public BrowserType getBrowser();
	public String getFYENDDateText();
	public String getOverseaseSaleText1();
	public String getOverseaseSaleText2();
	public String getOverseaseSaleText3();
	public String getOverseaseSaleText4();
	public String getOverseaseInvestText1();
	public String getOverseaseInvestText2();
	public String getOverseaseInvestText3();
	public String getOverseaseInvestText4();
	public String getRationalProjectionText();
	public String getBenifitsText();
	public String getCost_DescriptionText();
	public String getCost_RentalText();
	public String getCost_BillingCurrenctText();
}
