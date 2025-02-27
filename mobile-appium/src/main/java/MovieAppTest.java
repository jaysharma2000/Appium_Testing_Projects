import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class MovieAppTest {
	
	public static void main(String[] args) {
		
		try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Xiaomi Redmi Note 8 Pro");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability("appPackage", "com.example.mymovieapp");
            capabilities.setCapability("appActivity", ".MainActivity");

            AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//            WebElement firstTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Moana 2']"));
//            firstTitle.click();
//
//            WebElement discElement = driver.findElement(By.id("overviewTextView"));
//            System.out.println("Movie Description: " + discElement.getText());
//            
            
        	
        	//using RecyclerView
            
//        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.example.recyclerviewapp:id/recyclerView")));
//        	
        	
        	String targetItem = "Lucca's World";
        	boolean itemFound = false;
        	
        	for (int i = 0; i < 5; i++) {
        	    
        	    List<WebElement> listItems = driver.findElements(MobileBy.id("movieTitleTextView"));
        	
        	    for (WebElement item : listItems) {
        	        
        	        if (item.getText().equals(targetItem)) {
        	        	System.out.println("Item Found: " + item.getText());
        	            item.click();
        	            itemFound = true;
        	            System.out.println("Clicked on: " + targetItem);
        	            break;
        	        }
        	    }
        	
        	    if (itemFound) break;
        	
        	    
        	    // Scroll RecyclerView
//        	    driver.executeScript("mobile: scrollGesture", 
//        	        new java.util.HashMap<String, Object>() {{
//        	            put("direction", "down");
//        	            put("elementId", driver.findElement(MobileBy.id("com.example.recyclerviewapp:id/recyclerView")).getAttribute("resourceId"));
//        	        }})
        	    driver.findElement(MobileBy.AndroidUIAutomator(
        	    	    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
        	    	    + "new UiSelector().text(\"" + targetItem + "\"));"));

        	}
        	if(itemFound == false) {
        		System.out.println("The target movie not found");
        	}
        	WebElement titleElement = driver.findElement(By.id("titleTextView"));
        	WebElement discElement = driver.findElement(By.id("overviewTextView"));
        	WebElement imageElement = driver.findElement(By.id("posterImageView"));
        	if(imageElement.isDisplayed()) {
        		System.out.println("Image displayed Successfully");
        	}else {
        		System.out.println("No image found");  
        	}
        	
        	System.out.println("Movie Title Displayed, Title: " + titleElement.getText());
            System.out.println("Movie Description: " + discElement.getText());
            
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
}
}