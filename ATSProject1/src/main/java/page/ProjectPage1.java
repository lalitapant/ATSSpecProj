package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage1
{

	WebDriver driver;
	@FindBy(xpath="//label[contains(text(),'Bid Date')]/following-sibling::div/input")
	WebElement date;
	@FindBy(xpath="//label[contains(text(),'Project Name *')]/following-sibling::div/input")
	WebElement projName;
	@FindBy(xpath="//label[contains(text(),'Internal No. (if applicable)')]/following-sibling::div/input")
	WebElement intNo;
	@FindBy(xpath="//label[contains(text(),'Country *')]/following-sibling::div/div/input")
	WebElement countrytext;
	@FindBy(xpath="//label[contains(text(),'State/Province *')]/following-sibling::div/div/input")
	WebElement stateProvtext;
	@FindBy(xpath="//label[contains(text(),'City *')]/following-sibling::div/div/input")
	WebElement citytext;
	@FindBy(xpath="//label[contains(text(),'Address')]/following-sibling::div/textarea[1]")
	WebElement addresstext;
	@FindBy(xpath="//label[contains(text(),'Area (in sq. ft.) *')]/following-sibling::div/input")
	WebElement areatext;
	@FindBy(xpath="//button[@type='submit']")
	WebElement nextButton;
	@FindBy(css="input[class*='MuiInputBase-input']")
	List<WebElement> ele; 
	@FindBy(css="ul[role='listbox'] li")
	List<WebElement> list;
	
	//Constructor
	
	public ProjectPage1(WebDriver driver) 
	{
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
//Mehod to fill form
	public void FillFormFewElement(String intnum,String country,String state,String city,String address,String bidDate,double area,String projname) throws InterruptedException
	{	//WebElement element=null;
		//WebDriverWait wait = new WebDriverWait(driver, 60);
		//element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul[role='listbox'] li")));
		//List<WebElement> block1 = driver.findElements(By.xpath("//div/div/div/div/input"));
		//driver.findElement(By.cssSelector("span[class*='MuiButton-label']")).click();
		 ele.get(0).sendKeys(intnum);
		 ele.get(1).sendKeys(projname);
		  ele.get(2).sendKeys(country);
		 list.get(0).click();
		 ele.get(3).sendKeys(state);
		 list.get(0).click();
		 ele.get(4).sendKeys(city);
		 //Thread.sleep(5000);
		 Actions act=new Actions(driver);
		 act.moveToElement(addresstext).click().build().perform();//Mouse hover over address text area and add text
		 //if(driver.findElement(By.cssSelector("textarea[class*='MuiInputBase-input']")).)
		 driver.findElement(By.cssSelector("textarea[class*='MuiInputBase-input']")).sendKeys(address);
		 ele.get(5).sendKeys(bidDate);
		 String areadoub=String.valueOf(area);
		 ele.get(6).sendKeys(areadoub);
		
		
		 
		//Using Xpath
		/*projName.sendKeys(projname);
		intNo.sendKeys(intnum);
		countrytext.sendKeys(country);
		stateProvtext.sendKeys(state);
		citytext.sendKeys(city);
		addresstext.sendKeys(address);
		date.sendKeys(bidDate);
		*/
	}
	//Clicking on Next button
	public ProjectPage2 clicknext()
	{
		nextButton.click();
		return new ProjectPage2(driver);
	}
}


