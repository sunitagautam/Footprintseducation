package financialModule;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generics.BaseTest;

public class CustomerRequestPage extends BaseTest{
	
	//Service request  Modal popup
	//@FindBy(xpath = "//html//body//div[5]//div//div//div[1]//div[2]//div[3]//legend//div[2]//div//div[1]//a[7]//span[text()='Service Request']")
	@FindBy(xpath ="//html//body//div[5]//div//div//div[1]//div[2]//div[3]//legend//div[2]//div//div[1]//a[7]//i")
	WebElement ServiceRequest_Link;
	@FindBy(xpath="//*[@id='send_request']")
	WebElement selectServices_dropdown;
	
	//Center Shift *************************************************************************
	@FindBy(xpath="//*[@id='send_request']/option[2]")
	WebElement service_centerShift;
	@FindBy(xpath="//html//body//div[6]//div//div//div//div//div//div[2]//div//div[3]//div[8]//form//div[1]//div//div//input[1]")
	WebElement oldCenterAttritionDate_calendar;
    @FindBy(xpath="//div//div[3]//div[8]//form//div[1]//div//div/div//div//div//div//div//table//tbody//tr[3]//td[2]")
	WebElement oldCenterAttritionDate_Selected;
	@FindBy(xpath="//html//body//div[6]//div//div//div//div//div//div[2]//div//div[3]//div[8]//form//div[2]//div//div//input[1]")
	WebElement newCenterJoiningDate_calendar;
	@FindBy(xpath="//html//body//div[6]//div//div//div//div//div//div[2]//div//div[3]//div[8]//form//div[2]//div//div//div//div//div//div//div//table//tbody//tr[4]//td[2]")
	WebElement newCenterJoiningDate;
	@FindBy(id="new_center")
	WebElement newCenter_dropdown;
	@FindBy(xpath="//*[@id='new_center']//optgroup[2]//option[3]")
	WebElement newCenter_Selected;
	@FindBy(id="new_program")
	WebElement newProgram_dropdown;
	@FindBy(xpath="//*[@id='new_program']//option[2][text()='Full Day']")
	WebElement programSelected_fullDay;
	@FindBy(xpath="//*[@id='frm-center-shift']//div[4]//div[3]")
	WebElement centerShift_notes;
	@FindBy(css=".btn btn-primary btn-service center-shift")
	WebElement submit_CenterShiftBtn;
	
	
	
	// child pause *******************************************************************************
	@FindBy(xpath="//*[@id='send_request']/option[4]")
	WebElement service_childPause;
	//program change*****************************************************
	@FindBy(xpath="//*[@id='send_request']/option[5]")
	WebElement service_programChange;
	
	//Time Extension*******************************************
	@FindBy(xpath="//*[@id='send_request']/option[6]")
	WebElement service_startTimeExtension;
	@FindBy(id="startFrom")
	WebElement starFromDate_calendar;
	@FindBy(xpath="//*[@id='startFrom_root']//div//div//div//div//div[2]//button[1]")
	WebElement todayBtn_calendar;
	@FindBy(xpath="//*[@id='frm-start-time-extension']//span//ul//li")
	WebElement note_msg;
	@FindBy(xpath="//html//body//div[6]//div//div//div//div//div//div[2]//div//div[3]//div[14]//form//div[3]//div//button[@id='add_request']")
	WebElement submit_BtnTE;
	//@FindBy(xpath="//div[@class='alert alert-success p-10']")
	@FindBy(css=".alert alert-success p-10")
	WebElement successMsg_TE;
	@FindBy(css=".icon-cancel-circle2 fa-2x")
	WebElement closeIcon_Modal;
	@FindBy(css=".alert alert-warning p-10")
	WebElement eMsg_alreadyexists;
	

	
	//Transport1 way********************************
	@FindBy(xpath="//*[@id='send_request']/option[7]")
	WebElement service_StartTransport1Way;
	
	//Transport 2 way **********************************
	@FindBy(xpath="//*[@id='send_request']/option[8]")
	WebElement service_StartTransport2Way;
	
		
	
	
	//customer Request screen webElements:
	@FindBy(xpath="//legend//div[2]//div//div[2]//a[2]//span[text()='Customer Requests']")
	WebElement customerRequest_page;
	
	
	
	// Initializing the page Objects/webElement
			public static String downloadPath = "C:\\Users\\admin\\Downloads";
			WebDriver driver;
			WebDriverWait wait;

			public CustomerRequestPage(WebDriver driver) {
				this.driver =driver;
				this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				PageFactory.initElements(driver, this);
			}
			
