package com.dynamicUsgbc.ReusableMethods;

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
			
			CommonMethod.selectdropdown("communityName",);
			CommonMethod.testlog("Pass", "Feeding Random Unique name for Project and saving to external location");
			
			CommonMethod.selectdropdown("ClickOnProjectType",prjType);
			CommonMethod.testlog("Pass","Selecting Project Type as Buildings");
			
		
		}
	
}
