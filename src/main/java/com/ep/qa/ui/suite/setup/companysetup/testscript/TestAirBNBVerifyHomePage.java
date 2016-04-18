package com.ep.qa.ui.suite.setup.companysetup.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBHomePage;

public class TestAirBNBVerifyHomePage {
AirBNBHomePage airBNBHomePage;

@BeforeMethod
public void setUp(){
	airBNBHomePage = new AirBNBHomePage();
	airBNBHomePage.loadSearchHotelsPageObjectProperties();
}

@Test
public void verifyHomePageElements(){
	airBNBHomePage.verifyHomePage("WELCOME HOME", "Rent unique places to stay from local hosts in 190+ countries.");
}
}
