package onboarding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileMenuPage {
	
	@FindBy(xpath = "//*[@id='navbar-mobile']//ul//li[4]//a//span[text()='Kapil Gupta']")
	WebElement profileMenu;
	@FindBy(xpath ="//*[@id='navbar-mobile']//ul//li[4]//ul//li[2]//a[text()=' Logout']")
	WebElement logout_option;
	
	
	// Initializing the page Objects/webElement
				public static String downloadPath = "C:\\Users\\admin\\Downloads";

				public ProfileMenuPage(WebDriver driver) {
					PageFactory.initElements(driver, this);
					
				}
	public void logOutFun() throws InterruptedException {
		profileMenu.click();
		Thread.sleep(500);
		logout_option.click();
		Thread.sleep(500);
	}

	


}
