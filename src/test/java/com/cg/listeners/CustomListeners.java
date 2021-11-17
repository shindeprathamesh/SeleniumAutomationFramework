package com.cg.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.cg.base.TestBase;
import com.cg.utilities.TestUtil;
import com.relevantcodes.extentreports.LogStatus;



public class CustomListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		test = rep.startTest(result.getName().toUpperCase());
		
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		TestBase.test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailure(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output","false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ExtentReports
		//ExtentReports
		TestBase.test.log(LogStatus.FAIL, result.getName().toUpperCase()+" FAILED with exception : "+result.getThrowable());
		TestBase.test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		rep.endTest(test);
		rep.flush();
		
		Reporter.log("<a target=\"_blank\" href = "+TestUtil.screenshotName+">Click to see screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href = "+TestUtil.screenshotName+"><img src ="+TestUtil.screenshotName+" height=200 width =200></img></a>");
		
	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+" Skipped the test as the Run Mode is NO");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
