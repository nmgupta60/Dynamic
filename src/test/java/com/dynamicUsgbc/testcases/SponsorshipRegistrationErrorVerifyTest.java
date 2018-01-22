package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodSponsorship;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class SponsorshipRegistrationErrorVerifyTest extends BaseClass{
	
	@Test
	@Parameters()
	public void SponsorshipRegistrationErrorVerify() throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("SponsorshipRegistrationPage Error Test", "Verifies Online sponsorship Functionality").assignCategory("CheckSponsorship");
		CommonMethod.setUrl(SponsorshipUrl);
		
		ReusableMethodSponsorship reuse = new ReusableMethodSponsorship();
		
		try {
			
			reuse.SponsorshipPageErrorMessageVerify();
			
		} 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("SponsorshipRegistrationPageErrorTest");
			throw e1;
		}
	}
	
}
