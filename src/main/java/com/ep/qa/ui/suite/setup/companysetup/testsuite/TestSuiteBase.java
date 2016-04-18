package com.ep.qa.ui.suite.setup.companysetup.testsuite;

import java.io.File;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.ep.automation.ui.selenium.Browser;
import com.ep.qa.automation.dataprovider.TestDataProvider;
import com.ep.qa.automation.util.enums.BrowserType;
import com.ep.qa.automation.util.logging.LogLevel;
import com.ep.qa.automation.util.logging.LogManager;
import com.ep.qa.automation.util.reporter.ReportLogService;
import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.ui.suite.setup.companysetup.testfunction.AirBNBCommonUtil;

public class TestSuiteBase {
	private static ReportLogService report = new ReportLogServiceImpl(TestSuiteBase.class);
	public static Browser browser;
	public static Properties CONFIG, PAGEELEMENTS;
	public  TestDataProvider dataProvider;
	public static String basePath = System.getProperty("user.dir");
	public  AirBNBCommonUtil commonUtil = new AirBNBCommonUtil();

	/**
	 * Purpose: This method is to load all configurations & page elements of application.
	 * 1. Load configurations list
	 * 2. Load all the page objects as properties
	 * 3. Create an instance for Browser class
	 * 4. Open URL
	 */
	@BeforeTest
	public void setup(){
		dataProvider = TestDataProvider.getInstance(); 
		try{
			CONFIG = dataProvider.loadProperties(basePath + File.separator + 
					"src" + File.separator + "main" + File.separator + "resources" +
					File.separator + "config.properties");
		}catch(Exception exception){
			report.debug("File not found" + exception.getMessage());
			throw new IllegalStateException();
		}
		LogManager.setLogLevel(LogLevel.INFO);
		browser = new Browser();
		browser.openPage(CONFIG.getProperty("url"), BrowserType.CHROME);
		
		browser.maximizeWindow();
	}
	
	/**
	 * Purpose: This method is to close browser instance after every @Test
	 */
	@AfterTest
	public static void tearDown(){
		browser.clearAllCookies();
		
		browser.closeBrowser();
	}
}
