package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodPayment;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodStore;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsSignIn;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class StoreContactPageErrorVerifyTest extends BaseClass{

	
	@Test
	@Parameters({"rowNum" ,"StoreSheet","SignInSheet","PaymentSheet"})
	public void StorePageErrorVerify(int rowNum, String storeSheet,String signInSheet,String paymentSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("StorePageErrorVerify Test", "Verifies Store Functionality").assignCategory("CheckStore");
		CommonMethod.setUrl(StoreUrl);
		
		ReusableMethodStore reuse = new ReusableMethodStore();
		
		try {
			reuse.AddProductInCart();
			reuse.UpdateProductInCart(rowNum, storeSheet);
			reuse.VerifyPriceInCart(rowNum, storeSheet);
			reuse.ClickCheckout();
			reuse.StoreContactPageErrorMessageVerify();
			
            } 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("StorePageErrorVerifyTest");
			throw e1;
		}
	}

	
}
