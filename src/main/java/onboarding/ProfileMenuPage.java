package onboarding;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfileMenuPage {

//	@FindBy(xpath = "//*[@id='navbar-mobile']//ul//li[4]//a//span[text()='Kapil Gupta']")
	@FindBy(xpath="//*[@id='navbar-mobile']//ul//li[4]/a/i[1]")
	WebElement profileMenu;
	@FindBy(xpath="//*[@id='navbar-mobile']//ul//li[4]//ul//li[1]//a[text()=' My Profile']")
	WebElement myProfile_tab;
	@FindBy(xpath ="//*[@id='navbar-mobile']//ul//li[4]//ul//li[2]//a[text()=' Logout']")
	WebElement logout_option;


	// Initializing the page Objects/webElement
	public static String downloadPath = "C:\\Users\\admin\\Downloads";
	WebDriver driver;
	WebDriverWait wait;

	
	public ProfileMenuPage(WebDriver driver) {
		this.driver =driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);

	}
	public void openMyProfile_page() {
		profileMenu.click();
		myProfile_tab.click();

	}
	public void logOutFun() throws InterruptedException {
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profileMenu")));
		profileMenu.click();
		
		}
		catch (Exception e) {
	        System.out.println("Logout failed: " + e.getMessage());
	    }
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_option")));
		logout_option.click();
		}
		catch (Exception e) {
	        System.out.println("Logout failed: " + e.getMessage());
	    }
	}




}
