package com.ep.qa.ui.suite.setup.companysetup.testfunction;

import java.io.File;
import java.util.Properties;

import com.ep.qa.automation.dataprovider.TestDataProvider;

public class AirBNBCommonUtil {

	public TestDataProvider dataProvider;
	public static Properties CONFIG;
	

	public Properties objectsPropFile;
	
	 public Properties getPageObjects(String propertiesFileName){	
		 dataProvider=TestDataProvider.getInstance();
	    	try {
	    		CONFIG = dataProvider.loadProperties(System.getProperty("user.dir") + File.separator + 
	    				"src" + File.separator + "main" + File.separator + "resources" +
	    				File.separator + "config.properties");
	    		
	    			objectsPropFile = new Properties();
	    		objectsPropFile = dataProvider.loadProperties(System.getProperty("user.dir")+File.separator+CONFIG.getProperty("pageObjectsPropertiesPath")+File.separator+propertiesFileName);
			} catch (Exception  e) {
				e.getMessage();
				
			//throw new FileNotFoundException(propertiesFileName+" Page object properties file not found");
				// TODO Auto-generated catch block
			}
	    	
	    	
	    	return objectsPropFile;
	    	
	    	
	    }
	 
	 
		public String getFilePath(String fileName) throws Exception{
			return CONFIG.getProperty("testDataFilePath")+ fileName;
		}
	 
}
