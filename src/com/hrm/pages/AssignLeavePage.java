package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hrm.base.HomePage;
import generics.Utility;

public class AssignLeavePage extends HomePage {

	public AssignLeavePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='assignleave_txtFromDate']//following-sibling::img")
	private WebElement fromDatePicker;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthListBox;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yearListBox;
	
	public void clickFromDatePicker(){
		fromDatePicker.click();
	}
	
	public String getFromSelectedMonth(){
		Select sel=new Select(monthListBox);
		String selected=sel.getFirstSelectedOption().getText();
		return selected;
	}
	
	public String getFromSelectedYear(){
		Select sel=new Select(yearListBox);
		String selected=sel.getFirstSelectedOption().getText();
		return selected;
	}
	public void verifyDatePickerListBox(){
		log.info("verifying list box"); 
		String selectedMonth=getFromSelectedMonth(); //Mar
		String selectedYear=getFromSelectedYear(); //2017
		String currentDate=Utility.getCurrentMonthYear(); //Mar 2017
		String[] date=currentDate.split(" ");
		Assert.assertEquals(selectedMonth, date[0],"Current month is not selected");
		log.info("Current month is selected");
		Assert.assertEquals(selectedYear, date[1], "Current year is not selected");
		log.info("Curren year is selected");
	}

}
