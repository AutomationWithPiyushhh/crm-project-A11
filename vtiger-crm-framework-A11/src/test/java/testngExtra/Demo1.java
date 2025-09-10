package testngExtra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {
	
	@Test
	public void createOrgTest() throws InterruptedException {
//	public static void main(String[] args) {
		System.out.println("Hey there !");
		Thread.sleep(3999);
	}
	
	@Test
	public void case1() {
//		System.out.println("Hey there !!");
		Reporter.log("Hey there !!! Please go elsewhere....", false);
	}
}
