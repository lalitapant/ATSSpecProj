package login;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.BaseTestCase;
import page.HomePage;
import page.LoginPage;
import page.ProjectPage1;
import page.ProjectPage2;
import page.ProjectPage3;
import page.ScreenshotUtils;
/**
 * 
 * Test Cases covered
 *-- Login
 *-- Creating a project with Single use Building Class and Type
 *--Creating a project with Multi Use Building Class and Type
 *@author Lalita Pant
 */

public class Login extends BaseTestCase

{
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	ProjectPage1 projectpage1;
	ProjectPage2 projectpage2;
	ProjectPage3 projectpage3;
	FileReader reader;
	Properties props;

	@BeforeMethod
	public void Login() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = getWebDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(getApplicationURL());
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		// Enter user name and password on login page
		loginpage.LoginATS(getUserName(), getPassword());

	}
//Test Method for Single Use Building class and building type
	@Test(priority=1)
	public void SingleUse() {
		try {
			
			String address1="250 Wellington Street";
			//String address = "123 Downtown";
			// Navigating to Home page
			homepage = loginpage.NavigateToHomePage();
			// Validating title of the home page
			Assert.assertEquals(driver.getTitle(), "Spec Tool");
			projectpage1 = homepage.clickNewProject();
			Assert.assertEquals(driver.getTitle(), "Spec Tool");
			// Validating title of the page
			projectpage1.FillFormFewElement("1245", "Australia", "Australian Capital Territory", "Canberra",
					"123 Downtown", "2020-01-31", 320.0, "ATSproj");
			// Clicking Next button and moving on to second step
			projectpage2 = projectpage1.clicknext();
			ScreenshotUtils.takeSnapShot(driver,
					"C:\\Users\\User\\Desktop\\Learning\\ATS\\ATSProject1\\Screenshots\\page2.png");
			projectpage2.selectBuildingInfo("Health Care Facilities", "Hospital");
			// Clicking Next and moving on to Next Page
			projectpage3 = projectpage2.clicknext();
			// Validating title of third step
			Assert.assertEquals(driver.getTitle(), "Spec Tool");
			System.out.println(driver.getTitle());
			//Clicking permissions on third page
			projectpage3.selectPermissions("123 Main Street","view-only");
			driver.quit();
			

		} catch (Exception e) {

		}
	}
//Test Method for Multi Use button which will allow selection of multiple building class and type
	@Test(priority=2)
	public void MultiUse() {
		try {
			String address2= "250 Wellington Street";
			// Navigating to Home page
			homepage = loginpage.NavigateToHomePage();
			// Validating title of the home page
			Assert.assertEquals(driver.getTitle(), "Spec Tool");
			projectpage1 = homepage.clickNewProject();
			Assert.assertEquals(driver.getTitle(), "Spec Tool");
			// Validating title of the page
			projectpage1.FillFormFewElement("1245", "Australia", "Australian Capital Territory", "Canberra",
					address2, "2020-01-31", 320.0, "ATSproj");
			// Clicking Next button and moving on to second step
			projectpage2 = projectpage1.clicknext();
			//Taking SnapShot of 
			ScreenshotUtils.takeSnapShot(driver,
					"C:\\Users\\User\\Desktop\\Learning\\ATS\\ATSProject1\\Screenshots\\page2.png");
			projectpage2.selectBuildingInfo("Commercial, Hospitality, Public Space", "Fire Hall, Entertainment Center, Place of Worship, Luxury");
			// Clicking Next and moving on to Next Page
			projectpage3 = projectpage2.clicknext();
			// Validating title of third step
			Assert.assertEquals(driver.getTitle(), "Spec Tool");
			//Clicking permissions on third page
			projectpage3.selectPermissions("123 Main Street, Brian Young", "view-only, Edit");
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@AfterMethod()
	public void closeCon()
	{
		driver.quit();
	}

}
