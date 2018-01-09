package com.dynamicUsgbc.ReusableMethods;

import java.io.IOException;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class ReusableMethodsCommunity extends BaseClass {


		public void CommunityRegistration(int rowNum, String sheetName) throws IOException, InterruptedException {
		
			String communityName = data.getCellData(sheetName, "CommunityName", rowNum);
			String newCommunityName = data.getCellData(sheetName, "NewCommunityName", rowNum);
			String country   = data.getCellData(sheetName, "Country", rowNum);
			String street1	 = data.getCellData(sheetName, "Street1", rowNum);
			String street2 	 = data.getCellData(sheetName, "Street2", rowNum);
			String city		 = data.getCellData(sheetName, "City", rowNum);
			String state 	 = data.getCellData(sheetName, "State", rowNum);
			String zip       = data.getCellData(sheetName, "Zip", rowNum);
			String schoolName = data.getCellData(sheetName, "SchoolName", rowNum);
			String studentId  = data.getCellData(sheetName, "StudentID", rowNum);
			String graduationDate  = data.getCellData(sheetName, "GraduationDate", rowNum);
			String dob       = data.getCellData(sheetName, "DOB", rowNum);
			
			CommonMethod.selectdropdown("communityName",communityName);
			CommonMethod.testlog("Pass", "Selecting the community Name frm the Dropdown");
			CommonMethod.selectdropdown("communityCountry",country);
			CommonMethod.testlog("Pass","Selecting the Country Name");
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
			CommonMethod.click("IsStudent");
			CommonMethod.testlog( "Pass","Select Yes in Student Option");
			CommonMethod.sendKeys("SchoolName", schoolName);
			CommonMethod.testlog( "Pass","Entering School Name");
			CommonMethod.sendKeys("StudentId", studentId);
			CommonMethod.testlog( "Pass","Entering Student ID");
			CommonMethod.sendKeys("GraduationDate", graduationDate);
			CommonMethod.testlog( "Pass","Entering Graduation Date");
			CommonMethod.click("IsEmergingProff");
			CommonMethod.testlog( "Pass","Select Yes Emerging Option");
			CommonMethod.sendKeys("EmergingProffDOB", dob);
			CommonMethod.testlog( "Pass","Entering date of birth ");
			CommonMethod.click("HearEmail");
			CommonMethod.testlog( "Pass","Selecting Hear from email");
			CommonMethod.click("tickAgree");
			CommonMethod.testlog( "Pass","Click on I Agree option");
			String[] splits = CommonMethod.getText("CommunityRegAmt").split(" ");
			String Amount= splits[1];
			data.setCellData(sheetName, "TotalAmount" , rowNum, Amount );
			CommonMethod.click("CommunityContinue");
			CommonMethod.testlog( "Pass","Click on Continue button to proceed to SignIn Page");
			Thread.sleep(3000);
			CommonMethod.assertcontainsmessage("VerifyTextSignIn", "Sign In for existing Users", "The User Didn't Redirected to SignIn Page");
		}
		
		
		
	
}
