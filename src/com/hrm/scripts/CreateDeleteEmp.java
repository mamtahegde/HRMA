package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.AddEmpPage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;
import com.hrm.pages.PersonalDetailsPage;

public class CreateDeleteEmp extends BaseTest {

	@Test
	public void testCreateDeleteEmp() throws InterruptedException {
		DashboardPage dbPage = new DashboardPage(driver);
		dbPage.clickPIM_Menu();

		EmpInfoPage eiPage = new EmpInfoPage(driver);
		eiPage.clickAddEmp_Menu();

		log.info("Creating Employee");
		AddEmpPage aePage = new AddEmpPage(driver);
		aePage.setFirstName("mamta");
		aePage.setLastName("hegde");
		aePage.clickSave();
		log.info("Employee Created");

		PersonalDetailsPage pdPage = new PersonalDetailsPage(driver);
		log.info("Verifying first name");
		pdPage.verifyFirstName("mamta");
		log.info("Deleting the created Employee");
		String empID = pdPage.getEmpID();
		pdPage.clickEmpList_Menu();
		eiPage.selectEmpCheckBox(empID);
		Thread.sleep(3000);
		eiPage.clickDelete();
		eiPage.clickOK();
		log.info("Verifying deletion");
		eiPage.verifyEmpNotPresent(empID);
		log.info("Deletion Verification Successfull");
	}
}
