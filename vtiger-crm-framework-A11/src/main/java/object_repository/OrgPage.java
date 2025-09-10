package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {

	public OrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "img[title='Create Organization...']")
	private WebElement plusIcon;

	@FindBy(name = "accountname")
	private WebElement orgNameField;

	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement saveBtn;

	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement getOrgNameField() {
		return orgNameField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

}
