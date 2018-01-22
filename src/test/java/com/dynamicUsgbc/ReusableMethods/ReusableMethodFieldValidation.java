package com.dynamicUsgbc.ReusableMethods;

import java.io.IOException;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class ReusableMethodFieldValidation extends BaseClass{

	
	public void verifyElementsDonationPage(int rowNum, String sheetName ) throws IOException {
	
		for(int i= rowNum; i<=data.getRowCount(sheetName);++i) {
			String labelLocater= data.getCellData(sheetName, "labelLocater", i);
			String inputLocater= data.getCellData(sheetName, "inputLocater", i);
			String labelText= data.getCellData(sheetName, "labelText", i);
			String tagName= data.getCellData(sheetName, "tagName", i);
			String type=data.getCellData(sheetName, "type", i);
			
			if(CommonMethod.findElement(inputLocater).getAttribute("type").equalsIgnoreCase(type)) {
				CommonMethod.testlog("Pass", "Button input type is present on the page");	
			}
			else {
			   CommonMethod.fieldVerification(labelLocater, inputLocater, labelText, tagName);	
			}	
		   }
	       	   CommonMethod.testlog("Pass", "All the Input fields verified successfully");
	     }
	
	
}
	