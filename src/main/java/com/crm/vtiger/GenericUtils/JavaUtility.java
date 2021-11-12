package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;



public class JavaUtility
{
	
      //this method is to generate random number to avoid duplicates
	public static String getRandomData()
	{
		Random random=new Random();
		int ran = random.nextInt(1000);
		return ""+ran;
	}
	// this method is used to generate currentdate
	public static String getCurrentDate()
	{
		Date date=new Date();
	String currentdate = date.toString();		
		return currentdate;
		
	}
}
