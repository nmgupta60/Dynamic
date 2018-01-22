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

public class ProductAdminFlowTest extends BaseClass {
	
	@Test
	@Parameters({"rowNum" ,"StoreSheet","SignInSheet","ProductSheet","PaymentSheet"})
	public void ProductAdminFlow(int rowNum, String storeSheet,String signInSheet,String productSheet,String paymentSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("Product Admin Flow Test", "Verifies Product Functionality").assignCategory("CheckProduct");
		CommonMethod.setUrl(SignInUrl);
		
		
		ReusableMethodPayment reusePay = new ReusableMethodPayment();
		ReusableMethodsSignIn reuseSign = new ReusableMethodsSignIn();
		ReusableMethodProduct reusePro = new ReusableMethodProduct();
		
		try {
			
			reuseSign.adminSignIn(rowNum, signInSheet);
			CommonMethod.setUrl(ProductUrl);
			reusePro.productFlow(rowNum, productSheet);
			reusePay.verifyProductPaymentDetails(rowNum, productSheet);
			reusePay.PaymentByCC(rowNum, paymentSheet);
			reusePay.verifyPaymentSuccessful();
			reusePro.VerifyReceiptProduct(rowNum, productSheet);
			
            } 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("ProductAdminFlow");
			throw e1;
		}
	}

	

}
