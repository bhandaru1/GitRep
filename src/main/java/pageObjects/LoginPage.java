package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
public WebDriver driver; //object
By email=By.id("user_email");
By password=By.xpath("//input[@type='password']");
By login=By.cssSelector("input[value='Log In']");

public LoginPage(WebDriver driver)
{
	this.driver = driver;
}
public WebElement getEmail() //method to pull driver object 
{
	return driver.findElement(email);
}
public WebElement getPassword()
{
	return driver.findElement(password);
}
public WebElement getLogin()
{
	return driver.findElement(login);
}
}

