package com.tutorialsninja.qa.listeners;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.MyExtentReporter;

import zmq.ZError.IOException;



public class MyListeners implements ITestListener {
	private static final TakesScreenshot driver = null;
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	
	@Override 
	public void onStart(ITestContext context) {
		try {
			extentReport = MyExtentReporter.generateExtentReports();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Execution of Tutorialsninja Project started");
		
	}
@Override 
public void onTestStart(ITestResult result) { 
	String testName =  result.getName();
	extentTest = extentReport.createTest(testName);
	extentTest.log(Status.INFO, testName + "stated exeuting");
	System.out.println(testName + "strated execting");
}
 @Override
 public void onTestSuccess(ITestResult result) {
	 String testName =  result.getName();
	 extentTest = extentReport.createTest(testName);
		extentTest.log(Status.PASS, testName + "successfully extented");
		System.out.println(testName + "successfully executed");
	}
 @Override
 public void onTestFailure(ITestResult result) {
	 String testName =  result.getName();
	 try {
	 WebDriver driver= null;
	 driver = (WebDriver) result.getTestClass().getRealClass().getClass().getDeclaredField("driver").get(result.getInstance());
	 }catch(IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		 e.printStackTrace();
	 }
	 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 String destination = System.getProperty("user.dir")+ "\\test-output\\screenshots\\" + testName + ".png";
	 try {
		 FileHandler.copy(source, new File (destination));
	 }catch (IOException e) {
		 e.printStackTrace();
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    extentTest.addScreenCaptureFromPath(destination);
	    extentTest.log(Status.INFO,result.getThrowable());
	    extentTest.log(Status.FAIL, testName + "failed");
	    
		//System.out.println(testName + "failed");
		//System.out.println(result.getThrowable());
		
 }
 @Override
 public void onTestSkipped(ITestResult result) {
	 String testName =  result.getName();
	 extentTest.log(Status.INFO,result.getThrowable());
	 extentTest.log(Status.FAIL, testName + "skipped");
		//System.out.println(testName + "got skipped");
		//System.out.println(result.getThrowable());
 }
 @Override
 public void onFinish(ITestContext context) {
		System.out.println("Execution of Tutorialsninja Project finished");
		extentReport.flush();
 }
 @Override
 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	 String testName =  result.getName();
		System.out.println(testName + "with this much percentage");
		System.out.println(result.getThrowable());

 }
}
 

 
 
 
 
 
 
 
