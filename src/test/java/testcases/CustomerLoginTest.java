package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;

public class CustomerLoginTest extends TestBase
{
	 public static Object[][] data;
	 public static FileInputStream fis;
		public static XSSFWorkbook wb;
		public static File src;
	
		
		@Test(dataProvider="a")
	public void customerLogin(String customerName)
	{
		click("homeButton_css");
		log.debug("home button clicked");
		System.out.println("home button clicked");
		click("customerLogin_xpath");
		System.out.println("customerLoginbutton clicked");
		select("CustomerDropdown_css",customerName);
		System.out.println("value selected from dropdown");
		 wait = new WebDriverWait(driver, 200);
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(or.getProperty("loginButton_css"))));
		 WebElement element= wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(or.getProperty("loginButton_css"))));
		boolean status = element.isDisplayed();
		System.out.println(status);
		if(status)
		{
			click("loginButton_css");
			System.out.println("login button clicked");
		}
		else 
		{
			System.out.println("element is not present");
		}
		//	wait.until(ExpectedConditions.visibilityOfAllElements("loginButton_css"));
		
	}
	 @DataProvider
	   public static Object[][] a()
	   {
		   System.out.println("testing");
		   File src = new File("C:\\Users\\Ranjodhbir.Kaur\\Downloads\\Selenium\\Book1.xlsx");
		  log.debug("file path added");
		   try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   try {
		    wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   System.out.println("workbook added");
		   
		   XSSFSheet sheet=wb.getSheet("Sheet3");
		   
		   System.out.println("worksheet founded from workbook");
		   
		   int rows = sheet.getLastRowNum();
		   System.out.println("No. of rows are : " + rows);
		   int cols = sheet.getRow(0).getLastCellNum();
		   System.out.println("No. of columns are : " + cols);
		   data= new Object[rows][cols];
		  for(int i=0;i<rows;i++)
		  {
			  for(int j=0;j<cols;j++)
			  {
				  data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			  }
		  }
		  
		return data;
	   }
	   
}
