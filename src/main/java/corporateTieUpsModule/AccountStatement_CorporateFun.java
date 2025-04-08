package corporateTieUpsModule;

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

public class AccountStatement_CorporateFun extends BaseTest{
	
	// page Factory

			@FindBy(xpath = "//*[@id='navbar-second-toggle']/ul/li[8]/a[text()='Support']")
			WebElement SupportModule;
			@FindBy(xpath ="//*[@id='navbar-second-toggle']//ul//li[8]//div//div[1]//div//div[1]//ul//li[1]//a[text()='Account Statement']")
			WebElement accountStatement_tag;
			@FindBy(name="child_id")
			WebElement admissionID;
			@FindBy(name="statement_bnt")
			WebElement generateReport_Btn;
			
			// TieupPorgram Change********************************************
			@FindBy(xpath="//div[@class=\"text-right pull-right pd-10\"]//a[@href=\"javascript:addTieupProgramChange('50947');\"]")
			WebElement tieup_ProgramChangeLink;
			@FindBy(id="new_program")
			WebElement Select_Program;
			@FindBy(id="processing_date")
			WebElement calendar_ProcessingDate;
			@FindBy(xpath="//*[@id='processing_date_root']//div//div//div//div//div[1]//div[3]")
			WebElement next_Arrow;
			@FindBy(xpath="//*[@id='processing_date_table']//tbody//tr[2]//td[3]//div[text()='4']")
			WebElement date_selected;
			@FindBy(xpath="//*[@id='modal_form_corp_program_change']//div//div//div[3]//button[2][text()='Add Program Change Request']")
			WebElement addProgramChange_btn;
			@FindBy(xpath="//div[@class=\"text-right pull-right pd-10\"]//a[@href=\"javascript:updateTieupProgramChange('50947', 'Processing');\"]")
			WebElement approveTieUp_ProgramChangeRequest_Btn;
            @FindBy(id="wef_date")
            WebElement wef_dropdown;
            @FindBy(xpath="//*[@id='wef_date_root']//div//div//div//div//div[1]//div[3]")
            WebElement wef_Next;
            @FindBy(id="req_comment")
            WebElement feeBreakup;
            @FindBy(id="parent_monthly")
            WebElement monthlyAmount_ParentPayable;
            @FindBy(id="corporate_monthly")
            WebElement monthlyAmount_CorporatePayable;
            @FindBy(xpath="//*[@id='modal_form_program_change_req']//div//div//div[3]//button[2][text()='Approve Request']")
            WebElement approveRequest_Btn;
            @FindBy(xpath="//div[@class='text-right pull-right pd-10']//a[@href=\"javascript:updateTieupProgramChange('50947','Approved');\"]")
            WebElement TieUpProgramChangeRequestApproved_btn;
            @FindBy(xpath="//div[@class='modal-body model-program-change-body-req']//div[@class='row mt-10']")
            List<WebElement> TieupProgramChange_info;
            
			// Corporate Transfer********************************************
            @FindBy(xpath="//a//span[text()='Corporate Transfer']")
            WebElement corporateTransfer_link;
            @FindBy(id="applicable_month")
            WebElement joining_month;
            @FindBy(xpath="//*[@id=\"applicable_month\"]//option[2]")
            WebElement selected_month;
            @FindBy(id="new_offer_id")
            WebElement new_offerID;
            @FindBy(id="new_center")
            WebElement newCenter;
            @FindBy(id="new_program_name")
            WebElement newPromgram;
            @FindBy(id="add_request")
            WebElement submit_Btn;
            @FindBy(xpath="//a[contains(text(), 'Approve Corporate Transfer')]")
            WebElement approve_ctransfer_Btn;
            @FindBy(id="frm-corporate-change-req")
            WebElement modal_CorporateTransferRequest;
            @FindBy(id="req_comment")
            WebElement feebreakup_comment;
            @FindBy(xpath="//*[@id='modal_form_corporate_change_req']//div//div//div[3]//button[2][text()='Approve Request']")
            WebElement approve_Btn;
            @FindBy(xpath="//div//legend//div[3]//div[2][contains(text(), 'Corporate Transfer Already Requested')]")
            WebElement transfer_msg;
            
            //Customer Request links & screen webelements**********************************
            @FindBy(xpath="//div[2]//a[2]//span[text()='Customer Requests']")
            WebElement customerRequest_link;
            @FindBy(xpath="//*[@id='DataTables_Table_0_filter']//label//input")
            WebElement search_bar;
	
