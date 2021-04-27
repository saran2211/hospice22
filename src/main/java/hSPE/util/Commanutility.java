package hSPE.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import hSPE.base.testbase;

public class Commanutility extends testbase{

	
	//script for mouseclick
	public static void mouseclick(WebElement mouse) {
		
		Actions act=new Actions(driver);
		
		act.click(mouse).build().perform();
		
	}
	
	public static void fileupload() {
		
		StringSelection select=new StringSelection("E:\\selenium testing\\screen\\new\\sar.pdf");	
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select,null);
		
		try {
			Robot rob=new Robot();
			
			//press enter
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			
		       // Press CTRL+V
		      rob.keyPress(KeyEvent.VK_CONTROL);
		      rob.keyPress(KeyEvent.VK_V);
		      
		     // Release CTRL+V
		      rob.keyRelease(KeyEvent.VK_CONTROL);
		      rob.keyRelease(KeyEvent.VK_V);
		      //Thread.sleep(1000);
		             
		     //Press Enter 
		      rob.keyPress(KeyEvent.VK_ENTER);
		      rob.keyRelease(KeyEvent.VK_ENTER);
		      

			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	public static void takescreenshot()
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		File destination=new File(currentDir+"./screenshot/"+System.currentTimeMillis()+".png");
		try {
			FileHandler.copy(scrFile,destination );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
}
}
