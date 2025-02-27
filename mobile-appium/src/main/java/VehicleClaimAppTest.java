import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class VehicleClaimAppTest {
	
	public static void main(String[] args) {
		
	try {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 8 Pro");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability("appPackage", "com.example.vehicleinsuranceclaimapp");
		capabilities.setCapability("appActivity", ".MainActivity");
		
		AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement beginButtonElement = driver.findElement(By.id("beginButton"));
		
		beginButtonElement.click();
		
		WebElement firstTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Welcome Back!']"));
		
		if(firstTitle.getText().equals("Welcome Back!")) {
			System.out.println("Successfully navigated to Login Page");
		}
		
		WebElement registerButtonElement = driver.findElement(By.id("registerBtn"));
		registerButtonElement.click();
		
		WebElement registerTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Register']"));
		
		if(registerTitle.getText().equals("Register")) {
			System.out.println("Successfully navigated to Register Page");
		}
		
		WebElement registerUsernameField = driver.findElement(By.xpath("//android.widget.EditText[@hint='enter the username']"));
		WebElement registerEmailField = driver.findElement(By.xpath("//android.widget.EditText[@hint='enter your email']"));
		WebElement registerPasswordField = driver.findElement(By.xpath("//android.widget.EditText[@hint='enter your password']"));
		WebElement createAccountElement = driver.findElement(By.id("registerButton"));
		
		registerUsernameField.sendKeys("jaysharma");
		registerEmailField.sendKeys("jaysharma@gmail.com");
		registerPasswordField.sendKeys("12345");
		createAccountElement.click();
		
		System.out.println("Registration Successfull!");
		
		WebElement loginUsernameField = driver.findElement(By.xpath("//android.widget.EditText[@hint='Username']"));
		WebElement loginPasswordField = driver.findElement(By.xpath("//android.widget.EditText[@hint='Password']"));
		WebElement loginButtonElement = driver.findElement(By.id("loginButton"));
		
		loginUsernameField.sendKeys("jaysharma");
		loginPasswordField.sendKeys("12345");
		
		loginButtonElement.click();
		
		WebElement startClaimButtonElement = driver.findElement(By.id("startClaim"));
		
		if(startClaimButtonElement.isDisplayed()) {
			System.out.println("Login successfull!");
			System.out.println("Navigated to the dashboard page");
		}
		
		
		WebElement yourPoliciesButtonElement = driver.findElement(By.id("myPolicies"));
		
		yourPoliciesButtonElement.click();
		
		WebElement addPolicyTextElement = driver.findElement(By.xpath("//android.widget.TextView[@text='Add Policy']"));
		
		if(addPolicyTextElement.isDisplayed()) {
			System.out.println("Navigated to add policy page");
		}
		
		WebElement vehicleTypeFieldElement = driver.findElement(By.xpath("//android.widget.EditText[@hint='Vehicle Type']"));
		WebElement vehicleNumberFieldElement = driver.findElement(By.xpath("//android.widget.EditText[@hint='Vehicle Number']"));
		WebElement savePolicyElement  = driver.findElement(By.id("savePolicyButton"));
		
		vehicleTypeFieldElement.sendKeys("Four Wheeler");
		vehicleNumberFieldElement.sendKeys("MADH2523K");
		savePolicyElement.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     WebElement addedPolicy = driver.findElement(By.id("tvVehicleNumber"));
	     
	     if(addedPolicy.isDisplayed()) {
	    	 System.out.println("Added Vehicle Number: " + addedPolicy.getText());
	    	 System.out.println("Policy added successfully");
	     }else {
	    	 System.out.println("Policy not found in RecyclerView!");
	     }
	     
	     driver.navigate().back();
	     System.out.println("back navigation to dashboard page completed.");
	     
	     WebElement startClaimButton = driver.findElement(By.id("startClaim"));
	     startClaimButton.click();
	     System.out.println("Clicked on start claim button");
	     


	     //testing the alertbox 
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	     WebElement permissionAlert = driver.findElement(
	    		    By.xpath("//android.widget.TextView[contains(@text, 'Allow')]")
	    		);
	     
	     if (permissionAlert.isDisplayed()) {
	    	    System.out.println("Permission alert is displayed");

	    	    WebElement allowWhileUsingApp = driver.findElement(
	    	        By.xpath("//android.widget.Button[contains(@text, 'WHILE USING THE APP')]"));
	    	        allowWhileUsingApp.click();
	    	        System.out.println("Permission Granted");
	    	} else {
	    	    System.out.println("Permission alert not found!");
	    	}
	     
	     //submit claim testing
	     
	     WebElement claimDescriptionEditTextElement = driver.findElement(By.id("claimDiscription"));
	     
	     claimDescriptionEditTextElement.sendKeys("This claim is about the four wheeler");
	     System.out.println("The claim discription provided: " + claimDescriptionEditTextElement.getText());
	     
	     WebElement previewElement = driver.findElement(By.id("previewView"));
	     if(previewElement.isDisplayed()) {
	    	 System.out.println("The preview for capturing image is ON");
	     }else {
	    	 System.out.println("No preview available");
	     }
	     
	     WebElement captureButtonElement  = driver.findElement(By.id("captureButton"));
	     captureButtonElement.click();
	     System.out.println("Image captured successfully");
	     
	     Thread.sleep(5000);
	     
	     WebElement submitclaimButtonElement = driver.findElement(By.id("submitClaim"));
	     if(submitclaimButtonElement.isDisplayed()) {
	    	 submitclaimButtonElement.click();
	    	 System.out.println("Click on submit claim button");
	     }else {
	    	 System.out.println("Submit claim button not found");
	     }
	     
	     Thread.sleep(5000);
	     
	     WebElement submitclaimAlertBoxElement = driver.findElement(By.id("dialogTitle"));
	     if(submitclaimAlertBoxElement.isDisplayed()) {
	    	 System.out.println("The submit claim alert box displayed");
	     }
	     
	     WebElement alertBoxConfirmButtonElement = driver.findElement(By.id("confirmButton"));
         alertBoxConfirmButtonElement.click();
         System.out.println("Clicked on confirm button");
         System.out.println("Successfully submitted the claim");

	     
	     		
		driver.quit();
		
	}catch(Exception e) {
		e.printStackTrace();
   }
	
  }
}



