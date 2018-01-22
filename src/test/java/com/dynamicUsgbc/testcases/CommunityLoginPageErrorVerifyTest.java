package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodsCommunity;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class CommunityLoginPageErrorVerifyTest extends BaseClass{

	
	@Test
	@Parameters({"rowNum" ,"CommunityRegistrationSheet"})
	public void CommunityLoginPageErrorVerify(int rowNum, String CommRegSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("CommunityLoginPageErrorVerify Test", "Verifies if Community Registration is done successfully").assignCategory("CheckCommunityRegistration");
		CommonMethod.setUrl(CommunityRegistrationUrl);
		
		ReusableMethodsCommunity reuse = new ReusableMethodsCommunity();
		try {
			
			reuse.CommunityRegistration(rowNum, CommRegSheet);
			reuse.CommunityLogInPageErrorMessageVerify();
			
            } 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("CommunityLoginPageErrorVerifyTest");
			throw e1;
		}
	}

	
}
