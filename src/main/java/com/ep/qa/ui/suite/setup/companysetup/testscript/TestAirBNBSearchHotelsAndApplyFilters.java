package com.ep.qa.ui.suite.setup.companysetup.testscript;

import java.io.File;

import org.codehaus.jettison.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBHomePage;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.ApplyingFilters;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class TestAirBNBSearchHotelsAndApplyFilters extends TestSuiteBase{

	AirBNBHomePage airBNBHomePage;
	ApplyingFilters applyingFiltersPage;
	ReportLogServiceImpl report = new ReportLogServiceImpl(TestAirBNBSearchHotelsAndApplyFilters.class);
	JSONObject dataForSearchFilters;
	File searchPlaceAndApplyFilters;
	String placeName,guestInfo;

	@BeforeMethod
	public void setUp(){
		
		airBNBHomePage = new AirBNBHomePage();
		airBNBHomePage.loadSearchHotelsPageObjectProperties();
		applyingFiltersPage = new ApplyingFilters();
		applyingFiltersPage.loadHotelFiltersPageObjects();

		try{
	
			searchPlaceAndApplyFilters = new File(basePath + commonUtil.getFilePath("searchPlaceAndApplyFilters.json"));
			dataForSearchFilters = dataProvider.getJSONObject(searchPlaceAndApplyFilters).getJSONObject("searchPlaceAndApplyFiltersInfo");
			placeName = dataForSearchFilters.getString("placeName");
			guestInfo = dataForSearchFilters.getString("guestInfo");

		}catch (Exception exception) {
			report.debug("Valid JSON resource arguement required" + exception.getMessage());
		}

}


	
	
	@Test
	public void searchHotelsAndApplyFilters(){
		
		
		airBNBHomePage.searchHotelsInAPlace(placeName, guestInfo);
		applyingFiltersPage.applyHotelFilters();
		
	}
}
