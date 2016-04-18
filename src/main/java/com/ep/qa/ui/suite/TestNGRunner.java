package com.ep.qa.ui.suite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

//import com.ep.automation.ui.selenium.CustomListener;
import com.ep.qa.automation.util.main.AbstractTestNGEngine;
import com.ep.qa.automation.util.main.TestNGEngineFactory;
import com.ep.qa.automation.util.main.TestNGEngineTemplateType;
import com.ep.reportengine.CustomListener;
import com.ep.reportengine.ReportListener;

public class TestNGRunner {
	private static AbstractTestNGEngine testNGEngine = new TestNGEngineFactory()
			.getTestNGEngine(TestNGEngineTemplateType.PARALLEL_RUN_WITH_SET_PARAMS);
	private static TestNG testng = new TestNG();
	private static List<XmlSuite> suitesToRun = new ArrayList<XmlSuite>();
	private static String filePath = File.separator;

	/**
	 * Purpose: The main method invoked by the Maven plugin that uses the
	 * services of TestNGEngine to create new Xml Suites on runtime and executes
	 * them
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		suitesToRun = testNGEngine.getSuitesToRunFor("testng.xml", "clients", "OS_version_Browser_version");
		for (XmlSuite xmlSuite : suitesToRun) {
			System.out.println("Suite name ---" + xmlSuite.getName());
		}
		List<Class> listeners = new ArrayList<Class>();
		listeners.add(CustomListener.class);
		listeners.add(ReportListener.class);
		testng.setXmlSuites(suitesToRun);
		int concurrent_vm_size = Integer.parseInt(System.getProperty("ConcurrentVMs"));
		testng.setSuiteThreadPoolSize(concurrent_vm_size);
		/* testng.setParallel("methods"); */
		testng.setListenerClasses(listeners);
		testng.setOutputDirectory("target" + filePath + "surefire-reports");
		testng.run();
	}
}