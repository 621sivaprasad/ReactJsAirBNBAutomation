package com.ep.qa.ui.suite.setup.companysetup.testscript;

import java.io.File;

import org.codehaus.jettison.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBLoginPage;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBMenuLinkOperations;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBWishListPage;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;


public class TestAirBNBWishList extends TestSuiteBase {
	
	AirBNBMenuLinkOperations airBNBMenuLinkOperations;
	AirBNBLoginPage airBNBLoginPage;
	AirBNBWishListPage airBNBWishListPage;
	ReportLogServiceImpl report = new ReportLogServiceImpl(TestAirBNBWishList.class);
	JSONObject dataForWishList;
	File wishListDetails;
	String wishListName,privacySetting;
	
	
	@BeforeMethod
	public void setUp() {

		airBNBMenuLinkOperations = new AirBNBMenuLinkOperations();
		airBNBWishListPage = new AirBNBWishListPage();
		airBNBMenuLinkOperations.loadMenuObjects();
		airBNBWishListPage.loadWishListObjects();
		
		try{
			
			wishListDetails = new File(basePath + commonUtil.getFilePath("wishListDetails.json"));
			dataForWishList = dataProvider.getJSONObject(wishListDetails).getJSONObject("wishListInfo");
			wishListName = dataForWishList.getString("wishListName");
			privacySetting = dataForWishList.getString("privacySetting");
		}catch (Exception exception) {
			report.debug("Valid JSON resource arguement required" + exception.getMessage());
		}
		
		}
		
	
	
	
	@Test
	public void wishList()
	{
		airBNBMenuLinkOperations.hoverUserMenuclickWishListLink();
		airBNBWishListPage.createWishList(wishListName, privacySetting);
		airBNBWishListPage.deleteWishList();
		
	}
	

}
