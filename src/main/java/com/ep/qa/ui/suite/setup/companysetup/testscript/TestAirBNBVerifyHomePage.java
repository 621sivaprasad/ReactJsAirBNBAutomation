package com.ep.qa.ui.suite.setup.companysetup.testscript;

import java.io.File;

import org.codehaus.jettison.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBHomePage;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class TestAirBNBVerifyHomePage extends TestSuiteBase{
AirBNBHomePage airBNBHomePage;

ReportLogServiceImpl report = new ReportLogServiceImpl(TestAirBNBVerifyHomePage.class);
JSONObject dataForHomePage;
File homePageDetails;
String mainText,subMainText;

@BeforeMethod
public void setUp(){
	airBNBHomePage = new AirBNBHomePage();
	airBNBHomePage.loadSearchHotelsPageObjectProperties();
	
   try{
		
	   homePageDetails = new File(basePath + commonUtil.getFilePath("homePageDetails.json"));
	   dataForHomePage = dataProvider.getJSONObject(homePageDetails).getJSONObject("homePageInfo");
	   mainText = dataForHomePage.getString("mainText");
	   subMainText = dataForHomePage.getString("subMainText");
	}catch (Exception exception) {
		report.debug("Valid JSON resource arguement required" + exception.getMessage());
	}
	
}

@Test
public void verifyHomePageElements(){
	airBNBHomePage.verifyHomePage(mainText, subMainText);
}
}
