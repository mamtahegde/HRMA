package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;

public class TestJobTitle extends BaseTest {

	@Test
	public void testJobTitleListBoxIsSorted() {
		DashboardPage dbPage = new DashboardPage(driver);
		dbPage.clickPIM_Menu();

		EmpInfoPage eiPage = new EmpInfoPage(driver);
		eiPage.verifyJobTitleListBoxIsSorted();// check if job title listbox is
												// sorted
	}

	@Test
	public void testJobTitleHasNoDuplicate() {
		DashboardPage dbPage = new DashboardPage(driver);
		dbPage.clickPIM_Menu();

		EmpInfoPage eiPage = new EmpInfoPage(driver);
		eiPage.verifyJobTitleListBoxHasNoDuplicate();// checks if the jobtitle listbox
												// has duplicates
	}
}
