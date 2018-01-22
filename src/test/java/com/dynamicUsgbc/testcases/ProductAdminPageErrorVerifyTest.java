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

public class ProductAdminPageErrorVerifyTest extends BaseClass {
	
	@Test
	@Parameters({"rowNum" ,"SignInSheet"})
	public void ProductAdminPageErrorVerify(int rowNum, String signInSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("ProductAdminPage ErrorVerify Test", "Verifies Product Functionality").assignCategory("CheckProduct");
		CommonMethod.setUrl(SignInUrl);
		
		ReusableMethodsSignIn reuseSign = new ReusableMethodsSignIn();
		ReusableMethodProduct reusePro = new ReusableMethodProduct();
		
		try {
			
			reuseSign.adminSignIn(rowNum, signInSheet);
			CommonMethod.setUrl(ProductUrl);
			reusePro.ProductPageErrorMessageVerify();
			
            } 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("ProductAdminPageErrorVerify");
			throw e1;
		}
	}

	

}
