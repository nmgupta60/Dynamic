package com.dynamicUsgbc.testcases;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodExamRegistration;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodPayment;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsCommunity;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsSignIn;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class ExamRegistrationFlowTest extends BaseClass {
	
	@Test
	@Parameters({"rowNum" ,"ExamRegistrationSheet","SignInSheet","PaymentSheet"})
	public void ExamRegistrationFlow(int rowNum, String examRegSheet, String signinSheet, String paymentSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("Exam Registration Flow", "Verifies Exam Registration Functionality").assignCategory("CheckExamRegistration");
		CommonMethod.setUrl(ExamRegistrationUrl);
		
		ReusableMethodExamRegistration reuse = new ReusableMethodExamRegistration();
		ReusableMethodPayment reusePay = new ReusableMethodPayment();
		ReusableMethodsSignIn reuseSign = new ReusableMethodsSignIn();
		
		try {
			
			reuse.ExamRegistration(rowNum, examRegSheet);
			reuseSign.SignIn(rowNum, signinSheet);
			reuse.clickContinue();
			reuse.CandidateInformation(rowNum, examRegSheet);
			reusePay.verifyExamPaymentDetails(rowNum, examRegSheet);
			reusePay.PaymentByCC(rowNum, paymentSheet);
			reusePay.verifyPaymentSuccessful();
			reuse.VerifyReceiptExam(rowNum, examRegSheet);
			
            } 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("ExamRegistrationFlow");
			throw e1;
		}
	}

	

}
