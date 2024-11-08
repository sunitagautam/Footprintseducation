package HardwareModule;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.ui.WebDriverWait;


import generics.BaseTest;
import generics.FWUtils;

public class ManageVendorPage extends BaseTest {

	// page Factory

	@FindBy(xpath = "//*[@id=\"navbar-second-toggle\"]/ul/li[8]/a[text()='Support']")
	WebElement SupportModule;
	@FindBy(xpath ="//*[@id='navbar-second-toggle']//ul//li[8]//div//div[1]//div//div[3]//ul//li[8]//a[text()='Manage Vendors']")
	WebElement manageVendor_tag;

	// Search********************************
	@FindBy(xpath = "//*[@id='vendors_datatable_filter']//label//input")
	WebElement searchBar;
	@FindBy(xpath = "//*[@id='tr-14']/td[1]")
	WebElement sResultfound;
	@FindBy(xpath = "//*[@id='vendors_datatable']//tbody//tr//td[text()='No matching records found']")
	WebElement sResultNotFound;

	// DOwnload report....
	@FindBy(xpath = "//*[@id='vendors_datatable_wrapper']//div[1]//div[3]//a//span[text()='Download Vendor Details']")
	WebElement download_VendorDetails;

	//pagination
	@FindBy(id="vendors_datatable_next")
	WebElement pNext;
	@FindBy(id="vendors_datatable_previous")
	WebElement pPrevious;
	@FindBy(xpath="//*[@id='vendors_datatable_paginate']//span//a[2]")
	WebElement page2;
	//Sorting
	@FindBy(xpath ="//table[@id='vendors_datatable']//th[@data-priority='1' and @class='sorting' and @aria-label='Name: activate to sort column ascending']")
	WebElement sortingColumn;
	//Action->active/Inactive
	@FindBy(xpath="//*[@id='tr-18']//td[15]//a[2]")
	WebElement action_AI;

	//Add Vendors
	@FindBy(xpath ="//html//body//div[5]//div//div//div[1]//div[1]//div//a[@href='add_edit_vendor']")
	WebElement addVendorBtn;
	@FindBy(name="vendor_name")
	WebElement vendorName;
	@FindBy(name="vendor_company")
	WebElement vendorComp;
	@FindBy(name="vendor_mobile")
	WebElement vendorMobile;
	@FindBy(name="vendor_email")
	WebElement vendorEmail;
	@FindBy(name="vendor_gst")
	WebElement vGST;
	@FindBy(name="vendor_pan")
	WebElement vPan;
	@FindBy(id="select2-vendor_city-container")
	WebElement cityDropdown;
	@FindBy(xpath="//span[1]//input[@class='select2-search__field']")
	WebElement dropdown_searchbar;
	@FindBy(name="vendor_products")
	WebElement vproducts;
	@FindBy(name="vendor_address")
	WebElement vAddress;
	@FindBy(name="vendor_description")
	WebElement vDes;
	@FindBy(xpath="//*[@id='vendor_form']//div//div[2]//div[6]//input[@name='Submit_Vendor_Form']")
	WebElement submitBtn;

	//Validations msg for add new vendors
	@FindBy(id="vendor_name-error")
	WebElement vendorName_error;
	@FindBy(id="vendor_company-error")
	WebElement vendorComp_error;
	@FindBy(id="vendor_products-error")
	WebElement vendorProd_error;
	@FindBy(id="vendor_mobile-error")
	WebElement vendorMobile_error;
	@FindBy(id="vendor_mobile_msg")
	WebElement vMobile_duplicate;
	@FindBy(xpath="//*[@id='vendor_mobile_msg']/span[text()='Duplicacy Exists!']")
	WebElement mobile_duplicacy;
	@FindBy(id="vendor_email-error")
	WebElement vendorEmail_error;
	@FindBy(xpath="//*[@id='vendor_email_msg']//span[text()='Duplicacy Exists!']")
	WebElement email_duplicacy;
	@FindBy(id="vendor_pan-error")
	WebElement vendorPan_error;
	// Edit 
	@FindBy(xpath="//*[@id='tr-19']//td[15]//a[1]//span")
	WebElement editIcon;




