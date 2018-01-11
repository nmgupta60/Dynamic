package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodPayment;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodSponsorship;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsCommunity;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsDonations;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class SponsorshipFlowTest  extends BaseClass{

	
	@Test
	@Parameters({"rowNum" ,"SponsorshipSheet","PaymentSheet", "SignInSheet"})
	public void SponsorshipFlow(int rowNum, String sponsorshipSheet,String paymentSheet, String SignInSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("Sponsorship Community", "Verifies Online sponsorship Functionality").assignCategory("CheckSponsorship");
		CommonMethod.setUrl(SponsorshipUrl);
		
		ReusableMethodSponsorship reuse = new ReusableMethodSponsorship();
		ReusableMethodPayment reusePay = new ReusableMethodPayment();
		ReusableMethodsCommunity reuseComm= new ReusableMethodsCommunity();
		try {
			
			reuse.Sponsorship(rowNum, sponsorshipSheet);
			reuseComm.SignIn(rowNum, SignInSheet);
			reusePay.verifySponsershipPaymentDetails(rowNum, sponsorshipSheet);
			reusePay.PaymentByCC(rowNum, paymentSheet);
			reusePay.verifyPaymentSuccessful();
			//reuse.VerifyReceiptDonation(rowNum, sponsorshipSheet);
			
            } 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("SponsorshipCommunity");
			throw e1;
		}
	}
	
}
