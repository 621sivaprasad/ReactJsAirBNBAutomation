package com.ep.qa.ui.suite.setup.companysetup.testfunction;

import java.util.Properties;

import org.openqa.selenium.By;

import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class AirBNBLogOut extends TestSuiteBase{
	
	
	
	Properties logoutObjectProperties;
	ReportLogServiceImpl report = new ReportLogServiceImpl(AirBNBLogOut.class);
	
	
	public void loadLogoutObjectProperties()
	{
		logoutObjectProperties = commonUtil.getPageObjects("homePage.properties");
		
	}
	
	
	public void logout()
	{
		
		Boolean verifyLogout=browser.getDriver().findElement(By.xpath(logoutObjectProperties.getProperty("homePage.loginLink"))).isDisplayed();
	
	}
	
	
	
	

}
