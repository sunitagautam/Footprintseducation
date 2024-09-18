package practiceDemo;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import generics.BaseTest;
import onboarding.LoginPage;

public class BrowserStackDemo extends BaseTest{
	public static void main(String[] args) {
        // BrowserStack credentials
        String username = "sunitagautam_x3pFBT";
        String accessKey = "GZz1ppnHfjsbjpuzy2jA";

     // Desired capabilities using W3C format
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "latest");
        
        // Use "os" and "osVersion" with "bstack:options"
        HashMap<String, Object> options = new HashMap<>();
        options.put("os", "Windows");
        options.put("osVersion", "10");
        options.put("projectName", "My Project"); // Optional
        options.put("buildName", "My Build"); // Optional
        capabilities.setCapability("bstack:options", options);

        // Additional capability for the test name
       // capabilities.setCapability("name", "BrowserStack Test"); // Optional

        WebDriver driver = null;
        try {
            // Initialize the remote WebDriver
            String url = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
            driver = new RemoteWebDriver(new java.net.URL(url), capabilities);
         // Your test logic
            driver.get(URL);
            System.out.println("Page title is: " + driver.getTitle());
            LoginPage lp= new LoginPage(driver);
    		lp.login_admin();
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }




	

}
