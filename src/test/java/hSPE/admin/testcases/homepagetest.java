package hSPE.admin.testcases;

import org.testng.annotations.Test;

import hSPE.base.testbase;
import hSPE.pages.Homepage;
import hSPE.pages.Logpage;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class homepagetest extends testbase {

	Logpage log;
	Homepage home;
	
	public homepagetest() {
		super();
	}

	
	  @Test(priority=3) public void checktitletest() { 
		  String expectedtitle="Smart Hospital Management System"; 
		  String actualtitle=home.verifyhomepagetitle();
		  Assert.assertEquals(actualtitle,expectedtitle); 
		  System.out.println("fourth method  checktitletest executed");
		  }
	  
	  @Test(priority=4) public void checkuserlabel() {
	  	  	 
		  Assert.assertTrue(home.usernametest()); 
		  System.out.println("fifth method  checkuserlabel executed");
		 
	  }
	 
	@Test(priority=5)
	public void checkfrontofficeclick() {
		home.clickfrontoffice();
		System.out.println("sixth method checkfrontofficeclick executed");
	}
	

	@BeforeMethod
	public void beforeMethod() {
		Initialization();
		log = new Logpage();
		home=log.logintest(prop.getProperty("username"),prop.getProperty("password"));

	}

	@AfterMethod
	public void afterMethod() {

		driver.close();
	}

}
