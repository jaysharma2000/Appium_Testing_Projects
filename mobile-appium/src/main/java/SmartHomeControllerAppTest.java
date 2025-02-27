import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

public class SmartHomeControllerAppTest {
	
	public static void main(String[] args) {
		try {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 8 Pro");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			capabilities.setCapability("appPackage", "com.example.mysmarthomecontrollerapp");
			capabilities.setCapability("appActivity", ".ui.MainActivity");
			
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
