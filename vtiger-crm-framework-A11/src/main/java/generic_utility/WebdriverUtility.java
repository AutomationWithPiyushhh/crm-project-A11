package generic_utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * This class is designed to use basic selenium methods hassle free
 * 
 * @version 1.1
 * 
 * @author Piyush Baldaniya
 */
public class WebdriverUtility {
	
	WebDriver driver ;
	Actions act;
	WebDriverWait wait;
	
	public WebdriverUtility(WebDriver driver){
		this.driver = driver;
		this.act = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	
	/**
	 * This method will hover on the particular element which is passed,
	 * without creation of Actions class object
	 * 
	 * @param element target to hover
	 * 
	 */
	public void hover(WebElement element) {
		act.moveToElement(element).build().perform();
	}
	
	/*
	 * dropdown
	 * Taking screenshot of web element 
	 * Taking screenshot of web page
	 * Disable notification X
	 * JavascriptExecutor 
	 * 		- click
	 * Alert
	 * DragAndDrop
	 * frames
	 * window handling
	 * window interface methods
	 * click and hold
	 * authentication
	 * window scrolling
	 * scroll to element
	 * waiting commands
	 * double click
	 * key down
	 * key up
	 * release
	 * setHeight
	 * navigation interface
	 * Scroll Into view 
	 * deselect methods
	 * scroll by
	 * manage
	 * verification
	 * move by offset
	 * actions class methods
	 * 
	 */	
	
	

	public void rightClick(WebElement element) {
		act.contextClick(element).build().perform();
	}

	public void rightClick() {
		act.contextClick().build().perform();
	}
	
	public void waitTillClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitTillvisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	

}




