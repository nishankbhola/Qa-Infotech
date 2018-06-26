package selenium.selenuim;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopUpWindow {
	
WebDriver driver;
	
	public PopUpWindow(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 
		
	}
	public void popup(WebDriver driver) {
		    WebDriverWait wait = new WebDriverWait(driver,10);
		    WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".page > a:nth-child(4)")));
	        link.click();	     	        	    
	        ArrayList tabs = new ArrayList (driver.getWindowHandles());
	        System.out.println(tabs.size());
	        driver.switchTo().window((String) tabs.get(1)); 
	        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
	        input.sendKeys("name");
	        driver.findElement(By.id("submit")).click();
	        driver.switchTo().window((String) tabs.get(0));
	        driver.findElement(By.cssSelector(".page > a:nth-child(6)")).click();
	}
}
