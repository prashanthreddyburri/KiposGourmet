package gourmet.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase 
{
	
	//reference variables or global variables 
	
	public static WebDriver driver;
	public static Properties prop;
	
	// creating TestBase class Constructor and read properties file
		public TestBase()
		{
			
			// reading properties file 
			try
			{
				prop = new Properties();
			
				FileInputStream ip = new FileInputStream("F:\\SriJayQA\\Gourmet\\src\\main\\java\\gourmet\\qa\\config\\config.properties");
				prop.load(ip);
			}
			catch(FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			catch(IOException e) 
			{
				e.printStackTrace();
			}
			
		}
		
		
		public static void initialization()
		{
			String browserName = prop.getProperty("browser");
			if(browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "F:\\SriJayQA\\New\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browserName.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "F:\\SriJayQA\\New\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
		
		
			// common browser actions
			// default actions...
		
				driver.manage().window().maximize();	// to maximize browser window
				driver.manage().deleteAllCookies();		// to delete cookies 
				driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
				
				// launching url and getting url from config.properties file....
				
				driver.get(prop.getProperty("ProdPOSURL"));	
				
				
				
				
		
		}
		
		
	
	
	

		
		
		
	}


		



