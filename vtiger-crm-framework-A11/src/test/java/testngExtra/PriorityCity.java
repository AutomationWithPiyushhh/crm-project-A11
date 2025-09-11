package testngExtra;

import org.testng.annotations.Test;

public class PriorityCity {
	@Test
	public void createCity() {
		System.out.println("noida created");
	}
	
	@Test
	public void modify() {
		System.out.println("noida created");
		System.out.println("noida modified to Okhla");
	}
	
	@Test
	public void deleteCity() {
		System.out.println("Okhla created");
		System.out.println("Okhla deleted");
	}
}
