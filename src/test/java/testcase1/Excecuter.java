package testcase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Element;
import utility.PropertyClass;

public class Excecuter {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// navigate to the website
		driver.get(PropertyClass.getValue("URL"));
		
	}
	
	@Test(priority=0)
	public void login() {
		Element element = new Element(driver);
		// click on Sign in button
		Element.loginButton.click();
		// verify current URL, to make sure Sign in button works
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		Assert.assertEquals(currentURL, expectedURL);
		// set up properties
		Element.username.sendKeys(PropertyClass.getValue("User"));
		Element.password.sendKeys(PropertyClass.getValue("Password"));
		Element.signIn.click();
		// verify current title to make sure you've successfully signed in 
		String currentTitle = driver.getTitle();
		String expectedTitle = "My account - My Store";
		Assert.assertEquals(currentTitle, expectedTitle);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}	

}
