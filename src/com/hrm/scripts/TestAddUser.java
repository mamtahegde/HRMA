package com.hrm.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.AddUsersPage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.SystemUsersPage;

public class TestAddUser extends BaseTest {

	@Test()
	public void testAddUserModule() throws IOException, InterruptedException {

		DashboardPage dbPage = new DashboardPage(driver);
		
		// click on admin module
		dbPage.clickAdminModule();

		// click on user management menu
		dbPage.moveToUserManagementMenu();
		Thread.sleep(2000);
		// click on users submenu
		dbPage.clickUsersMenu();

		// Click on add button
		SystemUsersPage suPage = new SystemUsersPage(driver);
		suPage.clickOnAddButton();

		// Type first letter of the existing employee into the employee name
		// textbox
		AddUsersPage auPage = new AddUsersPage(driver);
		String empNameEntered=auPage.enterEmpName1stAlpha();
//		System.out.println(empNameEntered);
		Thread.sleep(3000);

		// verify if empname is present and select the option
		auPage.verifySelectEmpName(empNameEntered);
        log.info("adding other fields");
		// Enter other mandatory inputs
		auPage.selectUserRole();
		auPage.enterUserName();
		auPage.selectUserStatus();
        auPage.enterPassword();
        auPage.enterConfirmPassword();
        String currentEmp=auPage.getEmpName();
//        System.out.println(currentEmp);
        //click on save button
        auPage.clickSaveButton();
        log.info("User Added");
        suPage.verifyAddedUser(currentEmp);
        log.info("User verified");
        suPage.deleteAllUsers(); //bug found, not deleting users in the database, shows deleted in application
        //have written code to delete from db for script execution purposes
        log.info("Deleted all users");
        
    	}
}
