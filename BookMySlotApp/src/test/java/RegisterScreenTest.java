import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class RegisterScreenTest {

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
	public void registerScreenTest() throws InterruptedException {
		WebElement appLogoElement = driver.findElement(By.id("splash_logo"));
		
		if(appLogoElement.isDisplayed()) {
			System.out.println("App Logo Displayed Successfully");
		}else {
			System.out.println("No app logo found");
		}
		
		Thread.sleep(3000);
		System.out.println("Wait for 3 sec splash screen");
		
		WebElement apptitleElement = driver.findElement(By.id("loginButton"));
		
		if(apptitleElement.isDisplayed()) {
			System.out.println("Successfully navigated to Login screen after 3 sec delay");
		}else {
			System.out.println("Not able to navigate to Login screen");
		}
		
		WebElement registerBtnElement = driver.findElement(By.id("registerBtn"));
		
		if(registerBtnElement.isDisplayed()) {
			System.out.println("Register button displayed");
		}else {
			System.out.println("No register button found");
		}
		
		registerBtnElement.click();
		
		Thread.sleep(2000);
		WebElement registerTextElement = driver.findElement(By.id("registerTitle"));
		
		if(registerTextElement.isDisplayed()) {
			System.out.println("Successfully navigated to registration screen");
		}else {
			System.out.println("Not able to navigate to register screen");
		}
		
		Thread.sleep(2000);
		WebElement usernameTextElement = driver.findElement(By.id("usernameEditText"));
		WebElement emailTextElement = driver.findElement(By.id("emailEditText"));
		WebElement passwordTextElement = driver.findElement(By.id("passwordEditText"));
		
		usernameTextElement.sendKeys("rahul");
		emailTextElement.sendKeys("rahul23@gmail.com");
		passwordTextElement.sendKeys("12345");
		System.out.println("Added the required details");

		if (driver instanceof AndroidDriver) {
		    ((AndroidDriver) driver).hideKeyboard();
		}

		
		Thread.sleep(1000);
		WebElement registerButtonElement = driver.findElement(By.id("registerButton"));
		if(registerButtonElement.isDisplayed()) {
			registerButtonElement.click();
			System.out.println("Click on register button");
		}
		
		Thread.sleep(2000);
		WebElement loginBtnElement = driver.findElement(By.id("usernameEditText"));
		
		if(loginBtnElement.isDisplayed()) {
			System.out.println("Registration Successfull, navigated to login page");
		}else {
			System.out.println("Not able to register");
		}
	}

}
