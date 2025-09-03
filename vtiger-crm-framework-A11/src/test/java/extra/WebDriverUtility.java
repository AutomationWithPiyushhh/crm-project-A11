package extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility{
	WebDriver driver;
	Actions act;
	
	WebDriverUtility(WebDriver driver){
		this.driver = driver;
		this.act = new Actions(driver);
	}
	
	public void hover(WebElement element) {
		act.moveToElement(element).build().perform();
	}
	
	public void rightClick(WebElement element) {
		act.contextClick(element).build().perform();
	}
	
}