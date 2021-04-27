package hSPE.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hSPE.util.WebEventListener;

public class testbase {

	// script to read config
	public static WebDriver driver;

	public static Properties prop;

	public static FileInputStream ipconfig;

	public static EventFiringWebDriver e_driver;

	public static WebEventListener webel;

	public testbase() {

		prop = new Properties();

		try {
			ipconfig = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/hSPE/configure/config.properties");

			prop.load(ipconfig);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// script for initial setup

	public static void Initialization() {
		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
			driver = new FirefoxDriver();

		}

		// basic methods

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		//firing event
		
		e_driver=new EventFiringWebDriver(driver);
		webel=new WebEventListener();
		e_driver.register(webel);
		driver=e_driver;
		
		/*
		 * //explicit wait script WebDriverWait wait ; //visibility Of Elements public
		 * void waitforElementvisible(WebElement el) { wait = new WebDriverWait(driver,
		 * 10); wait.until(ExpectedConditions.visibilityOf(el)); }
		 */

	}
	
	
	
	
	
	
	

}