			// Initializing the page Objects/webElement
			public static String downloadPath = "C:\\Users\\admin\\Downloads";
			WebDriver driver;
			WebDriverWait wait;

			public AccountStatement_CorporateFun(WebDriver driver) {
				this.driver =driver;
				this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				PageFactory.initElements(driver, this);
			}
			 public void GenerateReport_functionality() {
					wait.until(ExpectedConditions.visibilityOf(SupportModule));
				 SupportModule.click();
				 accountStatement_tag.click();
				// admissionID.sendKeys("50947"); //Tieup Program change
				admissionID.sendKeys("49839");   //Corporate Transfer
				 generateReport_Btn.click();
			 }
			 
			 public void TieUp_ProgramChangeFun() {
				 wait.until(ExpectedConditions.visibilityOf(tieup_ProgramChangeLink));
				 tieup_ProgramChangeLink.click();
				 wait.until(ExpectedConditions.visibilityOf(Select_Program));
					Select select = new Select(Select_Program);
			        select.selectByVisibleText("Half Day");
			        calendar_ProcessingDate.click();
			        next_Arrow.click();
			        date_selected.click();  
			        addProgramChange_btn.click();
					 wait.until(ExpectedConditions.visibilityOf(approveTieUp_ProgramChangeRequest_Btn));
			        approveTieUp_ProgramChangeRequest_Btn.click();
			        
			        feeBreakup.sendKeys("8000");
			        monthlyAmount_ParentPayable.sendKeys("3000");
			        monthlyAmount_CorporatePayable.sendKeys("5000");
					 wait.until(ExpectedConditions.visibilityOf(approveRequest_Btn));
			        approveRequest_Btn.click();
					 wait.until(ExpectedConditions.visibilityOf(TieUpProgramChangeRequestApproved_btn));
			        TieUpProgramChangeRequestApproved_btn.click();
			        
			     // Iterate over each row and print the text
			        for (WebElement row : TieupProgramChange_info) {
			            System.out.println(row.getText());
			        }    
			 }
			 
			 public void CoporateTransfer_fun() {
				 wait.until(ExpectedConditions.visibilityOf(corporateTransfer_link));
				 corporateTransfer_link.click();
				 wait.until(ExpectedConditions.visibilityOf(joining_month));
					Select select = new Select(joining_month);
			        select.selectByVisibleText("May 2025");
			        Select select1 = new Select(new_offerID);
			        select1.selectByVisibleText("ABP News - Sector 62 Offer");
			        Select select2 = new Select(newCenter);
			        select2.selectByVisibleText("Sector 122, Noida");
			        submit_Btn.click();
			     // Switch to the alert
			        Alert alert = driver.switchTo().alert();

			        // Perform actions on the alert
			        // Accept the alert (click OK)
			        alert.accept();
			        System.out.println("request submitted successsfully");
			        
					 wait.until(ExpectedConditions.visibilityOf(approve_ctransfer_Btn));
			        approve_ctransfer_Btn.click();
			        wait.until(ExpectedConditions.visibilityOf(modal_CorporateTransferRequest));
			        
					wait.until(ExpectedConditions.visibilityOf(feebreakup_comment));
			        feebreakup_comment.sendKeys("8499");
			        approve_Btn.click();
			        driver.navigate().refresh();
			        
					wait.until(ExpectedConditions.visibilityOf(transfer_msg));
			        System.out.println(transfer_msg.getText());
			        
					String originalWindow = driver.getWindowHandle();
			        customerRequest_link.click();
					 Set<String> allWindowHandles = driver.getWindowHandles();
			      //Switch to the new tab
					 for (String handle : allWindowHandles) {
					     if (!handle.equals(originalWindow)) {
					         driver.switchTo().window(handle);  // Switch to the new tab
					         break;
					     }
					 }
					// Get the URL of the new tab
					 String newTabURL = driver.getCurrentUrl();
					 System.out.println("New Tab URL: " + newTabURL);
					 String pageTitle = driver.getTitle();
						System.out.println("title of the page is:" +pageTitle);	
					 
					 //wait.until(ExpectedConditions.visibilityOf(search_bar));
					// search_bar.sendKeys("Corporate Transfer");
					 
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
					 // Optionally, you can switch back to the original window if needed:
					 driver.switchTo().window(originalWindow);	
                 }
			 
}
