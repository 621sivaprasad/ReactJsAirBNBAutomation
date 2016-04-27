package com.ep.qa.ui.suite.setup.companysetup.testfunction;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ep.qa.automation.util.enums.LocatorType;
import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;
import com.ep.qa.ui.utils.AirBNBConstants;

public class EditProfilePhotoPage extends TestSuiteBase{
	
	Properties editProfilePageObjectProperties;
	ReportLogServiceImpl report = new ReportLogServiceImpl(EditProfilePhotoPage.class);
	
	public void loadProfilePhotoPageObjects(){
		editProfilePageObjectProperties = commonUtil.getPageObjects("editProfilePage.properties");
      }
	
	public void uploadProfilePhoto(String uploadFilePath)
	{
		System.out.println("Browser reference in EditProfile");
		browserObj.getWait().waitFor(LocatorType.XPATH, editProfilePageObjectProperties.getProperty("editProfilePage.profilePhotoAreaLink"));
		
		browserObj.getClick().performClick(LocatorType.XPATH, editProfilePageObjectProperties.getProperty("editProfilePage.profilePhotoAreaLink"));
		 report.info("Clicked upload photo link from edit profile page");
		 
		 System.out.println("The profile photo path is "+AirBNBConstants.profilePhotoPath+uploadFilePath);
		
		browserObj.getDriver().findElement(By.xpath(editProfilePageObjectProperties.getProperty("editProfilePage.uploadPhotoButton"))).sendKeys(uploadFilePath);
		report.info("Selected upload photo");
	}
	
	public void editProfilePage(String describeYourself, String confirmPassword)
	{
		WebDriverWait wait = new WebDriverWait(browserObj.getDriver(), AirBNBConstants.waitInSeconds);
		
		browserObj.getClick().performClick(LocatorType.XPATH, editProfilePageObjectProperties.getProperty("editProfilePage.editProfilePageAreaLink"));
		report.info("Clicked edit profile link from edit profile page");
		
		browserObj.getDriver().findElement(By.xpath(editProfilePageObjectProperties.getProperty("editProfilePage.describeYourselfTextArea"))).clear();
		report.info("Cleared describe yourself from edit profile page");
		
		browserObj.getTextField().enterTextField(LocatorType.XPATH, editProfilePageObjectProperties.getProperty("editProfilePage.describeYourselfTextArea"), describeYourself+Math.random());
		report.info("Entered describe yourself text from edit profile page");
		
		browserObj.getClick().performClick(LocatorType.XPATH, editProfilePageObjectProperties.getProperty("editProfilePage.addLanguageButton"));
		report.info("Clicked add language button from edit profile page");
		
		browserObj.getWait().waitFor(LocatorType.XPATH,  editProfilePageObjectProperties.getProperty("editProfilePage.selectLanguagecheckBox"));
		browserObj.getDriver().findElement(By.xpath( editProfilePageObjectProperties.getProperty("editProfilePage.selectLanguagecheckBox"))).click();
		report.info("Selected language from language modal dialog box");
		
		browserObj.getClick().performClick(LocatorType.XPATH,  editProfilePageObjectProperties.getProperty("editProfilePage.saveLanguageButton"));
		report.info("Clicked save language button from language modal dialog box");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editProfilePageObjectProperties.getProperty("editProfilePage.saveProfileButton"))));
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(editProfilePageObjectProperties.getProperty("editProfilePage.saveProfileButton"))));
		 browserObj.getWait().waitFor(LocatorType.XPATH,  editProfilePageObjectProperties.getProperty("editProfilePage.saveProfileButton"));
    	 browserObj.getClick().performClick(LocatorType.XPATH,  editProfilePageObjectProperties.getProperty("editProfilePage.saveProfileButton"));
    	 report.info("Clicked save  profile button from edit profile page");
    	 
    	 browserObj.getTextField().enterTextField(LocatorType.XPATH, editProfilePageObjectProperties.getProperty("editProfilePage.confirmPasswordTextField"), confirmPassword);
    	 report.info("Entered confirm password in password field");
    	 
    	 browserObj.getDriver().findElement(By.xpath(editProfilePageObjectProperties.getProperty("editProfilePage.confirmPasswordButton"))).click();
    	 report.info("Clicked confirm password button");
    	 
    	 String successMessage = browserObj.getDriver().findElement(By.xpath( editProfilePageObjectProperties.getProperty("editProfilePage.updateSucessfulMessage"))).getText();
		// VerificationManager.verifyString(successMessage, "Profile Updated Successfully", "Verifying success message "+successMessage);
		
		
	}

}
