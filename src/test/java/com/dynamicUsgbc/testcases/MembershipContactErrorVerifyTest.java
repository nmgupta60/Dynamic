package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodMembership;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class MembershipContactErrorVerifyTest extends BaseClass{

	
		@Test
		@Parameters({"rowNum","registerSheet"})
		public void MembershipSignUpPageErrorVerify(int rowNum, String registerSheet) throws IOException {
			
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			CommonMethod.ExtentReportConfig();
			CommonMethod.test = CommonMethod.extent.startTest("MembershipContactPage ErrorVerify", "Verifies Errors displayed").assignCategory("CheckErrors");
			CommonMethod.setUrl(MembershipUrl);
			
			ReusableMethodMembership reuse = new ReusableMethodMembership();
			
			
			try {
				
				reuse.newUserRegistration(registerSheet, rowNum);
				reuse.MembershipContactPageErrorMessageVerify();
				
	            } 
			
			catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
				CommonMethod.takeScreenshot("MembershipContactPageErrorVerify");
				throw e1;
			}
		}
}
