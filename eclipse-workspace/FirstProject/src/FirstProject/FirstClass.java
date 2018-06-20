package FirstProject;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.*;
public class FirstClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://10.0.1.86/tatoc");
        driver.findElement(By.cssSelector("a")).click();
        driver.findElement(By.className("greenbox")).click();    
        driver.switchTo().frame("main");    
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
        //System.out.println("heheheheheh");
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement from = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dragbox")));
        WebElement to = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dropbox")));    
        Actions act = new Actions(driver);
        act.dragAndDrop(from, to).build().perform();
        driver.findElement(By.cssSelector(".page > a:nth-child(10)")).click();   
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".page > a:nth-child(4)")));
        link.click();
     
        
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window((String) tabs.get(1)); 
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        input.sendKeys("name");
        driver.findElement(By.id("submit")).click();
        driver.switchTo().window((String) tabs.get(0));
        driver.findElement(By.cssSelector(".page > a:nth-child(6)")).click();
        
        driver.findElement(By.linkText("Generate Token")).click();
	    String token = driver.findElement(By.id("token")).getText();
	    System.out.println(token);
	    String[] splitStr = token.split("\\s+");
	    System.out.println(splitStr[1]);
	    Cookie name = new Cookie("Token",splitStr[1]);
        driver.manage().addCookie(name);
        driver.findElement(By.linkText("Proceed")).click();
        
        
        

    }
}
//export PATH=$PATH://usr/bin//geckodriver