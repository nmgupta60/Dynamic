package com.dynamicUsgbc.testcases;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodPayment;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsCommunity;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class CommunityRegLoggedInUserFlowTest extends BaseClass {
	
	@Test
	@Parameters({"rowNum" ,"CommunityRegistrationSheet","SignInSheet"})
	public void CommunityRegLoggedInUserFlow(int rowNum, String CommRegSheet, String signinSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("CommunityReg LoggedIn User Flow", "Verifies LoggedIn user Flow").assignCategory("CheckCommunityRegistration");
		CommonMethod.setUrl(CommunityRegistrationUrl);
		
		ReusableMethodsCommunity reuse = new ReusableMethodsCommunity();
		
		try {
			
			reuse.CommunityRegistration(rowNum, CommRegSheet);
			reuse.CommunitySignIn(rowNum, signinSheet);
			reuse.verifyEditDetailsLoggedInUser(rowNum, CommRegSheet);
            } 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("CommunityRegLoggedInUserFlow");
			throw e1;
		}
	}

	

}
