package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.SystemUsersPage;

public class TestNoRecordFound extends BaseTest {
	
	@Test
	public void testNoRecordFound(){
		log.info("This Script will search non existing user and verify if no record found message is displayed");
		DashboardPage dbPage=new DashboardPage(driver);
		dbPage.clickAdminModule();
		
		SystemUsersPage suPage=new SystemUsersPage(driver);
		suPage.enterInSearchUsernameTxtBox("user");
		suPage.clickSearchButton();
		
		suPage.verifyNoRecordFoundMsg();
	}

}
