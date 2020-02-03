package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver; 

		PageFactory.initElements(driver, this); 

	}
	
	@FindBy(xpath="//a/span[contains(text(),'New Project')]")
	WebElement newproject;
	public ProjectPage1 clickNewProject()
	{
		newproject.click();
		return new ProjectPage1(driver);
	}
}
