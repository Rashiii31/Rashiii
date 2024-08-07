package Generic_Libary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class WebDriver_Utility 
{
	public void captureScreenshot(WebDriver driver, String name) 
	{
         String modName = name+" "+Java_Utility.getTimeStamp();
         
         
         TakesScreenshot ts= (TakesScreenshot)driver;
         File src = ts.getScreenshotAs(OutputType.FILE);
         File trg=new File("./Screenshots/"+modName+".png");
         
         
        
         
         
         
         try {
			FileHandler.copy(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
        		 
	}
}
