package com.ep.qa.ui.suite.setup.companysetup.testfunction;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ep.qa.automation.util.enums.LocatorType;
import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.automation.verifyresult.VerificationManager;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;
import com.ep.qa.ui.utils.AirBNBConstants;

public class AirBNBWishListPage extends TestSuiteBase {
	
	
	
	Properties wishListObjectProperties;
	ReportLogServiceImpl report = new ReportLogServiceImpl(AirBNBWishListPage.class);
	
	
	public void loadWishListObjects()
	{
		
		wishListObjectProperties=commonUtil.getPageObjects("wishListPage.properties");
	}
	
	
	public void createWishList(String wishListName, String selectOption )
	{
		 browserObj.getClick().performClick(LocatorType.XPATH, wishListObjectProperties.getProperty("createWishListPage.createWishListButton"));
		 report.info("Clicked on create new wishlist button");
		 
		 browserObj.getWait().waitFor(LocatorType.XPATH, wishListObjectProperties.getProperty("createWishListPage.wishListInput"));
		 browserObj.getTextField().enterTextField(LocatorType.XPATH, wishListObjectProperties.getProperty("createWishListPage.wishListInput"), wishListName);
		 report.info("Entered wish list name in wish list input field");	
		 
		 browserObj.getTextField().enterTextField(LocatorType.XPATH, wishListObjectProperties.getProperty("createWishListPage.selectPrivacySetting"), selectOption);
		 report.info("Selected privacy setting option");
		 
		 browserObj.getClick().performClick(LocatorType.XPATH, wishListObjectProperties.getProperty("createWishListPage.saveButton"));
		 report.info("Clicked save button from wishlist page");
		 
		 String createdWishListName =  browserObj.getDriver().findElement(By.xpath("//strong[contains(text(),'DreamLand')]")).getText();
		 VerificationManager.verifyString(createdWishListName, "DreamLand", "Verifying the wish list "+createdWishListName+" created ");
		 report.info("WishList name get verified");
	}
	
	public void deleteWishList()
	{
		//browserObj.getWait().waitFor(LocatorType.XPATH, wishListObjectProperties.getProperty("deleteWishListPage.wishList"));
		WebDriverWait wait = new WebDriverWait(browserObj.getDriver(), AirBNBConstants.waitInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(wishListObjectProperties.getProperty("deleteWishListPage.wishList"))));
		browserObj.getClick().performClick(LocatorType.XPATH, wishListObjectProperties.getProperty("deleteWishListPage.wishList"));
		 report.info("Clicked delete wish list button from delete wish list page");
		
		 //browserObj.getWait().waitFor(LocatorType.XPATH, wishListObjectProperties.getProperty("deleteWishListPage.editWishListIcon"));
		browserObj.getClick().performClick(LocatorType.XPATH, wishListObjectProperties.getProperty("deleteWishListPage.editWishListIcon"));
		 report.info("Clicked on delete wish list icon from wish list page");
		
		 //browserObj.getWait().waitFor(LocatorType.XPATH, wishListObjectProperties.getProperty("deleteWishListPage.deleteWishListLink"));
		browserObj.getClick().performClick(LocatorType.XPATH, wishListObjectProperties.getProperty("deleteWishListPage.deleteWishListLink"));
		 report.info("Clicked on delete wish list link from wish list page");
		
		browserObj.getDriver().switchTo().alert().accept();
		 report.info("Confirmed wish list  deletion");
		
		
	}
	

}
