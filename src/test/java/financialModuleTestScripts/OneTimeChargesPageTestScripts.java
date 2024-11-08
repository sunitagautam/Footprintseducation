package financialModuleTestScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import financialModule.OneTimeChargesPage;
import generics.BaseTest;
import onboarding.LoginPage;

public class OneTimeChargesPageTestScripts extends BaseTest{
	
	@BeforeMethod
	public void Login_OpenOneTimeChargePage() throws InterruptedException {
		LoginPage lp= new LoginPage(driver);
		lp.login_admin();
		Thread.sleep(500);
		OneTimeChargesPage charges = new OneTimeChargesPage(driver);
        charges.OpenOneTimeChargesPage();
		String pageURL = driver.getCurrentUrl();
		System.out.println("URL of the page is:" +pageURL);	
		String pageTitle = driver.getTitle();
		System.out.println("title of the page is:" +pageTitle);	
	}
  @Test(priority =1, enabled =false)
  
  public void ChargeType_AnnualFee() {
	  OneTimeChargesPage charges = new OneTimeChargesPage(driver);
      charges.AnnualPreSchoolFee_charge();
  }
  @Test(priority =2, enabled =false)
  public void ChargeType_BookSet() {
	  OneTimeChargesPage charges = new OneTimeChargesPage(driver);
      charges.BookSet_charge();	  
  }
  @Test(priority =3,enabled =false)
  public void ChargeType_CourierCharge() {
	  OneTimeChargesPage charges = new OneTimeChargesPage(driver);
      charges.Courier_charge();;	  
  }
  @Test(priority =4)
  public void ChargeType_ExtendedDayCare() {
	  OneTimeChargesPage charges = new OneTimeChargesPage(driver);
      charges.Courier_charge();;	  
  }

  
}
