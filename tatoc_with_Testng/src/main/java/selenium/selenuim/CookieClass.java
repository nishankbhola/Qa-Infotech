package selenium.selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookieClass {
	WebDriver driver;
	
	public CookieClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Generate Token")
	private WebElement tok ;
	
	
	public void CokkieInput() {
		    tok.click();
		    String token = driver.findElement(By.id("token")).getText();
		   // System.out.println(token);
		    String[] splitStr = token.split("\\s+");
		    System.out.println(splitStr[1]);
		    Cookie name = new Cookie("Token",splitStr[1]);
	        driver.manage().addCookie(name);
	        driver.findElement(By.linkText("Proceed")).click();
	        
	}
	public String cookiecheck() {
		WebDriverWait wait = new WebDriverWait(driver , 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div/div[2]/h1")));
		return driver.findElement(By.xpath("/html/body/div/div[2]/h1")).getText();
	}
	
}
