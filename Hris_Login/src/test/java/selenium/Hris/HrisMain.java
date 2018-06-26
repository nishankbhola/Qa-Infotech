package selenium.Hris;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class HrisMain {
	WebDriver driver;
	
	
	@BeforeClass 
	public void LaunchBrowser() {
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		driver = new FirefoxDriver();
		String url = "https://hris.qainfotech.com/login.php";
		driver.get(url);
		
	}

	@Test(priority=0)
	public void CkeckingValidLogin() {
		 ValidLogin obj = new ValidLogin(driver);
		 String f = "/home/qainfotech/Documents/userdata.property";
		String array123 [] = obj.DetailsFromFile(f);
		System.out.println(array123);
		driver.findElement(By.cssSelector("a.active")).click();
		driver.findElement(By.id("txtUserName")).sendKeys(array123[0]);
		driver.findElement(By.id("txtPassword")).sendKeys(array123[1]);	
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[1]/div[1]/div[1]/form/div[2]/div/input")).click();
		Assert.assertTrue(obj.ValidateLogin(driver).contains("Nishank Bhola"));
		
	}
	@Test(priority = 1)
	public void CheckingInvalidLogin() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/ul/li/a/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/ul/li/ul/li[4]/a/span")).click();
		InvalidLogin obj = new InvalidLogin(driver);
		obj.EnteringInvalidDetails();
		Assert.assertTrue(obj.InvalidError().contains("Invalid Login"));
	}
	@Test(priority = 2)
	public void CheckingBlankLogin() {
		BlankLogin obj = new BlankLogin(driver);
		obj.Blank();
		Assert.assertTrue(obj.CheckRed().contains("red"));
	}
	@AfterClass
	public void CloseBrowser() {
		//driver.quit();
	}
	
	
}
