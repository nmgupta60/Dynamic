package com.dynamicUsgbc.ReusableMethods;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class ReusableMethodStore extends BaseClass{

	public void AddProductInCart() throws IOException, InterruptedException {
		
		CommonMethod.click("geenApplePins");
		CommonMethod.testlog("Pass", "Selecting the green apple from the Shopping list");
		CommonMethod.click("addToCart");
		CommonMethod.testlog("Pass", "Adding the items into the cart");
		CommonMethod.assertcontainsmessage("cartProductItem1", "Green Apple Lapel Pins", "Item didn't added to the cart");
		CommonMethod.testlog("Pass", "The item added into the cart successfully");
	}
	
	public void UpdateProductInCart(int rowNum, String sheetName) throws IOException, InterruptedException {
		
		String items  = data.getCellData(sheetName, "ItemCount", rowNum);
		CommonMethod.clear("updateItems");
		Thread.sleep(3000);
		System.out.println(items);
		CommonMethod.sendKeys("updateItems", items);
		CommonMethod.testlog("Pass", "Increasing the product count");
		CommonMethod.click("updateCart");
		CommonMethod.testlog("Pass", "Updating the cart");
	}
	
	public void VerifyPriceInCart(int rowNum, String sheetName) throws IOException, InterruptedException {
		
		String items  = data.getCellData(sheetName, "ItemCount", rowNum);
		int item=Integer.parseInt(items)*30;
		System.out.println(item);
		String price = "$"+Integer.toString(item)+".00";
		CommonMethod.assertcontainsmessage("cartProductPrice1",price ,"Product price didn't matched");
		CommonMethod.testlog("Pass", "Product price verified successfully");
		CommonMethod.assertcontainsmessage("cartTotalPrice", "$150.00", "Total Product price didn't matched");
		CommonMethod.testlog("Pass", "Product total price verified successfully");
		data.setCellData(sheetName, "Amount", rowNum, CommonMethod.getText("cartTotalPrice"));
		CommonMethod.testlog("Pass", "Total price saved into the Excel Sheet");
	}
	
	public void ClickCheckout() throws IOException {
		CommonMethod.click("clickCheckout");
		CommonMethod.testlog("Pass","Clicking on checkout");
	}
	
	public void ShippingAddressProduct(int rowNum, String sheetName) throws IOException, InterruptedException {
	
	String country   = data.getCellData(sheetName, "Country", rowNum);
	String street1	 = data.getCellData(sheetName, "Street1", rowNum);
	String street2 	 = data.getCellData(sheetName, "Street2", rowNum);
	String city		 = data.getCellData(sheetName, "City", rowNum);
	String state 	 = data.getCellData(sheetName, "State", rowNum);
	String zip       = data.getCellData(sheetName, "Zip", rowNum);
	String serviceType = data.getCellData(sheetName, "ServiceType", rowNum);
	String school 	   = data.getCellData(sheetName, "School", rowNum);
	String studentId   = data.getCellData(sheetName, "StudentId", rowNum);
	String graduation  = data.getCellData(sheetName, "Graduation", rowNum);
	
	
	CommonMethod.selectdropdown("shippingCountry", country);
	CommonMethod.testlog("Pass", "Selecting the Country Name");
	CommonMethod.sendKeys("shippingAdd1", street1);
	CommonMethod.testlog( "Pass","Entering Addrress 1");
	CommonMethod.sendKeys("shippingAdd2", street2);
	CommonMethod.testlog( "Pass","Entering Address 2");
	CommonMethod.sendKeys("shippingCity", city);
	CommonMethod.testlog( "Pass","Ebtering City Name");
	CommonMethod.selectdropdown("shippingState", state);
	CommonMethod.testlog( "Pass","Entering State Name");
	CommonMethod.sendKeys("shippingPin",zip );
	CommonMethod.testlog( "Pass","Entering Zip Code");
	CommonMethod.selectdropdown("selectServiceType", serviceType);
	CommonMethod.testlog( "Pass","Selecting the fedex service type");
	Thread.sleep(4000);
	CommonMethod.click("IsStudent");
	CommonMethod.testlog( "Pass","Selecting yes in full time student ");
	CommonMethod.sendKeys("SchoolName", school);
	CommonMethod.testlog( "Pass","Entering the school name");
	CommonMethod.sendKeys("StudentId", studentId);
	CommonMethod.testlog( "Pass","Entering the student id");
	CommonMethod.sendKeys("GraduationDate", graduation);
	CommonMethod.testlog( "Pass","Entering the graduation Date");
	CommonMethod.click("HearEmail");
	CommonMethod.testlog( "Pass","Selecting hear from Email");
	data.setCellData(sheetName,"TotalAmount" , rowNum, CommonMethod.getText("finalShippingPrice"));
	CommonMethod.testlog( "Pass","Saving the data in the excel sheet");
	CommonMethod.click("CommunityContinue");
	CommonMethod.testlog( "Pass","Clicking on the Continue buttn to proceed Payment ");
	Thread.sleep(3000);
	CommonMethod.assertcontainsmessage("VerifyTextSignIn", "Sign In for existing Users",
			"The User Didn't Redirected to SignIn Page");
    CommonMethod.testlog( "Pass", " Welcome to Payment Page");
	}
	
	
	public void StoreContactPageErrorMessageVerify() throws InterruptedException, IOException {
		String[] CommunityRegistrationErrorMsg = {
	
				"Street address field is required.",
				"Street address line 2 field is required.",
				"City field is required.",
				"State field is required.",
				"Zip code field is required.",
				"Please select a shipping option.",
				"Please mention how did you hear about the product."
		};
	
		CommonMethod.click("CommunityContinue");
		Thread.sleep(3000);
	
		List<WebElement> ErrorMsgList = driver.findElements(By.className("input-error-desc"));
		System.out.println(ErrorMsgList.size());
		int i = 0;
		for (WebElement ErrorMsg : ErrorMsgList) {
			System.out.println(ErrorMsg.getText());
			if (ErrorMsg.getText().equals("")) {
	
				continue;
			} else
	
				CommonMethod.assertEqualsMessage(ErrorMsg.getText(), CommunityRegistrationErrorMsg[i],
						"Error Msg is not correct");
	
			i++;
		}
    }	
		
}

