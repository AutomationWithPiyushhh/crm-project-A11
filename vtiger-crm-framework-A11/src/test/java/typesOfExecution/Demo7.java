package typesOfExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo7 {

	@Parameters({"un","pwd","bro","url"})
	@Test
	public void case7(String un , String pwd, String bro, String url) {
		
//		String un = "admin";
//		String pwd = "manager";
//		String bro = "chrome";
//		String url = "http://localhost:8888";
//		
		System.out.println(un);
		System.out.println(pwd);
		System.out.println(bro);
		System.out.println(url);
	}	
}
