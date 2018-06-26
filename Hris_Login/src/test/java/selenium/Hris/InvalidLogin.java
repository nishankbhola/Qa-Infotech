package selenium.Hris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvalidLogin {
	WebDriver driver;
	
	InvalidLogin(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "txtUserName")
	private WebElement username ;
	
	@FindBy(id = "txtPassword")
	private WebElement password ;



public void EnteringInvalidDetails() {
	ValidLogin obj = new ValidLogin(driver);
	 String f = "/home/qainfotech/Documents/userdataInvalid.property";
	 String array123 [] = obj.DetailsFromFile(f);
	 driver.findElement(By.id("txtUserName")).sendKeys(array123[0]);
	driver.findElement(By.id("txtPassword")).sendKeys(array123[1]);	
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[1]/form/div[2]/div/input")).click();
    }

public String InvalidError() {
	return driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[1]/form/div[1]/div")).getText();
}
}