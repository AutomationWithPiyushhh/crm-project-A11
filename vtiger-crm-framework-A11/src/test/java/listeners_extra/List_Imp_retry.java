package listeners_extra;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class List_Imp_retry implements IRetryAnalyzer {

	int count = 0;
	int initCount = 7;

	@Override
	public boolean retry(ITestResult result) {
		if (count < initCount) {
			count++;
			return true;
		} else {
			return false;
		}
	}
}
