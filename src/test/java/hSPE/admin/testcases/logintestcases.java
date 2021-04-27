package hSPE.admin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hSPE.base.testbase;
import hSPE.pages.Homepage;
import hSPE.pages.Logpage;

public class logintestcases extends testbase {

	Logpage objlg;

	public logintestcases() {

		super();
	}

	@BeforeMethod
	public void setup() {

		Initialization();
		objlg = new Logpage();
	}

	@Test(priority = 0)
	public void titletest() {

		String expectedtitle = "Smart Hospital : Hospital Management System";
		String actualtitle = objlg.checkfortitle();
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("first method  titletest executed");
	}

	// logo
	@Test(priority = 1)
	public void logotest() {

		Assert.assertTrue(objlg.checklogo());
		System.out.println("second method  logotest executed");

	}
	
	
	//login
	@Test(priority=2)
	
	public void login() {
		objlg.logintest(prop.getProperty("username"),prop.getProperty("password"));
		System.out.println("third method  login executed");
		
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}

