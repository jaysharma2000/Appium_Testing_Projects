import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class RegisterAndLoginScreenTest {
	private AppiumDriver driver;
    
    public RegisterAndLoginScreenTest(AppiumDriver driver) {
        this.driver = driver;
    }
    
    public void performLoginScreenTest() throws InterruptedException{
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
		
		WebElement usernameTextElement2 = driver.findElement(By.id("usernameEditText"));
		WebElement passwordTextElement2 = driver.findElement(By.id("passwordEditText"));
		WebElement  loginButtonElement2 = driver.findElement(By.id("loginButton"));
		
		if(usernameTextElement2.isDisplayed() && passwordTextElement2.isDisplayed() && loginButtonElement2.isDisplayed()) {
			usernameTextElement2.sendKeys("rahul");
			passwordTextElement2.sendKeys("12345");
			System.out.println("Login details filled");
			
			if (driver instanceof AndroidDriver) {
			    ((AndroidDriver) driver).hideKeyboard();
			}
			
		}else {
			System.out.println("Login not possible");
		}
		
		loginButtonElement2.click();
		System.out.println("Clicked on login button");
		
		Thread.sleep(2000);
		
		WebElement dashBoardTitlElement = driver.findElement(By.id("dashboardTitle"));
		
		if(dashBoardTitlElement.isDisplayed()) {
			System.out.println("Login Successfull, navigated to dashboard page");
		}else {
			System.out.println("Login failed!");
		}
    }

}
