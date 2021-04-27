package hSPE.admin.testcases;

import org.testng.annotations.Test;

import com.google.common.collect.ObjectArrays;

import hSPE.base.testbase;
import hSPE.pages.Homepage;
import hSPE.pages.Logpage;
import hSPE.pages.frontofficepage;
import hSPE.pages.visitorpage;
import hSPE.util.ReadExcel;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class visitorpagetest extends testbase {

	Logpage log;
	Homepage home;
	frontofficepage office;
	visitorpage visit;
	
	String stname="saranss";

	public visitorpagetest() {

		super();
	}

	@Test(priority = 8)
	public void verifyvisitortext() {

		String expectedtitle = "Visitor List";
		String actualtitle = visit.checkvisitortext();
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("nineth method verifyvisitortext executed");
	}

	@Test(priority = 9)
	public void verifyadvisitortitle() {

	
		String expectedtitle = "Add Visitor";
		String actualtitle = visit.checkaddvisitortitle();
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("tenth method verifyadvisitortitle executed");
	}

	@Test(priority = 10)
	public void verifyaddvisitor() {
	
	visit.checkaddvisitor();
	System.out.println("eleventh method verifyaddvistor executed");
	}
	@DataProvider
	public Object[][] getdata(){
		
	Object data[][]=ReadExcel.getTestData(stname);	
		
		return data; 
		
	}
	
	@Test(dataProvider="getdata",priority=11)
	public void verifyexceldata(String args[]) {
		
		visit.checkaddvisitorinexcel(args);
		System.out.println("twelveth method verifyexceldata executed");
	}

	@BeforeMethod
	public void beforeMethod() {
		Initialization();
		log = new Logpage();  
		home = log.logintest(prop.getProperty("username"), prop.getProperty("password"));
		office = home.clickfrontoffice();
		visit = office.checkvisitorbk();
	
	}

	@AfterMethod
	public void afterMethod() {
		//driver.close();
	}

}
