package com.ep.qa.ui.suite.setup.companysetup.testfunction;

import java.util.Properties;

import org.openqa.selenium.By;

import com.ep.qa.automation.util.enums.LocatorType;
import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.automation.verifyresult.VerificationManager;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class AirBNBWishListPage extends TestSuiteBase {
	
	
	
	Properties wishListObjectProperties;
	ReportLogServiceImpl report = new ReportLogServiceImpl(AirBNBWishListPage.class);
	
	
	public void loadWishListObjects()
	{
		
		wishListObjectProperties=commonUtil.getPageObjects("wishListPage.properties");
	}
	
	
	public void createWishList(String wishListName, String selectOption )
	{
		 browser.getClick().performClick(LocatorType.XPATH, wishListObjectProperties.getProperty("createWishListPage.createWishListButton"));
		 report.info("Clicked on create new wishlist button");
		 
		 browser.getWait().waitFor(LocatorType.XPATH, wishListObjectProperties.getProperty("createWishListPage.wishListInput"));
		 browser.getTextField().enterTextField(LocatorType.XPATH, wishListObjectProperties.getProperty("createWishListPage.wishListInput"), wishListName);
		 report.info("Entered wish list name in wish list input field");	
		 
		 browser.getTextField().enterTextField(LocatorType.XPATH, wishListObjectProperties.getProperty("createWishListPage.selectPrivacySetting"), selectOption);
		 report.info("Selected privacy setting option");
		 
		 browser.getClick().performClick(LocatorType.XPATH, wishListObjectProperties.getProperty("createWishListPage.saveButton"));
		 report.info("Clicked save button from wishlist page");
		 
		 String createdWishListName =  browser.getDriver().findElement(By.xpath("//strong[contains(text(),'DreamLand')]")).getText();
		 VerificationManager.verifyString(createdWishListName, "DreamLand", "Verifying the wish list "+createdWishListName+" created ");
		
	}
	
	public void deleteWishList()
	{
		
		browser.getClick().performClick(LocatorType.XPATH, wishListObjectProperties.getProperty("deleteWishListPage.wishList"));
		 report.info("Clicked delete wish list button from delete wish list page");
		
		browser.getClick().performClick(LocatorType.XPATH, wishListObjectProperties.getProperty("deleteWishListPage.editWishListIcon"));
		 report.info("Clicked on delete wish list icon from wish list page");
		
		browser.getClick().performClick(LocatorType.XPATH, wishListObjectProperties.getProperty("deleteWishListPage.deleteWishListLink"));
		 report.info("Clicked on delete wish list link from wish list page");
		
		browser.getDriver().switchTo().alert().accept();
		 report.info("Confirmed wish list  deletion");
		
		
	}
	

}
