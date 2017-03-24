package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;

public class TestIncludeListBox extends BaseTest {

	@Test(priority = 1)
	public void testIncludeListBoxIsSorted() {
		DashboardPage dbPage = new DashboardPage(driver);
		dbPage.clickPIM_Menu();

		EmpInfoPage eiPage = new EmpInfoPage(driver);

		eiPage.verifyIncludeListBoxIsSorted();// checks if include list box is
												// sorted
	}

	@Test(priority = 2)
	public void testIncludeListBoxHasNoDuplicate() {
		DashboardPage dbPage = new DashboardPage(driver);
		dbPage.clickPIM_Menu();

		EmpInfoPage eiPage = new EmpInfoPage(driver);

		eiPage.verifyIncludeListBoxHasNoDuplicate();

	}
}
