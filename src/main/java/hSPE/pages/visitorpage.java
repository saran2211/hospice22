package hSPE.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import hSPE.base.testbase;
import hSPE.util.Commanutility;
import hSPE.util.Datepicker;
import schemasMicrosoftComOfficeOffice.DetectmouseclickAttribute;

public class visitorpage extends testbase {

	@FindBy(xpath = "/html/body/div[1]/div[1]/section/div/div/div/div[1]/h3")
	WebElement vsttext;
	@FindBy(xpath = "/html/body/div[1]/div[1]/section/div/div/div/div[1]/div/a")
	WebElement advisitorclk;
	@FindBy(xpath = "//*[@id=\"formadd\"]/div[1]/div[1]/div[1]/div/select")
	WebElement drop;
	@FindBy(xpath = "//*[@id=\"formadd\"]/div[1]/div[1]/div[2]/div/input")
	WebElement name;
	@FindBy(xpath = "//*[@id=\"formadd\"]/div[1]/div[2]/div[1]/div/input")
	WebElement phoneno;
	@FindBy(xpath = "//*[@id=\"formadd\"]/div[1]/div[2]/div[2]/div/input")
	WebElement idcard;
	@FindBy(xpath = "//*[@id=\"formadd\"]/div[1]/div[3]/div[1]/div/input")
	WebElement noofperson;
	@FindBy(xpath = "//*[@id=\"description\"]")
	WebElement notes;
	@FindBy(xpath = "//*[@id=\"formadd\"]/div[1]/div[6]/div/div/input")
	WebElement file;
	@FindBy(xpath = "//*[@id=\"myModal\"]/div/div/div[1]/h4")
	WebElement visititle;
	@FindBy(xpath = "//*[@id=\"formadd\"]/div[2]/button")
	WebElement save;
	@FindBy(id = "date")
	WebElement date;
	@FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[1]/div[4]/div[1]/div/div/div[2]/div/input")
	WebElement intime;
	@FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[1]/div[4]/div[2]/div/div/div[2]/div/input")
	WebElement outtime;

	Datepicker dat = new Datepicker();

//WebDriverWait wait=new WebDriverWait(driver, 60);

	public visitorpage() {

		PageFactory.initElements(driver, this);

	}

	public String checkvisitortext() {
		String visit = vsttext.getText();
		return visit;

	}

	public String checkaddvisitortitle() {

		advisitorclk.click();

		try {
			Thread.sleep(11000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title = visititle.getText();

		return title;

	}

	public void checkaddvisitor() {

		advisitorclk.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drop.click();
		Select sel = new Select(drop);
		sel.selectByIndex(10);

		name.sendKeys("aabbcc");
		phoneno.sendKeys("999477");
		idcard.sendKeys("sa007");
		noofperson.sendKeys("8");
		notes.sendKeys("is it correct");

		date.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dat.datpicker("7/7/1986");

		intime.clear();
		intime.sendKeys("02:30 PM");
		outtime.clear();
		outtime.sendKeys("08:30 PM");

		Commanutility.mouseclick(file);
		Commanutility.fileupload();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// save.click();

	}

	public void checkaddvisitorinexcel(String data[]) {

		advisitorclk.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drop.click();
		Select sel = new Select(drop);
		sel.selectByVisibleText(data[0]);

		name.sendKeys(data[1]);
		phoneno.sendKeys(data[2]);
		idcard.sendKeys(data[3]);
		noofperson.sendKeys(data[4]);

		date.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dat.datpicker(data[5]);

		intime.clear();
		intime.sendKeys(data[6]);
		outtime.clear();
		outtime.sendKeys(data[7]);

		notes.sendKeys(data[8]);

		Commanutility.mouseclick(file);
		Commanutility.fileupload();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// save.click();

	}
}
