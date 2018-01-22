package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodMembership;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class MembershipSignUpErrorVerifyTest extends BaseClass{

	@Test
	public void MembershipSignUpPageErrorVerify() throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("MembershipSignUpPage Error Verify", "Verifies Errors displayed").assignCategory("CheckErrors");
		CommonMethod.setUrl(MembershipUrl);
		
		ReusableMethodMembership reuse = new ReusableMethodMembership();
		
		
		try {
			
			reuse.MembershipSignUpErrorMessageVerify();
			
            } 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("MembershipSignUpPageErrorVerify");
			throw e1;
		}
	}

	
	
}
