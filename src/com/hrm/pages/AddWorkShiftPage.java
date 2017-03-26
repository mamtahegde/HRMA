package com.hrm.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.hrm.base.HomePage;

import generics.Utility;

public class AddWorkShiftPage extends HomePage{
	
	List<WebElement> allSelectedOptions;
	SoftAssert sa=new SoftAssert();
	
	@FindBy(id="workShift_availableEmp")
	private WebElement availEmpListBox;
	
	@FindBy(id="workShift_assignedEmp")
	private WebElement assignedEmpListBox;
	
	@FindBy(id="btnAssignEmployee")
	private WebElement addButton;

	public AddWorkShiftPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickAddButton(){
		addButton.click();
	}
	
	public void selectAvailableEmpListBox() throws InterruptedException{
		Select sel=new Select(availEmpListBox);
		List<WebElement> allOpt = sel.getOptions();
		int listSize=allOpt.size();
//		System.out.println(allOpt.size());
		int emp1=Utility.generateRandomInt(listSize);
		int emp2=Utility.generateRandomInt(listSize);
		sel.selectByIndex(emp1);
		sel.selectByIndex(emp2);
		allSelectedOptions=sel.getAllSelectedOptions();
	}
	
	public void verifyAddedEmployee(){
		Select assigned=new Select(assignedEmpListBox);
		Select available=new Select(availEmpListBox);
		List<WebElement> allAssgned = assigned.getOptions();
		List<WebElement> allAvailable=available.getOptions();
		
		SoftAssert sa=new SoftAssert();
	    boolean checkAssignedListBox=Utility.checkListContainsList(allAssgned, allSelectedOptions);
	    System.out.println(checkAssignedListBox);
	    sa.assertTrue(checkAssignedListBox);
	    boolean checkAvailableListBox=Utility.checkListContainsList(allAvailable, allSelectedOptions);
	    System.out.println(checkAvailableListBox);
	    sa.assertFalse(checkAvailableListBox);
		
	    sa.assertAll();
	}
	
}
