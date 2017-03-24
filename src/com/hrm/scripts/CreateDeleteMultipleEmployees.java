package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.AddEmpPage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;
import com.hrm.pages.PersonalDetailsPage;

import generics.Utility;

public class CreateDeleteMultipleEmployees extends BaseTest {

	@Test
	public void testCreateDeleteEmp() throws InterruptedException {
		DashboardPage dbPage = new DashboardPage(driver);
		dbPage.clickPIM_Menu();

		EmpInfoPage eiPage = new EmpInfoPage(driver);
		AddEmpPage aePage = new AddEmpPage(driver);

		int rc = Utility.getExcelRowCount(INPUT_PATH, "emp");
		for (int i = 1; i <= rc; i++) {
			eiPage.clickAddEmp_Menu();
			log.info("Creating Employee " + i);
			String fn = Utility.getExcelCellValue(INPUT_PATH, "emp", i, 0);
			String ln = Utility.getExcelCellValue(INPUT_PATH, "emp", i, 1);
			aePage.setFirstName(fn);
			aePage.setLastName(ln);
			aePage.clickSave();
			log.info("Employee" + i + " Created");
		}
		PersonalDetailsPage pdPage = new PersonalDetailsPage(driver);
		log.info("Deleting all added Employees");
		pdPage.clickEmpList_Menu();
		eiPage.clickSelectAllChckBox();
		Thread.sleep(3000);
		eiPage.clickDelete();
		eiPage.clickOK();
		log.info("Verifying deletion");
		eiPage.verifyNoRecordsMsgIsDisplayed();
		log.info("Deletion Verification Successfull");

	}
}