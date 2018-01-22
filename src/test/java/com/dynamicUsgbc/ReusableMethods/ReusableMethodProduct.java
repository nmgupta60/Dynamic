package com.dynamicUsgbc.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class ReusableMethodProduct extends BaseClass{
	
	
	public void productFlow(int rowNum, String sheetName) throws IOException, InterruptedException {
	
	String ProductName   = data.getCellData(sheetName, "ProductName", rowNum);
	String OrgName	 = data.getCellData(sheetName, "OrgName", rowNum);
	String ContactEmail 	 = data.getCellData(sheetName, "ContactEmail", rowNum);
	
	
	CommonMethod.selectdropdown("ProductsName", ProductName);
	CommonMethod.testlog("Pass", "Selecting the Product");
	CommonMethod.sendKeys("ProductOrgName", OrgName);
	CommonMethod.testlog( "Pass","Entering Organization Name");
	CommonMethod.sendKeys("ProductContactEmail", ContactEmail);
	CommonMethod.testlog( "Pass","Entering primary contact email");
	CommonMethod.selectdropdownrandom("ProductSubscription");
	CommonMethod.testlog( "Pass","Selecting random subscription plan");
	String subsPlan = CommonMethod.getFirstSelectedOptionDropdown("ProductSubscription");
	System.out.println(subsPlan);
	data.setCellData(sheetName,"Subscription" , rowNum, subsPlan );
	String[] splits = CommonMethod.getText("ProductTotalAmount").split(" ");
	String subsAmount = splits[1];
	data.setCellData(sheetName,"SubsAmount" , rowNum, subsAmount );
	CommonMethod.testlog( "Pass","Saving the data in the excel sheet");
	CommonMethod.click("ProductContinueButton");
	CommonMethod.testlog( "Pass","Clicking on the Continue buttn to proceed Payment ");
	Thread.sleep(3000);
	CommonMethod.assertcontainsmessage("VerifyTextOnPayment", "Confirmation",
	"Didn't Rediredted to the payment page");
    CommonMethod.testlog("Pass", "Welcome to the payment page");
    
	}
	
	public void VerifyReceiptProduct(int rowNum, String sheetName) throws IOException {
		
		String ProductName   = data.getCellData(sheetName, "ReceiptProductName", rowNum);
		String OrgName	 = data.getCellData(sheetName, "OrgName", rowNum);
		String ContactEmail 	 = data.getCellData(sheetName, "ContactEmail", rowNum);
		String Offering	 = data.getCellData(sheetName, "Subscription", rowNum);
		String Amount 	 = data.getCellData(sheetName, "SubsAmount", rowNum);

		CommonMethod.assertEqualsmessage("ReceiptProductName", ProductName, "Product Name is not correct");
		CommonMethod.testlog("pass", "Product Name is correct in receipt");
		CommonMethod.assertEqualsmessage("ReceiptProductOffering", Offering , "Product Offering is not correct");
		CommonMethod.testlog("Pass", "Product Offering is correct in receipt");
		CommonMethod.assertEqualsmessage("ReceiptProductOrg", OrgName, "Product Org Name is not correct");
		CommonMethod.testlog("Pass", "Product Org Name is correct in receipt");
		CommonMethod.assertEqualsmessage("ReceiptProductEmail", ContactEmail, "Product Contact email is not correct");
		CommonMethod.testlog("pass", "Product Contact email is correct in receipt");
		CommonMethod.assertEqualsmessage("ReceiptProductAmount", Amount , "Product amount is not correct");
		CommonMethod.testlog("Pass", "Product amount is correct in receipt");
		CommonMethod.assertEqualsmessage("ReceiptProductDate", CommonMethod.getTodaysDate(), "Date is not correct");
		CommonMethod.testlog("Pass","Date is correct in receipt");
	}
	
	public void ProductPageErrorMessageVerify() throws InterruptedException, IOException {
		String[] CommunityRegistrationErrorMsg = {
	
			    "Please select valid organization.",
			    "Please enter a valid email."

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

