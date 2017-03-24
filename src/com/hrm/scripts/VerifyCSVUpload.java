package com.hrm.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.CSVDataImportPage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;

public class VerifyCSVUpload extends BaseTest {
	
	@Test
	public void testCSVUpload() throws InterruptedException, IOException{
		
		//Go to PIM menu
		DashboardPage dbPage=new DashboardPage(driver);
		
		dbPage.clickPIM_Menu();
		//move to configuration menu
		dbPage.moveToPimConfigurationMenu();
		Thread.sleep(3000);
		//Click on data import
		dbPage.clickPimDataImport();
		
		//select and bowser the file to be uploaded
		CSVDataImportPage csvPage=new CSVDataImportPage(driver);
		csvPage.uploadCSVFile();
		
		//click on upload button
		csvPage.clickUploadButton();
		
		//Go to employee list page
		EmpInfoPage eiPage=new EmpInfoPage(driver);
		eiPage.clickEmpList_Menu();
		
		//verify if the records are imported
		eiPage.verifyCSVRecordsImported();
		
		Thread.sleep(3000);
		//delete added records
		log.info("Deleting all records");
		eiPage.clickSelectAllChckBox();
		eiPage.clickDelete();
		eiPage.clickOK();
	}
}
