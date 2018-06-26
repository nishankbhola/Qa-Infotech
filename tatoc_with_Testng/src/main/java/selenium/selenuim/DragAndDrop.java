package selenium.selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {
	WebDriver driver;
	
	public DragAndDrop(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 
		
	}
	
	
	public void DragingBoxinsideTheBox(WebDriver driver) {
		    WebDriverWait wait = new WebDriverWait(driver,10);
	        WebElement from = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dragbox")));
	        WebElement to = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dropbox")));    
	        Actions act = new Actions(driver);
	        act.dragAndDrop(from, to).build().perform();
	        driver.findElement(By.cssSelector(".page > a:nth-child(10)")).click();   
	        
	}

	public String getPopUpTitle(WebDriver driver) {
		//driver.switchTo().defaultContent();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div/div[2]/h1")));
		return driver.findElement(By.xpath("/html/body/div/div[2]/h1")).getText();
	}
}

