package com.dynamicUsgbc.ReusableMethods;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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


	public void SponsorshipPageErrorMessageVerify() throws InterruptedException, IOException {
		String[] CommunityRegistrationErrorMsg = {
	
				"You must specify the sponsorship type",
				"Please specify a valid amount. Do not enter currency symbols.",
				"Please specify sponsorship start date.",
				"Please specify sponsorship end date.",
				"Street address field is required.",
				"Street address line 2 field is required.",
				"City field is required.",
				"Postal code field is required."
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
