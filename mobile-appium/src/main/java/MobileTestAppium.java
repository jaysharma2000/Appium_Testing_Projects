import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileTestAppium {
	
   public static void main(String[] args) throws MalformedURLException{
	
	   DesiredCapabilities capabilities = new DesiredCapabilities();
	   capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	   capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Xiaomi Redmi Note 8 Pro");
	   capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	   capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	   
	   AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
	   
	   try {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		driver.get("https://developer.android.com/studio?gad_source=1&gclid=CjwKCAiA2JG9BhAuEiwAH_zf3q3Id1w798FLm2JS7ltZQpu31TZ1zLcHMEFchseLaajVWYVGA6ZtFhoC-84QAvD_BwE&gclsrc=aw.ds");
		
		WebElement h2Element = driver.findElement(By.id("android-studio"));
		System.out.println("The HeadLine - " + h2Element.getText());
		
		WebElement firstPTagElement = driver.findElement(By.xpath("//div[@class='devsite-landing-row-item-description-content']/p[1]"));
		System.out.println("The discription: "+ firstPTagElement.getText());
		
		WebElement tryComposeButtonElement = driver.findElement(By.xpath("//a[contains(text(), 'Design with Compose')]"));
		
		tryComposeButtonElement.click();
		
		System.out.println("Second Page Title: " + driver.getTitle());
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		driver.quit();
	}
}
}
