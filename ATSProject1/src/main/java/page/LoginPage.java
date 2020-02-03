package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver; 

		PageFactory.initElements(driver, this); 

	}
@FindBy(xpath="//input[@name='password'][@type='password']")
WebElement password;
@FindBy(xpath="//input[@name='username'][@type='text']")
WebElement username;
@FindBy(xpath="//button/span[contains(text(),'Login')]")
WebElement login;
@FindBy(css="input[type='text']")
WebElement logincss;

//PageFactory.initElements(driver);
public void LoginATS(String uname,String pwd)
{
	
	username.sendKeys(uname);
	password.sendKeys(pwd);
	//login.click();
	login.click();
}

public HomePage NavigateToHomePage()

{
	//HomePage homepage=new HomePage();
return new HomePage(driver);
}

}
