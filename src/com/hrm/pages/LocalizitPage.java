package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.HomePage;

public class LocalizitPage extends HomePage{
	
	public LocalizitPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="languageList")
	private WebElement targetLangListBox;
	
	public void verifyTargetLangIsSorted(){
		verifyListBoxIsSorted(targetLangListBox, 1);
		
	}

}
