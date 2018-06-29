package selenium.BingTranslator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	WebDriver driver;
	public DropDown(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void DropDownSelect1() {
		WebElement mySelectElement = driver.findElement(By.id("t_sl"));
		Select dropdown= new Select(mySelectElement);
		dropdown.selectByVisibleText("German");
		
	}
	String DropDown1Check() {
		return driver.findElement(By.xpath("//*[@id='t_sl']")).getText();
		
	}

	public void DropDownSelect2() {
		WebElement mySelectElement = driver.findElement(By.xpath("//*[@id='t_tl']"));
		Select dropdown= new Select(mySelectElement);
		dropdown.selectByVisibleText("English");
	}
	String DropDown2Check() {
		return driver.findElement(By.xpath("//*[@id='t_tl']")).getText();
		
	}
	
	
}
