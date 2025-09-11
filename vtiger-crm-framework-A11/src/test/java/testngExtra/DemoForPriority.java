package testngExtra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoForPriority {

	@Test(priority = 1)
	public void login() {
		System.out.println("Logged in");
	}

	@Test(priority = 2)
	public void search() {
		System.out.println("Logged in");
		System.out.println("Searched watch");
	}

	@Test(priority = 3)
	public void addTocart() {
//		Failure of testScript
		Assert.assertTrue(true);
		System.out.println("Added to cart");
		Assert.assertTrue(true);
	}

	@Test(priority = 4)
	public void payment() {
		System.out.println("Payment successfully done !!!");
	}

}
