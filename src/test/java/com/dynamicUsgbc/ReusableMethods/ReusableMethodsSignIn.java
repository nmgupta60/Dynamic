package com.dynamicUsgbc.ReusableMethods;

import java.io.IOException;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class ReusableMethodsSignIn extends BaseClass {

	
	public void NewRegistration(int rowNum, String sheetName) throws IOException, InterruptedException {

		String email = data.getCellData(sheetName, "Email", rowNum);
		String password = data.getCellData(sheetName, "Password", rowNum);

		CommonMethod.sendKeys("SignInEmailId", email);
		CommonMethod.testlog("Pass", "Entering Email Id");
		CommonMethod.sendKeys("SignInpassword", password);
		CommonMethod.testlog("Pass", "Entering Password");
		CommonMethod.click("CommunityContinue");
		CommonMethod.testlog("Pass", "Clicked on Sign and Continue");
		/*CommonMethod.assertcontainsmessage("VerifyTextOnPayment", "Confirmation",
				"Didn't Rediredted to the payment page");*/
		CommonMethod.testlog("Pass", "Welcome to the payment page");
	}
	
	
	
	public void SignIn(int rowNum, String sheetName) throws IOException, InterruptedException {

		String email = data.getCellData(sheetName, "Email", rowNum);
		String password = data.getCellData(sheetName, "Password", rowNum);

		CommonMethod.sendKeys("SignInEmailId", email);
		CommonMethod.testlog("Pass", "Entering Email Id");
		CommonMethod.sendKeys("SignInpassword", password);
		CommonMethod.testlog("Pass", "Entering Password");
		CommonMethod.click("CommunityContinue");
		CommonMethod.testlog("Pass", "Clicked on Sign and Continue");
		/*CommonMethod.assertcontainsmessage("VerifyTextOnPayment", "Confirmation",
				"Didn't Rediredted to the payment page");*/
		CommonMethod.testlog("Pass", "Welcome to the payment page");
	}
	
	public void adminSignIn(int rowNum, String sheetName) throws IOException, InterruptedException {

		String email = data.getCellData(sheetName, "AdminEmail", rowNum);
		String password = data.getCellData(sheetName, "AdminPassword", rowNum);

		CommonMethod.sendKeys("AdminEmailId", email);
		CommonMethod.testlog("Pass", "Entering Email Id");
		CommonMethod.sendKeys("AdminPassword", password);
		CommonMethod.testlog("Pass", "Entering Password");
		CommonMethod.click("CommunityContinue");
		CommonMethod.testlog("Pass", "Clicked on Sign and Continue");
		/*CommonMethod.assertcontainsmessage("VerifyTextOnPayment", "Confirmation",
				"Didn't Rediredted to the payment page");*/
		CommonMethod.testlog("Pass", "Welcome to the payment page");
	}

	
}
