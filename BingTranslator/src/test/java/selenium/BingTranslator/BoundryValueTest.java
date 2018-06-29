package selenium.BingTranslator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoundryValueTest {
	WebDriver driver;
	static int x;


	public BoundryValueTest(WebDriver driver){
		this.driver = driver;	
	}

	/*public void InputFile() throws IOException {
		char[] arr ;
		FileInputStream fm = new FileInputStream("/home/qainfotech/Documents/5001words.txt");
		int i=0;    
		while((i=fm.read())!=-1){    
			x = i;   
		}    

		system



		fm.close();
	}*/

	public String InputFile() throws IOException {
		String everything = null;
		BufferedReader br = new BufferedReader(new FileReader("/home/qainfotech/Documents/5001words.txt"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everything = sb.toString();
			//System.out.println(everything);
			char[] arr = everything.toCharArray();
			//System.out.println(arr.length);
		} finally {
			br.close();
		}
		return everything;
	}
	
	public String MaxLimit() {
		return driver.findElement(By.id("t_charcount")).getText();
	}
}
