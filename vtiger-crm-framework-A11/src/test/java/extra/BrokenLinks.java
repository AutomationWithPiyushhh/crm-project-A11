package extra;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinks {
	@Test
	public static void facebook() throws IOException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (WebElement i : links) {
			String url = i.getAttribute("href");
			verifyUrl(url);
		}
	}

	public static void verifyUrl(String url) throws IOException {
		try {
			URL urlLink = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlLink.openConnection();
			http.connect();

			if (http.getResponseCode() < 300) {
				System.out.println(url + " is not broken");

			}
		} catch (Exception e) {
			System.out.println(url + " is broken");
		}
	}
}
