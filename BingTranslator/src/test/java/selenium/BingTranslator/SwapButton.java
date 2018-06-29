package selenium.BingTranslator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwapButton {
	WebDriver driver ;
	String arr[] = new String[2];
	public SwapButton(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	public String[] ClickingSwapBtn() throws InterruptedException {
		driver.findElement(By.id("t_revIcon")).click();
		arr[0] = driver.findElement(By.xpath("//*[@id='t_sl']")).getText();
		arr[1] = driver.findElement(By.xpath("//*[@id='t_tl']")).getText();
		return arr;
		
	}
}
