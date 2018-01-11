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
		Thread.sleep(55000);

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

		CommonMethod.assertEqualsmessage("VerifyCommunityName", communityName, "Community name is not correct");
		CommonMethod.assertEqualsmessage("VerifyPaymentAmount", "", "Community name is not correct");
		CommonMethod.assertEqualsmessage("VerifyStudent", "Yes", "Community name is not correct");
		CommonMethod.assertEqualsmessage("VerifyEmergingProfessionals", "Yes", "Community name is not correct");
		CommonMethod.assertEqualsmessage("VerifyAddress", street1 + " " + street2, "Community name is not correct");
		CommonMethod.assertEqualsmessage("VerifyCity", city, "Community name is not correct");
		CommonMethod.assertEqualsmessage("VerifyState", state, "Community name is not correct");
		CommonMethod.assertEqualsmessage("VerifyZipCode", zip, "Community name is not correct");
		CommonMethod.assertEqualsmessage("VerifyCountry", country, "Community name is not correct");
		CommonMethod.assertEqualsmessage("VerifyEmail", email, "Community name is not correct");
		CommonMethod.assertEqualsmessage("VerifyPhone", "", "Community name is not correct");

	}
	
	public void verifyPaymentSuccessful() throws IOException {
		
		String ExpectedMessage = "Thank you!";
		CommonMethod.assertEqualsmessage("SuccessfulPayment", ExpectedMessage, "Payment is not succesful");
	}

	public void CommunityRegistrationPaymentPageErrorMessageVerify() throws InterruptedException, IOException {
		String[] CommunityRegistrationErrorMsg = {

				"Please enter Name on the card.", "Please enter card number.",
				"Please enter the expiry month on your card.", "Please enter the expiry year on your card.",
				"Please enter Security code.", "Street address field is required.",
				"Street address line 2 field is required.", "City field is required.", "State field is required.",
				"Zip code field is required."

		};

		CommonMethod.click("PaymentSubmitButton");
		Thread.sleep(3000);

		List<WebElement> ErrorMsgList = driver.findElements(By.className("input-error-desc"));
		System.out.println(ErrorMsgList.size());
		int i = 0;
		for (WebElement ErrorMsg : ErrorMsgList) {
			System.out.println(ErrorMsg.getText());
			if (ErrorMsg.getText().equals("")) {

				continue;
			} else

			CommonMethod.assertEqualsMessage(ErrorMsg.getText(), (CommunityRegistrationErrorMsg[i]),
					"Error Msg is not correct");

			i++;
		}

	}

}
