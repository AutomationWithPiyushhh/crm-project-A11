package avance_reports;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Facebook {
	ExtentReports report;
	
	@BeforeSuite
	public void repConfig() {

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
		String time = now.format(dtf);

		ExtentSparkReporter spark = new ExtentSparkReporter("./advance_html_reports/" + time + ".html");
		spark.config().setDocumentTitle("Facebook-reports");
		spark.config().setReportName("First Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "Chromium");
		report.setSystemInfo("OS", "window");
		report.setSystemInfo("version", "11");

	}
	
	@Test
	public void login() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.facebook.com/");

		ExtentTest test = report.createTest("login");
		test.log(Status.INFO, "This is info....");
		test.log(Status.PASS, "This is passed....");
		test.log(Status.WARNING, "This is warning....");
		test.log(Status.SKIP, "This is skipped....");
		test.log(Status.FAIL, "This is failed....");

		
		TakesScreenshot tks = (TakesScreenshot) driver;
//		File src = tks.getScreenshotAs(OutputType.FILE);
//		File dest = new File("./advance_html_reports/ss.png");
//		FileHandler.copy(src, dest); 
		
		String ss = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss, "image of ss");
		
		driver.quit();
	}
	
	
	@AfterSuite
	public void repBackup() {
		report.flush();
	}
}
