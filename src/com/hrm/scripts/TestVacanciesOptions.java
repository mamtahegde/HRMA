package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.VacanciesPage;

public class TestVacanciesOptions extends BaseTest{
	
	@Test
	public void testVacanciesOptions(){
	
		DashboardPage dbPage=new DashboardPage(driver);
		VacanciesPage vPage=new VacanciesPage(driver);
		
		log.info("Redirecting to vacancies Page");
		//Go to vacancies option in recruitment menu
		dbPage.moveToRecruitmentMenu();
		dbPage.clickVacanciesMenu();
		
		log.info("Triggering tooltip");
		//Place mouse on vacancies bar
		vPage.moveToVacanciesBar();
		
		//verify that "Hide Options" tooltip is displayed
		vPage.verifyHideTooltipIsPresent();
		
		//click on vacancies bar
		vPage.clickOnVacanciesBarAndWait();

		//verify that elements under vacancies such as 'Search' are hidden
		log.info("verifying if vacancy search division is displayed");
		vPage.verifyVacanciesDivIsNotVisible();
		
		//Place mouse on vacancies bar
		vPage.moveToVacanciesBar();
		
		//verify that "Expand for Options" tooltip is displayed
		vPage.verifyExpandForOptionsIsPresent();
		
		//click on vacancies bar
		vPage.clickVacanciesBarAndWaitTillVisible();
		
		//verify if search division is visible
		vPage.verifyVacanciesDivIsVisible();
		
	}

}
