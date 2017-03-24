package dummies;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.base.AutomationConstants;

public class JavascriptDemo implements AutomationConstants {
	
	public static void main(String[] args) {
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		WebDriver driver=new FirefoxDriver();
		driver.get("file:///E:/htmlWorkshopDemo/JS.html");
		
		JavascriptExecutor j=(JavascriptExecutor) driver;
//		String js="document.getElementById('t1').value='mamta'";
//		j.executeScript(js);
		
//		j.executeScript("document.getElementById('t1').value='mamta'");
		
//		j.executeScript("document.getElementById('t1').value=arguments[0]","mamta");
		
	    WebElement e=driver.findElement(By.id("t1"));
	    
//	    j.executeScript("arguments[0].value='mamta'", e);
	    
	    j.executeScript("arguments[0].value=arguments[1]",e,"mamta"); //e will have the webelement which will be argument[0], the next parameter will be in argument[1] and so on...
	
	}

}
