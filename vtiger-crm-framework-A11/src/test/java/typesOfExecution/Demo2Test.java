package typesOfExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo2Test {
	
	@Parameters("bro")
	@Test
	public void case2(String browser) throws InterruptedException {
		WebDriver driver = null;

//		String browser = "edge";
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.get("https://www.instagram.com/");
		Thread.sleep(2000);
		driver.quit();
	}
	
}
