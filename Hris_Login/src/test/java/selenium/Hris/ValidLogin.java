package selenium.Hris;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidLogin {
	public String arr[] = new String[2]; 
	WebDriver driver;
	 
	public ValidLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public String[] DetailsFromFile(String file) {
		BufferedReader objReader = null;
		 int a = 0 ; {
		  try {
		   String strCurrentLine;

		   objReader = new BufferedReader(new FileReader(file));

		   while ((strCurrentLine = objReader.readLine()) != null) {
			   if (a == 0) {
				   this.arr[0] = strCurrentLine;
				
				   a++;
			   }
			   else {
				   this.arr[1]= strCurrentLine;
				 
			   }
		   // System.out.println(strCurrentLine);
		   }
		   

		  } catch (IOException e) {

		   e.printStackTrace();

		  } finally {

		   try {
		    if (objReader != null)
		     objReader.close();
		   } catch (IOException ex) {
		    ex.printStackTrace();
		   }
		  
		 }
	 }
		
		return arr ;

		
	}
	public String ValidateLogin(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver , 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/div[2]/div/div/time-sheet/div/div[1]/user-profile-sidebar/div/div[2]/div/ul[1]/li[2]/span[2]/a")));
		return driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/time-sheet/div/div[1]/user-profile-sidebar/div/div[2]/div/ul[1]/li[2]/span[2]/a")).getText();
	}
}
