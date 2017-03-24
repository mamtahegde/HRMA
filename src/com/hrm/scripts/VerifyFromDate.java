package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.AssignLeavePage;
import com.hrm.pages.DashboardPage;

public class VerifyFromDate extends BaseTest{
	
	@Test
	public void testFromDate() throws InterruptedException{
		
		
		//Go to Leave->Assign Leave
		DashboardPage dbPage=new DashboardPage(driver);
		dbPage.moveToLeaveMenu();
		dbPage.moveToAssignLeave();
		
		//click calendar icon of 'From Date'
		AssignLeavePage alPage=new AssignLeavePage(driver);
		alPage.clickFromDatePicker();
		Thread.sleep(3000);
		
		//verify if present month and year is displayed as default option in the listbox on the calendar
		alPage.verifyDatePickerListBox();
		
		alPage.clickFromDatePicker();

	}
	

	

}
