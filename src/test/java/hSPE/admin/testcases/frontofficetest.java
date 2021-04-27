package hSPE.admin.testcases;

import org.testng.annotations.Test;

import hSPE.base.testbase;
import hSPE.pages.Homepage;
import hSPE.pages.Logpage;
import hSPE.pages.frontofficepage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class frontofficetest extends testbase{
	Logpage log;
	Homepage home;
	frontofficepage froffice;
	
	public frontofficetest() {
		super();
	}
	
  @Test(priority=6)
  public void checkapmnttext() {
	  
	 String expectedtitle="Appointment Details";
	 String actualtitle=froffice.apmttest();
	 Assert.assertEquals(actualtitle, expectedtitle);
	 System.out.println("seventh method checkapmntext executed");
  }
  @Test(priority=7)
  public void clickvisitortest() {
	  
	  froffice.checkvisitorbk();
	  System.out.println("eightth method  login executed");
  }
  @BeforeMethod
  public void beforeMethod() {
	  Initialization();
	  log=new Logpage();
	  home=log.logintest(prop.getProperty("username"),prop.getProperty("password"));
	  froffice=home.clickfrontoffice();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
