package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.DefineTimeSheetPeriodPage;

public class TestWeekListBoxIsSorted extends BaseTest{
	
	@Test
	public void testWeekListBoxIsSorted(){
		DashboardPage dbPage=new DashboardPage(driver);
		dbPage.clickTimeMenu();
		
		DefineTimeSheetPeriodPage dtspPage=new DefineTimeSheetPeriodPage(driver);
		dtspPage.checkFirstDayOfWeekListIsSorted();
		log.info("List is sorted according to weekdays");
	}
	
	

}
