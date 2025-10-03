package listeners_extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class JustToProve {



	@Test(retryAnalyzer = listeners_extra.List_Imp_retry.class)
	public void case2() {
		Assert.assertTrue(false);
	}

	
	
	
	
	
	
	
	

	@Test(retryAnalyzer = listeners_extra.List_Imp_retry.class)
	public void amazon() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement verify = driver.findElement(By.cssSelector("a[aria-label='Amazon.in']"));
		Assert.assertTrue(verify.isDisplayed());
	}
}
