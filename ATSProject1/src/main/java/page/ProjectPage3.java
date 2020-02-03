package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage3 {
	WebDriver driver;
	@FindBy(css = "div[aria-colindex='1'][role='gridcell']")
	List<WebElement> farm;
	@FindBy(css = "input[type='checkbox']")
	List<WebElement> permission;
	@FindBy(xpath="//button[@type='submit']")
	WebElement finish;

//Constructor
	public ProjectPage3(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

//Method to set Permissions
	public void selectPermissions(String farmName, String permissions) throws InterruptedException {
		String[] arrfarmName = farmName.split(",");
		String[] arrpermissions = permissions.split(",");
		for (int iLoop = 0; iLoop < arrfarmName.length; iLoop++) {
			List<WebElement> farm = driver.findElements(By.cssSelector("div[aria-colindex='1'][role='gridcell']"));
			for (int iLoop1 = 0; iLoop1 < farm.size(); iLoop1++) {
				
				if (farm.get(iLoop1).getText().equalsIgnoreCase(arrfarmName[iLoop].trim())) {
					List<WebElement> permission = driver.findElements(By.cssSelector("input[type='checkbox']"));
					for (int iLoop2 = 0; iLoop2 < arrpermissions.length; iLoop2++) {
						for (int iLoop4 = 0; iLoop4 < 3; iLoop4++) {
							if (permission.get(iLoop4).getAttribute("value")
									.equalsIgnoreCase(arrpermissions[iLoop2].trim())) {
								permission.get(iLoop1 * 3 + iLoop4).click();
								Thread.sleep(1000);
								
							}
						}
					}
				}
			}
		}
		finish.click();
		}

}
