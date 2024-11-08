package financialModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneTimeChargesPage {
	// page Factory

			@FindBy(xpath = "//*[@id='navbar-second-toggle']/ul/li[8]/a[text()='Support']")
			WebElement supportModule;
			@FindBy(xpath ="//*[@id='navbar-second-toggle']//ul//li[8]//div//div[1]//div//div[2]//ul//li[1]//a[text()='OneTime Charges']")
			WebElement oneTimeCharge_tag;
			@FindBy(xpath="//html//body//div[5]//div//div//div[1]//div[1]//div//ul//li//a//button[text()='Add One Time Charges']")
			WebElement addCharges_btn;
			@FindBy(name="charge_child_id")
			WebElement childID;
			@FindBy(id="btn_child_details")
			WebElement fetch_details;
			@FindBy(id="charge_type")
			WebElement chargeType_dropdown;
			@FindBy(xpath="//*[@id='charge_type']//option[2]")
			WebElement cType_AnnualPreSchoolFee;
			@FindBy(id="charge_amount")
			WebElement charge_amount;
			@FindBy(id="charge_comments")
			WebElement charge_comments;
			@FindBy(id="apply_charge")
			WebElement submitForm_Btn;
			// Confirm submission popup
			@FindBy(id="submit_apply_charge")
			WebElement confirmButton;
			
			//BookSet charge
			@FindBy(xpath="//*[@id='charge_type']//option[3]")
			WebElement cType_BookSet;
			//Courier charge
			@FindBy(xpath="//*[@id='charge_type']//option[4]")
			WebElement cType_CourierCharges;
			//Extended DayCare charge
			@FindBy(xpath="//*[@id='charge_type']//option[5]")
			WebElement cType_ExtendedDayCare_charges;


			
			// Initializing the page Objects/webElement
			public static String downloadPath = "C:\\Users\\admin\\Downloads";
			WebDriver driver;
			WebDriverWait wait;

			public OneTimeChargesPage(WebDriver driver) {
				this.driver =driver;
				this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				PageFactory.initElements(driver, this);
			}
	
			public void OpenOneTimeChargesPage() {
				supportModule.click();
				oneTimeCharge_tag.click();
				
			}
			public void FetchChildDetails_fun() {
				// Use JavaScript to prevent the default action
			   // wait.until(ExpectedConditions.elementToBeClickable(addCharges_btn)).click();
			    String script = "arguments[0].onclick = function(event) { event.preventDefault(); }; arguments[0].click();";
			  ((JavascriptExecutor) driver).executeScript(script, addCharges_btn);

			    
			    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("apply_onetime_frm")));
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("apply_onetime_frm")));
			    childID.sendKeys("49157");
				fetch_details.click();
				// Wait for child details to load
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("div-child-name")));
			}
			
			public void AnnualPreSchoolFee_charge() {
				FetchChildDetails_fun();
				chargeType_dropdown.click();
				cType_AnnualPreSchoolFee.click();
				charge_amount.sendKeys("15000");
				charge_comments.sendKeys("AnnualFee OneTimeCharge");
				submitForm_Btn.click();
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
			}
			
			public void BookSet_charge() {
				FetchChildDetails_fun();
				chargeType_dropdown.click();
				cType_BookSet.click();
				submitForm_Btn.click();
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
			}
			public void Courier_charge() {
				FetchChildDetails_fun();
				chargeType_dropdown.click();
				cType_CourierCharges.click();
				submitForm_Btn.click();
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
            }
			
			public void ExtendedDayCare_charge() {
				FetchChildDetails_fun();
				chargeType_dropdown.click();
				cType_ExtendedDayCare_charges.click();
				charge_amount.sendKeys("15000");
				charge_comments.sendKeys("AnnualFee OneTimeCharge");
				submitForm_Btn.click();
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
			}
}
