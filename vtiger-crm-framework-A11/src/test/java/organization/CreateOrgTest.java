package organization;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OrgPage;

public class CreateOrgTest {
	@Test
	public void createOrgTest() throws IOException, InterruptedException {

		FileUtility fUtil = new FileUtility();

		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");

		String orgName = fUtil.getStringDataFromExcelFile("Org", 1, 0) + (int) (Math.random() * 9999);
		System.out.println(orgName);

		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);

//		Login
		LoginPage lp = new LoginPage(driver);

		lp.loginToCRM(USERNAME, PASSWORD);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrgPage op = new OrgPage(driver);
		op.getPlusIcon().click();
		WebElement orgField = op.getOrgNameField();
		orgField.sendKeys(orgName);

		op.getSaveBtn().click();

		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.equals(orgName)) {
			System.out.println("Organization created successfully!!!");
		} else {
			System.out.println("Organization could not be created successfully!!!");
		}

//		Logout
		WebElement profile = hp.getProfile();
		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		wdUtil.hover(profile);
		hp.getSignOut().click();

		Thread.sleep(3000);
		driver.quit();
	}
}