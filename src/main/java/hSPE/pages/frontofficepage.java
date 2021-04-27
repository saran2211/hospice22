package hSPE.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hSPE.base.testbase;

public class frontofficepage extends testbase {
	
	@FindBy(xpath="/html/body/div[1]/div[1]/section/div/div/div/div[1]/h3")WebElement Apttext;
	@FindBy(xpath="/html/body/div[1]/div[1]/section/div/div/div/div[1]/div/a[2]")WebElement vstbkclk;
	
	public frontofficepage() {
		
		PageFactory.initElements(driver,this);
	}

	public String apmttest() {
		String aptext=Apttext.getText();
		return aptext;
		
	}
	
	public visitorpage checkvisitorbk() {
		
		vstbkclk.click();
		return new visitorpage();
		
	}
	
			
	}
	
	
	
	

