package organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {
	public static void main(String[] args) throws InterruptedException, IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\git\\A11-crm-framework\\vtiger-crm-framework-A11\\src\\test\\resources\\commondata.properties");

		Properties pObj = new Properties();
		pObj.load(fis);

		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");

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
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));

		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();

//		Create Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

		String orgName = "qspiders_" + (int) (Math.random() * 9999);
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);

		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

//		Verification

		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.equals(orgName)) {
			System.out.println("Organization created successfully!!!");
		} else {
			System.out.println("Organization could not be created successfully!!!");
		}

//		Logout
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();

		Thread.sleep(3000);
		driver.quit();
	}
}
