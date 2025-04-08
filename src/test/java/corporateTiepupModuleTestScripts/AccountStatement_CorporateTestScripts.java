package corporateTiepupModuleTestScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import corporateTieUpsModule.AccountStatement_CorporateFun;
import generics.BaseTest;
import onboarding.LoginPage;

public class AccountStatement_CorporateTestScripts extends BaseTest {
	
	@BeforeMethod
	public void Login_AccountStatementCorporateFuns() throws InterruptedException {
		LoginPage lp= new LoginPage(driver);
		lp.login_admin();
		Thread.sleep(500);
		AccountStatement_CorporateFun aCorporate = new AccountStatement_CorporateFun(driver);
		aCorporate.GenerateReport_functionality();
		String pageURL = driver.getCurrentUrl();
		System.out.println("URL of the page is:" +pageURL);	
		String pageTitle = driver.getTitle();
		System.out.println("title of the page is:" +pageTitle);	
	}
	
	@Test(priority=0, enabled =false)
	public void TieupProgramChange_fun() throws InterruptedException {
		AccountStatement_CorporateFun aCorporate = new AccountStatement_CorporateFun(driver);
		aCorporate.TieUp_ProgramChangeFun();
		
	}
	@Test(priority=1)
	public void CorporateTransfer() throws InterruptedException {
		AccountStatement_CorporateFun aCorporate = new AccountStatement_CorporateFun(driver);
		aCorporate.CoporateTransfer_fun();
		
	}

}
