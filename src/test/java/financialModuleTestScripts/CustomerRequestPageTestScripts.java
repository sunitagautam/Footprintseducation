package financialModuleTestScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HardwareModule.ManageVendorPage;
import financialModule.AccountStatementPage;
import financialModule.CustomerRequestPage;
import generics.BaseTest;
import onboarding.LoginPage;
import onboarding.ProfileMenuPage;

public class CustomerRequestPageTestScripts extends BaseTest {
	
	@BeforeMethod
	public void Login_CustomerRequestPage() throws InterruptedException {
		LoginPage lp= new LoginPage(driver);
		lp.login_admin();
		Thread.sleep(500);
		AccountStatementPage as = new AccountStatementPage(driver);
		as.GenerateReport_functionality();
		String pageURL = driver.getCurrentUrl();
		System.out.println("URL of the page is:" +pageURL);	
		String pageTitle = driver.getTitle();
		System.out.println("title of the page is:" +pageTitle);	
	}

	@Test (priority=0, enabled=false)
	public void CenterShift_SC_002_TC_002() throws InterruptedException
	{	
		CustomerRequestPage cr =new CustomerRequestPage(driver);
		cr.CenterShift_ServiceRequest();	
		Thread.sleep(500);
		cr.Open_CustomerRequestPage();
		cr.runParentProcessingAPI();
		cr.printALL_TableData_LatestRequest();
		//ProfileMenuPage profile = new ProfileMenuPage(driver);
		//profile.logOutFun();		
	}	
	@Test (priority=1)
	public void Pause_SC_003_TC_002() throws InterruptedException
	{	
		CustomerRequestPage cr =new CustomerRequestPage(driver);
		cr.pause_Request();	
		Thread.sleep(500);
		cr.Open_CustomerRequestPage();
		cr.printALL_TableData_LatestRequest();
		//ProfileMenuPage profile = new ProfileMenuPage(driver);
		//profile.logOutFun();		
	}
	
	@Test (priority=2,enabled=false)
	public void Pause_LeaveExtendRequest() throws InterruptedException
	{	
		CustomerRequestPage cr =new CustomerRequestPage(driver);
		cr.pause_LeaveExtendRequest();
		Thread.sleep(500);
			
	}

	@Test(priority =10, enabled=false)
	public void TimeExtension_Start_SC_001_TC_002() {
		CustomerRequestPage cr =new CustomerRequestPage(driver);
		cr.StartTimeExtension_ServiceRequest();	
		cr.Open_CustomerRequestPage();
		cr.runParentProcessingAPI();
		cr.printALL_TableData_LatestRequest();
		
	}
}
