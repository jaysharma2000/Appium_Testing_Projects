import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class DashBoardTest {

	private AppiumDriver driver;
	
	@Before
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Xiaomi Redmi Not 8 Pro");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability("appPackage", "com.example.bookmyslot");
		capabilities.setCapability("appActivity", "com.example.bookmyslot.ui.MainActivity");
		driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
	}

	@Test
	public void dashBoardTest() throws InterruptedException {
		
		RegisterAndLoginScreenTest loginScreenTestCommon = new RegisterAndLoginScreenTest(driver);
		loginScreenTestCommon.performLoginScreenTest();
		
		WebElement dashBoardTitlElement = driver.findElement(By.id("dashboardTitle"));
		
		System.out.println("Dashboard title visible: " + dashBoardTitlElement.getText());
		
		WebElement addSlotBtnElement = driver.findElement(By.id("addInterviewSlot"));
		WebElement viewSlotBtnElement = driver.findElement(By.id("viewInterviewSlot"));
		
		if(addSlotBtnElement.isDisplayed() && viewSlotBtnElement.isDisplayed()) {
			System.out.println("Add interview and View interview Slots Button are visible");
		}
		
		WebElement recyclerViewElement = driver.findElement(By.id("recyclerView"));
		if(recyclerViewElement.isDisplayed()) {
			System.out.println("Recyclerview is displayed");
		}
		
		boolean allItemsFound = false;
		
		Set<String> allJobRoleNames = new HashSet<>();
		
		for(int i=0; i<5; i++) {
			Thread.sleep(1000);
			
			List<WebElement> jobRoleNames = driver.findElements(By.id("jobTitleTextView"));
			
			for(WebElement jobRole: jobRoleNames) {
				allJobRoleNames.add(jobRole.getText());
			}
			
			
			System.out.println("JobRoles found so far: " + allJobRoleNames.size());
			
			if(allJobRoleNames.size() >= 10) {
				allItemsFound = true;
				System.out.println("All 10 items displayed successfully");
				break;
			}
			
			driver.findElement(MobileBy.AndroidUIAutomator(
			        "new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"
			    ));
		}
		
		if (!allItemsFound) {
		    System.out.println("All items not found after scrolling.");
		}
		
		WebElement logoutBtnElement = driver.findElement(By.id("logoutButton"));
		
		if(logoutBtnElement.isDisplayed()) {
			System.out.println("Logout button is displayed");
		}
		
		logoutBtnElement.click();
		System.out.println("Clicked on logout button");
		
		Thread.sleep(2000);
		
		WebElement loginButton3Element = driver.findElement(By.id("loginButton"));
		if(loginButton3Element.isDisplayed()) {
			System.out.println("Sussessfully logout");
		}
	}
}