	// Initializing the page Objects/webElement
	public static String downloadPath = "C:\\Users\\admin\\Downloads";
	WebDriver driver;
	WebDriverWait wait;

	public ManageVendorPage(WebDriver driver) {
		this.driver = driver;
		// Use Duration to specify the timeout
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
		PageFactory.initElements(driver, this);
	}

	public void OpenManageVendorPage() throws InterruptedException {
		SupportModule.click();
		manageVendor_tag.click();
		Thread.sleep(500);

	}
	//SC_001_TC_001

	public void printALL_TableData() {

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

	public void searchFunctionality() throws InterruptedException {
		searchBar.sendKeys("Amazon");
		Thread.sleep(500); // Consider using WebDriverWait here
		if (sResultfound.isDisplayed()) {
			System.out.println("Searched Vendor Name is found " + sResultfound.getText());
		} else {

			System.out.println("Searched VendorName is not found."+sResultNotFound.getText());
		}
	}

	//SC_001_TC_003
	public void verifyDownloadReport_FileExt() throws InterruptedException {
		download_VendorDetails.click();
		Thread.sleep(500);
		//AssertJUnit.assertTrue(FWUtils.isFileDownloaded_Ext(downloadPath, ".csv"));
		//Assert.assertTrue(FWUtils.isFileDownloaded(downloadPath,"Vendor_Details_29_07_2024"),"Failed to download Expected document");
		System.out.println("Report downloaded successfully");
	}
	//SC_001_TC_004 

	public void pagination_fun() throws InterruptedException {
		pNext.click();
		pPrevious.click();
		Thread.sleep(500);
		page2.click();

	}
	//SC_001_TC_005 

	public void sorting_fun() throws InterruptedException {
		sortingColumn.click();
		Thread.sleep(500);
		page2.click();

	}
	//SC_001_TC_006
	public void Action_Active_fun() throws InterruptedException {
		try {
			action_AI.click();
			// Switch to the alert
			Alert confirmAlert = driver.switchTo().alert();
			// Get the alert message (optional)
			String confirmMessage = confirmAlert.getText();
			System.out.println("Confirmation message: " + confirmMessage);
			Thread.sleep(500);

			confirmAlert.accept(); // Accept the confirmation (click "OK")
			System.out.println("Vendor gets activated successfully");
		}
		catch(Exception exp) {
			System.out.println("I am inside catch block");
			System.out.println("Message is :" +exp.getMessage());
			System.out.println("Message is :" +exp.getCause());

		}

	}

	//SC_001_TC_006
	public void Action_Inactive_fun() throws InterruptedException {
		try {
			action_AI.click();
			// Switch to the alert
			Alert confirmAlert = driver.switchTo().alert();
			// Get the alert message (optional)
			String confirmMessage = confirmAlert.getText();
			System.out.println("Confirmation message: " + confirmMessage);

			confirmAlert.dismiss();	 // Accept the confirmation (click "CANCEL")
			Thread.sleep(500);
			action_AI.click();
			confirmAlert.accept(); // Accept the confirmation (click "OK")
			System.out.println("Vendor gets deactivated successfully");
		}
		catch(Exception exp) {
			System.out.println("I am inside catch block");
			System.out.println("Message is :" +exp.getMessage());
			System.out.println("Message is :" +exp.getCause());

		}

	}
	//SC_001_TC_008

	public void addVendor_func() throws InterruptedException {
		addVendorBtn.click();
		vendorName.sendKeys("Amazon VendorK");
		vendorComp.sendKeys("Mac Company2");
		vendorMobile.sendKeys("9095123456");
		vendorEmail.sendKeys("sunita+mj@gmail.com");
		vGST.sendKeys("6878GTR123RTY67PL");
		vPan.sendKeys("ABCDE1234B");
		cityDropdown.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(dropdown_searchbar).click().sendKeys("Noida").sendKeys(Keys.ENTER).perform();
		vproducts.sendKeys("MacAirM1");
		vAddress.sendKeys("Tower C1 sector 120");
		vDes.sendKeys("MAC OS- Sonoma 14.5");
		FWUtils.scrollDown();
		submitBtn.click();
		Thread.sleep(1000);
	}
	//SC_001_TC_009 (validations)
	public void AddNewVendor_MandatoryfieldValidations() {
		addVendorBtn.click();
		FWUtils.scrollDown();
		submitBtn.click();
		System.out.println("Validation message without filling any field of form:"+ vendorName_error.getText());
		System.out.println("Validation message without filling any field of form:"+ vendorComp_error.getText());
		System.out.println("Validation message without filling any field of form:"+ vendorProd_error.getText());
	}

	public void AddNewVendor_MobilePhoneformatValidations() throws InterruptedException {
		addVendorBtn.click();
		vendorMobile.sendKeys("90651234");
		FWUtils.scrollDown();
		submitBtn.click();
		System.out.println("Mobile Validation Message for less than 10 digits :"+ vendorMobile_error.getText());
		System.out.println("warning for duplicacy:"+ vMobile_duplicate.getText());
		vendorMobile.clear();
		Thread.sleep(500);
		vendorMobile.sendKeys("987654321123456");
		submitBtn.click();
		System.out.println("Mobile Validation Message for More than 13 digits"+ vendorMobile_error.getText());
		vendorMobile.clear();
		Thread.sleep(500);
	}

	public void AddNewvendor_MobileDuplicacy() {
		addVendorBtn.click();
		vendorName.sendKeys("Amazon VendorK");
		vendorComp.sendKeys("Mac Company2");
		vproducts.sendKeys("Mac-Air M1");
		vendorMobile.sendKeys("7503664514");
		FWUtils.scrollDown();
		submitBtn.click();
		FWUtils.scrollUp();
		WebElement mobileDuplicacyMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-warning"))); // Replace with actual selector
		System.out.println("Duplicacy Validation message of mobile no:" +mobileDuplicacyMessage.getText());

		// Use JavaScript to find the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement messageElement = (WebElement) js.executeScript("return document.querySelector('.alert-warning')");

		if (messageElement != null) {
			System.out.println("Message text: " + messageElement.getText());
			System.out.println("validation msg: " +mobile_duplicacy.getText());
		} else {
			System.out.println("Message element not found.");
		}


	}

	public void AddNewVendor_EmailformatValidations() throws InterruptedException {
		addVendorBtn.click();
		vendorEmail.sendKeys("sunita");
		FWUtils.scrollDown();
		submitBtn.click();
		System.out.println("email format Validation Message :"+ vendorEmail_error.getText());
	}

	public void AddNewvendor_EmailDuplicacy() {
		addVendorBtn.click();
		vendorName.sendKeys("Amazon VendorK");
		vendorComp.sendKeys("Mac Company2");
		vproducts.sendKeys("Mac-Air M1");
		vendorEmail.sendKeys("sunita.gautam@footprintseducation.in");
		FWUtils.scrollDown();
		submitBtn.click();
		FWUtils.scrollUp();
		WebElement emailDuplicacyMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-warning"))); // Replace with actual selector
		System.out.println("Duplicacy Validation message of email no:" +emailDuplicacyMessage.getText());

		// Use JavaScript to find the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement messageElement = (WebElement) js.executeScript("return document.querySelector('.alert-warning')");

		if (messageElement != null) {
			System.out.println("Message text: " + messageElement.getText());
			System.out.println("validation msg: " +email_duplicacy.getText());

		} else {
			System.out.println("Message element not found.");
		}

	}

	public void AddNewvendor_PANValidation() {
		addVendorBtn.click();
		vendorName.sendKeys("Amazon VendorK");
		vendorComp.sendKeys("Mac Company2");
		vproducts.sendKeys("Mac-Air M1");
		vPan.sendKeys("BWBPG63Q");
		FWUtils.scrollDown();
		submitBtn.click();
		System.out.println("PAN Validation msg :"+vendorPan_error.getText());
	}
	//............................................................................................
	//SC_001_TC_010
	public void editVendor_func() {
		editIcon.click();
		vendorName.clear();
		vendorName.sendKeys("Amazon MAC5");
		FWUtils.scrollDown();
		submitBtn.click();
		FWUtils.scrollUp();
		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success"))); // Replace with actual selector
		System.out.println("update success message :" +successMessage.getText());

		// Use JavaScript to find the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement messageElement = (WebElement) js.executeScript("return document.querySelector('.alert-success')");

		if (messageElement != null) {
			System.out.println("Message text: " + messageElement.getText());
		} else {
			System.out.println("Message element not found.");
		}

	}
	//SC_001_TC_011  edit validations
	public void EditVendor_MandatoryfieldValidations() {
		editIcon.click();
		vendorName.clear();
		vendorComp.clear();
		vproducts.clear();
		FWUtils.scrollDown();
		submitBtn.click();
		System.out.println("Validation message without filling any field of form:"+ vendorName_error.getText());
		System.out.println("Validation message without filling any field of form:"+ vendorComp_error.getText());
		System.out.println("Validation message without filling any field of form:"+ vendorProd_error.getText());
	}

	public void EditVendor_MobileformatValidations() throws InterruptedException {
		editIcon.click();
		vendorMobile.clear();
		vendorMobile.sendKeys("90651234");
		FWUtils.scrollDown();
		submitBtn.click();
		System.out.println("Mobile Validation Message for less than 10 digits :"+ vendorMobile_error.getText());
		System.out.println("warning for duplicacy:"+ vMobile_duplicate.getText());
		vendorMobile.clear();
		Thread.sleep(500);
		vendorMobile.sendKeys("9876543211234569");
		submitBtn.click();
		System.out.println("Mobile Validation Message for More than 13 digits"+ vendorMobile_error.getText());
		vendorMobile.clear();
		Thread.sleep(500);
	}

	public void Editvendor_MobileDuplicacy() {
		editIcon.click();
		vendorMobile.clear();
		vendorMobile.sendKeys("7503664514");
		FWUtils.scrollDown();
		submitBtn.click();
		FWUtils.scrollUp();
		WebElement mobileDuplicacyMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-warning"))); // Replace with actual selector
		System.out.println("Duplicacy Validation message of mobile no:" +mobileDuplicacyMessage.getText());

		// Use JavaScript to find the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement messageElement = (WebElement) js.executeScript("return document.querySelector('.alert-warning')");

		if (messageElement != null) {
			System.out.println("Message text: " + messageElement.getText());
			System.out.println("validation msg: " +mobile_duplicacy.getText());
		} else {
			System.out.println("Message element not found.");
		}


	}

	public void EditVendor_EmailformatValidation() throws InterruptedException {
		editIcon.click();
		vendorEmail.clear();
		vendorEmail.sendKeys("sunita");
		FWUtils.scrollDown();
		submitBtn.click();
		System.out.println("email format Validation Message :"+ vendorEmail_error.getText());
	}

	public void EditVendor_EmailDuplicacy() {
		editIcon.click();
		vendorEmail.clear();
		vendorEmail.sendKeys("sunita.gautam@footprintseducation.in");
		FWUtils.scrollDown();
		submitBtn.click();
		FWUtils.scrollUp();
		WebElement emailDuplicacyMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-warning"))); // Replace with actual selector
		System.out.println("Duplicacy Validation message of email no:" +emailDuplicacyMessage.getText());

		// Use JavaScript to find the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement messageElement = (WebElement) js.executeScript("return document.querySelector('.alert-warning')");

		if (messageElement != null) {
			System.out.println("Message text: " + messageElement.getText());
			System.out.println("validation msg: " +email_duplicacy.getText());

		} else {
			System.out.println("Message element not found.");
		}

	}

	public void Editvendor_PANValidation() {
		editIcon.click();
		vPan.clear();
		vPan.sendKeys("BWBPG63Q");
		FWUtils.scrollDown();
		submitBtn.click();
		System.out.println("PAN Validation msg :"+vendorPan_error.getText());
	}

}
