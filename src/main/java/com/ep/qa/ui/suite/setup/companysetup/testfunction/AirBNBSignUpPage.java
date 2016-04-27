package com.ep.qa.ui.suite.setup.companysetup.testfunction;

import java.util.Properties;

import org.openqa.selenium.By;

import com.ep.automation.ui.selenium.Browser;
import com.ep.qa.automation.util.enums.LocatorType;
import com.ep.qa.automation.util.reporter.ReportLogServiceImpl;
import com.ep.qa.ui.suite.setup.companysetup.testsuite.TestSuiteBase;

public class AirBNBSignUpPage extends TestSuiteBase {

	Properties signUpObjectProperties;
	ReportLogServiceImpl report = new ReportLogServiceImpl(AirBNBSignUpPage.class);

	public void loadSignUpObjects(){
		signUpObjectProperties = commonUtil.getPageObjects("signUpPage.properties");
      }
	
		public void signUp(String firstName, String lastName, String emailAddress, String password,String birthDay_Month,String birthDay_Date,String birthday_Year)
		{
			browserObj.getWait().waitFor(LocatorType.XPATH, signUpObjectProperties.getProperty("signUpPage.createUsingEmailButton"));
			
			browserObj.getClick().performClick(LocatorType.XPATH, signUpObjectProperties.getProperty("signUpPage.createUsingEmailButton"));
			report.info("Clicked create using email button for sign up");
			
			browserObj.getTextField().enterTextField(LocatorType.XPATH, signUpObjectProperties.getProperty("signUpPage.firstNameTextField"), firstName);
			report.info("Entered first name in the firstName text field");
			
			browserObj.getTextField().enterTextField(LocatorType.XPATH, signUpObjectProperties.getProperty("signUpPage.lastNameTextField"), lastName);
			report.info("Entered last name in the lastName text field");
			
			browserObj.getTextField().enterTextField(LocatorType.XPATH, signUpObjectProperties.getProperty("signUpPage.emailTextField"), emailAddress);
			report.info("Entered email address in the email address text field");
			
			browserObj.getTextField().enterTextField(LocatorType.XPATH, signUpObjectProperties.getProperty("signUpPage.passwordTextField"),password);
			report.info("Entered password in the password text field");
			
			browserObj.getDriver().findElement(By.xpath(signUpObjectProperties.getProperty("signUpPage.birthDay_Month_Dropdown"))).sendKeys(birthDay_Month);
			report.info("Selected month from the birthday Month dropdown");
			
			browserObj.getDriver().findElement(By.xpath(signUpObjectProperties.getProperty("signUpPage.birthDay_Day_Dropdown"))).sendKeys(birthDay_Date);
			report.info("Selected day from the birthday day dropdown");
			
			browserObj.getDriver().findElement(By.xpath(signUpObjectProperties.getProperty("signUpPage.birthDay_Year_Dropdown"))).sendKeys(birthday_Year);
			report.info("Selected year from the birthday year dropdown");
			
			browserObj.getClick().performClick(LocatorType.XPATH, signUpObjectProperties.getProperty("signUpPage.signUpButton"));
			report.info("Clicked Sign Up Button for completing Signing Up");
			
			browserObj.getClick().performClick(LocatorType.XPATH, signUpObjectProperties.getProperty("signUpPage.loginLink"));
			report.info("Clicked Login Link from Sign Up Page");
		}
	

}
