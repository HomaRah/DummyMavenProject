package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExtentReporter {
	public static ExtentReports generateExtentReports() throws Exception {
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+ "\\test-output\\ExtentReports\\extenReport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Tutorialsninja Test Result");
        sparkReporter.config().setDocumentTitle("TutorialsninjaAutomationTest");
        sparkReporter.config().setTimeStampFormat("DD/MM/YY");
        
        extentReport.attachReporter(sparkReporter);
        
        Properties configProp = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tutorialsninja\\qa\\config\\config.properties" );
        configProp.load(ip);
        
        extentReport.setSystemInfo("Application url", configProp.getProperty("url"));
        extentReport.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
        extentReport.setSystemInfo("Username", configProp.getProperty("validUsername"));
        extentReport.setSystemInfo("Password", configProp.getProperty("validPassword"));
        extentReport.setSystemInfo("Operating System", configProp.getProperty("os.version"));
        extentReport.setSystemInfo("Tester Name", configProp.getProperty("user.name"));
        extentReport.setSystemInfo("Jave Version", configProp.getProperty("java.version"));
        
        return extentReport;
        
        
        		
	}

}
