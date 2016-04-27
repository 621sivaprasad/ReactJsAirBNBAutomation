package com.ep.qa.ui.suite.setup.companysetup.testfunction;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ep.qa.automation.util.enums.LocatorType;
import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class AirBNBMenuLinkOperations extends TestSuiteBase {

	public Properties menuLinkObjectProperties;
	ReportLogServiceImpl report = new ReportLogServiceImpl(AirBNBMenuLinkOperations.class);

	public void loadMenuObjects() {
		menuLinkObjectProperties = commonUtil.getPageObjects("homePage.properties");
		
	}

	public void clickLoginLink() {

		browserObj.getClick().performClick(LocatorType.XPATH, menuLinkObjectProperties.getProperty("homePage.loginLink"));
		report.info("Clicked login link from home page");
	}

	public void clickSignUpLink() {
		browserObj.getClick().performClick(LocatorType.XPATH, menuLinkObjectProperties.getProperty("homePage.signUpLink"));
		report.info("Clicked Sign Up link from Home page");
	}

	public void hoverUserMenuAndclickEditProfileLink() {
		WebDriver driver = browserObj.getDriver();
		Actions action = new Actions(driver);
		browserObj.getWait().waitFor(LocatorType.XPATH, menuLinkObjectProperties.getProperty("menuLink.userMenu"));
		browserObj.getClick().performClick(LocatorType.XPATH, menuLinkObjectProperties.getProperty("menuLink.userMenu"));
		System.out.println("Failed step click user menu link ------------------------------*************** ");
		browserObj.getWait().waitFor(LocatorType.XPATH, "//h2[@class='text-center']");

		while (true) {

			browserObj.getWait().waitFor(LocatorType.XPATH, menuLinkObjectProperties.getProperty("menuLink.userMenu"));
			System.out.println("****************************** in while loop of edit profile hover");
			action.moveToElement(
					driver.findElement(By.xpath(menuLinkObjectProperties.getProperty("menuLink.userMenu")))).perform();
			if (driver.findElement(By.xpath(menuLinkObjectProperties.getProperty("menuLink.editProfileLink")))
					.isDisplayed()) {
				browserObj.getWait().waitFor(LocatorType.XPATH,
						menuLinkObjectProperties.getProperty("menuLink.editProfileLink"));
				browserObj.getClick().performClick(LocatorType.XPATH,
						menuLinkObjectProperties.getProperty("menuLink.editProfileLink"));
				System.out.println("before break ************************** in if ...");
				break;

			}

			driver.findElement(By.xpath(menuLinkObjectProperties.getProperty("menuLink.userMenu"))).sendKeys(Keys.F5);
			System.out.println("F5 KEY PRESS $$$$$$$$$$$$$$$$$$$$$$$$$$");

		}
		report.info("Clicked edit profile from userMenu");
	}

	public void hoverUserMenuclickWishListLink() {
		
		
		WebDriver driver = browserObj.getDriver();
		Actions action = new Actions(driver);
		browserObj.getWait().waitFor(LocatorType.XPATH, menuLinkObjectProperties.getProperty("menuLink.userMenu"));
		browserObj.getClick().performClick(LocatorType.XPATH, menuLinkObjectProperties.getProperty("menuLink.userMenu"));
		browserObj.getWait().waitFor(LocatorType.XPATH, "//h2[@class='text-center']");

		while (true) {

			browserObj.getWait().waitFor(LocatorType.XPATH, menuLinkObjectProperties.getProperty("menuLink.userMenu"));
			action.moveToElement(
					driver.findElement(By.xpath(menuLinkObjectProperties.getProperty("menuLink.userMenu")))).perform();
			if (driver.findElement(By.xpath(menuLinkObjectProperties.getProperty("menuLink.wishListLink")))
					.isDisplayed()) {
				browserObj.getWait().waitFor(LocatorType.XPATH,
						menuLinkObjectProperties.getProperty("menuLink.wishListLink"));
				browserObj.getClick().performClick(LocatorType.XPATH,
						menuLinkObjectProperties.getProperty("menuLink.wishListLink"));
				break;

			}

			driver.findElement(By.xpath(menuLinkObjectProperties.getProperty("menuLink.userMenu"))).sendKeys(Keys.F5);

		}
		report.info("Clicked wishlist link from home page");
		
	}
	
	
	public void hoverUserMenuAndclickLogOutLink() {
		WebDriver driver = browserObj.getDriver();
		Actions action = new Actions(driver);
		browserObj.getWait().waitFor(LocatorType.XPATH, menuLinkObjectProperties.getProperty("menuLink.userMenu"));
		browserObj.getClick().performClick(LocatorType.XPATH, menuLinkObjectProperties.getProperty("menuLink.userMenu"));
		browserObj.getWait().waitFor(LocatorType.XPATH, "//h2[@class='text-center']");

		while (true) {

			browserObj.getWait().waitFor(LocatorType.XPATH, menuLinkObjectProperties.getProperty("menuLink.userMenu"));
			action.moveToElement(
					driver.findElement(By.xpath(menuLinkObjectProperties.getProperty("menuLink.userMenu")))).perform();
			if (driver.findElement(By.xpath(menuLinkObjectProperties.getProperty("menuLink.logoutLink")))
					.isDisplayed()) {
				browserObj.getWait().waitFor(LocatorType.XPATH,
						menuLinkObjectProperties.getProperty("menuLink.logoutLink"));
				browserObj.getClick().performClick(LocatorType.XPATH,
						menuLinkObjectProperties.getProperty("menuLink.logoutLink"));
				break;

			}

			driver.findElement(By.xpath(menuLinkObjectProperties.getProperty("menuLink.userMenu"))).sendKeys(Keys.F5);

		}
		report.info("Clicked logout link from home page");
	}

	
}