package com.ep.qa.ui.suite.setup.companysetup.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBLoginPage;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBMenuLinkOperations;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBWishListPage;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;


public class TestAirBNBWishList extends TestSuiteBase {
	
	AirBNBMenuLinkOperations airBNBMenuLinkOperations;
	AirBNBLoginPage airBNBLoginPage;
	AirBNBWishListPage airBNBWishListPage;
	
	@BeforeMethod
	public void setUp() {

		airBNBMenuLinkOperations = new AirBNBMenuLinkOperations();
		airBNBWishListPage = new AirBNBWishListPage();
		airBNBMenuLinkOperations.loadMenuObjects();
		airBNBWishListPage.loadWishListObjects();
	}
	
	
	@Test
	public void wishList()
	{
		airBNBMenuLinkOperations.hoverUserMenuclickWishListLink();
		airBNBWishListPage.createWishList("DreamLand", "Invite only");
		airBNBWishListPage.deleteWishList();
		
	}
	

}
