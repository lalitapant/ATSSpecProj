package page;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestCase {
	
	
	public static String getApplicationURL() throws IOException
	
	{		
		Properties props = new Properties();
		// load the properties file:
		props=configReader();		
		String url = props.getProperty("URL");
				
		return url;

	}
	public static String getUserName() throws IOException
	
	{		
		Properties props = new Properties();
		// load the properties file:
		props=configReader();		
		String username = props.getProperty("username");
				
		return username;

	}
	public static String getPassword() throws IOException
	
	{		
		Properties props = new Properties();
		// load the properties file:
		props=configReader();		
		String pwd = props.getProperty("pwd");
				
		return pwd;

	}
	

	public static WebDriver getWebDriver() 
	{

		return new ChromeDriver();
	}
	public static Properties configReader() throws IOException
	{
		FileReader reader;
		Properties props;
		
		String configpath="C:\\Users\\User\\Desktop\\Learning\\ATS\\ATSProject1\\src\\main\\resources\\config.properties";
		File configFile = new File(configpath);//Take file from the location specified
		reader = new FileReader(configFile);//
		props=new Properties();
		props.load(reader);
		
		return props;
		
	}
	
}
