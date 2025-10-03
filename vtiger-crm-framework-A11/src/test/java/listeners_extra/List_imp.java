package listeners_extra;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class List_imp implements ISuiteListener, ITestListener {

	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {

		System.out.println("=================onstart=================");
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

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("=================onTestStart=================");

		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("=================onTestSuccess=================");
		test.log(Status.PASS,"");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("=================onTestFailure=================");
		test.log(Status.FAIL, "This is failing...");
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("=================onTestSkipped=================");
		test.log(Status.SKIP, "This is skipping...");
	}
	
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("=================onFinish=================");
		report.flush();
	}
}
