package com.domi.testCases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.domi.utilities.ReadConfig;


public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		

		if (br.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.chromePath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			
			
			

		} 
		else 
		{

			System.setProperty("webdriver.gecko.driver", readconfig.firefoxPath());
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary("C:\\Users\\Spotcheck\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
			
			
		}

			driver.get(baseURL);
		
		
		
		}
	
	public void sleep(long millesec) {
		Date d;
		long start, now;
		d = new Date();
		start = d.getTime();
		do {
			d = new Date();
			now = d.getTime();		
		}while((now - start) < millesec);
	
	}
	
	
}
