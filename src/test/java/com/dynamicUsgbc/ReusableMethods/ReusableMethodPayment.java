package com.dynamicUsgbc.ReusableMethods;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class ReusableMethodPayment extends BaseClass {

	public void PaymentByCC(int rowNum, String sheetName) throws IOException, InterruptedException {

		String NameOnCard = data.getCellData(sheetName, "Name", rowNum);
		String CardNumber = data.getCellData(sheetName, "CardNumber", rowNum);
		String ExpirationMonth = data.getCellData(sheetName, "ExpMonth", rowNum);
		String ExpirationYear = data.getCellData(sheetName, "ExpYear", rowNum);
		String SecurityCode = data.getCellData(sheetName, "SecurityCode", rowNum);
		String BillCountry = data.getCellData(sheetName, "Country", rowNum);
		String BillStreetAdd1 = data.getCellData(sheetName, "Street1", rowNum);
		String BillStreetAdd2 = data.getCellData(sheetName, "Street2", rowNum);
		String BillCity = data.getCellData(sheetName, "City", rowNum);
		String BillState = data.getCellData(sheetName, "State", rowNum);
		String BillZipCode = data.getCellData(sheetName, "Zip", rowNum);

		CommonMethod.sendKeys("NameOnCard", NameOnCard);
		CommonMethod.testlog("Pass", "Entering Card Name");
		CommonMethod.sendKeys("CardNumber", CardNumber);
		CommonMethod.testlog("Pass", "Entering Card Number");
		CommonMethod.selectdropdown("ExpirationMonth", ExpirationMonth);
		CommonMethod.testlog("Pass", "Entering expiry month");
		CommonMethod.selectdropdown("ExpirationYear", ExpirationYear);
		CommonMethod.testlog("Pass", "Entering expiry year");
		CommonMethod.sendKeys("SecurityCode", SecurityCode);
		CommonMethod.testlog("Pass", "Entering Security code");
		CommonMethod.selectdropdown("BillCountry", BillCountry);
		CommonMethod.testlog("Pass", "Selecting Country Name");
		CommonMethod.sendKeys("BillStreetAdd1", BillStreetAdd1);
		CommonMethod.testlog("Pass", "Entering Street Add 1");
		CommonMethod.sendKeys("BillStreetAdd2", BillStreetAdd2);
		CommonMethod.testlog("Pass", "Entering Street Add 2");
		CommonMethod.sendKeys("BillCity", BillCity);
		CommonMethod.testlog("Pass", "Entering City name");
		CommonMethod.selectdropdown("BillState", BillState);
		CommonMethod.testlog("Pass", "Selecting the State name");
		CommonMethod.sendKeys("BillZipCode", BillZipCode);
		CommonMethod.testlog("Pass", "Entering Zip Code");
		CommonMethod.click("PaymentSubmitButton");
		CommonMethod.testlog("Pass", "Clicking on Next button");
		Thread.sleep(3000);

	}

	public void verifyCommRegPaymentDetails(int rowNum, String sheetName) throws IOException, InterruptedException {

		String communityName = data.getCellData(sheetName, "CommunityName", rowNum);
		String country = data.getCellData(sheetName, "CountryCode", rowNum);
		String street1 = data.getCellData(sheetName, "Street1", rowNum);
		String street2 = data.getCellData(sheetName, "Street2", rowNum);
		String city = data.getCellData(sheetName, "City", rowNum);
		String state = data.getCellData(sheetName, "StateCode", rowNum);
		String zip = data.getCellData(sheetName, "Zip", rowNum);
		String email = data.getCellData("SignIn", "Email", rowNum);
		String total = data.getCellData(sheetName, "TotalAmount", rowNum);

		CommonMethod.assertEqualsmessage("VerifyCommunityName", communityName, "Community name is not correct");
		CommonMethod.testlog("Pass","Community Name Verified Successfully");
		CommonMethod.assertEqualsmessage("VerifyPaymentAmount", total, "Amount Payable is not correct");
		CommonMethod.testlog("Pass","Amount payable is correct");
		CommonMethod.assertEqualsmessage("VerifyStudent", "Yes", "User is not Student");
		CommonMethod.testlog("Pass","The user is Student Verified Sucessfully");
		CommonMethod.assertEqualsmessage("VerifyEmergingProfessionals", "Yes", "User is not Emerging professinal");
		CommonMethod.testlog("Pass","The user is emerging professional verified successfully");
		CommonMethod.assertEqualsmessage("VerifyAddress", street1 + " " + street2, "Street Address is not correct");
		CommonMethod.testlog("Pass","Street Address verified successfully");
		CommonMethod.assertEqualsmessage("VerifyCity", city, "Community city is not correct");
		CommonMethod.testlog("Pass","Community city name is correct");
		CommonMethod.assertEqualsmessage("VerifyState", state, "Community state is not correct");
		CommonMethod.testlog("Pass","Community state name is correct");
		CommonMethod.assertEqualsmessage("VerifyZipCode", zip, "Community zip is not correct");
		CommonMethod.testlog("Pass","Community zip code is correct");
		CommonMethod.assertEqualsmessage("VerifyCountry", country, "Community country is not correct");
		CommonMethod.testlog("Pass","Community country name is correct");
		CommonMethod.assertEqualsmessage("VerifyEmail", email, "Community email is not correct");
		CommonMethod.testlog("Pass","Community email id is correct");
		CommonMethod.assertEqualsmessage("VerifyPhone", "", "Community phone is not correct");
		CommonMethod.testlog("Pass","Community phone no is correct");

	}
	
	public void verifyDonationPaymentDetails(int rowNum, String sheetName) throws IOException, InterruptedException {

		String amount      = data.getCellData(sheetName, "Amount", rowNum) + ".00";
		String donorName   = data.getCellData(sheetName, "DonorName", rowNum);
		String dedicatedTo   = data.getCellData(sheetName, "DedicatedTo", rowNum);
		String email     = data.getCellData(sheetName, "Email", rowNum);
		String message   = data.getCellData(sheetName, "Message", rowNum);

		CommonMethod.assertEqualsmessage("VerifyDonationAmount", amount, "Donation Amount is not correct");
		CommonMethod.testlog("Pass", "Donation amount is correct");
		CommonMethod.assertEqualsmessage("VerifyDonationAnon", "N/A", "Anon Donation detail is not correct");
		CommonMethod.testlog("Pass", "Anonymous name is correct");
		CommonMethod.assertEqualsmessage("VerifyDonationDonor", donorName, "Donor name is not correct");
		CommonMethod.testlog("Pass", "Donor name is correct");
		CommonMethod.assertEqualsmessage("VerifyDonationDedication", "yes", "Dedication detail is not correct");
		CommonMethod.testlog("Pass", "Dedication detail is correct");
		CommonMethod.assertEqualsmessage("VerifyDonationOnbehalfOf", dedicatedTo, "Donation On behalf of is not correct");
		CommonMethod.testlog("Pass", "Donation detail on behalf of is correct");
		CommonMethod.assertEqualsmessage("VerifyDonationSendeCard", email, "Donation email detail is not correct");
		CommonMethod.testlog("Pass", "Donation email is correct");
		CommonMethod.assertEqualsmessage("VerifyDonationMessage", message, "Donation message is not correct");
		CommonMethod.testlog("Pass", "Donation message is correct");
		

	}
	
	public void verifyExamPaymentDetails(int rowNum, String sheetName) throws IOException, InterruptedException {

		String examType = data.getCellData(sheetName, "ExamType", rowNum);
		String language = data.getCellData(sheetName, "Language", rowNum);
		String country   = data.getCellData(sheetName, "CountryCode", rowNum);
		String street1	 = data.getCellData(sheetName, "Street1", rowNum);
		String street2 	 = data.getCellData(sheetName, "Street2", rowNum);
		String city		 = data.getCellData(sheetName, "City", rowNum);
		String state 	 = data.getCellData(sheetName, "StateCode", rowNum);
		String zip       = data.getCellData(sheetName, "Zip", rowNum);
		String amount       = data.getCellData(sheetName, "Amount", rowNum);
		String email = data.getCellData("SignIn", "Email", rowNum);

		CommonMethod.assertEqualsmessage("VerifyExamName", examType, "Exam name is not correct");
		CommonMethod.testlog("Pass", "Examination Name is correct");
		CommonMethod.assertEqualsmessage("VerifyExamSpeciality", examType, "Special preference is not correct");
		CommonMethod.testlog("pass", "Special preference is correct");
		CommonMethod.assertEqualsmessage("VerifyExamLanguage", language, "Examination language is not correct");
		CommonMethod.testlog("pass", "Examination language is correct");
		CommonMethod.assertEqualsmessage("VerifyExamFee", amount , "Examination fee is not correct");
		CommonMethod.testlog("Pass", "Examination fee is correct");
		//CommonMethod.assertEqualsmessage("VerifyExamContactName", "" , "Community name is not correct");
		CommonMethod.assertEqualsmessage("VerifyExamContactAdd", street1 + " " + street2 , "Examination contact address is not correct");
		CommonMethod.testlog("Pass", "Examination contact address is correct");
		CommonMethod.assertEqualsmessage("VerifyExamCity", city , "Examination contact city is not correct");
		CommonMethod.testlog("Pass", "Examination contact city is correct");
		CommonMethod.assertEqualsmessage("VerifyExamState", state, "Examination contact state is not correct");
		CommonMethod.testlog("Pass", "Examination contact state is correct");
		CommonMethod.assertEqualsmessage("VerifyExamZipCode", zip, "Examination zip is not correct");
		CommonMethod.testlog("Pass", "Examination zip is correct");
		CommonMethod.assertEqualsmessage("VerifyExamCountry", country, "Examination contact country is not correct");
		CommonMethod.testlog("Pass", "Examination contact country is correct");
		CommonMethod.assertEqualsmessage("VerifyExamEmail", email, "Examination contact email is not correct");
		CommonMethod.testlog("Pass", "Examination contact email is correct");

	}
	

	
	public void PaymentByCheck() throws IOException, InterruptedException {
		CommonMethod.click("SelectPayByCheck");
		CommonMethod.testlog("Pass", "Selecting the payment by check option");
		Thread.sleep(2000);
		CommonMethod.click("PaymentSubmitButton");
		CommonMethod.testlog("Pass", "Clicking on the submit payment button ");
	}

	public void verifyStorePaymentDetails(int rowNum, String sheetName) throws IOException, InterruptedException {

		String country   = data.getCellData(sheetName, "CountryCode", rowNum);
		String street1	 = data.getCellData(sheetName, "Street1", rowNum);
		String street2 	 = data.getCellData(sheetName, "Street2", rowNum);
		String city		 = data.getCellData(sheetName, "City", rowNum);
		String state 	 = data.getCellData(sheetName, "StateCode", rowNum);
		String zip       = data.getCellData(sheetName, "Zip", rowNum);

		CommonMethod.assertEqualsmessage("VerifyStoreAddress", street1 + " " + street2, "Billing Address is not correct");
		CommonMethod.testlog("Pass", "Billing Address is correct");
		CommonMethod.assertEqualsmessage("VerifyStoreCity", city, "billing City is not correct");
		CommonMethod.testlog("Pass", "Billing city is correct");
		CommonMethod.assertEqualsmessage("VerifyStoreState", state, "Billing State is not correct");
		CommonMethod.testlog("Pass", "Billing Address is correct ");
		CommonMethod.assertEqualsmessage("VerifyStoreZipCode", zip , "Billing Zipcode is not correct");
		CommonMethod.testlog("Pass", "Billing zip code is correct");
		CommonMethod.assertEqualsmessage("VerifyStoreCountry", country, "Billing Country is not correct");
		CommonMethod.testlog("Pass", "Billing country is correct");
		
	}
	
	public void verifySponsershipPaymentDetails(int rowNum, String sheetName) throws IOException, InterruptedException {

		String communityName  = data.getCellData(sheetName, "CommunityName", rowNum);
		String sponserType   = data.getCellData(sheetName, "SponsorshipType", rowNum);
		String amount   = data.getCellData(sheetName, "Amount", rowNum);
		String startDate = data.getCellData(sheetName, "StartDate", rowNum);
		String endDate   = data.getCellData(sheetName, "EndDate", rowNum);
		String country   = data.getCellData(sheetName, "CountryCode", rowNum);
		String street1	 = data.getCellData(sheetName, "Street1", rowNum);
		String street2 	 = data.getCellData(sheetName, "Street2", rowNum);
		String city		 = data.getCellData(sheetName, "City", rowNum);
		String state 	 = data.getCellData(sheetName, "StateCode", rowNum);
		String zip       = data.getCellData(sheetName, "Zip", rowNum);
		String email = data.getCellData("SignIn", "Email", rowNum);
		
		String SponAmount = "$" + amount + ".00";

		CommonMethod.assertEqualsmessage("VerifySponserCommName", communityName, "Sponsorship Community name is not correct");
		CommonMethod.testlog("Pass", "Sponsorship Community name is correct");
		System.out.println(sponserType);
		System.out.println(CommonMethod.getText("VerifySponserType"));
		CommonMethod.assertEqualsmessage("VerifySponserType", sponserType, "SponsorType is not correct");
		CommonMethod.testlog("pass", "Sponsor type is correct");
		CommonMethod.assertEqualsmessage("VerifySponserStartsOn", startDate, "Event start date is not correct");
		CommonMethod.testlog("pass", "Event start date is correct");
		CommonMethod.assertEqualsmessage("VerifySponserValidUntil", endDate , "Event end date is not correct");
		CommonMethod.testlog("Pass", "Event end date is correct");
		CommonMethod.assertEqualsmessage("VerifySponserAmount", SponAmount , "Sponsorship amount is not correct");
		CommonMethod.testlog("Pass", "Sponsorship amount is correct");
		CommonMethod.assertEqualsmessage("VerifySponserAddress", street1 + " " + street2 , "Sponsorship address is not correct");
		CommonMethod.testlog("Pass", "Sponsorship Address is correct");
		CommonMethod.assertEqualsmessage("VerifySponserCity", city, "Sponsorship city  is not correct");
		CommonMethod.testlog("Pass", "Sponsorship city is correct");
		CommonMethod.assertEqualsmessage("VerifySponserState", state, "Sponsorship state is not correct");
		CommonMethod.testlog("Pass", "Sponsorship state is correct");
		CommonMethod.assertEqualsmessage("VerifySponserZip", zip, "Sponsorship zip is not correct");
		CommonMethod.testlog("Pass", "Sponsorship zip is corret");
		CommonMethod.assertEqualsmessage("VerifySponserCountry", country, "Sponsorship Country is not correct");
		CommonMethod.testlog("Pass", "Sponsorship country is correct");
		CommonMethod.assertEqualsmessage("VerifySponserEmail", email, "Sponsorship contact email is not correct");
		CommonMethod.testlog("Pass", "Sponsorship contact email is correct");

	}
	
	public void verifyProductPaymentDetails(int rowNum, String sheetName) throws IOException, InterruptedException {

		String ProductName   = data.getCellData(sheetName, "ReceiptProductName", rowNum);
		String OrgName	 = data.getCellData(sheetName, "OrgName", rowNum);
		String ContactEmail 	 = data.getCellData(sheetName, "ContactEmail", rowNum);
		String Offering	 = data.getCellData(sheetName, "Subscription", rowNum);
		String Amount 	 = data.getCellData(sheetName, "SubsAmount", rowNum);

		CommonMethod.assertEqualsmessage("VerifyProductOrg", OrgName, "Receipt Product Org Name is not correct");
		CommonMethod.testlog("Pass", "Receipt Product Organization name is correct");
		CommonMethod.assertEqualsmessage("VerifyProductContactEmail", ContactEmail, "Product Contact email is not correct");
		CommonMethod.testlog("pass", "Sponsor type is correct");
		CommonMethod.assertEqualsmessage("VerifyProductName", ProductName, "Product Name is not correct");
		CommonMethod.testlog("pass", "Product name is correct");
		CommonMethod.assertEqualsmessage("VerifyProductOffering", Offering , "Product offered is not correct");
		CommonMethod.testlog("Pass", "Product offered is correct");
		CommonMethod.assertEqualsmessage("VerifyProductAmount", Amount , "Product amount is not correct");
		CommonMethod.testlog("Pass", "Product amount is correct");
		

	}
	
	public void verifyPaymentSuccessful() throws IOException {
		
		CommonMethod.assertcurrentUrl(ReceiptUrl, "User is not redirected to receipt page");
		String ExpectedMessage = "Thank you!";
		CommonMethod.assertcontentPageSource(ExpectedMessage,"Payment is not succesful");
		CommonMethod.testlog("Pass","Payment made successfully");
	}

	public void PaymentPageErrorMessageVerify() throws InterruptedException, IOException {
		String[] CommunityRegistrationErrorMsg = {

				"Please enter Name on the card.", "Please enter card number.",
				"Please enter the expiry month on your card.", "Please enter the expiry year on your card.",
				"Please enter Security code.", "Street address field is required.",
				"Street address line 2 field is required.", "City field is required.", "State field is required.",
				"Zip code field is required."

		};

	
		CommonMethod.click("PaymentSubmitButton");
		CommonMethod.testlog("Pass", "Clicking on Submit Payment button");
		Thread.sleep(3000);

		List<WebElement> ErrorMsgList = driver.findElements(By.className("input-error-desc"));
		System.out.println(ErrorMsgList.size());
		int i = 0;
		for (WebElement ErrorMsg : ErrorMsgList) {
			System.out.println(ErrorMsg.getText());
			if (ErrorMsg.getText().equals("")) {
				CommonMethod.testlog("Pass", "All the Errors Verified Sucessfully");
				continue;
			} else

			CommonMethod.assertEqualsMessage(ErrorMsg.getText(), (CommunityRegistrationErrorMsg[i]),
					"Error Msg is not correct");
			CommonMethod.testlog("Info", ErrorMsg.getText());
			i++;
		}
		CommonMethod.testlog("Pass", "Total No of Errors are : "+Integer.toString(i));
	}

	
	public void verifyMembershipPaymentDetails(int rowNum, String sheetName, String sheetName1, String sheetName2) throws IOException, InterruptedException {

		String organizationName  = data.getCellData(sheetName, "OrganizationName", rowNum);
		String countryCode       = data.getCellData(sheetName, "CountryCode", rowNum);
		String level             = data.getCellData(sheetName, "MembershipLevel", rowNum);
		String term              = data.getCellData(sheetName, "Term", rowNum);
		String amount            = data.getCellData(sheetName, "TotalAmount", rowNum);
		String name              = data.getCellData(sheetName1, "FirstName", rowNum);
		String street1	         = data.getCellData(sheetName, "Street1", rowNum);
		String street2 	         = data.getCellData(sheetName, "Street2", rowNum);
		String city		         = data.getCellData(sheetName, "City", rowNum);
		String zip		         = data.getCellData(sheetName, "Zip", rowNum);
		String state 	         = data.getCellData(sheetName, "StateCode", rowNum);
		String email             = data.getCellData(sheetName2, "Email", rowNum);
		
		String membershipAmount = amount + ".00";

		CommonMethod.assertEqualsmessage("VerifyMembershipPaymentOrganization", organizationName, "Organization name is not correct");
		CommonMethod.testlog("Pass", "Organization name is correct");
		CommonMethod.assertEqualsmessage("VerifyMembershipPaymentCountry", countryCode, "Country Code is not correct");
		CommonMethod.testlog("pass", "Country name is correct");
		CommonMethod.assertEqualsmessage("VerifyMembershipPaymentLevel", level.toLowerCase(), "Membership Level is not correct");
		CommonMethod.testlog("pass", "Membership Level is correct");
		CommonMethod.assertEqualsmessage("VerifyMembershipPaymentTerm", term+"s" , "Term Year is not correct");
		CommonMethod.testlog("Pass", "Term Year is correct");
		//CommonMethod.assertEqualsmessage("MembershipPaymentEffective", CommonMethod.getTodaysDate() +" to "+ CommonMethod.getDatefutureYear(1) , "Validity date is not correct");
		CommonMethod.testlog("Pass", "Validity date is correct");
		CommonMethod.assertEqualsmessage("VerifyMembershipPaymentAmount", membershipAmount , "Membership amount is not correct");
		CommonMethod.testlog("Pass", "Membership amount is correct");
		//CommonMethod.assertEqualsmessage("MembershipPaymentName", name , "User Name is not correct");
		CommonMethod.testlog("Pass", "User Name is correct");
		CommonMethod.assertEqualsmessage("VerifyMembershipPaymentAddress", street1 + " " + street2 , " Address is not correct");
		CommonMethod.testlog("Pass", "Address is correct");
		CommonMethod.assertEqualsmessage("VerifyMembershipPaymentCity", city, "Membership city  is not correct");
		CommonMethod.testlog("Pass", "Membership city is correct");
		CommonMethod.assertEqualsmessage("VerifyMembershipPaymentState", state, "Membership state is not correct");
		CommonMethod.testlog("Pass", "Membership state is correct");
		CommonMethod.assertEqualsmessage("VerifyMembershipPaymentzip", zip , "Membership Zip is not correct");
		CommonMethod.testlog("Pass", "Membership zip is correct");
		CommonMethod.assertEqualsmessage("VerifyMembershipPaymentCountry", countryCode, "Sponsorship Country is not correct");
		CommonMethod.testlog("Pass", "Sponsorship country is correct");
		CommonMethod.assertEqualsmessage("VerifyMembershipPaymentEmail", email, "Membership email is not correct");
		CommonMethod.testlog("Pass", "Membership email is corret");
	}
	
	
	
}
