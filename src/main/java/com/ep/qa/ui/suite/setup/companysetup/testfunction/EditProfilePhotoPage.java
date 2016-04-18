package com.ep.qa.ui.suite.setup.companysetup.testfunction;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ep.automation.ui.selenium.Browser;
import com.ep.qa.automation.util.enums.LocatorType;
import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.automation.verifyresult.VerificationManager;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class EditProfilePhotoPage extends TestSuiteBase{
	
	Properties editProfilePageObjectProperties;
	ReportLogServiceImpl report = new ReportLogServiceImpl(EditProfilePhotoPage.class);
	
	public void loadProfilePhotoPageObjects(){
		editProfilePageObjectProperties = commonUtil.getPageObjects("editProfilePage.properties");
      }
	
	public void uploadProfilePhoto()
	{
		browser.getClick().performClick(LocatorType.XPATH, editProfilePageObjectProperties.getProperty("editProfilePage.profilePhotoAreaLink"));
		 report.info("Clicked upload photo link from edit profile page");
		
		browser.getDriver().findElement(By.xpath(editProfilePageObjectProperties.getProperty("editProfilePage.uploadPhotoButton"))).sendKeys("C:\\Users\\sp092268\\Downloads\\glasses.JPG");
		report.info("Selected upload photo");
	}
	
	public void editProfilePage(String text)
	{
		browser.getClick().performClick(LocatorType.XPATH, editProfilePageObjectProperties.getProperty("editProfilePage.editProfilePageAreaLink"));
		report.info("Clicked edit profile link from edit profile page");
		
		browser.getDriver().findElement(By.xpath(editProfilePageObjectProperties.getProperty("editProfilePage.describeYourselfTextArea"))).clear();
		report.info("Cleared describe yourself from edit profile page");
		
		browser.getTextField().enterTextField(LocatorType.XPATH, editProfilePageObjectProperties.getProperty("editProfilePage.describeYourselfTextArea"), text+Math.random());
		report.info("Entered describe yourself text from edit profile page");
		
		browser.getClick().performClick(LocatorType.XPATH, editProfilePageObjectProperties.getProperty("editProfilePage.addLanguageButton"));
		report.info("Clicked add language button from edit profile page");
		
		browser.getWait().waitFor(LocatorType.XPATH,  editProfilePageObjectProperties.getProperty("editProfilePage.selectLanguagecheckBox"));
		browser.getDriver().findElement(By.xpath( editProfilePageObjectProperties.getProperty("editProfilePage.selectLanguagecheckBox"))).click();
		report.info("Selected language from language modal dialog box");
		
		browser.getClick().performClick(LocatorType.XPATH,  editProfilePageObjectProperties.getProperty("editProfilePage.saveLanguageButton"));
		report.info("Clicked save language button from language modal dialog box");
		
		browser.getWait().waitFor(LocatorType.XPATH,  editProfilePageObjectProperties.getProperty("editProfilePage.saveProfileButton"));
    	 browser.getWait().waitFor(LocatorType.XPATH,  editProfilePageObjectProperties.getProperty("editProfilePage.saveProfileButton"));
    	 browser.getClick().performClick(LocatorType.XPATH,  editProfilePageObjectProperties.getProperty("editProfilePage.saveProfileButton"));
    	 report.info("Clicked save  profile button from edit profile page");
    	 
    	 browser.getTextField().enterTextField(LocatorType.XPATH, editProfilePageObjectProperties.getProperty("editProfilePage.confirmPasswordTextField"), "airbnb@123");
    	 report.info("Entered confirm password in password field");
    	 
    	 browser.getDriver().findElement(By.xpath(editProfilePageObjectProperties.getProperty("editProfilePage.confirmPasswordButton"))).click();
    	 report.info("Clicked confirm password button");
    	 
    	 String successMessage = browser.getDriver().findElement(By.xpath( editProfilePageObjectProperties.getProperty("editProfilePage.updateSucessfulMessage"))).getText();
		// VerificationManager.verifyString(successMessage, "Profile Updated Successfully", "Verifying success message "+successMessage);
		
		
	}

}
