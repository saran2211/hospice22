package hSPE.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hSPE.base.testbase;

public class Homepage extends testbase {
	@FindBy(xpath = "//*[@id=\"alert\"]/nav/div[2]/div/div/ul/li[4]/a")WebElement profile;
	@FindBy(xpath="//*[@id=\"alert\"]/nav/div[2]/div/div/ul/li[4]/ul/li/div/div[1]/a/img")WebElement label;
	@FindBy(xpath="//*[@id=\"sibe-box\"]/ul[2]/li[1]/a/span")WebElement front;
	@FindBy(className="sidebar-session")WebElement title;
	
	public Homepage() {
		
		PageFactory.initElements(driver,this);
	}
	public String verifyhomepagetitle() {
	
		String htitle=driver.getTitle();
		
		return htitle;
		
	}
	public boolean usernametest() {
	
		profile.click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		boolean logolabel=label.isDisplayed();
		
		return logolabel;	
	}
	
	public frontofficepage clickfrontoffice() {
		front.click();
		
		return new frontofficepage();
		
	}
	
	
}
