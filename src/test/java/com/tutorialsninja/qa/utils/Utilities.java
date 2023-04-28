package com.tutorialsninja.qa.utils;

import java.util.Date;

public class Utilities {
	
	public static void main(String[] args) {
		generateNameforEmailWithTimeStamp();
	}

	public static String generateEmailWithTimeStamp() {
		Date date = new Date ();
		String timeStamp = date.toString().replace("  ", " _ ").replace("  ", " _ ");
		return "homa.12345" +  timeStamp + "@hotmail.com";

	}
	
	public static String generateNameforEmailWithTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_").substring(8, 19).replace("_"," " );
		return "homa.12345" + timeStamp + "@hotmail.com";
		
}
public static final int implitWaitTime = 10;
public static final int pageLoadTime = 10;
public static final int scripttTime = 100;
}
