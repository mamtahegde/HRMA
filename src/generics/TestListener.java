package generics;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hrm.base.AutomationConstants;

public class TestListener implements ITestListener{

	
	public void onTestStart(ITestResult result) {	
	}

	public void onTestSuccess(ITestResult result) {
	}

	public void onTestFailure(ITestResult result) {
		Utility.getScreenShot(AutomationConstants.SNAP_PATH);
		//we cannot call another getscreenshot method because we do not have driver variable here
	}

	public void onTestSkipped(ITestResult result) {
    }

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}

}
