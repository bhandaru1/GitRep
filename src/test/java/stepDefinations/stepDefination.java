package stepDefinations;

import org.apache.logging.log4j.message.Message;
import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.BaseInitBrowser;

public class stepDefination extends BaseInitBrowser {

	@Given("^Initialize the chrome browser$")
	public void initialize_the_chrome_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver =initializeDrive();
	}

	@Given("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@Given("^Click on Login lnk in home page to land on Secure sign in page$")
	public void click_on_Login_lnk_in_home_page_to_land_on_Secure_sign_in_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage l = new LandingPage(driver);
		if(l.getPopUpSize()>0){
			l.getPopUP().click();
		}
		
		l.getLogin().click();
	}

	
	 @When("^User enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		 LoginPage lp = new LoginPage(driver);
			lp.getEmail().sendKeys(username);
			lp.getPassword().sendKeys(password);
			lp.getLogin().click(); 
	    }
	 @Then("^Verify that user is successfully logged in$")
		public void verify_that_user_is_successfully_logged_in() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    portalHomePage p = new portalHomePage(driver);
		    Assert.assertTrue(p.getSearchBox().isDisplayed());
		}
	 @And("^close browsers$")
	    public void close_browsers() throws Throwable {
	       driver.quit(); 
	    }




}
