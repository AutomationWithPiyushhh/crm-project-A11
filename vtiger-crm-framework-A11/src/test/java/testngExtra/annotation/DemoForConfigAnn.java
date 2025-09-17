package testngExtra.annotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoForConfigAnn {

	@BeforeSuite
	public void dbConn() {
		System.out.println("Database connectivity + Report configuration");
	}

	@BeforeTest
	public void preCon() {
		System.out.println("Pre conditions");
	}

	@BeforeClass
	public void openBro() {
		System.out.println("browser open");
	}

	@BeforeMethod
	public void login() {
		System.out.println("login");
	}

	@AfterMethod
	public void logOut() {
		System.out.println("logout");
	}

	@AfterClass
	public void closeBro() {
		System.out.println("browser close");
	}

	@AfterTest
	public void postCon() {
		System.out.println("Post conditions");
	}

	@AfterSuite
	public void dbClose() {
		System.out.println("Database connectivity close + Report Backup");
	}
}

class Execution extends DemoForConfigAnn {
	@Test
	public void orgTest() {
		System.out.println("Create organization");
	}

	@Test
	public void conTest() {
		System.out.println("Create contact");
	}
}