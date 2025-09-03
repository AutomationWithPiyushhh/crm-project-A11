package extra;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.WebDriverUtility;

public class Facebook {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.facebook.com/r.php?entry_point=login");

		WebDriverUtility wdUtil = new WebDriverUtility(driver);
//		wdUtil.takeScreenshot("first");

		driver.get("http://shoppersstack.com/products_page/39");

		Thread.sleep(20000);
		String pid = driver.getWindowHandle();

		driver.findElement(By.id("compare")).click();

//		Set<String> IDs = driver.getWindowHandles();
//
//		for (String i : IDs) {
//			driver.switchTo().window(i);
//
//			if (driver.getTitle().contains("Pay")) {
//				break;
//			}
//		}
		
		wdUtil.closeAllChildWindows(pid);
		Thread.sleep(3000);
		driver.close();
		
		Thread.sleep(3000);

		wdUtil.switchToParentWindow(pid);

		Thread.sleep(3000);
		driver.quit();
	}
}
