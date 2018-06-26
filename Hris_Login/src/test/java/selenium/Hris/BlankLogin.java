package selenium.Hris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BlankLogin {
WebDriver driver;
	
	BlankLogin(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Blank() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[1]/form/div[2]/div/input")).click();
		
	}
	public String CheckRed() {
		String style = driver.findElement(By.id("txtUserName")).getAttribute("style");
		System.out.println(style);
		return style;
	}
}
