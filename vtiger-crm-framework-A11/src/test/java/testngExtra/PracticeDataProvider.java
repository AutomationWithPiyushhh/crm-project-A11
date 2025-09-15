package testngExtra;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeDataProvider {
	
	@Test(dataProvider = "getData")
	public void case1(String un, String pwd) {
//		String un = "admin";
//		String pwd = "manager";
		System.out.println(un);
		System.out.println(pwd);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] credentials = new Object[5][2];
		credentials[0][0] = "amit";
		credentials[0][1] = "amit@123";
		
		credentials[1][0] = "deepa";
		credentials[1][1] = "deepa@123";
		
		credentials[2][0] = "avinash";
		credentials[2][1] = "avinash@123";
		
		credentials[3][0] = "abhishek";
		credentials[3][1] = "abhishek@123";
		
		credentials[4][0] = "mukesh";
		credentials[4][1] = "mukesh@123";
				
		return credentials;
	}
}
