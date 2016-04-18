package com.ep.qa.ui.suite.setup.companysetup.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBLoginPage;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBMenuLinkOperations;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.EditProfilePhotoPage;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class TestAirBNBEditProfileAndUploadPhoto extends TestSuiteBase {

	AirBNBMenuLinkOperations airBNBMenuLinkOperations;
	AirBNBLoginPage airBNBLoginPage;
	EditProfilePhotoPage editProfilePhotoPage;

	@BeforeMethod
	public void setUp() {

		airBNBMenuLinkOperations = new AirBNBMenuLinkOperations();
		editProfilePhotoPage = new EditProfilePhotoPage();
		airBNBMenuLinkOperations.loadMenuObjects();
		editProfilePhotoPage.loadProfilePhotoPageObjects();

	}

	@Test
	public void editProfileaNDUploadPhoto() 
	{
		airBNBMenuLinkOperations.hoverUserMenuAndclickEditProfileLink();
		editProfilePhotoPage.uploadProfilePhoto();
		editProfilePhotoPage.editProfilePage("text");
		
	}

}
