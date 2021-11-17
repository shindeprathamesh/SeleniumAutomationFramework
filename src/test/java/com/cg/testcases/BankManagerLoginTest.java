package com.cg.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cg.base.TestBase;

public class BankManagerLoginTest extends TestBase{
	
	@Test
	public void bankManageroginTest() throws InterruptedException, IOException {
		
		
		log.debug("Inside Login Test!");
		//driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		TestBase.verifyEquals("abc", "abc");
		Thread.sleep(3000);
		click("bmlBtn_XPATH");
		
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustBtn_XPATH"))), "Login Failed!");
		
		log.debug("Login Successfully Executed");
	
		
	}

}
