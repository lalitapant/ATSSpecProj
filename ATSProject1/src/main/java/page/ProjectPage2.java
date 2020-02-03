package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage2 {
WebDriver driver;
//input[contains(@value,'Dealership / Service Center')]
//@FindBy(xpath="//input[@type='radio'][@name='FormSelectedBuildingTypesKey.6.FormSingleKey']")
@FindBy(css="span[class*='MuiTypography']")
List<WebElement>buildingType;
@FindBy(css="div[class*='MuiCardContent']")
List<WebElement>buildingClass;
@FindBy(xpath="//button[@type='submit']")
WebElement nextbtn;
@FindBy(xpath="//input[@name='isMulti']")
WebElement multiuse;

@FindBy(xpath="//span[text()='Back']")
WebElement backbtn;


	public ProjectPage2(WebDriver driver)
	{
		this.driver = driver; 

		PageFactory.initElements(driver, this); 

	}
	public void SelectBuildingClass(String bclass )
	{

	//driver.findElement(By.xpath("//p[contains(text(),'"+bclass+"')]")).click();
		 for(int iLoop = 0; iLoop<=buildingClass.size(); iLoop++) {

			  if(buildingClass.get(iLoop).getText().equalsIgnoreCase(bclass)) {

				  buildingClass.get(iLoop).click();

				  //Thread.sleep(2000);

				  break;

			  }
		 }
	}
	
	
	public void SelectBuildingType(String btype)
	{
		//driver.findElement(By.xpath("//input[contains(@value,'"+btype+"')]")).click();Code using xpath
		 for(int iLoop = 0; iLoop<=buildingType.size(); iLoop++) {

			  if(buildingType.get(iLoop).getText().equalsIgnoreCase(btype)) {

				  buildingType.get(iLoop).click();

				  

				  break;

			  }
	}
	}
	//Method to select Building Class and corresponding building type on the basis of Single use and Multi Use
	public void selectBuildingInfo(String buildingInfo, String category) throws InterruptedException {
		String[] arrBuilding = buildingInfo.split(",");
		String[] arrCategory = category.split(",");
		if(arrBuilding.length > 1) {
		driver.findElement(By.cssSelector("input[class*='MuiSwitch-input']")).click();
		}
		for(int iLoop = 0 ; iLoop <arrBuilding.length; iLoop++) {
		
		for (int iLoop1 = 0; iLoop1 < buildingClass.size(); iLoop1++) {
		
		if (buildingClass.get(iLoop1).getText().equalsIgnoreCase(arrBuilding[iLoop].trim())) {
			buildingClass.get(iLoop1).click();
		
		}
		}
		}

		for(int iLoop = 0 ; iLoop <arrCategory.length; iLoop++) {
		//List<WebElement> buildingType = driver.findElements(By.cssSelector("span[class*='MuiTypography']"));
		for (int iLoop1 = 0; iLoop1 < buildingType.size(); iLoop1++) {
		if (buildingType.get(iLoop1).getText().equalsIgnoreCase(arrCategory[iLoop].trim())) {
		buildingType.get(iLoop1).click();
		
		}
		}
		}

				
		}

	public ProjectPage3 clicknext()
	{
		nextbtn.click();
		return new ProjectPage3(driver);
	}
	
	public void clickback()
	{
	backbtn.click();	
	}
	
}
