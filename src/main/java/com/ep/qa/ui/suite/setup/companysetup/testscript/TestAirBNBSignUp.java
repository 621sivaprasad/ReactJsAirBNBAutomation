package com.ep.qa.ui.suite.setup.companysetup.testscript;

import java.io.File;

import org.codehaus.jettison.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBLoginPage;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBMenuLinkOperations;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBSignUpPage;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class TestAirBNBSignUp extends TestSuiteBase{
	AirBNBMenuLinkOperations airBNBMenuLinkOperations;
	AirBNBSignUpPage airBNBSignUpPage;
	AirBNBLoginPage airBNBLoginPage;
	
	ReportLogServiceImpl report = new ReportLogServiceImpl(TestAirBNBSignUp.class);
	
	JSONObject dataForSignUp;
	File signUpDetails;
	String firstName,lastName,email,password,month,day,year;
	
	@BeforeMethod
	public void setUp(){
		
	airBNBMenuLinkOperations = new AirBNBMenuLinkOperations();
	airBNBSignUpPage =  new AirBNBSignUpPage();
	airBNBLoginPage = new AirBNBLoginPage();
	airBNBMenuLinkOperations.loadMenuObjects();
	airBNBSignUpPage.loadSignUpObjects();
	airBNBLoginPage.loadLoginObjects();
	
    try{
		
	    signUpDetails = new File(basePath + commonUtil.getFilePath("signUpDetails.json"));
	    dataForSignUp = dataProvider.getJSONObject(signUpDetails).getJSONObject("signupInfo");
		firstName = dataForSignUp.getString("firstName");
		lastName = dataForSignUp.getString("lastName");
		email = dataForSignUp.getString("email");
		password = dataForSignUp.getString("password");
		month = dataForSignUp.getString("month");
		day = dataForSignUp.getString("day");
		year = dataForSignUp.getString("year");
				
	}catch (Exception exception) {
		report.debug("Valid JSON resource arguement required" + exception.getMessage());
	}
	
	
	}
	

	@Test
	public void airBNBSignUp(){
		
		
		airBNBMenuLinkOperations.clickSignUpLink();
		System.out.println("SignUpInfo FirstName"+firstName);
		airBNBSignUpPage.signUp(firstName, lastName, email, password, month, day, year);
		
		
	}
	
}
