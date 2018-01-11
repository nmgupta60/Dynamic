package com.dynamicUsgbc.ReusableMethods;

import java.io.IOException;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class ReusableMethodSponsorship extends BaseClass{

	
public void Sponsorship(int rowNum, String sheetName) throws IOException, InterruptedException {
		
	
		String communityName  = data.getCellData(sheetName, "CommunityName", rowNum);
		String amount   = data.getCellData(sheetName, "Amount", rowNum);
		String startDate = data.getCellData(sheetName, "StartDate", rowNum);
		String endDate   = data.getCellData(sheetName, "EndDate", rowNum);
		String country   = data.getCellData(sheetName, "Country", rowNum);
		String street1	 = data.getCellData(sheetName, "Street1", rowNum);
		String street2 	 = data.getCellData(sheetName, "Street2", rowNum);
		String city		 = data.getCellData(sheetName, "City", rowNum);
		String state 	 = data.getCellData(sheetName, "State", rowNum);
		String zip       = data.getCellData(sheetName, "Zip", rowNum);
		
		CommonMethod.selectdropdown("communityName", communityName);
		CommonMethod.testlog("Pass", "Selecting the community Name frm the Dropdown");
		CommonMethod.click("checkEvents");
		CommonMethod.testlog("Pass", "Clciking on Sponsorship Type");
		CommonMethod.sendKeys("sponsorAmount", amount);
		CommonMethod.testlog("Pass", "Entering the scholarship amount");
		CommonMethod.sendKeys("startDate", startDate);
		CommonMethod.testlog("Pass", "Entering the start date");
		CommonMethod.sendKeys("endDate", endDate);
		CommonMethod.testlog("Pass", "Entering the end date");
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
		String[] splits = CommonMethod.getText("sponsorshipAmount").split(" ");
		String Amount = splits[1];
		data.setCellData(sheetName, "TotalAmount", rowNum, Amount);
		CommonMethod.click("CommunityContinue");
		CommonMethod.testlog( "Pass","Click on Continue button to proceed payment");
		CommonMethod.assertcontainsmessage("VerifyTextOnPayment", "Confirmation","Didn't Rediredted to the payment page");
		CommonMethod.testlog("Pass", "Welcome to the payment page");
		
	}

	
}
