package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.hrm.base.HomePage;

import generics.Utility;

public class VacanciesPage extends HomePage {

	public VacanciesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h1[text()='Vacancies']/..")
	private WebElement vacanciesBar;
	
	@FindBy(xpath="//div[@id='tiptip_content'][text()='Hide Options']")
	private WebElement hideOptionsToolTip;
	
	@FindBy(xpath="//h1[text()='Vacancies']/../following-sibling::div")
	private WebElement vacanciesDivision;
	
	@FindBy(xpath="//div[@id='tiptip_content'][text()='Expand for Options']")
	private WebElement expandForOptionsToolTip;
	
	public void moveToVacanciesBar(){
		Utility.moveToElement(driver, vacanciesBar);
	}
	
	public void verifyHideTooltipIsPresent(){
		log.info("Verifying if Hide Options is displayed");
		try{
			wait.until(ExpectedConditions.visibilityOf(hideOptionsToolTip));
			log.info("Hide Options Found");
		}catch(TimeoutException te){
			log.info("Tooltip not displayed");
			Assert.fail();
		}
		
	}
	
	public void clickOnVacanciesBarAndWait(){
		//normal click triggers "webdriver exception, element not clickable at this point", chrome error 
		Utility.moveToElementAndClick(driver, vacanciesBar);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h1[text()='Vacancies']/../following-sibling::div")));
	}
	
	public void verifyVacanciesDivIsNotVisible(){
		try{
			wait.until(ExpectedConditions.visibilityOf(vacanciesDivision));
			log.info("Still Displaying");
			Assert.fail();
		}catch(Exception e){
			log.info("Search Vacancy division is not visible");
			Utility.moveToElement(driver, hideOptionsToolTip);
		}
		
	}
	
	public void verifyExpandForOptionsIsPresent(){
		log.info("Verifying if Expand for Options is displayed");
		try{
			wait.until(ExpectedConditions.visibilityOf(expandForOptionsToolTip));
			log.info("Expand for Options Found");
		}catch(TimeoutException te){
			log.info("Tooltip not displayed");
			Assert.fail();
		}
	}
	
	public void clickVacanciesBarAndWaitTillVisible(){
		Utility.moveToElementAndClick(driver, vacanciesBar);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Vacancies']/../following-sibling::div")));
	}
	
    public void verifyVacanciesDivIsVisible(){
    	try{
			wait.until(ExpectedConditions.visibilityOf(vacanciesDivision));
			log.info("Search Vacancy division is visible");
			
		}catch(Exception e){
			log.info("Search Vacancy division is not visible");
			Assert.fail();
		}
    }
	

}
