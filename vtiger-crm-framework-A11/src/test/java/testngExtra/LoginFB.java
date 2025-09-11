package testngExtra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginFB {
	
	@Test(invocationCount = 3)
	public void logginInToFaceBook() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.facebook.com/");
		
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));

		username.sendKeys("admin");
		password.sendKeys("manager");
		
		Thread.sleep(500);

		driver.findElement(By.name("login")).click();
		
		Thread.sleep(1000);
		driver.quit();
	}
}
