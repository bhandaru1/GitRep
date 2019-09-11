package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseInitBrowser;

public class HomePage  extends BaseInitBrowser{
	private static Logger Log=LogManager.getLogger(BaseInitBrowser.class.getName());
   @BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDrive();
		Log.info("Driver is initialized");
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to Home page");
		//two ways  access methods of other class
		//1.inheritance 2. Creating object to that class and invoke methods of the class
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();//is nothing but driver.findelemnt(By.css) don't want hard code. pointing to  centralized location if object change update at one place
		//sending anything to argument you have create constructor
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		Message text = null;
		Log.info(text);
		lp.getLogin().click();
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		//Rows stands for how many different data types test should run
		//Column stands for how many values for each test
		Object[][] data = new Object[2][2];
		//0th row
		data[0][0]="nonrestriceduser@gmail.com";
		data[0][1]="1234";
	    //1st row
	    data[1][0]="restricteduser@gmail.com";
		data[1][1]="5678";
  		
	    return data;
				
		
		
	}
	
	
	
	}

	


