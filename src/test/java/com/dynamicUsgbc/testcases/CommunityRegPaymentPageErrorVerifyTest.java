package com.dynamicUsgbc.testcases;



import java.io.IOException;

import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodPayment;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class CommunityRegPaymentPageErrorVerifyTest extends BaseClass {
	
	@Test
	public void CommunityRegPaymentPageErrorVerify() throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("CommunityReg Payment Page Error Verify", "Verifies Errors displayed").assignCategory("CheckErrors");
		CommonMethod.setUrl(CommunityRegistrationUrl);
		
		ReusableMethodPayment reusePay = new ReusableMethodPayment();
		
		
		try {
		
			reusePay.CommunityRegistrationPaymentPageErrorMessageVerify();
			
            } 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("CommunityRegPaymentPageErrorVerify");
			throw e1;
		}
	}

	

}
