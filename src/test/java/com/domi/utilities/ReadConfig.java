package com.domi.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() 
	{
		File src = new File("./Configuration/config.properties");
		try 
		{
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception e "+ e.getMessage());
		}
	}
		public String  getApplicationURL()
		{
			String url=pro.getProperty("baseURL");
			return url;
		}
		
		
		public String  chromePath()
		{
			String chromepath=pro.getProperty("chromedriver");
			return chromepath;
		}
		public String  firefoxPath()
		{
			String firefox=pro.getProperty("geckodriver");
			
			return firefox;
		}
	}


