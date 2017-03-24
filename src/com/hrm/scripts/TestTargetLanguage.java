package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LocalizationPage;
import com.hrm.pages.LocalizitPage;

import generics.Utility;

public class TestTargetLanguage extends BaseTest{
	
	@Test
	public void testTargetLanguageIsSorted() throws InterruptedException{
		
		//click on Admin module
		
		DashboardPage dbPage=new DashboardPage(driver);
		dbPage.clickAdminModule();
		
		//move to configuration menu
		dbPage.moveToConfigurationMenu();
		
		//click on Localization menu
		dbPage.clickOnLoclizationMenu();
		
		//click on language and font help
		LocalizationPage lPage=new LocalizationPage(driver);
		lPage.clickLanguageAndFontHelpLink();
		
		//switch to new window
		Utility.switchBrowser(driver, "Orange - Localizit");
		
		//verify target language list box is sorted
		LocalizitPage lzitPage=new LocalizitPage(driver); //which page should it extend Home or Base
		lzitPage.verifyTargetLangIsSorted();
		
		//close the localizit page
		driver.close();
		
		Thread.sleep(3000);
		
		//back to parent browser
		Utility.switchBrowser(driver, "OrangeHRM");
		
	}

}
