package onboarding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generics.BaseTest;

public class LoginPage extends BaseTest{
	
	//Page Factory
	
		//create logs inside resources folder
		@FindBy(name="username")
		private WebElement username;
		
		@FindBy(name="password")
		
		private WebElement pwd;
		
		@FindBy(id="submit")
	private WebElement loginbtn;
		
		
		@FindBy(xpath="//img[@src='assets/images/logo.png']")
		private WebElement FootPrintslogo;
		
			
		//Initalizing the page Objects/webElements
		
		public LoginPage(WebDriver driver) {   //constructor
			
			PageFactory.initElements(driver,this);
		}
		
		//utilization of weElelements
		
		
		public boolean validateQBlogo() {
			return FootPrintslogo.isDisplayed();
		}
		
				
	public void login_admin()
	{	
		username.clear();
		username.sendKeys("kapil");
		pwd.clear();
		pwd.sendKeys("Dev@123");
		loginbtn.click();
	}
	
	
	
		public void login(String un, String pw) {  //using excel
			username.sendKeys(un);
			pwd.sendKeys(pw);
			loginbtn.click();
			return;
			
		}
		public void setUsername(String un) {
			username.clear();
			username.sendKeys(un);
		}
		
		public void setPassword(String pw) {
			pwd.clear();
			pwd.sendKeys(pw);

		}
		
		public void clickOnLoginBTN() {
			loginbtn.click();
		}
		
//		public void verifyErrMsg(WebDriver driver) 
//		{   
//			String ActualErrorMsg =errMSG.getText();
//			 //Assert.assertTrue(errMSG.isDisplayed());
//			 Reporter.log("Error Msg Is Displayed:  "+ActualErrorMsg,true);
//		}

	

}
