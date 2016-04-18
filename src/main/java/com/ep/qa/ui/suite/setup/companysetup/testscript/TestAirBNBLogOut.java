package com.ep.qa.ui.suite.setup.companysetup.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBMenuLinkOperations;

public class TestAirBNBLogOut {
	
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
