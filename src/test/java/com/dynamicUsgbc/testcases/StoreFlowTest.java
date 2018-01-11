package com.dynamicUsgbc.testcases;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodExamRegistration;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodPayment;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodStore;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsCommunity;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class StoreFlowTest extends BaseClass {
	
	@Test
	@Parameters({"rowNum" ,"StoreSheet","SignInSheet","PaymentSheet"})
	public void StoreFlow(int rowNum, String storeSheet,String signInSheet,String paymentSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("Store Flow Test", "Verifies Store Functionality").assignCategory("CheckStore");
		CommonMethod.setUrl(StoreUrl);
		
		ReusableMethodStore reuse = new ReusableMethodStore();
		ReusableMethodsCommunity reuseSign = new ReusableMethodsCommunity();
		ReusableMethodPayment reusePay = new ReusableMethodPayment();
		
		try {
			
			reuse.AddProductInCart();
			reuse.UpdateProductInCart(storeSheet, rowNum);
			reuse.VerifyPriceInCart(rowNum, storeSheet);
			reuse.ClickCheckout();
			reuse.ShippingAddressProduct(rowNum, storeSheet);
			reuseSign.SignIn(rowNum, signInSheet);
			reusePay.PaymentByCC(rowNum, paymentSheet);
			reusePay.verifyPaymentSuccessful();
			//reuse.VerifyReceiptExam(rowNum, examRegSheet);
			
            } 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("StoreFlow");
			throw e1;
		}
	}

	

}
