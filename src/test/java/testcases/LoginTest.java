package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;



import base.TestBase;

public class LoginTest extends TestBase{

	//public static String fileName;
	
	@Test
	public void login()
	{
		click("signin_xpath");
		log.debug("click method works");
		System.out.println("test passed");
	}
	
	/*@Test
	public void verify()
	{
		Assert.assertEquals("yahoo.com", "https://google.com");
	}*/   
	
	
	
	
	/*@Test
	public static void captureScreenshot() throws IOException
	{
		Date d= new Date();

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		fileName= (d.toString().replaceAll(" ","_")) + ".png";
	    FileUtils.copyFile(src,new File(System.getProperty("user.dir")+ "\\screenshot\\"+fileName));
	} */
	
}
