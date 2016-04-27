package com.ep.qa.ui.suite.setup.companysetup.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBMenuLinkOperations;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class TestAirBNBLogOut extends TestSuiteBase {
	
	AirBNBMenuLinkOperations airBNBMenuLinkOperations;

	@BeforeMethod
	public void setUp()
	{
		
	airBNBMenuLinkOperations = new AirBNBMenuLinkOperations();
	airBNBMenuLinkOperations.loadMenuObjects();
	}
	
	
	@Test
	public void logOut(){
		
		airBNBMenuLinkOperations.hoverUserMenuAndclickLogOutLink();
	}
	

}
