package selenium.selenuim;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.*;
import org.testng.annotations.*;

public class Testing {
		
	WebDriver driver;
	
	
	@BeforeClass 
	public void OpenWebpage() {
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://10.0.1.86/tatoc");
        driver.findElement(By.cssSelector("a")).click();
	}
	
	@Test(priority=1)
	public void CheckingGreenGrid () {
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
		Grid gridobj = new Grid(driver);
		gridobj.OnClickGreenBox(driver);
		Assert.assertTrue(gridobj.getPageTitle(driver).contains("Frame Dungeon"));
	}
	
	@Test(priority=0)
	public void CheckingRedGrid () {
		Grid gridobj = new Grid(driver);
		gridobj.OnclickRedBox(driver);
		Assert.assertTrue(gridobj.getPageTitleError(driver).contains("Error"));	
		
	}
	
	
	@Test(priority=2)
	public void ClickingProceedWithoutColorMatch() {
		FrameDungeon fd = new FrameDungeon(driver);
		fd.clickingproceed();
		Assert.assertTrue(fd.getFrameTitleError(driver).contains("Error"));	
		
		
	}
	
	@Test(priority=4)
	public void ClickingProceedWithColorMatch() {
		//driver.switchTo().defaultContent();
		FrameDungeon fd = new FrameDungeon(driver);
		Assert.assertTrue(fd.getFrameTitle(driver).contains("Drag Around"));
	}
	
	@Test(priority=3)
	public void ClickingRepaint() {
		driver.get("http://10.0.1.86/tatoc/basic/frame/dungeon");
		FrameDungeon fd = new FrameDungeon(driver);
		fd.ClickingRepaint(driver);
		
	}
	@Test(priority=5)
	public void DraginigBox(){
		DragAndDrop fd = new DragAndDrop(driver);
		fd.DragingBoxinsideTheBox(driver);	
	}
	@Test(priority=6)
	public void CheckingDragTest() {
		//driver.switchTo().defaultContent();
		DragAndDrop fd = new DragAndDrop(driver);
		Assert.assertTrue(fd.getPopUpTitle(driver).contains("Popup Windows"));
	}
	@Test(priority=7)
	public void PopUp() {
		//driver.switchTo().defaultContent();
		PopUpWindow obj = new PopUpWindow(driver);
		obj.popup(driver);
		//Assert.assertTrue(obj.popup(driver).contains("Popup Windows"));
	}
	
	@Test(priority=8)
	public void Cookie() {
		CookieClass obj = new CookieClass(driver);
		obj.CokkieInput();
		Assert.assertTrue(obj.cookiecheck().contains("End"));
	}
	
	
	@AfterClass
	public void CloseBrowser() {
		//driver.quit();
		
	}
	
	
	
}
