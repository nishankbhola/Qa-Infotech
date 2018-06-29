package selenium.BingTranslator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Translation {
	WebDriver driver;
	public Translation(WebDriver driver){
		this.driver = driver;	
	}
	
	
	public String CheckingTrans() throws InterruptedException{
		driver.findElement(By.id("t_sv")).sendKeys("hello");
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	Thread.sleep(2000);
    	String value = (String)(js.executeScript("return arguments[0].value", driver.findElement(By.id("t_tv"))));
    	System.out.println(value);
    	driver.findElement(By.id("t_sv")).clear();
    	return value;
	}
	
	
	
}
