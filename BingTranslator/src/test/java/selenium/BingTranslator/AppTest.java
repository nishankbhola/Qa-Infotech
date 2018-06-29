package selenium.BingTranslator;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AppTest
{
    WebDriver driver ;
    
    public AppTest() {
    	System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
    	this.driver = new FirefoxDriver();
    }
    
    @BeforeClass
    public void LaunchBrowser() {
    	String url = "https://www.bing.com/translator";
    	driver.get(url);
    }
    @AfterClass
    private void CloseBrowser() {
    	//driver.quit();
    }
      
    @Test(priority = 0)
    public void CheckingFirstDropdown() {
    	DropDown obj = new DropDown(driver);
    	obj.DropDownSelect1();
    	Assert.assertTrue(obj.DropDown1Check().contains("German"));
    }
    @Test(priority = 1)
    public void CheckingSecondDropdown() {
    	DropDown obj = new DropDown(driver);
    	obj.DropDownSelect2();
    	Assert.assertTrue(obj.DropDown2Check().contains("English"));
    }
    
    @Test(priority = 2 )
    public void CheckingSwapButton() throws InterruptedException {
    	SwapButton obj = new SwapButton(driver);
    	String[] arr=obj.ClickingSwapBtn();
    	Assert.assertTrue(arr[0].contains("English"));
    	Assert.assertTrue(arr[1].contains("German"));
    }
    
  
     @Test(priority = 3)
    public void CheckTranslation() throws InterruptedException {
    	Translation obj = new Translation(driver);
    	
    	String val = obj.CheckingTrans();
    	Assert.assertTrue(val.contains("Hallo"));
    }
    
    
    @Test(priority = 4)
    public void CheckBoundryValueMaxLimit() throws IOException {
    	BoundryValueTest obj = new BoundryValueTest(driver);
    	driver.findElement(By.id("t_sv")).sendKeys(obj.InputFile());
    	
    	String limit = obj.MaxLimit();
    	String str [] = limit.split("/");
    	int lim = Integer.parseInt(str[0]);
    	System.out.println(lim);
    	Assert.assertTrue(lim<=5000);	
    }
   
    
    
    
   
    
    
}