package com.dynamicUsgbc.testcases;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodPayment;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsCommunity;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class CommunityRegPageErrorVerifyTest extends BaseClass {
	
	@Test
	@Parameters({"rowNum" ,"CommunityRegistrationSheet","SignInSheet"})
	public void CommunityRegPaymentPageErrorVerify(int rowNum, String CommRegSheet, String signinSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("CommunityReg PaymentPage Error Verify", "Verifies Errors displayed").assignCategory("CheckErrors");
		CommonMethod.setUrl(CommunityRegistrationUrl);
		
		ReusableMethodsCommunity reuse = new ReusableMethodsCommunity();
		ReusableMethodPayment reusePay = new ReusableMethodPayment();
		
		try {
			
			reuse.CommunityRegistration(rowNum, CommRegSheet);
			reuse.CommunitySignIn(rowNum, signinSheet);
			reuse.CommunityRegistrationPageErrorMessageVerify();
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
