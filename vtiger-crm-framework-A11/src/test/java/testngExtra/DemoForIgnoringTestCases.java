package testngExtra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoForIgnoringTestCases {

	@Test
	public void login() {
		System.out.println("Logged in");
	}

	@Test(alwaysRun = true,enabled = false)
	public void search() {
		System.out.println("Searched watch");
	}
	

	@Test(enabled = false)
	public void addTocart() {
//		Failure of testScript
		Assert.assertTrue(true);
		System.out.println("Added to cart");
		Assert.assertTrue(true);
	}
	
	@Test
	public void payment() {
		System.out.println("Payment successfully done !!!");
	}
}
