package com.dynamicUsgbc.ReusableMethods;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class ReusableMethodExamRegistration extends BaseClass{

	public void ExamRegistration(int rowNum, String sheetName) throws IOException, InterruptedException {
		
		String examType = data.getCellData(sheetName, "ExamType", rowNum);
		String language = data.getCellData(sheetName, "Language", rowNum);		
		CommonMethod.selectdropdown("SelExamType",examType);
		CommonMethod.testlog("Pass", "Selecting the Exam Type from the Dropdown");
		CommonMethod.selectdropdown("SelLanguage",language);
		CommonMethod.testlog("Pass","Selecting the Language for the examination");
		CommonMethod.click("SpclAccomodation");
		CommonMethod.testlog( "Pass","Select Yes ,if you are in need of special accommodations for taking your credentialing exam");
		/*CommonMethod.click("StudentDiscount");
		CommonMethod.testlog( "Pass","Select Yes ,Student to get special discount on your Green Associate exam.");
		*/
		CommonMethod.click("ArmyVeteran");
		CommonMethod.testlog( "Pass","Selecting, 'US Army Veteran'");
		String[] splits = CommonMethod.getText("ExamRegistrationAmt").split(" ");
		String Amount= splits[1];
		data.setCellData(sheetName, "Amount" , rowNum, Amount );
		CommonMethod.testlog("Pass","Saving the Examination registration fee in excel");
		CommonMethod.click("CommunityContinue");
		CommonMethod.testlog( "Pass","Click on Continue button to proceed to SignIn Page");
		Thread.sleep(3000);
		CommonMethod.assertcontainsmessage("VerifyTextSignIn", "Sign In for existing Users", "The User Didn't Redirected to SignIn Page");
		CommonMethod.testlog("Pass","Redirected to SigIn Page successfully");
	}
	
	
	
    public void CandidateInformation(int rowNum, String sheetName) throws IOException, InterruptedException {
		
    	String country   = data.getCellData(sheetName, "Country", rowNum);
		String street1	 = data.getCellData(sheetName, "Street1", rowNum);
		String street2 	 = data.getCellData(sheetName, "Street2", rowNum);
		String city		 = data.getCellData(sheetName, "City", rowNum);
		String state 	 = data.getCellData(sheetName, "State", rowNum);
		String zip       = data.getCellData(sheetName, "Zip", rowNum);
		String dob       = data.getCellData(sheetName, "DOB", rowNum);
		String jobTitle  = data.getCellData(sheetName, "JobTitle", rowNum);
		String Organization  = data.getCellData(sheetName, "Organization", rowNum);
		
		
		CommonMethod.click("CommunityContinue");
		
		
		CommonMethod.selectdropdown("communityCountry",country);
		CommonMethod.testlog("Pass", "Selecting the Candidate Country");
		CommonMethod.sendKeys("CommunityAdd1", street1);
		CommonMethod.testlog("Pass","Entering the street Address1");
		CommonMethod.sendKeys("CommunityAdd2",street2);
		CommonMethod.testlog("Pass","Entering the street Address2");
		CommonMethod.sendKeys("CommunityCity",city);
		CommonMethod.testlog("Pass","Entering the city name");
		CommonMethod.selectdropdown("CommunityState", state);
		CommonMethod.testlog( "Pass","Selecting the State");
		CommonMethod.sendKeys("CommunityZip", zip);
		CommonMethod.testlog("Pass", "Entering the Zip code");
		CommonMethod.sendKeys("candidateDob", dob);
		CommonMethod.testlog("Pass", "Entering the date of birth");
		CommonMethod.click("candidateGender");
		CommonMethod.testlog("Pass", "Checking gender male");
		CommonMethod.sendKeys("candidateJobTitle", jobTitle);
		CommonMethod.testlog("Pass", "Entering the job title");
		CommonMethod.sendKeys("candidateOrganization", Organization);
		CommonMethod.testlog("Pass", "Entering the organization name");
		CommonMethod.click("candidatecheckPDL");
		CommonMethod.testlog("Pass", "Checkingthe public directry listing");
		CommonMethod.click("candidateAgreement");
		CommonMethod.testlog("Pass", "Checking the agreement");
		CommonMethod.click("CommunityContinue");
		CommonMethod.testlog("Pass", "Clicking on the continue button to proceed on payment page");
		Thread.sleep(3000);
	    CommonMethod.assertcontainsmessage("VerifyTextOnPayment", "Confirmation", "Didn't Redirected to paymnet page");
	    CommonMethod.testlog( "Pass", " Welcome to Payment Page");
		
    }
    
    public void VerifyReceiptExam(int rowNum, String sheetName) throws IOException {
		
    	String examType = data.getCellData(sheetName, "ExamType", rowNum);
    	String examTypeSpeciality = data.getCellData(sheetName, "ExamType", rowNum).replaceAll("Exam", "").trim();
		String language = data.getCellData(sheetName, "Language", rowNum);
		String amount       = data.getCellData(sheetName, "Amount", rowNum);
		
		
		
		CommonMethod.assertEqualsmessage("ReceiptExamName", examType, "Exam Name is not correct");
		CommonMethod.assertEqualsmessage("ReceiptExamSpeciality", examTypeSpeciality, "Exam Speciality is not correct");
		CommonMethod.assertEqualsmessage("ReceiptExamLanguage", language, "Exam Language is not correct");
		CommonMethod.assertEqualsmessage("ReceiptExamFee", amount, "Exam Fee is not correct");
		CommonMethod.assertEqualsmessage("ReceiptOrderDate", CommonMethod.getTodaysDate(), "Order Date is not correct");
		CommonMethod.assertEqualsmessage("ReceiptExpirationDate", CommonMethod.getDatefutureYear(1), "Expiration Date is not correct");
	}
    
	
    
    public void ExamRegistrationPageErrorMessageVerify() throws InterruptedException, IOException {
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
