package com.hrm.pages;

import java.time.DayOfWeek;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.HomePage;

import generics.Utility;

public class DefineTimeSheetPeriodPage extends HomePage{

	public DefineTimeSheetPeriodPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="time_startingDays")
	private WebElement firstDayOfWeekListBox;
	
	public void checkFirstDayOfWeekListIsSorted(){
		ArrayList<String> allOptions=Utility.getAllTextFromListBox(firstDayOfWeekListBox, 1);
		DayOfWeek[] dow = DayOfWeek.values();
		for(int i=0;i<dow.length;i++){
			String selOpt=allOptions.get(i);
			String day=dow[i].toString();
			if(selOpt.equalsIgnoreCase(day)){
				System.out.println(selOpt+" = "+day);
			}else{
				System.out.println(selOpt+" != "+day);
				Assert.fail();
			}
		}
	}
	
	

}
