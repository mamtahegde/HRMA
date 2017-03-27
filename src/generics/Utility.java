package generics;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	public static String getFormatedDateTime() {
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return simpleDate.format(new Date());
	}

	public static String getScreenShot(WebDriver driver, String imageFolderPath) {
		// this method takes only the screenshot of the webpage,
		// if a window based popup or window is present on the webpage, then it
		// is not captured by this method,
		// thats when we use another method that uses Robot class
		String imagePath = imageFolderPath + "/" + getFormatedDateTime() + ".png";
		TakesScreenshot page = (TakesScreenshot) driver;
		try {
			FileUtils.copyFile(page.getScreenshotAs(OutputType.FILE), new File(imagePath));
		} catch (Exception e) {

		}
		return imagePath;
	}

	public static void clickUsingJS(WebDriver driver, WebElement e) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click()", e);// refer JavaScriptDemo.java
													// of dummies package
	}

	public static boolean checkArrayListHasText(ArrayList<String> allText, String expectedText) {
		return allText.contains(expectedText);
	}

	public static boolean checkListContainsList(List<WebElement> listHas, List<WebElement> compareList) {
		return listHas.containsAll(compareList);
	}

	public static boolean checkArrayListHasArrayList(ArrayList<String> listHas, ArrayList<String> thisList) {
		return listHas.containsAll(thisList);
	}

	public static boolean checkArrayListHasDuplicate(ArrayList<String> allText) {
		HashSet<String> clone = new HashSet<String>();
		for (String s : allText) {
			if (clone.add(s)) {
				System.out.println(s + "->Not Duplicate");// no need of logging
															// this in the
															// logger,hence
															// s.o.p
			} else {
				System.out.println(s + "->Is Duplicate");
				return true;// means it has duplicate
			}
		}
		return false; // means it has no duplicate
	}

	public static ArrayList<String> getAllTextFromListBox(WebElement listBox, int startIndex) {
		Select select = new Select(listBox);
		List<WebElement> allOptions = select.getOptions();
		ArrayList<String> allText = new ArrayList<String>();
		for (int i = startIndex; i < allOptions.size(); i++) {
			String text = allOptions.get(i).getText();
			allText.add(text);
		}
		return allText;
	}

	public static boolean checkArrayListIsSorted(ArrayList<String> allText) {
		ArrayList<String> clone = new ArrayList<String>(allText);
		Collections.sort(clone, String.CASE_INSENSITIVE_ORDER);
		// for debugging purpose
		System.out.println("------------------------------------");
		for (int i = 0; i < clone.size(); i++) {
			System.out.println(allText.get(i) + "==" + clone.get(i));
		}
		System.out.println("------------------------------------");
		return allText.equals(clone);
	}

	public static String getScreenShot(String imageFolderPath) {
		String imagePath = imageFolderPath + "/" + getFormatedDateTime() + ".png";

		try {
			Dimension desktopSize = Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(desktopSize));
			ImageIO.write(image, "png", new File(imagePath));
		} catch (Exception e) {
		}

		return imagePath;

	}

	public static String getPropertyValue(String filePath, String key) {
		String value = "";
		Properties ppt = new Properties();
		try {
			ppt.load(new FileInputStream(filePath));
			value = ppt.getProperty(key);
		} catch (Exception e) {
		}
		return value;
	}

	public static int getExcelRowCount(String path, String sheet) {
		int r = 0;
		try {

			r = WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	public static String getExcelCellValue(String path, String sheet, int r, int c) {
		String v = "";
		try {

			v = WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(r).getCell(c).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	public static short getExcelColumnCount(String path, String sheet, int row) {
		short c = 0;
		try {
			c = WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(row).getLastCellNum();
		} catch (Exception e) {
		}
		return c;
	}

	public static boolean switchBrowser(WebDriver driver, String eTitle) { // based
																			// on
																			// page
																			// title
		String currentWH = "";
		try {
			currentWH = driver.getWindowHandle();
		} catch (Exception e) {
		}

		Set<String> allWH = driver.getWindowHandles();
		for (String wh : allWH) {
			String title = driver.switchTo().window(wh).getTitle();
			if (title.equals(eTitle)) {
				System.out.println("Browser Found");
				return true;
			}
		}
		driver.switchTo().window(currentWH);
		return false;
	}

	public static boolean switchBrowser(String eURL, WebDriver driver) { // based
																			// on
																			// page
																			// URL
		String currentWH = "";
		try {
			currentWH = driver.getWindowHandle();
		} catch (Exception e) {
		}
		Set<String> allWH = driver.getWindowHandles();
		for (String wh : allWH) {
			String url = driver.switchTo().window(wh).getCurrentUrl();
			if (url.contains(eURL)) {
				System.out.println("Browser Found");
				return true;
			}
		}
		driver.switchTo().window(currentWH);
		return false;
	}

	public static boolean switchBrowser(WebDriver driver, WebElement element) { // based
																				// on
																				// webelement
		String currentWH = "";
		try {
			currentWH = driver.getWindowHandle();
		} catch (Exception e) {
		}
		Set<String> allWH = driver.getWindowHandles();
		for (String wh : allWH) {
			driver.switchTo().window(wh);
			if (verifyElementIsPresent(driver, element)) {
				System.out.println("Browser Found");
				return true;
			}
		}
		driver.switchTo().window(currentWH);
		return false;
	}

	public static boolean verifyElementIsPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception E) {
			return false;
		}
	}

	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}

	public static void moveToElementAndClick(WebDriver driver, WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).click().build().perform();
	}

	public static void openLinkInNewWindow(WebDriver driver, WebElement link) {
		Actions ac = new Actions(driver);
		ac.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
	}

	public static ArrayList<String> getExcelCSVColumnValues(String path, String colName) throws IOException {

		Reader r = new FileReader(path);
		CSVFormat csvFormat = CSVFormat.EXCEL.withNullString("").withFirstRecordAsHeader();
		CSVParser csvp = new CSVParser(r, csvFormat);
		ArrayList<String> al = new ArrayList<String>();
		for (CSVRecord csv : csvp.getRecords()) {
			String values[] = { csv.get(colName) };
			for (String value : values) {
				if (value != null) {
					al.addAll(Arrays.asList(values));
				}
			}
		}
		csvp.close();
		return al;
	}

	public static int generateRandomInt(int max) {
		Random rand = new Random();
		// int range=(max-minimum)+1; //this statement if there is a range for
		// generating the random number
		return rand.nextInt(max);
	}

	public static String getCurrentMonthYear() {
		SimpleDateFormat sDate = new SimpleDateFormat("MMM YYYY");
		return sDate.format(new Date());
	}

	public static ResultSet getMySQLDataBaseColumn(String dbName, String un, String pwd, String tableName,
			String colName) {
		ResultSet rs = null;
		try {
			Statement stmt = Utility.getDBStatement(dbName, un, pwd);
			rs = stmt.executeQuery("select " + colName + " from " + tableName);
			// while(rs.next()) System.out.println(rs.getString(1));

		} catch (Exception e) {
		}
		return rs;
	}

	public static Statement getDBStatement(String dbName, String un, String pwd) {
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, un, pwd);
			stmt = c.createStatement();
		} catch (Exception e) {
		}
		return stmt;
	}

	public static void insertIntoDBTableFromExcel(Statement stmt, String xlPath, String tableName, int xlCol) {
		int rowCount = Utility.getExcelRowCount(xlPath, tableName);
		for (int i = 1; i <= rowCount; i++) {
			try {
				stmt.executeUpdate(Utility.getExcelCellValue(xlPath, tableName, i, xlCol));
			} catch (Exception e) {
			}//
		}
	}
	
	public static void deleteAllTableData(Statement stmt,String xlPath,String tableName){
		try {
			stmt.executeUpdate(Utility.getExcelCellValue(xlPath, tableName, 1, 1));
		} catch (SQLException e) {
		}
	}

}
