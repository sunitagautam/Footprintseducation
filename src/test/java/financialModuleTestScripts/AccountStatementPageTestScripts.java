package financialModuleTestScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import financialModule.AccountStatementPage;
import generics.BaseTest;
import onboarding.LoginPage;
import onboarding.ProfileMenuPage;

public class AccountStatementPageTestScripts extends BaseTest{
	
	@BeforeMethod
	public void Login_AccountStatementPage() throws InterruptedException {
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
	
	@Test(priority=0, enabled=false)
	public void childName_linkValidation() throws InterruptedException {
		AccountStatementPage as = new AccountStatementPage(driver);
		as.childName_link();
		//ProfileMenuPage profile = new ProfileMenuPage(driver);
		//profile.logOutFun();	
	}
	@Test(priority=1, enabled =false)
	public void Addcharges() throws InterruptedException {
		AccountStatementPage as = new AccountStatementPage(driver);
		as.addCharge_linkFunctionality();
		
	}
	@Test(priority=2, enabled =false)
	public void childPlan() throws InterruptedException {
		AccountStatementPage as = new AccountStatementPage(driver);
		as.childPlan_linkfun();
		
	}
	@Test(priority=3, enabled=false)
	public void childPlan_UpdateFeeCardSelected() throws InterruptedException {
		AccountStatementPage as = new AccountStatementPage(driver);
		as.childPlan_updateFeeCard();
		
	}
	
	@Test(priority=4, enabled=false)
	public void centerPlan() throws InterruptedException {
		AccountStatementPage as = new AccountStatementPage(driver);
		as.centerPlan_linkfun();	
	}
	@Test(priority=5, enabled=false)
	public void diaryNotes_link() throws InterruptedException {
		AccountStatementPage as = new AccountStatementPage(driver);
		as.diary_Notesfun();	
	}
	
	@Test(priority=6)
	public void childHistory_link() throws InterruptedException {
		AccountStatementPage as = new AccountStatementPage(driver);
		as.child_HistoryLink_func();
	}
}
