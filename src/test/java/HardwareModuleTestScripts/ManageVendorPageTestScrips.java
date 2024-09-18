package HardwareModuleTestScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HardwareModule.ManageVendorPage;
import generics.BaseTest;
import onboarding.LoginPage;
import onboarding.ProfileMenuPage;

public class ManageVendorPageTestScrips extends BaseTest {

	@BeforeMethod
	public void Login_openManageVendorPage() throws InterruptedException {
		LoginPage lp= new LoginPage(driver);
		lp.login_admin();
		Thread.sleep(500);
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		mVendorpage.OpenManageVendorPage();
		String pageURL = driver.getCurrentUrl();
		System.out.println("URL of the page is:" +pageURL);	
		String pageTitle = driver.getTitle();
		System.out.println("title of the page is:" +pageTitle);	
	}

	@Test (priority=1, enabled =false)
	public void DisplayTableData_SC_001_TC_001() throws InterruptedException
	{	
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_001");
		Thread.sleep(500);
		mVendorpage.printALL_TableData();	
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();		
	}	

	@Test (priority=2, enabled =false)
	public void SearchFunctionality_SC_001_TC_002() throws InterruptedException
	{	
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_002");
		Thread.sleep(500);
		mVendorpage.searchFunctionality();	
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();	
	}	

	@Test (priority=3, enabled =false)
	public void DownloadFileFunctionality_SC_001_TC_003() throws InterruptedException
	{	
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_003");
		Thread.sleep(500);
		mVendorpage.verifyDownloadReport_FileExt();	
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();	

	}	
	@Test (priority=4, enabled =false)
	public void Pagination_SC_001_TC_004() throws InterruptedException
	{	
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_004");
		Thread.sleep(500);
		mVendorpage.pagination_fun();	
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();		
	}	

	@Test (priority=5, enabled =false)
	public void Soritng_SC_001_TC_005() throws InterruptedException
	{	
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_005");
		Thread.sleep(500);
		mVendorpage.sorting_fun();	
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();		
	}	

	@Test (priority=6, enabled =false)
	public void Action_Active_SC_001_TC_006() throws InterruptedException
	{	
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_006");
		Thread.sleep(500);
		mVendorpage.Action_Active_fun();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();		
	}	
	
	@Test (priority=6, enabled =false)
	public void Action_Inactive_SC_001_TC_006() throws InterruptedException
	{	
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_006");
		Thread.sleep(500);
		mVendorpage.Action_Inactive_fun();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();		
	}	

	@Test(priority =7, enabled =false)
	public void AddVendor_SC_001_TC_008() throws InterruptedException {
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_008");
		mVendorpage.addVendor_func();
		Thread.sleep(1000);
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	
	@Test(priority =8, enabled =false)
	public void AddVendor_MandatoryValidations_SC_001_TC_009() throws InterruptedException {
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_009");
		mVendorpage.AddNewVendor_MandatoryfieldValidations();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority =9, enabled =false)
	public void AddVendor_MobilePhoneformatValidations_SC_001_TC_009() throws InterruptedException {
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_009.1");
		mVendorpage.AddNewVendor_MobilePhoneformatValidations();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	
	@Test(priority =10, enabled =false)
	public void AddVendor_MobileDuplicacy_SC_001_TC_009() throws InterruptedException {
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_009.2");
		mVendorpage.AddNewvendor_MobileDuplicacy();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority =11)
	public void AddVendor_EmailFormat_SC_001_TC_009() throws InterruptedException {
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_009.3");
		mVendorpage.AddNewVendor_EmailformatValidations();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	
	
	@Test(priority =12)
	public void AddVendor_EmailDuplicacy_SC_001_TC_009() throws InterruptedException {
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_009.5");
		mVendorpage.AddNewvendor_EmailDuplicacy();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	
	@Test(priority =13)
	public void AddVendor_PANValidation_SC_001_TC_009() throws InterruptedException {
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_009.6");
		mVendorpage.AddNewvendor_PANValidation();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	
	@Test(priority =14)
	public void EditVendor_SC_001_TC_010() throws InterruptedException {
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_010");
		mVendorpage.editVendor_func();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority =15)
	public void EditVendorMandatoryFields_SC_001_TC_010() throws InterruptedException {
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_011.1");
		mVendorpage.EditVendor_MandatoryfieldValidations();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority =16)
	public void EditVendorMobileFormat_SC_001_TC_010() throws InterruptedException {
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_011.2");
		mVendorpage.EditVendor_MobileformatValidations();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority =17)
	public void EditVendorMobileDuplicacy_SC_001_TC_010() throws InterruptedException {
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_011.3");
		mVendorpage.Editvendor_MobileDuplicacy();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority =18)
	public void EditVendorEmailFormat_SC_001_TC_010() throws InterruptedException {
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_011.4");
		mVendorpage.EditVendor_EmailformatValidation();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority =19)
	public void EditVendorEmailDuplicacy_SC_001_TC_010() throws InterruptedException {
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_011.5");
		mVendorpage.EditVendor_EmailDuplicacy();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority =20)
	public void EditVendorPAN_SC_001_TC_010() throws InterruptedException {
		ManageVendorPage mVendorpage = new ManageVendorPage(driver);
		System.out.println("SC_001_TC_011.6");
		mVendorpage.Editvendor_PANValidation();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}

}
