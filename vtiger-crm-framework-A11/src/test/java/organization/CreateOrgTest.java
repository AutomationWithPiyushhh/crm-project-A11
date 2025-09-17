package organization;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.HomePage;
import object_repository.OrgPage;

public class CreateOrgTest extends BaseClass{



	@Test
	public void createOrgTest() throws IOException, InterruptedException {
		FileUtility fUtil = new FileUtility();
		String orgName = fUtil.getStringDataFromExcelFile("Org", 1, 0) + (int) (Math.random() * 9999);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrgPage op = new OrgPage(driver);
		op.getPlusIcon().click();
		WebElement orgField = op.getOrgNameField();
		orgField.sendKeys(orgName);
		op.getSaveBtn().click();

//		Verify
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		Assert.assertEquals(actOrgName, orgName);
		
		System.out.println("it should not get executed in case of failure");
	}
	
}