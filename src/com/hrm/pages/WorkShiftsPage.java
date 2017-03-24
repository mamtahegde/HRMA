package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.HomePage;

public class WorkShiftsPage extends HomePage {
	
	@FindBy(id="btnAdd")
	private WebElement addButton;

	public WorkShiftsPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickAddButton(){
		addButton.click();
	}

}
