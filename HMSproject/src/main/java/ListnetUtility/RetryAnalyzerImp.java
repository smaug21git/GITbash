package ListnetUtility;

import org.testng.ITestResult;

public class RetryAnalyzerImp {
	
	public static int retryCount=0;
    public static final int maxRetryCount=5;
    public boolean retry(ITestResult iTestResult) {
        if (retryCount<maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

}
