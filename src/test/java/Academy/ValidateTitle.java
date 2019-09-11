package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseInitBrowser;

public class ValidateTitle  extends BaseInitBrowser{
	private static Logger Log=LogManager.getLogger(BaseInitBrowser.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDrive();
		driver.get(prop.getProperty("url"));
		Log.info("Driver is initialized");
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		//two ways  access methods of other class
		//1.inheritance 2. Creating object to that class and invoke methods of the class
		LandingPage l = new LandingPage(driver);
		
		//l.getLogin().click();//is nothing but driver.findelemnt(By.css) don't want hard code. pointing to  centralized location if object change update at one place
		//sending anything to argument you have create constructor
		//compare the text browser with actual text
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		Log.info("Successfully validated Text Message");
	
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
	}

	


