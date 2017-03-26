package com.hrm.pages;

import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hrm.base.HomePage;

import generics.Utility;

public class SystemUsersPage extends HomePage {

	public SystemUsersPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="searchSystemUser_userName")
	private WebElement searchUsernameTxtBox;
	
	@FindBy(id="searchBtn")
	private WebElement searchButton;
	
	@FindBy(xpath="//table[@id='resultTable']//td[text()='No Records Found']")
	private WebElement noRecordFoundMsg;
	
	@FindBy(id="btnAdd")
	private WebElement addButton;
	
	@FindBy(xpath="//table[@id='resultTable']//td[2]/a")
	private List<WebElement> allUsers;
	
	@FindBy(id="ohrmList_chkSelectAll")
	private WebElement selectAllCheckBox;
	
	@FindBy(id="btnDelete")
	private WebElement deleteButton;
	
	@FindBy(id="dialogDeleteBtn")
	private WebElement okButton;
	
	public void enterInSearchUsernameTxtBox(String txt){
		enterIntoTxtBox(searchUsernameTxtBox,txt);
	}

	public void clickSearchButton(){
		searchButton.click();
	}
	
	public void verifyNoRecordFoundMsg(){
		try{
			if(noRecordFoundMsg.isDisplayed()){
				log.info("No Record Found is Displayed");}
			}catch(Exception E){
				log.error("No Record Found is Not Displayed");
				Assert.fail();
			}
		}
	
	public void clickOnAddButton(){
		addButton.click();
	}
	
	public void verifyAddedUser(String emp){
		boolean flag=false;
		for(WebElement user:allUsers){
			String emp2=user.getText();
			if(emp2.equalsIgnoreCase(emp)){
				flag=true;
				break;
			}
		}
		Assert.assertTrue(flag,"User not verified");
	}
	
	public void deleteAllUsers(){
		log.info("Deleting all users");
		selectAllCheckBox.click();
		deleteButton.click();
		waitAndClick(okButton);
		this.deleteFromDB();
	}
	
	public void deleteFromDB(){
		System.out.println("Executing");
		try{
		Statement stmt2=Utility.getDBStatement("bitnami_orangehrm", "root", "manager");
		//SELECT user_name FROM ohrm_user WHERE user_name<>'admin'  for selecting all employees except admin
		//DELETE FROM ohrm_user WHERE user_name<>'admin'  for deleting. Note that * is removed before From
		stmt2.executeUpdate("DELETE FROM ohrm_user WHERE user_name<>'admin'");
		}catch(Exception e){}
	}
	}
