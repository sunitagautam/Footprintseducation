package generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

abstract public class BaseTest implements IAutoConstant {
	
	public static void main(String[] args)
	{
	
	driver.get("https://test-franchise.footprintseducation.in/login");
	String title = driver.getTitle();

	System.out.println("title of the page is "+ title);
	}
	
	public static WebDriver driver;
	public static int passCount=0,failCount=0;
	
	@BeforeClass 
	@Parameters("sBrowser")
	public void openBrowser(String sBrowser)
	{
		if(sBrowser.equals("chrome"))
		{
			// Setup ChromeDriver using WebDriverManager
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(sBrowser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(sBrowser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		
	}
	
	@BeforeMethod
	public void openApplication()
	{
		driver.get(URL);	
	}
	
	@AfterMethod
	public static void closeBrowser(ITestResult res)
	{
		
		int status = res.getStatus();
		String methodname = res.getName();
		if(status==1)
		{
			passCount++;
		}
		else
		{			
			failCount++;			
			String path = PHOTO_PATH+methodname+".png";
			FWUtils.take_Screen_Shoot(driver,path);
		}
		//driver.close();
	}
	@AfterClass
	public void closeBrowser() {
    driver.close();

	} 

	@AfterSuite
	public void printReport()
	{
		Reporter.log("PassCount:"+passCount,true);
		Reporter.log("FailCount:"+failCount,true);
		FWUtils.set_XL_Data(REPORT_PATH,"result",1,0,passCount);
		FWUtils.set_XL_Data(REPORT_PATH,"result",1,1,failCount);
	}
	

}
