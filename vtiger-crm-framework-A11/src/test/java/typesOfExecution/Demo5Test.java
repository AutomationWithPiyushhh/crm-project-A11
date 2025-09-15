package typesOfExecution;

import org.testng.annotations.Test;

public class Demo5Test {
	
	@Test(groups = "reg")
	public void case7() {
		System.out.println("I am regression");
	}	
	
	@Test(groups = {"smoke","reg"})
	public void case8() {
		System.out.println("I am smoke as well as regression");
	}	
	
	@Test(groups = "")
	public void case9() {
		System.out.println("I am none");
	}
}
