package financialModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generics.BaseTest;
import generics.FWUtils;

public class OneTimeChargesPage extends BaseTest{
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
			
			//Apron charge
			@FindBy(xpath="//*[@id='charge_type']//option[3]")
			WebElement cType_Apron;
			@FindBy(css=".alert-success")
			WebElement successMsg;
			//Bookset Charge
			@FindBy(xpath="//*[@id='charge_type']//option[4]")
			WebElement cType_Bookset;
			//Courier charge
			@FindBy(xpath="//*[@id='charge_type']//option[5]")
			WebElement cType_CourierCharges;
			//Extended DayCare charge
			@FindBy(xpath="//*[@id='charge_type']//option[6]")
			WebElement cType_ExtendedDayCare_charges;
			//LateStay charge
			@FindBy(xpath="//*[@id='charge_type']//option[7]")
			WebElement cType_LateStay;
			@FindBy(id="date")
			WebElement date_calendar;
			@FindBy(xpath="//*[@id='date_root']//div//div//div//div//div[2]//button[1][text()='Today']")
			WebElement date_today;
			@FindBy(id="hour")
			WebElement hour_dropdown;
			@FindBy(id="minute")
			WebElement min_dropdown;
			@FindBy(id="calculate_charge")
			WebElement calculate_Btn;
			


			
			// Initializing the page Objects/webElement
			public static String downloadPath = "C:\\Users\\admin\\Downloads";
			WebDriver driver;
			WebDriverWait wait;

			public OneTimeChargesPage(WebDriver driver) {
				this.driver =driver;
				this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
			
			public void Apron_charge() {
				FetchChildDetails_fun();
				chargeType_dropdown.click();
				cType_Apron.click();
				submitForm_Btn.click();
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
	            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMsg")));
	           // System.out.println("Msg: "+successMsg.getText());
			}
			
			public void BookSet_charge() {
				FetchChildDetails_fun();
				chargeType_dropdown.click();
				cType_Bookset.click();
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
			public void LateStay_charge() {
				FetchChildDetails_fun();
				//chargeType_dropdown.click();
				Select select = new Select(chargeType_dropdown);
		        select.selectByVisibleText("Late Stay");
		        date_calendar.click();
		        date_today.click();
		        Select select1 = new Select(hour_dropdown);
		        select1.selectByVisibleText("2");
		        Select select2 = new Select(min_dropdown);
		        select2.selectByVisibleText("30");
		        calculate_Btn.click();
				charge_comments.sendKeys("Late Stay OneTimeCharges");
				FWUtils.scrollDown();
				submitForm_Btn.click();
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
	            
			}
			public void ReadOStick_charge() {
				FetchChildDetails_fun();
				Select select = new Select(chargeType_dropdown);
		        select.selectByVisibleText("Read-O-Stick");
				submitForm_Btn.click();
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
            }
			
			public void RegistrationFee_charge() {
				FetchChildDetails_fun();
				Select select = new Select(chargeType_dropdown);
		        select.selectByVisibleText("Registration Fee");
				charge_amount.sendKeys("1500");
				submitForm_Btn.click();
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
            }
			
			public void SchoolBag_charge() {
				FetchChildDetails_fun();
				Select select = new Select(chargeType_dropdown);
		        select.selectByVisibleText("School Bag");
				submitForm_Btn.click();
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
            }
			public void SecurityFee_charge() {
				FetchChildDetails_fun();
				Select select = new Select(chargeType_dropdown);
		        select.selectByVisibleText("Security Fee");
				submitForm_Btn.click();
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
            }
			public void TransportFee_charge() {
				FetchChildDetails_fun();
				Select select = new Select(chargeType_dropdown);
		        select.selectByVisibleText("Transport Fee");
				charge_amount.sendKeys("1000");
				charge_comments.sendKeys("Transport Fee of Child");
				submitForm_Btn.click();
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
			}
			
			public void TuitionFee_charge() {
				FetchChildDetails_fun();
				Select select = new Select(chargeType_dropdown);
		        select.selectByVisibleText("Tuition Fee");
				charge_amount.sendKeys("3000");
				charge_comments.sendKeys("Tuition Fee of Child");
				submitForm_Btn.click();
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
	    	    driver.navigate().refresh(); // Refresh the page to maintain session

			}
			
			public void WelcomeKit_charge() {
				FetchChildDetails_fun();
				Select select = new Select(chargeType_dropdown);
		        select.selectByVisibleText("Welcome Kit");
				submitForm_Btn.click();
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
	    	    driver.navigate().refresh(); // Refresh the page to maintain session

            }
			public void WelcomeKit_WithoutReadOStick_charge() {
				FetchChildDetails_fun();
				Select select = new Select(chargeType_dropdown);
		        select.selectByVisibleText("Welcome Kit Without Read-O-Stick");
				submitForm_Btn.click();
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
	    	    driver.navigate().refresh(); // Refresh the page to maintain session

            }
			public void WelcomeKit_WithReadOStick_charge() {
				FetchChildDetails_fun();
				Select select = new Select(chargeType_dropdown);
		        select.selectByVisibleText("Welcome Kit With Read-O-Stick");
				submitForm_Btn.click();
				try {
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
				} catch (Exception e) {
			        System.out.println("Confirmation popup not displayed.");
				    driver.navigate().refresh(); // Refresh the page to maintain session

			    }
            }


}
