package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.HomePage;

public class AddEmpPage extends HomePage {

	public AddEmpPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "firstName")
	private WebElement firstName;

	@FindBy(id = "lastName")
	private WebElement lastName;

	@FindBy(id = "btnSave")
	private WebElement btnSave;

	public void setFirstName(String fn) {
		firstName.sendKeys(fn);
	}

	public void setLastName(String ln) {
		lastName.sendKeys(ln);
	}

	public void clickSave() {
		btnSave.click();
	}

}
