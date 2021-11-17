package com.cg.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.cg.base.TestBase;
import com.cg.utilities.TestUtil;

public class AddCustomerTest extends TestBase {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void addCustomerTest(Hashtable<String, String> data)
			throws InterruptedException {
		
	
		
		//For skipping the data parameterization
		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		
		log.debug("Inside Add Customer Test!");
		click("addCustBtn_XPATH");
		type("firstName_XPATH", data.get("firstName"));
		type("lastName_XPATH", data.get("lastName"));
		type("postCode_XPATH", data.get("postCode"));
		click("addBtn_XPATH");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
		alert.accept();

		//Assert.fail("Customer not added successfully");

	}

}
