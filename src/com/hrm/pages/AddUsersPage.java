package com.hrm.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.hrm.base.AutomationConstants;
import com.hrm.base.HomePage;

import generics.Utility;

public class AddUsersPage extends HomePage implements AutomationConstants {

	public AddUsersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "systemUser_employeeName_empName")
	private WebElement empNameTxtBox;

	@FindBy(xpath = "//div[@class='ac_results']//ul")
	private WebElement autoOptions;
	
	@FindBy(id="systemUser_userType")
	private WebElement userRoleListBox;
	
	@FindBy(id="systemUser_userName")
	private WebElement userNameTxtBox;
	
	@FindBy(id="systemUser_status")
	private WebElement statusListBox;
	
	@FindBy(id="systemUser_password")
	private WebElement passwordTxtBox;
	
	@FindBy(id="systemUser_confirmPassword")
	private WebElement confirmPwdTxtBox;
	
	@FindBy(id="btnSave")
	private WebElement saveButton;

	public String enterEmpName1stAlpha() {
		String empName=EmpInfoPage.getEmpName();
		String c = empName.substring(0, 1);
		empNameTxtBox.sendKeys(c);
		return empName;
	}

	public void verifySelectEmpName(String empName) {
		List<WebElement> allOptions = getAutoSuggestionOptions(autoOptions);
		for (int i = 0; i < allOptions.size(); i++) {
			String opt = allOptions.get(i).getText();
			if (empName.equalsIgnoreCase(opt)) {
				log.info("Employee Name found");
				System.out.println(opt);
				allOptions.get(i).click();
			}
		}
	}
	
	public void selectUserRole(){
		String role=Utility.getExcelCellValue(INPUT_PATH, "AddUsers", 1, 0);
		userRoleListBox.click();
		Select select=new Select(userRoleListBox);
		select.selectByVisibleText(role);
	}
	
	public void enterUserName(){
		userNameTxtBox.sendKeys(Utility.getExcelCellValue(INPUT_PATH, "AddUsers", 1, 1));
	}
	
	public void selectUserStatus(){
		String status=Utility.getExcelCellValue(INPUT_PATH, "AddUsers", 1, 2);
		Select select=new Select(statusListBox);
		select.selectByVisibleText(status);
	}
	
	public void enterPassword(){
		passwordTxtBox.sendKeys(Utility.getExcelCellValue(INPUT_PATH, "AddUsers", 1, 3));
	}
	
	public void enterConfirmPassword(){
		confirmPwdTxtBox.sendKeys(Utility.getExcelCellValue(INPUT_PATH, "AddUsers", 1, 3));
	}
	
	public String getEmpName(){
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		String empName = (String) js.executeScript("arguments[0].value", userNameTxtBox);
//		System.out.println(empName);
		String emp=userNameTxtBox.getAttribute("value");
		return emp;
	}
	
	public void clickSaveButton(){
		saveButton.click();
	}

}
