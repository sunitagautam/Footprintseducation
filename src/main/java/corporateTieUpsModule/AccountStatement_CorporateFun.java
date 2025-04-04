package corporateTieUpsModule;

import java.time.Duration;
import java.util.List;

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
				admissionID.sendKeys("50947"); //Tieup Program change
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
}
