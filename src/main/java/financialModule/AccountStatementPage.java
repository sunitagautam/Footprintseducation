package financialModule;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import generics.BaseTest;

public class AccountStatementPage extends BaseTest {
	// page Factory

		@FindBy(xpath = "//*[@id='navbar-second-toggle']/ul/li[8]/a[text()='Support']")
		WebElement SupportModule;
		@FindBy(xpath ="//*[@id='navbar-second-toggle']//ul//li[8]//div//div[1]//div//div[1]//ul//li[1]//a[text()='Account Statement']")
		WebElement accountStatement_tag;
		@FindBy(name="child_id")
		WebElement admissionID;
		@FindBy(name="statement_bnt")
		WebElement generateReport_Btn;
		
		
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
			 SupportModule.click();
			 accountStatement_tag.click();
			admissionID.sendKeys("49149"); //Center Shift
			// admissionID.sendKeys("49168"); //Time Extension
			 generateReport_Btn.click();
		 }

		

}
