package practiceDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import generics.BaseTest;
import onboarding.LoginPage;

import java.net.URL;

public class SauceLabsDemo extends BaseTest {
    public static void main(String[] args) {
        // Sauce Labs credentials (using google gmail account => sunita.fprints@gmail.com
    	// https://app.eu-central-1.saucelabs.com/tests/a7af770a967742069f1151adaafc9b1c#13
    	// https://saucelabs.com/
    	
        String username = "oauth-sunita.fprints-d4ecb";
        String accessKey = "f0a723a1-1a83-4bae-94ff-1a68234ffcd9";

        // Desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("platformName", "Windows 10");
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("name", "FP_login");
       // capabilities.setCapability("extendedDebugging", "true");
        //capabilities.setCapability("buildVersion", "4.4");




        try {
            // Initialize the remote WebDriver
            WebDriver driver = new RemoteWebDriver(
                    new URL("https://" + username + ":" + accessKey + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub"),
                    capabilities
                    //url: https://oauth-sunita.fprints-d4ecb:f0a723a1-1a83-4bae-94ff-1a68234ffcd9@ondemand.eu-central-1.saucelabs.com:443/wd/hub
            );

            // Your test logic
            driver.get(URL);
            System.out.println("Page title is: " + driver.getTitle());
            LoginPage lp= new LoginPage(driver);
    		lp.login_admin();
            

            // Clean up
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
