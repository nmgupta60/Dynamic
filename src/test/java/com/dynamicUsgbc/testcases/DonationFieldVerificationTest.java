package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodFieldValidation;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class DonationFieldVerificationTest extends BaseClass{

	
	@Test
	@Parameters({"rowNum" ,"fieldSheet"})
	public void FieldVerificationDonationOnlineCfgs(int rowNum, String fieldSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("Donation Online Cfgs Field Verification", "Verifies Online donation Functionality").assignCategory("CheckDonation");
		CommonMethod.setUrl(DonationsCfgsUrl);
		
		
		ReusableMethodFieldValidation reuse=  new ReusableMethodFieldValidation();
		
		try {
			
			reuse.verifyElementsDonationPage(rowNum, fieldSheet);
			
            } 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("FieldVerificationDonationOnlineCfgs");
			throw e1;
		}
	}

	
	
}
