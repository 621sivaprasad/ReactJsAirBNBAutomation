package com.ep.qa.ui.suite.setup.companysetup.testscript;

import java.io.File;

import org.codehaus.jettison.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBLoginPage;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBMenuLinkOperations;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.EditProfilePhotoPage;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class TestAirBNBEditProfileAndUploadPhoto extends TestSuiteBase {

	AirBNBMenuLinkOperations airBNBMenuLinkOperations;
	AirBNBLoginPage airBNBLoginPage;
	EditProfilePhotoPage editProfilePhotoPage;
	ReportLogServiceImpl report = new ReportLogServiceImpl(TestAirBNBEditProfileAndUploadPhoto.class);
	JSONObject dataForEditProfile;
	File editProfileDetails;
	String describeYourselfText,uploadPhotoPath,confirmPassword;


	@BeforeMethod
	public void setUp() {

		airBNBMenuLinkOperations = new AirBNBMenuLinkOperations();
		editProfilePhotoPage = new EditProfilePhotoPage();
		airBNBMenuLinkOperations.loadMenuObjects();
		editProfilePhotoPage.loadProfilePhotoPageObjects();
		
		try{
			
			editProfileDetails = new File(basePath + commonUtil.getFilePath("editProfileDetails.json"));
			dataForEditProfile = dataProvider.getJSONObject(editProfileDetails).getJSONObject("editProfileInfo");
			describeYourselfText = dataForEditProfile.getString("describeYourself");
			uploadPhotoPath = dataForEditProfile.getString("uploadPhotoPath");
			confirmPassword = dataForEditProfile.getString("confirmPasssword");
		}catch (Exception exception) {
			report.debug("Valid JSON resource arguement required" + exception.getMessage());
		}

	}

	@Test
	public void editProfileaNDUploadPhoto() 
	{
		airBNBMenuLinkOperations.hoverUserMenuAndclickEditProfileLink();
		editProfilePhotoPage.uploadProfilePhoto(uploadPhotoPath);
		editProfilePhotoPage.editProfilePage(describeYourselfText,confirmPassword);
		
	}

}
