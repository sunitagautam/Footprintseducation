package financialModule;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generics.BaseTest;

public class AccountStatementPage extends BaseTest {
	// page Factory

		@FindBy(xpath = "//*[@id='navbar-second-toggle']/ul/li[8]/a[text()='Support']")
		WebElement SupportModule;
		@FindBy(xpath ="//*[@id='navbar-second-to"
				+ "ggle']//ul//li[8]//div//div[1]//div//div[1]//ul//li[1]//a[text()='Account Statement']")
		WebElement accountStatement_tag;
		@FindBy(name="child_id")
		WebElement admissionID;
		@FindBy(name="statement_bnt")
		WebElement generateReport_Btn;
		@FindBy(xpath="//html//body//div[5]//div//div//div[1]//div[2]//div[3]//legend//div[1]/a[@title='Child Information']")
		WebElement childName;
		
		//Add Charges:
		@FindBy(xpath="//div[3]/legend/div[2]/div/div[1]/a[1]/span[text()='Add Charges']")
		WebElement AddCharges_link;
		@FindBy(id="charge_type")
		WebElement chargeType_dropdown;
		@FindBy(id="apply_charge")
		WebElement submitForm_Btn;
		// Confirm submission popup
		@FindBy(id="submit_apply_charge")
		WebElement confirmButton;
		
		//child Plan
		@FindBy(xpath="//div[3]//legend//div[2]//div//div[1]//a[2]//span[text()='Child Plan']")
		WebElement childPlan_link;
		@FindBy(id="selected_effective_date")
		WebElement year_dropdown;
		@FindBy(xpath="//*[@id='frm_apply_fee_card']//div[3]//div//input")
		WebElement check_Btn;
		@FindBy(xpath="//*[@id='frm_apply_fee_card']//div[4]//div//input")
		WebElement update_FeeCard;
		//center plan
		@FindBy(xpath="//div[3]//legend//div[2]//div//div[1]//a[3]//span[text()='Center Plan']")
		WebElement centerPlan_link;
		@FindBy(xpath="//*[@id='popdown-dialog']//div//div//div//div//div[3]//button[text()='Close']")
		WebElement close_btn;
		//Diary Notes**************************
		@FindBy(xpath="//div[3]//legend//div[2]//div//div[1]//a[4]//span[text()='Diary Notes']")
		WebElement Diary_Notes;
		@FindBy(id="note_text")
		WebElement comment_box;
		@FindBy(id="add_notes_button")
		WebElement notes_Btn;
		
		//Child History *************************************
		@FindBy(xpath="//div[3]//legend//div[2]//div//div[1]//a[5]//span[text()='Child History']")
		WebElement childHistory_link;
		@FindBy(xpath="//div[@class='modal-body text-left']//div[@class='pre-scrollable']//p")
		List<WebElement> history_Paragraph;
		@FindBy(xpath="//*[@id='popdown-dialog']//div//div//div//div//div[3]//button[text()='Close']")
		WebElement ChildHistory_close_btn;
		
		
		
		// Initializing the page Objects/webElement
		public static String downloadPath = "C:\\Users\\admin\\Downloads";
		WebDriver driver;
		WebDriverWait wait;

		public AccountStatementPage(WebDriver driver) {
			this.driver =driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			PageFactory.initElements(driver, this);
		}
		 public void GenerateReport_functionality() {
				wait.until(ExpectedConditions.visibilityOf(SupportModule));
			 SupportModule.click();
			 accountStatement_tag.click();
			//admissionID.sendKeys("49149"); //Center Shift
			admissionID.sendKeys("47494"); //pause service
			//admissionID.sendKeys("49215"); //pause_leaveExtend Request
			// admissionID.sendKeys("49168"); //Time Extension
			 generateReport_Btn.click();
		 }
	//ChildName Link functionality	 
		 public void childName_link() {
			 String originalWindow = driver.getWindowHandle();
			 childName.click();
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
			 // Optionally, you can switch back to the original window if needed:
			 driver.switchTo().window(originalWindow);	
			 }
		 
		 //Add Charges Link/modal functionality*******************************************
		 public void addCharge_linkFunctionality() {
			 AddCharges_link.click();
	            wait.until(ExpectedConditions.visibilityOf(chargeType_dropdown));
				Select select = new Select(chargeType_dropdown);
		        select.selectByVisibleText("Apron Charges");
				submitForm_Btn.click();
				// Confirm submission
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal_confirm")));
	            confirmButton.click();
		 }
		 
		 //Child Plan link FUnctionality**************************************
		 public void childPlan_linkfun() {
			 
			 childPlan_link.click();
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
		 
		 public void childPlan_updateFeeCard() {
			 childPlan_link.click();
	         wait.until(ExpectedConditions.visibilityOf(year_dropdown));
			 Select select = new Select(year_dropdown);
		     select.selectByVisibleText("2024-04-01");
		     check_Btn.click();
		     update_FeeCard.click();
			
		 }
		 
		 //Center Plan functionality ******************************
		 public void centerPlan_linkfun() {
			 centerPlan_link.click();
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
		 //Diary_Notes***********************************************
		 
		 public void diary_Notesfun() {
			    Diary_Notes.click();
				comment_box.sendKeys("payment done");
				notes_Btn.click();
		 }
// Child History *************************************************
		 public void child_HistoryLink_func() {
			 childHistory_link.click();
			// Iterate through each paragraph and print the text
			    for (WebElement paragraph : history_Paragraph) {
			        System.out.println(paragraph.getText());
			    }
			 }
}
