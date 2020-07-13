package com.demoguru99.Magenta.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigurationReader {

	private static Properties configFile;
	

	public static String getProperty(String key)
	{
		String value = null;
		try {
				
				String path = "Configuration.properties";
				FileInputStream input = new FileInputStream(path);
				configFile = new Properties();
				configFile.load(input);
				value = configFile.getProperty(key);
				input.close();
				
				//return value;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return value;
	}
	
	public static String getProperty(String key, String path)
	{
		String value = null;
		try {
				
				//path = "Configuration.properties";
				FileInputStream input = new FileInputStream(path);
				configFile = new Properties();
				configFile.load(input);
				value = configFile.getProperty(key);
				input.close();
				
				//return value;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return value;
	}
	public static void  SetProperty(String key, String value)
	{
		try {
				
				String path = "Email.properties";
				OutputStream out = new FileOutputStream(path);
				configFile = new Properties();
				configFile.setProperty(key, value);
				configFile.store(out, null);
				out.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
