package com.ep.qa.ui.suite.setup.companysetup.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBHomePage;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.ApplyingFilters;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class TestAirBNBSearchHotelsAndApplyFilters extends TestSuiteBase{

	AirBNBHomePage airBNBHomePage;
	ApplyingFilters applyingFiltersPage;

	@BeforeMethod
	public void setUp(){
		
airBNBHomePage = new AirBNBHomePage();
airBNBHomePage.loadSearchHotelsPageObjectProperties();
applyingFiltersPage = new ApplyingFilters();
applyingFiltersPage.loadHotelFiltersPageObjects();

	}
	
	@Test
	public void searchHotelsAndApplyFilters(){
		airBNBHomePage.searchHotelsInAPlace("spain", "5 Guests");
		applyingFiltersPage.applyHotelFilters();
		
	}
}
