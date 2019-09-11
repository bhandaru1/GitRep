package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.ScreenshotException;


public class BaseInitBrowser {
	
	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializeDrive() throws IOException 
	{
	    prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Bhandaru.000\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome"))
		{
			//execute chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\Driverfiles\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Driverfiles\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Driverfiles\\MicrosoftWebDriver.exe");
			 driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	}
	
		
	


