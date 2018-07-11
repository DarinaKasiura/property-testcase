package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Element {
	
	public Element(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='header_user_info']/a")
	public static WebElement loginButton;
	
	@FindBy(css="#email")
	public static WebElement username;
	
	@FindBy(css="#passwd")
	public static WebElement password;
	
	@FindBy(css="#SubmitLogin")
	public static WebElement signIn;
	
}
