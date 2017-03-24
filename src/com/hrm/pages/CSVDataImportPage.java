package com.hrm.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.HomePage;

public class CSVDataImportPage extends HomePage{

	public CSVDataImportPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="pimCsvImport_csvFile")
	private WebElement selectFileBrowserButton;
	
	@FindBy(id="btnSave")
	private WebElement uploadButton;
	
	public void uploadCSVFile(){
		String csvPath="\\csv\\empData.csv";
		File f=new File(".", csvPath);
		selectFileBrowserButton.sendKeys(f.getAbsolutePath());
	}
	
	public void clickUploadButton(){
		uploadButton.click();
	}
	
	
	

}
