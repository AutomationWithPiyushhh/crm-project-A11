package extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {

//		Step 1> Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("path of the file");
		
//		Step 2> load all the keys by using load() of Properties class
		Properties pObj = new Properties();
		pObj.load(fis);
		
//		step 3> get the value by passing the keys
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);

	}
}
