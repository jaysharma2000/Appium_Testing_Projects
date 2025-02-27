import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class SplashScreenCommonTest {
private AppiumDriver driver;
    
    // Constructor accepts an already initialized driver
    public SplashScreenCommonTest(AppiumDriver driver) {
        this.driver = driver;
    }
    
    // This method contains the splash screen validation steps.
    public void performSplashScreenTest() throws InterruptedException {
        WebElement appLogoElement = driver.findElement(By.id("splash_logo"));
        if (appLogoElement.isDisplayed()) {
            System.out.println("App Logo Displayed Successfully");
        } else {
            System.out.println("No app logo found");
        }
        
        // Wait for 3 seconds on the splash screen.
        Thread.sleep(3000);
        System.out.println("Waited for 3 sec splash screen");
        
        WebElement apptitleElement = driver.findElement(By.id("onboarding_text"));
        if (apptitleElement.isDisplayed()) {
            System.out.println("Successfully navigated to Onboarding screen after 3 sec delay");
        } else {
            System.out.println("Not able to navigate to onboarding screen");
        }
    }

}
