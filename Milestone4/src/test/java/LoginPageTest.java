import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LoginPageTest {
	private AppiumDriver driver;

//		public LoginPageTest(AppiumDriver driver) {
//				this.driver = driver;
//			}
	
	@Before
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Xiaomi Redmi Not 8 Pro");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability("appPackage", "com.example.milestone4");
		capabilities.setCapability("appActivity", "com.example.milestone4.ui.MainActivity");
		driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
	}
	
	
	@Test
	public void loginPageTesting() throws InterruptedException {
		System.out.println("Successfully launched LoginFragment");
		
		WebElement loginText = driver.findElement(By.id("loginText"));
		if(loginText.isDisplayed()) {
			System.out.println("LoginText is displayed");
		}
		
		
		WebElement emailElement = driver.findElement(By.id("email"));
		WebElement passwordElement = driver.findElement(By.id("password"));
		WebElement loginButtonElement = driver.findElement(By.id("loginButton"));
		//WebElement restaurantDeliveryTimeElement = driver.findElement(By.id("tvDeliveryTime"));
		
		if(emailElement.isDisplayed()) {
			System.out.println("The email field displayed successfully");
		}else {
			System.out.println("No email field found");
		}
		
		if(passwordElement.isDisplayed()) {
			System.out.println("password field visible");
		}else {
			System.out.println("No password field found");
		}
		
		if(loginButtonElement.isDisplayed()) {
			System.out.println("Login button found");
		}else {
			System.out.println("No Login button found");
		}
		emailElement.sendKeys("jaysharma@gmail.com");
		passwordElement.sendKeys("12345");
		
		loginButtonElement.click();
		System.out.println("Clicked on login button");
		
		Thread.sleep(2000);
		
		WebElement dashBoardTextElement = driver.findElement(By.id("dashBoardText"));
		Thread.sleep(1000);
		if(dashBoardTextElement.isDisplayed()) {
			System.out.println("navigated to Dashboard page");
		}else {
			System.out.println("Not able to navigate");
		}	
	}
	
	@After
    public void tearDown() {
   	 if(driver != null) {
   		 driver.quit();
   	 }
    }
}
