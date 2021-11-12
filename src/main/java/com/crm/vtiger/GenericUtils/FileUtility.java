package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;





public class FileUtility
{ 
	/*
      * author @Mohanraj
      */
	/**
	 * This method used to read data from properties and return the value based on key specified 
	 * @param key
	 * @return
	 * @throws Throwable 
	 */
	
	public String getPropertyKeyValue(String Key) throws Throwable
	{
		FileInputStream file=new FileInputStream(IpathConstant.PROPERTY_FILEPATH);
		Properties prop=new Properties();
		prop.load(file);
		return prop.getProperty(Key);
	}
	/**
	 * This method will return json value based on json key
	 * @throws Throwable 
	 * @param jsonKey
	 * @return jsonValue
	 */
	
	public String getDataFromJson(String jsonKey) throws Throwable
	{
		FileReader reader=new FileReader(IpathConstant.JSON_FILEPATH);
		
		JSONParser parser=new JSONParser();
	    Object object = parser.parse(reader);
	    JSONObject jsonObject = (JSONObject)object;
	    String value = jsonObject.get(jsonKey).toString();
		return value;	
		
	}

}
