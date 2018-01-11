package com.dynamicUsgbc.ReusableMethods;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class ReusableMethodsDonations extends BaseClass{

	public void DonationByEmailProjectHaiti(int rowNum, String sheetName) throws IOException, InterruptedException {
		
		String amount      = data.getCellData(sheetName, "Amount", rowNum);
		String donorName   = data.getCellData(sheetName, "DonorName", rowNum);
		String dedicatedTo   = data.getCellData(sheetName, "DedicatedTo", rowNum);
		String email     = data.getCellData(sheetName, "Email", rowNum);
		String country   = data.getCellData(sheetName, "Country", rowNum);
		String street1	 = data.getCellData(sheetName, "Street1", rowNum);
		String street2 	 = data.getCellData(sheetName, "Street2", rowNum);
		String city		 = data.getCellData(sheetName, "City", rowNum);
		String state 	 = data.getCellData(sheetName, "State", rowNum);
		String zip       = data.getCellData(sheetName, "Zip", rowNum);
	
		CommonMethod.sendKeys("DonationAmt", amount);
		CommonMethod.testlog("Pass", "Entering the Donation Amount");
		CommonMethod.sendKeys("DonorName", donorName);
		CommonMethod.testlog("Pass", "Entering the Donor Name");
		CommonMethod.sendKeys("DedicatedTo", dedicatedTo);
		CommonMethod.testlog("Pass", "Entering the Name of the person to whom it is dedicated");
		CommonMethod.sendKeys("DedicatedEmail", email);
		CommonMethod.testlog("Pass", "Entering the Email of the person to whom it is dedicated");
		CommonMethod.selectdropdown("communityCountry", country);
		CommonMethod.testlog("Pass", "Selecting the Country Name");
		CommonMethod.sendKeys("CommunityAdd1", street1);
		CommonMethod.testlog( "Pass","Entering Addrress 1");
		CommonMethod.sendKeys("CommunityAdd2", street2);
		CommonMethod.testlog( "Pass","Entering Address 2");
		CommonMethod.sendKeys("CommunityCity", city);
		CommonMethod.testlog( "Pass","Ebtering City Name");
		CommonMethod.selectdropdown("CommunityState", state);
		CommonMethod.testlog( "Pass","Entering State Name");
		CommonMethod.sendKeys("CommunityZip",zip );
		CommonMethod.testlog( "Pass","Entering Zip Code");
		CommonMethod.click("CommunityContinue");
		CommonMethod.testlog( "Pass","Click on Continue button to proceed Donation Receipt");
		Thread.sleep(3000);
		CommonMethod.VerifyDownloadWithFileName("USGBC Donation INVOICE.pdf");
		Thread.sleep(5000);
		System.out.println("File Downloaded Successully");
		CommonMethod.testlog( "Pass", "Downloaded Billing Pdf Successfully");
		
	}
	
	
		public void DonationByOnline(int rowNum, String sheetName) throws IOException, InterruptedException {
		
		String amount      = data.getCellData(sheetName, "Amount", rowNum);
		String donorName   = data.getCellData(sheetName, "DonorName", rowNum);
		String dedicatedTo   = data.getCellData(sheetName, "DedicatedTo", rowNum);
		String email     = data.getCellData(sheetName, "Email", rowNum);
		String message   = data.getCellData(sheetName, "Message", rowNum);
		
		CommonMethod.selectdropdown("SelDonationAmt", amount);
		CommonMethod.testlog("Pass", "Selecting the Donation Amount");
		CommonMethod.sendKeys("DonorName", donorName);
		CommonMethod.testlog("Pass", "Entering the Donor Name");
		CommonMethod.sendKeys("DedicatedTo", dedicatedTo);
		CommonMethod.testlog("Pass", "Entering the Name of the person to whom it is dedicated");
		CommonMethod.sendKeys("DedicatedEmail", email);
		CommonMethod.testlog("Pass", "Entering the Email of the person to whom it is dedicated");
		CommonMethod.sendKeys("MessageDedicationTo", message);
		CommonMethod.testlog( "Pass","Entering the message");
		CommonMethod.click("CommunityContinue");
		CommonMethod.testlog( "Pass", " Redirecting to Payment Page");
	    Thread.sleep(3000);
	    CommonMethod.assertcontainsmessage("VerifyTextOnPayment", "Donation - Confirmation", "Didn't Redirected to paymnet page");
	    CommonMethod.testlog( "Pass", " Welcome to Payment Page");
	}
		
		public void VerifyReceiptDonation(int rowNum, String sheetName) throws IOException {
			
			String amount      = data.getCellData(sheetName, "Amount", rowNum);
			String donorName   = data.getCellData(sheetName, "DonorName", rowNum);
			String dedicatedTo   = data.getCellData(sheetName, "DedicatedTo", rowNum);
			String message   = data.getCellData(sheetName, "Message", rowNum);
			
			
			CommonMethod.assertEqualsmessage("ReceiptDonationAmount", amount, "Amount is not correct");
			CommonMethod.testlog("Pass","Donation Amount is correct");
			CommonMethod.assertEqualsmessage("ReceiptDonationDonatedOn", CommonMethod.getTodaysDate(), "Date is not correct");
			CommonMethod.testlog("Pass","Donation date is correct");
			CommonMethod.assertEqualsmessage("ReceiptDonationDonatedBy", donorName, "Donor Name is not correct");
			CommonMethod.testlog("Pass","Donor Name is correct");
			CommonMethod.assertEqualsmessage("ReceiptDonationOnBehalfOf", dedicatedTo, "On Behalf of Name is not correct");
			CommonMethod.testlog("Pass","Donation on behalf of is correct");
			CommonMethod.assertEqualsmessage("ReceiptDonationeCard", message, "Donation Message is not correct");
			CommonMethod.testlog("Pass","Message on behalf of donation is correct");
		}
	
		
		
		
		
}
