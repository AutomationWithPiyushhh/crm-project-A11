package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "img[title='Create Contacts...']")
	private WebElement plusConIcon;

	public WebElement getConPlusIcon() {
		return plusConIcon;
	}

}
