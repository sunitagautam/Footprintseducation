package practiceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;

import generics.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import onboarding.LoginPage;

public class ApplitoolDemo extends BaseTest{
	@FindBy(xpath = "//*[@id=\"navbar-second-toggle\"]/ul/li[8]/a[text()='Support']")
	WebElement SupportModule;
	
	public static void main(String[] args) {
        // Set your Applitools API key
		//Account setup via : email : sunita.gautam@footprintseducation.in & P/w : Veer@30323
		
        String apiKey = "dDDPVfUEJYcHJoHwYjCwTRG1vOq4nWYbAQAJREX3iyQ110"; // Replace with your actual API key

        // Initialize WebDriver (Ensure you have the correct driver set up)
    
        WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

        // Initialize Applitools Eyes
        Eyes eyes = new Eyes();
        eyes.setApiKey(apiKey);

        try {
            // Start the test
            eyes.open(driver, "Demo App", "Visual Test Example");

            // Navigate to the application
            driver.get(URL);
            System.out.println("Page title is: " + driver.getTitle());
            LoginPage lp= new LoginPage(driver);
    		lp.login_admin();
    		
            // Your test logic
            // Validate visual elements
            eyes.check("Home Page", Target.window()); // Take a screenshot of the entire window
          //  eyes.checkWindow();

            // Close the Eyes instance
            eyes.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up
            driver.quit();
            eyes.abortIfNotClosed(); // Ensure Eyes is closed if an exception occurs
        }
    }

}
