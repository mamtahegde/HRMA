package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.AddWorkShiftPage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.WorkShiftsPage;

public class TestAdminJobWorkshiftListboxes extends BaseTest{
	
	@Test
	public void testAdminJobWorkshiftListboxes() throws InterruptedException{
		
		//Note that this testcase needs test data
		
		DashboardPage dbPage=new DashboardPage(driver);
		
	
		//Go to Admin module
		dbPage.clickAdminModule();
		
		//Go to job menu
		dbPage.moveToAdminJobMenu();
		Thread.sleep(2000);
		
		//Click on Workshifts menu
		dbPage.clickWorkshiftsMenu();
		
		//Click on add button
		WorkShiftsPage wsPage=new WorkShiftsPage(driver);
		wsPage.clickAddButton();
		
		//select multiple employee from available employee listbox
		AddWorkShiftPage awsPage=new AddWorkShiftPage(driver);
		awsPage.selectAvailableEmpListBox();
		Thread.sleep(1000);
		
		//Click on Add button
		awsPage.clickAddButton();
		Thread.sleep(2000);
		
		//check if it is added to assigned employee
		awsPage.verifyAddedEmployee();
		
		
	}

}
