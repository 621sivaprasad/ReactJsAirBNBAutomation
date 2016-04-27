package com.ep.qa.ui.suite.setup.companysetup.testscript;

import java.io.File;

import org.codehaus.jettison.json.JSONObject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBLoginPage;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class TestAirBNBLogin extends TestSuiteBase{

	AirBNBLoginPage airBNBLoginPage;
	
	ReportLogServiceImpl report = new ReportLogServiceImpl(TestAirBNBLogin.class);
	JSONObject dataForLogin;
	File loginDetails;
	String userName,password, loggedInUser;

	@BeforeMethod
	public void setUp(){
	airBNBLoginPage =  new AirBNBLoginPage();
	airBNBLoginPage.loadLoginObjects();
	try{
		
		loginDetails = new File(basePath + commonUtil.getFilePath("loginDetails.json"));
		dataForLogin = dataProvider.getJSONObject(loginDetails).getJSONObject("loginCreds");
		userName = dataForLogin.getString("userName");
		password = dataForLogin.getString("password");
		 loggedInUser=dataForLogin.getString("loggedInUser");
	}catch (Exception exception) {
		report.debug("Valid JSON resource arguement required" + exception.getMessage());
	}
	}
	
	@Test
	public void login()
	{
		
	    airBNBLoginPage.login(userName, password, loggedInUser);
	
	}
	
}
