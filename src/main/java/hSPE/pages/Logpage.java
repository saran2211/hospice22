package hSPE.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hSPE.base.testbase;

public class Logpage extends testbase{
	
	@FindBy(css="input#email")WebElement uname;
	@FindBy(css="input#password")WebElement upass;
	@FindBy(tagName="img")WebElement HSPlogo;
	@FindBy(linkText="forgot password")WebElement forgotpassword;
	@FindBy(className="btn")WebElement Ibttn;
	
	
public Logpage() {
	
	PageFactory.initElements(driver,this);
}

//to check title

public String checkfortitle() {

	String title=driver.getTitle();
	
	
	return title;	
}

//To validate logo
public boolean checklogo() {
	boolean logo=HSPlogo.isDisplayed();
	
	return logo;
}
public Homepage logintest(String username,String password) {
	
	uname.sendKeys(username);
	upass.sendKeys(password);
	Ibttn.click();
	
	return new Homepage();
}



}