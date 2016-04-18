package com.ep.qa.ui.suite.setup.companysetup.testfunction;

import java.util.Properties;

import com.ep.qa.automation.util.enums.LocatorType;
import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;


public class AirBNBLoginPage extends TestSuiteBase {

	
	Properties loginObjectProperties;
	ReportLogServiceImpl report = new ReportLogServiceImpl(AirBNBLoginPage.class);
	public void loadLoginObjects(){
	loginObjectProperties = commonUtil.getPageObjects("loginPage.properties");
}

	public void login(String userName, String password) {
		
		browser.getTextField().enterTextField(LocatorType.XPATH, loginObjectProperties.getProperty("loginPage.userNameField"), userName);
		report.info("Entered user name in the UserName text Field");
		browser.getTextField().enterTextField(LocatorType.XPATH, loginObjectProperties.getProperty("loginPage.passwordField"), password);
		report.info("Entered password in the password text field");
		browser.getClick().performClick(LocatorType.XPATH, loginObjectProperties.getProperty("loginPage.loginButton"));
		report.info("Clicked login button");

}
}
