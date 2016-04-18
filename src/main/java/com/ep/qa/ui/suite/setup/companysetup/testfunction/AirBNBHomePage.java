package com.ep.qa.ui.suite.setup.companysetup.testfunction;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.ep.automation.ui.selenium.Browser;
import com.ep.qa.automation.util.enums.BrowserType;
import com.ep.qa.automation.util.enums.LocatorType;
import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.automation.verifyresult.VerificationManager;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class AirBNBHomePage extends TestSuiteBase{
	
	Properties homePageObjectProperties;
	ReportLogServiceImpl report = new ReportLogServiceImpl(AirBNBHomePage.class);
	public void loadSearchHotelsPageObjectProperties(){
		homePageObjectProperties = commonUtil.getPageObjects("homePage.properties");
	}
	
	public void searchHotelsInAPlace(String place, String guestNumber){
		
		browser.getWait().waitFor(LocatorType.XPATH, homePageObjectProperties.getProperty("homePage.airBNBLogoLink"));
		browser.getClick().performClick(LocatorType.XPATH, homePageObjectProperties.getProperty("homePage.airBNBLogoLink"));
		report.info("Clicked airbnb logo link");
		
		browser.getWait().waitFor(LocatorType.XPATH, homePageObjectProperties.getProperty("homePage.locationTextField"));
		Actions actions = new Actions(browser.getDriver());

		actions.moveToElement(browser.getDriver().findElement(By.xpath(homePageObjectProperties.getProperty("homePage.locationTextField")))).click().perform();
		browser.getTextField().enterTextField(LocatorType.XPATH, homePageObjectProperties.getProperty("homePage.locationTextField"), place);
		report.info("Entered location in the location text field");
		
		browser.getDriver().findElement(By.xpath(homePageObjectProperties.getProperty("homePage.guestsDropdown"))).sendKeys(guestNumber);
		report.info("Selected number of guests from the drop down");
		
		browser.getClick().performClick(LocatorType.XPATH, homePageObjectProperties.getProperty("homePage.searchButton"));
		report.info("Clicked search button");
	}
	
	public void verifyHomePage(String headerText, String tagLineText)
	{
		VerificationManager.verifyString(browser.getDriver().findElement(By.xpath(homePageObjectProperties.getProperty("homePage.welcomeHomeLabel"))).getText(),headerText , "Verifying the Header message "+headerText+" .");
		VerificationManager.verifyString(browser.getDriver().findElement(By.xpath(homePageObjectProperties.getProperty("homePage.homeLabelTagLine"))).getText(), tagLineText, "Verifying the tagline text "+tagLineText+" .");
		Boolean verifyLoginLink = browser.getDriver().findElement(By.xpath(homePageObjectProperties.getProperty("homePage.loginLink"))).isDisplayed();
		VerificationManager.verifyBoolean(verifyLoginLink, true, "Verified login link "+verifyLoginLink);
		Boolean verifySignUpLink = browser.getDriver().findElement(By.xpath(homePageObjectProperties.getProperty("homePage.signUpLink"))).isDisplayed();
		VerificationManager.verifyBoolean(verifySignUpLink, true, "Verified sign up link "+verifySignUpLink);
	}
	
	
}