//List accessing elements
//		List<WebElement> listItems = driver.findElements(MobileBy.className("android.widget.TextView")); 
//		
//		for (WebElement item : listItems) {           
//			System.out.println("List Item: " + item.getText()); 
//		}

//	
//	//Wait for RecyclerView to load
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.example.recyclerviewapp:id/recyclerView")));
//	
	// Scroll and find the element by text
//	String targetItem = "Item 30";
//	boolean itemFound = false;
//	
//	for (int i = 0; i < 5; i++) {
//	    // Get all visible list items
//	    List<WebElement> listItems = driver.findElements(MobileBy.id("com.example.recyclerviewapp:id/textView"));
//	
//	    for (WebElement item : listItems) {
//	        System.out.println("Item Found: " + item.getText());
//	        if (item.getText().equals(targetItem)) {
//	            item.click();
//	            itemFound = true;
//	            System.out.println("Clicked on: " + targetItem);
//	            break;
//	        }
//	    }
//	
//	    if (itemFound) break;
//	
//	    // Scroll RecyclerView
//	    driver.executeScript("mobile: scrollGesture", 
//	        new java.util.HashMap<String, Object>() {{
//	            put("direction", "down");
//	            put("elementId", driver.findElement(MobileBy.id("com.example.recyclerviewapp:id/recyclerView")).getId());
//	        }});
//	}
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	import io.appium.java_client.MobileBy;
//	import io.appium.java_client.android.AndroidDriver;
//	import io.appium.java_client.remote.MobileCapabilityType;
//	import org.openqa.selenium.WebElement;
//	import org.openqa.selenium.remote.DesiredCapabilities;
//	import java.net.URL;
//	import java.util.List;
//	
//	public class MovieAppTest {
//	 
//	    public static void main(String[] args) {
//	        try {
//	            DesiredCapabilities capabilities = new DesiredCapabilities();
//	            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//	            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Your_Device_Name");
//	            capabilities.setCapability("app", "path/to/your/app.apk");
//	 
//	            AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//	 
//	            // Wait for the RecyclerView to load
//	            Thread.sleep(3000);
//	 
//	            // Click on the first movie item in the RecyclerView
//	            List<WebElement> movieItems = driver.findElements(MobileBy.className("android.widget.TextView"));
//	            if (!movieItems.isEmpty()) {
//	                movieItems.get(0).click();
//	            }
//	 
//	            // Wait for the details screen
//	            Thread.sleep(2000);
//	 
//	            // Verify movie details
//	            WebElement movieTitle = driver.findElement(MobileBy.id("com.example.movieapp:id/movieTitle"));
//	            System.out.println("Movie Title: " + movieTitle.getText());
//	 
//	            WebElement movieDescription = driver.findElement(MobileBy.id("com.example.movieapp:id/movieDescription"));
//	            System.out.println("Movie Description: " + movieDescription.getText());
//	 
//	            // Close the driver
//	            driver.quit();
//	 
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	    }
//	}
//	
//	
