package com.dynamicUsgbc.ReusableMethods;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class ReusableMethodsCommunity extends BaseClass {

	public void CommunityRegistration(int rowNum, String sheetName) throws IOException, InterruptedException {

		String communityName = data.getCellData(sheetName, "CommunityName", rowNum);
		//String newCommunityName = data.getCellData(sheetName, "NewCommunityName", rowNum);
		String country = data.getCellData(sheetName, "Country", rowNum);
		String street1 = data.getCellData(sheetName, "Street1", rowNum);
		String street2 = data.getCellData(sheetName, "Street2", rowNum);
		String city = data.getCellData(sheetName, "City", rowNum);
		String state = data.getCellData(sheetName, "State", rowNum);
		String zip = data.getCellData(sheetName, "Zip", rowNum);
		String schoolName = data.getCellData(sheetName, "SchoolName", rowNum);
		String studentId = data.getCellData(sheetName, "StudentID", rowNum);
		String graduationDate = data.getCellData(sheetName, "GraduationDate", rowNum);
		String dob = data.getCellData(sheetName, "DOB", rowNum);

		CommonMethod.selectdropdown("communityName", communityName);
		CommonMethod.testlog("Pass", "Selecting the community Name frm the Dropdown");
		CommonMethod.selectdropdown("communityCountry", country);
		CommonMethod.testlog("Pass", "Selecting the Country Name");
		CommonMethod.moveToElement("CommunityAdd1");
		Thread.sleep(2000);
		CommonMethod.sendKeys("CommunityAdd1", street1);
		CommonMethod.testlog("Pass", "Entering Addrress 1");
		CommonMethod.moveToElement("CommunityAdd2");
		Thread.sleep(2000);
		CommonMethod.sendKeys("CommunityAdd2", street2);
		CommonMethod.testlog("Pass", "Entering Address 2");
		CommonMethod.sendKeys("CommunityCity", city);
		CommonMethod.testlog("Pass", "Ebtering City Name");
		CommonMethod.selectdropdown("CommunityState", state);
		CommonMethod.testlog("Pass", "Entering State Name");
		CommonMethod.moveToElement("CommunityZip");
		CommonMethod.sendKeys("CommunityZip", zip);
		CommonMethod.testlog("Pass", "Entering Zip Code");
		CommonMethod.click("IsStudent");
		CommonMethod.testlog("Pass", "Select Yes in Student Option");
		CommonMethod.sendKeys("SchoolName", schoolName);
		CommonMethod.testlog("Pass", "Entering School Name");
		CommonMethod.sendKeys("StudentId", studentId);
		CommonMethod.testlog("Pass", "Entering Student ID");
		CommonMethod.moveToElement("GraduationDate");
		Thread.sleep(2000);
		CommonMethod.sendKeys("GraduationDate", graduationDate);
		CommonMethod.testlog("Pass", "Entering Graduation Date");
		CommonMethod.click("IsEmergingProff");
		CommonMethod.testlog("Pass", "Select Yes Emerging Option");
		CommonMethod.moveToElement("EmergingProffDOB");
		CommonMethod.sendKeys("EmergingProffDOB", dob);
		CommonMethod.testlog("Pass", "Entering date of birth ");
		CommonMethod.click("HearEmail");
		CommonMethod.testlog("Pass", "Selecting Hear from email");
		CommonMethod.click("tickAgree");
		CommonMethod.testlog("Pass", "Click on I Agree option");
		Thread.sleep(2000);
		String[] splits = CommonMethod.getText("CommunityRegAmt").split(" ");
		String Amount = splits[1];
		data.setCellData(sheetName, "TotalAmount", rowNum, Amount);
		CommonMethod.click("CommunityContinue");
		CommonMethod.testlog("Pass", "Click on Continue button to proceed to SignIn Page");
		Thread.sleep(3000);
		CommonMethod.assertcontainsmessage("VerifyTextSignIn", "Sign In for existing Users",
				"The User Didn't Redirected to SignIn Page");
	}

	public void SignIn(int rowNum, String sheetName) throws IOException, InterruptedException {

		String email = data.getCellData(sheetName, "Email", rowNum);
		String password = data.getCellData(sheetName, "Password", rowNum);

		CommonMethod.sendKeys("EmailId", email);
		CommonMethod.testlog("Pass", "Entering Email Id");
		CommonMethod.sendKeys("password", password);
		CommonMethod.testlog("Pass", "Entering Password");
		CommonMethod.click("CommunityContinue");
		CommonMethod.testlog("Pass", "Clicked on Sign and Continue");
		/*CommonMethod.assertcontainsmessage("VerifyTextOnPayment", "Confirmation",
				"Didn't Rediredted to the payment page");*/
		CommonMethod.testlog("Pass", "Welcome to the payment page");
	}

	public void verifyEditDetailsLoggedInUser(int rowNum, String sheetName) throws IOException, InterruptedException {
		
		String newCommunityName = data.getCellData(sheetName, "NewCommunityName", rowNum);
		
		CommonMethod.click("EditContactInfoPaymentPage");
		CommonMethod.testlog("Pass", "Clicking Contact Edit button on Payment page");
		CommonMethod.selectdropdown("communityName", newCommunityName);
		Thread.sleep(2000);
		CommonMethod.testlog("Pass", "Selecting the community Name frm the Dropdown");
		CommonMethod.click("tickAgree");
		CommonMethod.testlog("Pass", "Click on I Agree option");
		CommonMethod.click("CommunityContinue");
		CommonMethod.assertcontainsmessage("VerifyTextOnPayment", "Confirmation",
				"Didn't Rediredted to the payment page");
		CommonMethod.testlog("Pass", "Welcome to the payment page");
		CommonMethod.assertEqualsmessage("VerifyCommunityName", newCommunityName, "Community name is not correct");
		
	}

	public void VerifyReceiptCommunity(int rowNum, String sheetName) throws IOException {
		
		String amount      = data.getCellData(sheetName, "TotalAmount", rowNum) + ".00";
		String communityName   = data.getCellData(sheetName, "CommunityName", rowNum);
		
		
		CommonMethod.assertEqualsmessage("ReceiptDonationAmount", amount, "Amount is not correct");
		CommonMethod.testlog("Pass","Donation Amount is correct");
		CommonMethod.assertEqualsmessage("ReceiptCommunityDate", CommonMethod.getTodaysDate(), "Date is not correct");
		CommonMethod.testlog("Pass","Donation date is correct");
		CommonMethod.assertEqualsmessage("ReceiptCommunityName", communityName, "Community Name is not correct");
		CommonMethod.testlog("Pass","Community Name is correct");
		
	}
	
	public void CommunityRegistrationPageErrorMessageVerify() throws InterruptedException, IOException {
		String[] CommunityRegistrationErrorMsg = {

				"Street address field is required.", "Street address line 2 field is required.",
				"City field is required.", "State field is required.", "Zip code field is required.",
				"Please mention how did you hear about the product.", "Please agree to our terms."

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
