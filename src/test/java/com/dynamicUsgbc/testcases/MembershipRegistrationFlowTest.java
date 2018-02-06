package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodMembership;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodPayment;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsCommunity;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsSignIn;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class MembershipRegistrationFlowTest extends BaseClass{

	
	@Test
	@Parameters({"rowNum" ,"memberSheet","PaymentSheet","SignInSheet"})
	public void MembershipRegistration(int rowNum, String memberSheet, String paymentSheet, String signinSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("Membership Registration Flow", "Verifies Membership Registration Functionality").assignCategory("MembershipRegistration");
		CommonMethod.setUrl(MembershipUrl);
		
		ReusableMethodMembership reuse = new ReusableMethodMembership();
		ReusableMethodPayment reusePay = new ReusableMethodPayment();
		ReusableMethodsSignIn reuseSign = new ReusableMethodsSignIn();
		try {
			
			reuse.clickSignInMembershipPage();
			reuseSign.SignIn(rowNum, signinSheet);
			reuse.membershipContact(memberSheet, rowNum);
			reuse.membershipDetails(memberSheet, rowNum);
			reusePay.verifyMembershipPaymentDetails(rowNum, memberSheet, paymentSheet,signinSheet);
			reusePay.PaymentByCC(rowNum, paymentSheet);
			reuse.VerifyReceiptMembership(rowNum, memberSheet);
			reusePay.verifyPaymentSuccessful();
			
			
            } 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("MembershipRegistrationFlow");
			throw e1;
		}
	}

	
}
