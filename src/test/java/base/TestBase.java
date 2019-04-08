package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import utilities.MonitoringMail;

public class TestBase {

	public static WebDriver driver;
	public static Properties or = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static MonitoringMail mail = new MonitoringMail();
	public static WebDriver wait;
	String log4jConfPath = "C:\\Users\\Ranjodhbir.Kaur\\eclipse-workspace\\DDMaven1\\src\\test\\resources\\properties\\log4j.properties";
	public static FileInputStream fs;

	//PropertyConfigurator.configure(log4jConfPath);
	

	@BeforeSuite
	public void setup() 
	{
		System.out.println("setup method");
		
		PropertyConfigurator.configure(log4jConfPath);
		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config properties loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\or.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				or.load(fis);
				log.debug("Or properties loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		if(config.getProperty("browser").equals("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			driver=new ChromeDriver();
			log.debug("Chrome Browser Open");
		}
		else 
		{
			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir"+"\\src\\test\\resources\\executables\\IEDriverServer.exe"));
			driver=new InternetExplorerDriver();
		}
		
		driver.get(config.getProperty("testingurl"));
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
}

	@AfterSuite
	public void tearDown() 
	{
		System.out.println("tearDown");
		 driver.quit();
		log.debug("browser closed");
	}
    
	
	
	public static void click(String locator)
	{
		if(locator.endsWith("_xpath"))
		{
			driver.findElement(By.xpath(or.getProperty("signin_xpath")));

		}
		else if(locator.endsWith("_css"))
		{
			driver.findElement(By.xpath(or.getProperty("css")));
		}
		
	}
	
	public static void type(String key,String value)
	{
		
	}
	
	
}
