package base_utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class BaseClass {
	public WebDriver driver = null;
	public static WebDriver sdriver ;

	@BeforeSuite
	public void dbConn() {

	}

	@BeforeTest
	public void preCon() {
		System.out.println("Pre conditions");
	}

	@BeforeClass
	public void openBro() throws IOException {
		FileUtility fUtil = new FileUtility();

		String BROWSER = fUtil.getDataFromPropertiesFile("bro");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		sdriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@BeforeMethod
	public void login() throws IOException {
		FileUtility fUtil = new FileUtility();
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");

		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.loginToCRM(USERNAME, PASSWORD);
	}
	

	@AfterMethod
	public void logOut() {
//		Logout
		HomePage hp = new HomePage(driver);
		WebElement profile = hp.getProfile();
		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		wdUtil.hover(profile);
		hp.getSignOut().click();
	}
	
	@AfterClass
	public void closeBro() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterTest
	public void postCon() {
		System.out.println("Post conditions");
	}

	@AfterSuite
	public void dbClose() {

	}
}
