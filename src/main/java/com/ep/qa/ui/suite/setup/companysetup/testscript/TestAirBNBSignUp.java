package com.ep.qa.ui.suite.setup.companysetup.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBLoginPage;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBMenuLinkOperations;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBSignUpPage;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class TestAirBNBSignUp extends TestSuiteBase{
	AirBNBMenuLinkOperations airBNBMenuLinkOperations;
	AirBNBSignUpPage airBNBSignUpPage;
	AirBNBLoginPage airBNBLoginPage;
	
	@BeforeMethod
	public void setUp(){
		
	airBNBMenuLinkOperations = new AirBNBMenuLinkOperations();
	airBNBSignUpPage =  new AirBNBSignUpPage();
	airBNBLoginPage = new AirBNBLoginPage();
	airBNBMenuLinkOperations.loadMenuObjects();
	airBNBSignUpPage.loadSignUpObjects();
	airBNBLoginPage.loadLoginObjects();
	
	}
	

	@Test
	public void airBNBSignUp(){
		
		
		airBNBMenuLinkOperations.clickSignUpLink();
		airBNBSignUpPage.signUp("Siva", "Pilaka", "swap.more20@gmail.com", "234e23","March", "2", "1991");
		
		
	}
	
}
