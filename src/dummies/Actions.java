package dummies;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.hrm.base.AutomationConstants;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;

import generics.Utility;

public class Actions implements AutomationConstants { //was not done by sir hence not in bitnami

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://localhost/orangehrm/symfony/web/index.php/auth/login");
		new LoginPage(driver).login("admin", "manager");

		DashboardPage dbPage = new DashboardPage(driver);
		dbPage.clickAdminModule();
		
		Thread.sleep(3000);

		WebElement element = driver.findElement(By.id("menu_admin_Configuration"));
		Utility.moveToElement(driver, element);
		
		Thread.sleep(3000);

		WebElement element2 = driver.findElement(By.id("menu_admin_localization"));
		Utility.moveToElementAndClick(driver, element2);
		Thread.sleep(3000);
		
		driver.close();
	}

}
