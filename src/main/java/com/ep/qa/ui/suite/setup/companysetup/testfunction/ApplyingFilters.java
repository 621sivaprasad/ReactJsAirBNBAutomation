package com.ep.qa.ui.suite.setup.companysetup.testfunction;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ep.automation.ui.selenium.Browser;
import com.ep.automation.ui.seleniuminterfaces.ICheckBox.SelectType;
import com.ep.qa.automation.util.enums.LocatorType;
import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class ApplyingFilters  extends TestSuiteBase
{

	Properties hotelFiltersPageObjectProperties;
	ReportLogServiceImpl report = new ReportLogServiceImpl(ApplyingFilters.class);
	
	public void loadHotelFiltersPageObjects(){
		hotelFiltersPageObjectProperties = commonUtil.getPageObjects("hotelFiltersPage.properties");
	}

	
	public void applyHotelFilters(){
		
		browser.getClick().performClick(LocatorType.XPATH, hotelFiltersPageObjectProperties.getProperty("filterPage.roomType"));
		report.info("Clicked check box room type");
		
		//browser.getWait().waitFor(LocatorType.XPATH, hotelFiltersPageObjectProperties.getProperty("filterPage.moreFiltersButton"));
		browser.getClick().performClick(LocatorType.XPATH, hotelFiltersPageObjectProperties.getProperty("filterPage.moreFiltersButton"));
		report.info("Clicked button more filters button");
		
		WebDriverWait wait = new WebDriverWait(browser.getDriver(), 20);
		wait.until(ExpectedConditions.stalenessOf(browser.getDriver().findElement(By.xpath(hotelFiltersPageObjectProperties.getProperty("filterPage.internetCheckBox")))));
		wait.until(ExpectedConditions.visibilityOf(browser.getDriver().findElement(By.xpath(hotelFiltersPageObjectProperties.getProperty("filterPage.internetCheckBox")))));
		
		browser.getClick().performClick(LocatorType.XPATH, hotelFiltersPageObjectProperties.getProperty("filterPage.internetCheckBox"));
		report.info("Clicked checkbox wireless/internet");
		
		browser.getClick().performClick(LocatorType.XPATH, hotelFiltersPageObjectProperties.getProperty("filterPage.poolCheckBox"));
		report.info("Clicked checkbox pool");
		
		browser.getClick().performClick(LocatorType.XPATH, hotelFiltersPageObjectProperties.getProperty("filterPage.kitchenCheckBox"));
		report.info("Clicked checkbox Kitchen");
		
		browser.getClick().performClick(LocatorType.XPATH, hotelFiltersPageObjectProperties.getProperty("filterPage.applyFilterButton"));
		report.info("Clicked apply filter button");
		
		}
	

	}
