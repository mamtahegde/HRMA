package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.HomePage;

import generics.Utility;

public class LocalizationPage extends HomePage{

	public LocalizationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='Language and font help']")
	private WebElement languageAndFontHelpLink;
	
	public void clickLanguageAndFontHelpLink(){
		Utility.openLinkInNewWindow(driver, languageAndFontHelpLink);
	}

}
