package com.goodreads.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.goodreads.base.XlsReader;

public class BaseClass implements IAutoConstant{

	protected static WebDriver driver;
	public XlsReader xls=new XlsReader(Excel_File_Path);
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void preConditionTest(){
		
		Properties propFile = ReadFile.readPropertiesFile();
		String browser = propFile.getProperty("browser").toLowerCase();
		
		if(browser.contains("chrome")){
			
			 // Create object of DesiredCapabilities class
			DesiredCapabilities cap= new DesiredCapabilities();
			// Set ACCEPT_SSL_CERTS  variable to true
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			// Set the driver path
			System.setProperty(Chrome_Driver, Chrome_Path);
			 
			// Open browser with capability
			 driver=new ChromeDriver(cap);
		}
		else if(browser.contains("firefox")){
			driver=new FirefoxDriver();
		}
		else if(browser.contains("edge")){
			System.setProperty(Edge_Driver, Edge_Path);
			driver=new EdgeDriver();
		}
		else
			System.out.println("No input browser");
		driver.get(propFile.getProperty("URL").toLowerCase());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	  	//driver.get("http://132.148.128.96/#/account/login");
	  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	
	
	
}
