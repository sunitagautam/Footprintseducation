package generics;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FWUtils extends BaseTest {
	/**
	 * This Method Is Used To Verify The Page Title
	 * @param driver
	 * @param expectedTitle
	 */
//	public static void verifyPageTitle(WebDriver driver,String expectedTitle)
//	{
//		WebDriverWait wait = new WebDriverWait(driver,20);
//		wait.until(ExpectedConditions.titleContains(expectedTitle));
//		String actualTitle = driver.getTitle();
//		if(actualTitle.equals(expectedTitle))
//		{
//			System.out.println("The Expected Page is Dispalyed--->"+expectedTitle);
//		
//		else
//		{
//			System.out.println("The Expected Page is not Dispalyed--->"+actualTitle);
//		}
//	}
	/**
	 * This Method Is Used To Read The Data From Excel
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 */
	public static String read_XL_Data(String path,String sheet,int row,int cell)
	{
		String data="";
		try
		{
		    Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		    data = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return data;
	}
	/**
	 * This Method Is Used to Count Number Of Data Rows Present in Current Sheet
	 * @param sheet
	 * @return
	 */
	public static int read_XL_RowCount(String path,String sheet)
	{
		int data=0;
		try
		{
		    Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		    data = wb.getSheet(sheet).getLastRowNum();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return data;
	}
	/**
	 * This Method is used write Data into cell
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param data
	 */
	public static void set_XL_Data(String path,String sheet,int row,int cell,int data)
	{
		
		try
		{
		    Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		    wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(data);
		    
		    wb.write(new FileOutputStream(path));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void take_Screen_Shoot(WebDriver driver,String path)
	{
		try
		{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(path);
		FileUtils.copyFile(src, des);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public static void scrollDownPoint(int i, int j) {
		//to perform scroll down 

		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}
	public static void scrollDown() {
		//to perform scroll down 

		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}
	public static void scrollUp() {
		//to perform scrollup top of the page 

		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

	}
	public static void scrollHorizontally() {
		//to perform scroll Horizonatlly

		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(250,0)", "");
	}
	
	public static void scrollHorizontallytoElement() {
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript(
		    "document.getElementById('sResultNotFound').scrollLeft += 250", "");

	}
	
	public static void pageUrl() {
		System.out.println("PageUrl Is  "+driver.getCurrentUrl());
		
	}
	
	/* Check the file from a specific directory with extension */

	public static boolean isFileDownloaded_Ext(String dirPath, String ext){
		boolean flag=false;
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        flag = false;
	    }
	    
	    for (int i = 1; i < files.length; i++) {
	    	if(files[i].getName().contains(ext)) {
	    		flag=true;
	    	}
	    }
	    return flag;
	}
	
	/* Get the latest file from a specific directory*/
	public static File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	
/*check for the file name mention in the directory and will return 'True' if the document is available in the folder else 'false'*/
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}


	

}
