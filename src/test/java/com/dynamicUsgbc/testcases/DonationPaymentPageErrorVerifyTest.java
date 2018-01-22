package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodPayment;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsDonations;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class DonationPaymentPageErrorVerifyTest extends BaseClass{

	
		@Test
		@Parameters({"rowNum" ,"DonationSheet","PaymentSheet"})
		public void DonationOnlinePayementPageError(int rowNum, String donationsheet,String paymentSheet) throws IOException, InterruptedException {
			
			
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			CommonMethod.ExtentReportConfig();
			CommonMethod.test = CommonMethod.extent.startTest("DonationOnlinePaymentPage Error Test", "Verifies Online donation Functionality").assignCategory("CheckDonation");
			CommonMethod.setUrl(DonationsHaitiUrl);
			
			ReusableMethodsDonations reuse = new ReusableMethodsDonations();
			ReusableMethodPayment reusePay = new ReusableMethodPayment();
			
			try {
				
				reuse.DonationByOnline(rowNum, donationsheet);
				reusePay.verifyDonationPaymentDetails(rowNum, donationsheet);
				reusePay.PaymentPageErrorMessageVerify();
	            } 
			
			catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
				CommonMethod.takeScreenshot("DonationOnlinePaymentPageTest");
				throw e1;
			}
		}
	
}
