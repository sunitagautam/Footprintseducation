package onboardingModuleTestScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import financialModule.OneTimeChargesPage;
import generics.BaseTest;
import onboarding.LoginPage;
import onboarding.ProfileMenuPage;

public class ProfileMenuPageTestCases extends BaseTest{
	
	@BeforeMethod
	public void Login_OpenMyProfilePage() throws InterruptedException {
		LoginPage lp= new LoginPage(driver);
		lp.login_admin();
		Thread.sleep(500);
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.openMyProfile_page();
		String pageURL = driver.getCurrentUrl();
		System.out.println("URL of the page is:" +pageURL);	
		String pageTitle = driver.getTitle();
		System.out.println("title of the page is:" +pageTitle);	
	}
	@Test(priority =1)

	public void logout_fun() throws InterruptedException{
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}

}
