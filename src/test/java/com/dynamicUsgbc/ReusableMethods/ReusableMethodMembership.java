package com.dynamicUsgbc.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class ReusableMethodMembership extends BaseClass{

	
		public void newUserRegistration(String sheetName, int rowNum) throws IOException {
			
			String firstName = data.getCellData(sheetName, "FirstName", rowNum);
			String lastName  = data.getCellData(sheetName, "LastName" , rowNum);
			String password  = data.getCellData(sheetName, "Password" , rowNum);
			
			CommonMethod.click("MemberShipClickSignIn");
			CommonMethod.testlog("Pass", "Clicking on signin button");
			CommonMethod.click("MemberShipClickRegisterHere");
			CommonMethod.testlog("Pass", "Click on register here link");
			CommonMethod.sendKeys("MemberShipFirstName", firstName);
			CommonMethod.testlog("Pass", "Inputting the first name");
			CommonMethod.sendKeys("MemberShipLastName", lastName);
			CommonMethod.testlog("Pass", "Inputing the last name");
			CommonMethod.click("MemberShipEmailId"); 
			Random randomGenerator = new Random();  
			int randomInt = randomGenerator.nextInt(10000);  
			data.setCellData(sheetName, "Email", rowNum, "testuser"+ randomInt +"@email.com");
			CommonMethod.testlog("Pass", "Inputiing the Random Email Id in Excel Sheet");
			CommonMethod.sendKeys("MemberShipEmailId","testuser"+ randomInt +"@email.com");
			CommonMethod.testlog("Pass", "Inputting the Random Email Id");
			CommonMethod.sendKeys("MemberShipPassword", password);
			CommonMethod.testlog("Pass", "Inputting the Pasword");
			CommonMethod.sendKeys("MemberShipConfirmPassword", password);
			CommonMethod.testlog("Pass", "Inputing passeord to confirm");
			CommonMethod.click("CommunityContinue");
			CommonMethod.testlog("Pass", "Clicking on continue button to continue ");
			CommonMethod.assertEqualsmessage("MemberShipVerifyRegister", "You are signed in as "+firstName+" "+lastName+".", "Unable to Register");
			CommonMethod.testlog("Pass", "Verifying the User name on the contact page");
			CommonMethod.testlog("Pass", "User Registration module Tested Successfully");
			
		}
	
			
		
		
		public void membershipContact(String sheetName, int rowNum) throws IOException, InterruptedException {
			
			String attentionTo= data.getCellData(sheetName, "AttentionTo", rowNum);
			String company    = data.getCellData(sheetName, "Company", rowNum);
			String country    = data.getCellData(sheetName, "Country", rowNum);
			String street1    = data.getCellData(sheetName, "Street1", rowNum);
			String street2    = data.getCellData(sheetName, "Street2", rowNum);
			String city 	  = data.getCellData(sheetName, "City", rowNum);
			String state      = data.getCellData(sheetName, "State", rowNum);
			String zip        = data.getCellData(sheetName, "Zip", rowNum);
			
			
			CommonMethod.sendKeys("MemberShipAttentionTo", attentionTo);
			CommonMethod.testlog("Pass", "Entering value in the DedicationTo");
			CommonMethod.sendKeys("MemberShipCompany", company);
			CommonMethod.testlog("Pass", "Entering the Company Name");
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
			CommonMethod.click("tickAgree");
			CommonMethod.testlog("Pass", "Clicking on the agreement checkbox");
			CommonMethod.click("CommunityContinue");
			CommonMethod.testlog("Pass", "Clicking on the Continue button");
			CommonMethod.assertEqualsmessage("MemberShipVerifyContact", "Organization details", "Contact Page Detail is Incomplete");
			CommonMethod.testlog("Pass", "Sucessfully Rediredted to Membership Page");
		}
		
		
		
		public void membershipDetails(String sheetName, int rowNum) throws IOException, InterruptedException {
			
			String term       = data.getCellData(sheetName, "Term", rowNum); 
			String company    = data.getCellData(sheetName, "Company", rowNum);
			String country    = data.getCellData(sheetName, "Country", rowNum);
			String street1    = data.getCellData(sheetName, "Street1", rowNum);
			String street2    = data.getCellData(sheetName, "Street2", rowNum);
			String city 	  = data.getCellData(sheetName, "City", rowNum);
			String state      = data.getCellData(sheetName, "State", rowNum);
			String zip        = data.getCellData(sheetName, "Zip", rowNum);
			String website    = data.getCellData(sheetName, "Website", rowNum);
			String email      = data.getCellData(sheetName, "Email", rowNum);
			String indCategory = data.getCellData(sheetName, "IndustryCategory", rowNum);
			String subCategory        = data.getCellData(sheetName, "SubCategory", rowNum);
			String revenue        = data.getCellData(sheetName, "Revenue", rowNum);
			
			
			
			CommonMethod.selectdropdown("MemberShipTerm",term );
			CommonMethod.testlog("Pass", "Selecting the term year");
			List<WebElement> allLevels = driver.findElements(By.xpath(".//*[@class=\"title\"]"));
		    Random rand = new Random();
		    int randomLevel = rand.nextInt(allLevels.size());
		    allLevels.get(randomLevel).click();
		    data.setCellData(sheetName, "MembershipLevel", rowNum, allLevels.get(randomLevel).getText());
		    CommonMethod.testlog("Pass", "Entering the membership level in th excel sheet");
		    Random randomGenerator = new Random();  
			int randomInt = randomGenerator.nextInt(1000);  
			data.setCellData(sheetName, "OrganizationName", rowNum, "Test"+ randomInt +"Industries");
			CommonMethod.testlog("Pass", "Entering the organization name in the excel sheet");
		    CommonMethod.sendKeys("MemberShipOrganizationName", "Test"+ randomInt +"Industries");
			CommonMethod.testlog("Pass", "Entering the organization name ");
			CommonMethod.selectdropdown("MemberShipCountryIncorporate",country );
			CommonMethod.testlog("Pass", "Selecting the country incorporate Name");
			CommonMethod.assertEqualsMessage(CommonMethod.getFirstSelectedOptionDropdown("communityCountry"), country,"Country name didn't matched");
			CommonMethod.testlog("Pass", "Country Name Matched");
			CommonMethod.assertEqualsMessage(CommonMethod.getattributeValue("CommunityAdd1"), street1, "Street Adrress 1 didn't matched");
			CommonMethod.testlog("Pass", "Addrress 1 verified succcessfully");
			CommonMethod.assertEqualsMessage(CommonMethod.getattributeValue("CommunityAdd2"),street2,"Street Address 2 didn't matched");
			CommonMethod.testlog("Pass", "Address 2 verified successfully");
			CommonMethod.assertEqualsMessage(CommonMethod.getattributeValue("CommunityCity"), city, "City name didn't matched");
			CommonMethod.testlog("Pass", "City Name verified successfully");
			CommonMethod.assertEqualsMessage(CommonMethod.getFirstSelectedOptionDropdown("CommunityState"), state, "State name didn't matched");
			CommonMethod.testlog("Pass", "State Name verified sucessfully");
			CommonMethod.assertEqualsMessage(CommonMethod.getattributeValue("CommunityZip"), zip, "Zip code didn't matched");
			CommonMethod.testlog("Pass", "Zip Code verified successfully");
			CommonMethod.sendKeys("MemberShipWebsite", website);
			CommonMethod.testlog("Pass", "Entering the website");
			CommonMethod.sendKeys("MemberShipEmailId", email);
			CommonMethod.testlog("Pass", "Entering the mail id");
			CommonMethod.selectdropdown("MemberShipIndustryCategory", indCategory);
			CommonMethod.testlog("Pass", "Selecting the industry category");
			CommonMethod.selectdropdown("MemberShipIndustrySubCategory", subCategory);
			CommonMethod.testlog("Pass", "Selecting the subCategory");
			CommonMethod.selectdropdown("MemberShipRevenueRange", revenue);
			CommonMethod.testlog("Pass", "Selecting the Revenue");
			String[] splits = CommonMethod.getText("MembershipFee").split(" ");
			String Amount = splits[1];
			data.setCellData(sheetName, "TotalAmount", rowNum, Amount);
			CommonMethod.testlog("Pass", "Entering the data into the excel sheet");
			CommonMethod.click("CommunityContinue");
			CommonMethod.testlog("Pass", "Clicking on the continue button");
			CommonMethod.assertcontainsmessage("VerifyTextOnPayment", "Confirmation", "Didn't Redirected to paymnet page");
		    CommonMethod.testlog( "Pass", " Welcome to Payment Page");
				
		}
		
		
		
		
		public void MembershipSignUpErrorMessageVerify() throws InterruptedException, IOException {
			String[] CommunityRegistrationErrorMsg = {

					"First Name cannot be empty",
					"Last Name cannot be empty", "Please enter a valid email.",
					"Password cannot be empty", "Confirm password cannot be empty"
			};


			Thread.sleep(3000);
			CommonMethod.click("MemberShipClickSignIn");
			CommonMethod.testlog("Pass", "Clicking on signin button");
			CommonMethod.click("MemberShipClickRegisterHere");
			CommonMethod.testlog("Pass", "Click on register here link");
			CommonMethod.click("CommunityContinue");
			CommonMethod.testlog("Pass", "Clicking on continue button to continue ");

			Thread.sleep(3000);

			List<WebElement> ErrorMsgList = driver.findElements(By.className("messages messages--error"));
			System.out.println(ErrorMsgList.size());
			
			int i = 0;
			for (WebElement ErrorMsg : ErrorMsgList) {
				System.out.println(ErrorMsg.getText());
				if (ErrorMsg.getText().equals("")) {
					CommonMethod.testlog("Pass", "All the Errors Verified Sucessfully");
					continue;
				} else

					CommonMethod.assertEqualsMessage(ErrorMsg.getText(), CommunityRegistrationErrorMsg[i],
							"Error Msg is not correct");
					CommonMethod.testlog("Info", ErrorMsg.getText());

				i++;
			}
			CommonMethod.testlog("Pass", "Total No of Errors are : "+Integer.toString(i));
		}
		
		
		
		public void MembershipContactPageErrorMessageVerify() throws InterruptedException, IOException {
			String[] CommunityRegistrationErrorMsg = {

					 "Street address field is required.","Street address line 2 field is required.",
					 "City field is required.","State field is required.","Zip code field is required.",
					 "Please agree to our terms."
					
			};


			Thread.sleep(3000);
			CommonMethod.click("MembershipContactContinueButton");
			CommonMethod.testlog("Pass", "Clicking on continue button to continue ");

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

					CommonMethod.assertEqualsMessage(ErrorMsg.getText(), CommunityRegistrationErrorMsg[i],
							"Error Msg is not correct");
					CommonMethod.testlog("Info", ErrorMsg.getText());

				i++;
			}
			CommonMethod.testlog("Pass", "Total No of Errors are : "+Integer.toString(i));
		}
		
		
		
		public void MembershipRegistrationPageErrorMessageVerify() throws InterruptedException, IOException {
			String[] CommunityRegistrationErrorMsg = {

					 "Please specify your organization name.","Please specify your website.",
					 "Please specify your industry category.","Please specify your industry sub-category.",
					 "Please choose your revenue scale."		
			};
			Thread.sleep(3000);
			CommonMethod.click("MembershipRegistrationContinueButton");
			CommonMethod.testlog("Pass", "Clicking on continue button to continue ");
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

					CommonMethod.assertEqualsMessage(ErrorMsg.getText(), CommunityRegistrationErrorMsg[i],
							"Error Msg is not correct");
					CommonMethod.testlog("Info", ErrorMsg.getText());

				i++;
			}
			CommonMethod.testlog("Pass", "Total No of Errors are : "+Integer.toString(i));
		}
		
		
		
	
		
		public void VerifyReceiptMembership(int rowNum, String sheetName) throws IOException {
			
			String amount      = data.getCellData(sheetName, "TotalAmount", rowNum) + ".00";
			String orgName   = data.getCellData(sheetName, "OrganizationName", rowNum);
			String membershipLevel   = data.getCellData(sheetName, "MembershipLevel", rowNum);
			
			CommonMethod.assertEqualsmessage("VerifyMembershipReceiptDate", CommonMethod.getTodaysDate(), "Billing Date is not correct");
			CommonMethod.testlog("Pass","Membership Billing Date is correct");
			CommonMethod.assertEqualsmessage("VerifyMembershipReceiptAmount", amount, "Amount is not correct");
			CommonMethod.testlog("Pass","Membership Amount is correct");
			CommonMethod.assertEqualsmessage("VerifyMembershipReceiptOrganization", orgName, "Organization Name is not correct");
			CommonMethod.testlog("Pass","Organization Name is correct");
			CommonMethod.assertEqualsmessage("VerifyMembershipReceiptLevel",membershipLevel.toLowerCase() , "Membership Level is not correct");
			CommonMethod.testlog("Pass","MembershipLevel is correct");
			CommonMethod.assertEqualsmessage("VerifyMembershipReceiptValidity", CommonMethod.getDatefutureYear(1), "Valid till date is not correct");
			CommonMethod.testlog("Pass","Valid till Date is correct");
			CommonMethod.assertEqualsmessage("VerifyMembershipReceiptAutoRenewal", "Not enabled", "Auto Payment is Enabled");
			CommonMethod.testlog("Pass","Autopayment is not enabled");
		}
		
}
