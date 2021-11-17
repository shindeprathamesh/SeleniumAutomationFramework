package com.cg.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.cg.base.TestBase;
import com.cg.utilities.TestUtil;

public class OpenAccountTest extends TestBase {
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void openAccountTest(Hashtable<String, String> data) throws InterruptedException {

		if (!TestUtil.isTestRunnable("openAccountTest", excel)) {

			throw new SkipException("Skipping the test " + "openAccountTest" + " as the Run mode is NO");
		}
		
		click("openAccountBtn_XPATH");
		select("selectCustomer_XPATH", data.get("customer"));
		select("currency_XPATH", data.get("currency"));
		click("process_XPATH");
		Thread.sleep(3000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

	}

}
