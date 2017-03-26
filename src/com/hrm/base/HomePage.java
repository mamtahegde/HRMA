package com.hrm.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import generics.Utility;

public abstract class HomePage extends BasePage {

	@FindBy(xpath = "//a[@id='welcome']")
	private WebElement welcome;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;

	@FindBy(id = "menu_pim_viewPimModule")
	private WebElement pim_Menu;

	@FindBy(id = "menu_admin_viewAdminModule")
	private WebElement adminModule;

	@FindBy(id = "menu_admin_Job")
	private WebElement admin_Job_Menu;

	@FindBy(id = "menu_pim_addEmployee")
	private WebElement addEmp_Menu;

	@FindBy(id = "menu_admin_employmentStatus")
	private WebElement admin_EmploymentStatus;

	@FindBy(id = "menu_pim_viewEmployeeList")
	private WebElement empList_Menu;

	@FindBy(id = "menu_admin_Configuration")
	private WebElement configuration_Menu;

	@FindBy(id = "menu_admin_localization")
	private WebElement admin_localization_Menu;

	@FindBy(id = "menu_pim_Configuration")
	private WebElement pimConfigurationMenu;

	@FindBy(id = "menu_admin_pimCsvImport")
	private WebElement pimConfigurationCSVImport;

	@FindBy(id = "menu_admin_UserManagement")
	private WebElement userManagementMenu;

	@FindBy(id = "menu_admin_viewSystemUsers")
	private WebElement userMenu;
	
	@FindBy(id="menu_leave_viewLeaveModule")
	private WebElement leaveMenu;
	
	@FindBy(id="menu_leave_assignLeave")
	private WebElement assignLeaveMenu;
	
	@FindBy(id="menu_time_viewTimeModule")
	private WebElement timeMenu;
	
	@FindBy(id="menu_recruitment_viewRecruitmentModule")
	private WebElement recruitmentMenu;
	
	@FindBy(id="menu_recruitment_viewJobVacancy")
	private WebElement recruitmentVacanciesMenu;
	
	@FindBy(id="menu_admin_Job")
	private WebElement adminJobMenu;
	
	@FindBy(id="menu_admin_workShift")
	private WebElement adminJobWorkshifts;

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	Statement stmt=Utility.getDBStatement("bitnami_orangehrm", "root", "manager");

	public void clickAddEmp_Menu() {
		addEmp_Menu.click();
	}

	public void clickPIM_Menu() {
		pim_Menu.click();
	}

	public void clickEmpList_Menu() {
		empList_Menu.click();
	}

	public void moveToUserManagementMenu() {
		Utility.moveToElement(driver, userManagementMenu);
	}

	public void clickUsersMenu() {
		userMenu.click();
	}

	public void moveToConfigurationMenu() {
		Utility.moveToElement(driver, configuration_Menu);
	}

	public void moveToPimConfigurationMenu() {
		Utility.moveToElement(driver, pimConfigurationMenu);
	}

	public void clickPimDataImport() {
		Utility.moveToElementAndClick(driver, pimConfigurationCSVImport);
	}

	public void clickOnLoclizationMenu() {
		Utility.moveToElementAndClick(driver, admin_localization_Menu);
	}
	
	public void moveToAdminJobMenu(){
		Utility.moveToElement(driver, adminJobMenu);
	}

	public void clickAdminModule() {
		adminModule.click();
	}

	public void enterIntoTxtBox(WebElement element, String txt) {
		element.sendKeys(txt);
	}

	public void clickAdminJobMenu() {
		admin_Job_Menu.click();
	}

	public void clickAdminEmploymentStatus() {
		admin_EmploymentStatus.click();
	}
	
	public void clickWorkshiftsMenu(){
		Utility.moveToElementAndClick(driver, adminJobWorkshifts);
	}

	public void logout() {
		// welcome.click();
		Utility.clickUsingJS(driver, welcome);
		waitAndClick(logout);
	}

	public List<WebElement> getAutoSuggestionOptions(WebElement autoSuggestListBox) {
		try {
			wait.until(ExpectedConditions.visibilityOf(autoSuggestListBox));
		} catch (Exception E) {
		}
		List<WebElement> options = autoSuggestListBox.findElements(By.tagName("li"));
		return options;
	}
	
	public void moveToLeaveMenu(){
		Utility.moveToElement(driver, leaveMenu);
	}
	
	public void moveToAssignLeave(){
		Utility.moveToElementAndClick(driver, assignLeaveMenu);
	}
	
	public void clickTimeMenu(){
		timeMenu.click();
	}
	
	public void moveToRecruitmentMenu(){
		Utility.moveToElement(driver, recruitmentMenu);
	}
	
	public void clickVacanciesMenu(){
		Utility.moveToElementAndClick(driver, recruitmentVacanciesMenu);
	}
	
	public static ArrayList<String> getAllEmpFirstName(){
		
//		Utility.getMySQLDataBaseColumn("bitnami_orangehrm", "root", "manager","hs_hr_employee","emp_firstname");
		ArrayList<String> allEmp=new ArrayList<String>();
		try{
		ResultSet result=Utility.getMySQLDataBaseColumn("bitnami_orangehrm", "root", "manager","hs_hr_employee","emp_firstname");
		while(result.next())
//			    Reporter.log(result.getString(1));
			
				allEmp.add(result.getString(1));
			} catch (SQLException e) {
				
			}
		return allEmp;
	}
	
	public static ArrayList<String> getAllEmpLastName(){
		
		
		ArrayList<String> allEmp=new ArrayList<String>();
		try{
		ResultSet result=Utility.getMySQLDataBaseColumn("bitnami_orangehrm"/*databasename*/, "root"/*db password*/,
		 "manager"/*db password*/,"hs_hr_employee"/*table name*/,"emp_lastname"/*column name*/);
		while(result.next())
			
				allEmp.add(result.getString(1));
			} catch (SQLException e) {
				
			}
		return allEmp;
	}
	
	


}
