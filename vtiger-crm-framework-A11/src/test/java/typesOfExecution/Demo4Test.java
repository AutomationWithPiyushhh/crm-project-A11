package typesOfExecution;

import org.testng.annotations.Test;

public class Demo4Test {
	
	@Test(groups = "smoke")
	public void case4() {
		System.out.println("I am smoke");
	}	
	
	@Test(groups = "reg")
	public void case5() {
		System.out.println("I am regression");
	}	
	
	@Test(groups = "reg")
	public void case6() {
		System.out.println("I am regression");
	}
}
