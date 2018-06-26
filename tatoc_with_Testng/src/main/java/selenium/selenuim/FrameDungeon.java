package selenium.selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameDungeon {
	WebDriver driver;
	By xyz =By.xpath("");
	public FrameDungeon(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);


	}


	@FindBy(css="body > center:nth-child(1) > a:nth-child(9)")
	private WebElement  proceed;

	@FindBy(css="body > center:nth-child(1) > a:nth-child(7)")
	private WebElement  repaint;

	public void clickingproceed() {
		driver.switchTo().frame("main");
		proceed.click();
	}


	public String getFrameTitleError(WebDriver driver) {
		driver.switchTo().defaultContent();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div/div[2]/h1")));
		return driver.findElement(By.xpath("/html/body/div/div[2]/h1")).getText();
	}
	public String getFrameTitle(WebDriver driver) {
		driver.switchTo().defaultContent();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div/div[2]/h1")));
		return driver.findElement(By.xpath("/html/body/div/div[2]/h1")).getText();
	}



	public void ClickingRepaint(WebDriver driver) {
		driver.switchTo().defaultContent();
		//WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("main")));
		driver.switchTo().frame("main"); 
		repaint.click();
		boolean    check = true;
		while (check==true) {    
			WebElement a = driver.findElement(By.id("answer"));
			String box1 = a.getAttribute("class");
			driver.switchTo().frame("child");
			WebElement b = driver.findElement(By.id("answer"));
			String box2 = b.getAttribute("class");
			driver.switchTo().parentFrame();
			if (box1.equals(box2)) {
				driver.findElement(By.cssSelector("body > center:nth-child(1) > a:nth-child(9)")).click();
				check = false;
			}
			else {
				driver.findElement(By.cssSelector("body > center:nth-child(1) > a:nth-child(7)")).click();

			}

		}
		driver.switchTo().defaultContent();
	}


}
