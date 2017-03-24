package com.hrm.base;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import generics.Utility;

public abstract class BasePage {
	public Logger log = Logger.getLogger(this.getClass()); // why this logger?
	public long timeout = Long.parseLong(Utility.getPropertyValue(AutomationConstants.CONFIG_PATH, "EXPLICIT"));
	public WebDriver driver;
	public WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, timeout);
	}

	public void verifyListBoxIsSorted(WebElement listBox, int startIndex) {
		ArrayList<String> allText = Utility.getAllTextFromListBox(listBox, startIndex);
		boolean sorted = Utility.checkArrayListIsSorted(allText);
		Assert.assertTrue(sorted, "ListBox is Not Sorted");
	}

	public void verifyListBoxHasNoDuplicate(WebElement listBox, int startIndex) {
		ArrayList<String> allText = Utility.getAllTextFromListBox(listBox, startIndex);
		boolean hasDuplicate = Utility.checkArrayListHasDuplicate(allText);
		// return false then pass, return true then fail
		Assert.assertFalse(hasDuplicate, "ListBox has duplicate");
	}

	public void verifyElementIsPresent(WebElement element) {
		log.info("Verify element is Present");
		boolean present = Utility.verifyElementIsPresent(driver, element);
		Assert.assertTrue(present, "Element is not present");
		log.info("Element is present");
	}

	public void verifyElementIsNotPresent(By locator/* WebElement element */) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			// wait.until(ExpectedConditions.visibilityOf(element));
			log.error("FAIL:Element is Present");
			Assert.fail();
		} catch (Exception E) { // suppressing the TimeOutException
			log.info("PASS:Element is not Present");
		}
	}

	public void verifyURLhas(String expectedUrl) {
		wait.until(ExpectedConditions.urlContains(expectedUrl));
	}

	public void waitAndClick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

}
