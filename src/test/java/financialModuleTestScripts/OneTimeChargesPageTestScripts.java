package financialModuleTestScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import financialModule.OneTimeChargesPage;
import generics.BaseTest;
import generics.FWUtils;
import onboarding.LoginPage;
import onboarding.ProfileMenuPage;

public class OneTimeChargesPageTestScripts extends BaseTest{

		@BeforeMethod
	public void OpenOneTimeChargePage() throws InterruptedException {
			LoginPage lp= new LoginPage(driver);
			lp.login_admin();
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.OpenOneTimeChargesPage();
		String pageURL = driver.getCurrentUrl();
		System.out.println("URL of the page is:" +pageURL);	
		String pageTitle = driver.getTitle();
		System.out.println("title of the page is:" +pageTitle);	
	}
	@Test(priority =1)

	public void ChargeType_AnnualFee() throws InterruptedException{
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.AnnualPreSchoolFee_charge();
	}
	@Test(priority =2)
	public void ChargeType_Apron() throws InterruptedException {
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.Apron_charge();	
		
	}
	@Test(priority =3)
	public void ChargeType_BookSet() throws InterruptedException {
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.BookSet_charge();	  
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority =4)
	public void ChargeType_CourierCharge() throws InterruptedException {
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.Courier_charge();  
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority =5)
	public void ChargeType_ExtendedDayCare() throws InterruptedException {
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.Courier_charge();	
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority=6)
	public void ChargeType_lateStay() throws InterruptedException {
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.LateStay_charge();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}

	@Test(priority=7)
	public void ChargeType_ReadOStick() throws InterruptedException {
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.ReadOStick_charge();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority=8)
	public void ChargeType_RegistrationFee() throws InterruptedException {
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.RegistrationFee_charge();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority=9)
	public void ChargeType_SchoolBag() throws InterruptedException {
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.SchoolBag_charge();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority=10)
	public void ChargeType_SecurityFee() throws InterruptedException {
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.SecurityFee_charge();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority=11)
	public void ChargeType_TransportFee() throws InterruptedException {
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.TransportFee_charge();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority=12)
	public void ChargeType_TuitionFee() throws InterruptedException {
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.TuitionFee_charge();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority=13)
	public void ChargeType_WelcomeKit() throws InterruptedException {
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.WelcomeKit_charge();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
	profile.logOutFun();
	}
	@Test(priority=14)
	public void ChargeType_WecomeKit_withoutROS() throws InterruptedException {
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.WelcomeKit_WithoutReadOStick_charge();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
	@Test(priority=15)
	public void ChargeType_WelcomeKit_withROS() throws InterruptedException {
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
		charges.WelcomeKit_WithReadOStick_charge();
		FWUtils.keepSessionAlive();
		ProfileMenuPage profile = new ProfileMenuPage(driver);
		profile.logOutFun();
	}
}