			//SC_002_TC_002 Service Requests
			
			public void CenterShift_ServiceRequest() {
			    wait.until(ExpectedConditions.visibilityOf(ServiceRequest_Link));
				ServiceRequest_Link.click();
				String mainWindowHandle = driver.getWindowHandle();
				Set<String> allHandles = driver.getWindowHandles();
				for (String handle : allHandles) {
				    if (!handle.equals(mainWindowHandle)) {
				        driver.switchTo().window(handle);
				        break;
				    }
				}
				wait.until(ExpectedConditions.visibilityOf(selectServices_dropdown));
				//selectServices_dropdown.click();
				Select select = new Select(selectServices_dropdown);
		        select.selectByVisibleText("Center Shift");
				wait.until(ExpectedConditions.visibilityOf(oldCenterAttritionDate_calendar));
				oldCenterAttritionDate_calendar.click();
				oldCenterAttritionDate_Selected.click();
				newCenterJoiningDate_calendar.click();
				newCenterJoiningDate.click();
				newCenter_dropdown.click();
				newCenter_Selected.click();
				newProgram_dropdown.click();
				programSelected_fullDay.click();
				System.out.println("CenterShift Note" +centerShift_notes.getText());
				submit_CenterShiftBtn.click();
				try {
					// Switch to the alert
					Alert confirmAlert = driver.switchTo().alert();
					// Get the alert message (optional)
					String confirmMessage = confirmAlert.getText();
					System.out.println("Confirmation message: " + confirmMessage);

					confirmAlert.dismiss();	 // dismiss the confirmation (click "CANCEL")
					Thread.sleep(500);
					submit_CenterShiftBtn.click();
					confirmAlert.accept(); // Accept the confirmation (click "OK")
					//System.out.println("form Submission Msg:" +successMsg_TE.getText());
					//closeIcon_Modal.click();
				}
				catch(Exception exp) {
					System.out.println("I am inside catch block");
					System.out.println("Message is :" +exp.getMessage());
				}
			}
			
			public void StartTimeExtension_ServiceRequest() {
				wait.until(ExpectedConditions.visibilityOf(ServiceRequest_Link));
				ServiceRequest_Link.click();
				String mainWindowHandle = driver.getWindowHandle();
				Set<String> allHandles = driver.getWindowHandles();
				for (String handle : allHandles) {
				    if (!handle.equals(mainWindowHandle)) {
				        driver.switchTo().window(handle);
				        break;
				    }
				}
				wait.until(ExpectedConditions.visibilityOf(selectServices_dropdown));
				//selectServices_dropdown.click();
				Select select = new Select(selectServices_dropdown);
		        select.selectByVisibleText("Start Time Extension");
				//service_startTimeExtension.click();
				System.out.println("Time extension Time Limit Note :"  + note_msg.getText());
				starFromDate_calendar.click();
				todayBtn_calendar.click();
				wait.until(ExpectedConditions.visibilityOf(submit_BtnTE));
				submit_BtnTE.click();
				try {
						// Switch to the alert
						Alert confirmAlert = driver.switchTo().alert();
						// Get the alert message (optional)
						String confirmMessage = confirmAlert.getText();
						System.out.println("Confirmation message: " + confirmMessage);

						confirmAlert.dismiss();	 // dismiss the confirmation (click "CANCEL")
						Thread.sleep(500);
						submit_BtnTE.click();
						confirmAlert.accept(); // Accept the confirmation (click "OK")
						System.out.println("form Submission msg:" +successMsg_TE.getText());
						closeIcon_Modal.click();
					}
					catch(Exception exp) {
						System.out.println("I am inside block");
						System.out.println("Message is :" +exp.getMessage());
					}
				
			}
			
			public void Open_CustomerRequestPage() {
				customerRequest_page.click();
			}
			
			public void printALL_TableData_LatestRequest() {
				Open_CustomerRequestPage();
				List<WebElement> tRows = driver.findElements(By.tagName("tr"));
				int countRows = tRows.size();
				System.out.println("Total no of Rows: " + countRows);

				List<WebElement> tColumns = driver.findElements(By.tagName("th"));
				int countColumns = tColumns.size();
				System.out.println("Total no of Columns: " + countColumns);

				for (int i = 0; i < tRows.size(); i++) {
					List<WebElement> tData = driver.findElements(By.tagName("td"));
					for (int j = 0; j < tData.size(); j++) {
						System.out.println(tData.get(j).getText());
					}
				}
			}
			
			public void runParentProcessingAPI()
			{
				driver.get(Processing_Parent_Request);	
			}
}
