package com.dynamicUsgbc.testcases;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodPayment;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodProduct;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodStore;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsCommunity;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsSignIn;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class ProductAdminFlowByCheckTest extends BaseClass {
	
	@Test
	@Parameters({"rowNum" ,"StoreSheet","SignInSheet","ProductSheet","PaymentSheet"})
	public void ProductAdminFlowByCheck(int rowNum, String storeSheet,String signInSheet,String productSheet,String paymentSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("Product AdminFlow ByCheck Test", "Verifies Product Functionality").assignCategory("CheckProduct");
		CommonMethod.setUrl(SignInUrl);
		
		
		ReusableMethodPayment reusePay = new ReusableMethodPayment();
		ReusableMethodsSignIn reuseSign = new ReusableMethodsSignIn();
		ReusableMethodProduct reusePro = new ReusableMethodProduct();
		
		try {
			
			reuseSign.adminSignIn(rowNum, signInSheet);
			CommonMethod.setUrl(ProductUrl);
			reusePro.productFlow(rowNum, productSheet);
			reusePay.verifyProductPaymentDetails(rowNum, productSheet);
			reusePay.PaymentByCheck();
			reusePay.verifyPaymentSuccessful();
			reusePro.VerifyReceiptProduct(rowNum, productSheet);
			
            } 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("ProductAdminFlowByCheck");
			throw e1;
		}
	}

	

}
