package testcases;

import java.io.File;
import java.io.FileInputStream;
//import jxl.Workbook;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;

public class AddCustomerTest extends TestBase

{
	
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static File src;
	
	 public static Object[][] data;
  
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
	   
	   XSSFSheet sheet=wb.getSheet("Sheet1");
	   
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
			  data[i][j]=sheet.getRow(i).getCell(j).toString();
		  }
	  }
	  
	return data;
   }
   
   @Test(dataProvider="a")
   public static void getData(String a,String b,String c)
   { 
	 System.out.println("value of a : " + a + "   and " + " value of b : " + b  + " value of c : " + c );  
   }
	 
  

           
          
	
}
