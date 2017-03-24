package com.hrm.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hrm.base.HomePage;

import generics.Utility;

public class EmpInfoPage extends HomePage {

	public EmpInfoPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "searchBtn")
	private WebElement searchBtn;

	@FindBy(id = "empsearch_job_title")
	private WebElement jobTitleListBox;

	@FindBy(id = "empsearch_termination")
	private WebElement includeListBox;

	@FindBy(id = "btnDelete")
	private WebElement btnDelete;

	@FindBy(id = "dialogDeleteBtn")
	private WebElement ok;

	@FindBy(id = "ohrmList_chkSelectAll")
	private WebElement selectAllChckBox;

	@FindBy(xpath = "//td[text()='No Records Found']")
	private WebElement noRecordsMsg;

	@FindBy(xpath = "//table[@id='resultTable']//th/a")
	private List<WebElement> tableHeaders;

	@FindBy(xpath = "//table[@id='resultTable']//following::tr/td[3]/a") // refactoring
																			// needed,
																			// use
																			// dynamic
																			// xpath
	private List<WebElement> first_names;

	@FindBy(xpath = "//table[@id='resultTable']//following::tr/td[4]/a") // refactoring
																			// needed,
																			// use
																			// dynamic
																			// xpath
	private List<WebElement> last_names;

	public void selectEmpCheckBox(String empID) {
		String xp = "//a[text()='" + empID + "']/../..//input[@type='checkbox']";// using
																					// dynamic
																					// xpath
		driver.findElement(By.xpath(xp)).click();
	}

	public void clickDelete() {
		btnDelete.click();
	}

	public void clickOK() {
		ok.click();
	}

	public void verifyNoRecordsMsgIsDisplayed() {
		verifyElementIsPresent(noRecordsMsg);
	}

	public void clickSelectAllChckBox() {
		selectAllChckBox.click();
	}

	public void verifyEmpNotPresent(String empID) {
		// String xp="//a[text()='" + empID + "']";
		// WebElement element = driver.findElement(By.id(xp));
		By loc = By.xpath("//a[text()='" + empID + "']");
		verifyElementIsNotPresent(/* element */loc);
		// Here we cannot use driver.findelement, refer java extras for details
	}

	public void verifySearchBtnPresent() {
		verifyElementIsPresent(searchBtn);
	}

	public void verifyJobTitleListBoxIsSorted() {
		log.info("Verify that content of job title listbox is sorted");
		verifyListBoxIsSorted(jobTitleListBox, 1);
		log.info("ListBox Content is sorted");
	}

	public void verifyJobTitleListBoxHasNoDuplicate() {
		log.info("verify that job title listbox has no duplicate options");
		verifyListBoxHasNoDuplicate(jobTitleListBox, 1);
		log.info("ListBox has no duplicate");
	}

	public void verifyIncludeListBoxIsSorted() {
		log.info("Veify that content of Include listbox is sorted");
		verifyListBoxIsSorted(includeListBox, 0);
		log.info("ListBox Content is sorted");
	}

	public void verifyIncludeListBoxHasNoDuplicate() {
		log.info("verify that include listbox has no duplicate options");
		verifyListBoxHasNoDuplicate(includeListBox, 0);
		log.info("ListBox has no duplicate");
	}

	public void verifyCSVRecordsImported() throws IOException {
		log.info("verifying if csv records are imported");
		boolean flag = false;
		ArrayList<String> colData = Utility.getExcelCSVColumnValues("./csv/empData.csv", "first_name");
		// colData.removeIf(name -> name.equalsIgnoreCase("first_name"));
		// handled in utility
		System.out.println(colData.size());
		ArrayList<String> tableData = getEmpTableData("First (& Middle) Name");
		for (int i = 0; i < colData.size(); i++) {
			String search = colData.get(i);
			for (String name : tableData) {
				if (name.equals(search)) {
					System.out.println(search + " is added");
					flag = true;
					break;
				}
			}
			Assert.assertTrue(flag, search + " is not added");
		}
		log.info("All records added");
	}

	public static String getEmpName() {
		ArrayList<String> allEmpFirstName=getAllEmpFirstName();
		ArrayList<String> allEmpLastName=getAllEmpLastName();
		int index=Utility.generateRandomInt(allEmpFirstName.size());
		String empName;
		empName=allEmpFirstName.get(index)+" "+allEmpLastName.get(index);		
		return empName;		
		
	}

	public ArrayList<String> getEmpTableData(String colName) {
		int index = getHeaderIndex(colName);
		String xp = "//table[@id='resultTable']//following::tr/td[" + index + "]/a";
		List<WebElement> colData = driver.findElements(By.xpath(xp));
		ArrayList<String> al = new ArrayList<String>();
		for (WebElement data : colData) {
			al.add(data.getText());
		}
		return al;

	}

	public int getHeaderIndex(String colName) {
		int index = 1;
		for (int i = 0; i < tableHeaders.size(); i++) {
			WebElement h = tableHeaders.get(i);
			if (colName.equalsIgnoreCase(h.getText())) {
				index = index + i;
				break;
			}
		}
		return index + 1; // +1 because in xpath index starts from 1 and the
							// column name is an index ahead
	}

}
