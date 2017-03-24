package dummies;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.base.AutomationConstants;

public class TableHeaderAccess implements AutomationConstants {
	
	public static void main(String[] args) {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("file:///C:/Users/Mamta-PC/Desktop/test.html");
		List<WebElement> headers = driver.findElements(By.xpath("//table//th"));
		int index = 0;
		for(int i=0;i<headers.size();i++){
			WebElement h = headers.get(i);
			if(h.getText().equals("header4"))
				index=i+1;
		}
		System.out.println("Index of header4 is "+index);
		driver.close();
	}

}
