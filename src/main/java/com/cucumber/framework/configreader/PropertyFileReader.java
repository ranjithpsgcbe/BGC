
package com.cucumber.framework.configreader;

import com.cucumber.framework.browser.BrowserType;
import com.cucumber.framework.utility.ResourceHelper;

import java.util.Properties;

public class PropertyFileReader implements ConfigReader{

	private Properties prop = null;

	public PropertyFileReader() {
		prop = new Properties();
		try {
			prop.load(ResourceHelper.getResourcePathInputStream("/src/main/resources/configfile/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getprojectTitile() {
		return prop.getProperty("projectTitile");
	}

	public String getStardate() {
		return prop.getProperty("Stardate");
	}

	public String getEndDate() {
		return prop.getProperty("EndDate");
	}

	public String getActivity() {
		return prop.getProperty("Activity");
	}

	public String getTargetMarket() {
		return prop.getProperty("TargetMarket");
	}

	public String getProjectDescription() {
		return prop.getProperty("ProjectDescription");
	}

	public String getWebsite() {
		return prop.getProperty("Website");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	public String getDbType() {
		return prop.getProperty("DataBase.Type");
	}

	public String getDbConnStr() {
		return prop.getProperty("DtaBase.ConnectionStr");
	}

	public BrowserType getBrowser() {
		return BrowserType.valueOf(prop.getProperty("Browser"));
	}

	public String getFYENDDateText() {
		return prop.getProperty("FYENDDateText");
	}

	public String getOverseaseSaleText1() {
		return prop.getProperty("OverseaseSaleText1");
	}

	public String getOverseaseSaleText2() {
		return prop.getProperty("OverseaseSaleText2");
	}

	public String getOverseaseSaleText3() {
		return prop.getProperty("OverseaseSaleText3");
	}

	public String getOverseaseSaleText4() {
		return prop.getProperty("OverseaseSaleText4");
	}

	public String getOverseaseInvestText1() {
		return prop.getProperty("OverseaseInvestText1");
	}

	public String getOverseaseInvestText2() {
		return prop.getProperty("OverseaseInvestText2");
	}

	public String getOverseaseInvestText3() {
		return prop.getProperty("OverseaseInvestText3");
	}

	public String getOverseaseInvestText4() {
		return prop.getProperty("OverseaseInvestText4");
	}

	public String getRationalProjectionText() {
		return prop.getProperty("RationalProjectionText");
	}

	public String getBenifitsText() {
		return prop.getProperty("BenifitsText");
	}

	public String getCost_DescriptionText() {
		return prop.getProperty("Cost_DescriptionText");
	}

	public String getCost_RentalText() {
		return prop.getProperty("Cost_RentalText");
	}

	public String getCost_BillingCurrenctText() {
		return prop.getProperty("Cost_BillingCurrenctText");
	}

	public String getExpectedUrl() {
		return prop.getProperty("ExpectedURL");
	}

	
}
