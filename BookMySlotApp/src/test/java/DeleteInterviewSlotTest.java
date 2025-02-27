import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DeleteInterviewSlotTest {

private AppiumDriver driver;
	
	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Xiaomi Redmi Not 8 Pro");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability("appPackage", "com.example.bookmyslot");
		capabilities.setCapability("appActivity", "com.example.bookmyslot.ui.MainActivity");
		driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
	}
	
	public void swipeLeft() {
		PointerInput finger  = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence swipe = new Sequence(finger, 0);
		
		swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 900, 1000));
	    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	    swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 100, 1000));
	    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    driver.perform(Arrays.asList(swipe));
	}

	@Test
	public void addinterviewSlotTest() throws InterruptedException{
		RegisterAndLoginScreenTest loginScreenTestCommon = new RegisterAndLoginScreenTest(driver);
		loginScreenTestCommon.performLoginScreenTest();
		
		WebElement addInterviewSlotbutton = driver.findElement(By.id("addInterviewSlot"));
		
		if(addInterviewSlotbutton.isDisplayed()) {
			addInterviewSlotbutton.click();
			System.out.println("Navigated to the add interview screen");
		}else {
			System.out.println("No add interview button found");
		}
		
		WebElement interviewNameEditText = driver.findElement(By.id("interviewNameEditText"));
		WebElement designationEditText = driver.findElement(By.id("designationEditText"));
		
		if(interviewNameEditText.isDisplayed() && designationEditText.isDisplayed()) {
			interviewNameEditText.sendKeys("Jaykumar Sharma");
			designationEditText.sendKeys("Senior Software Developer");
		}
		
		
		WebElement selectDateButton = driver.findElement(By.id("selectDateButton"));
		WebElement selectTimeButton = driver.findElement(By.id("selectTimeButton"));
		
		selectDateButton.click();
		 WebElement okButton = driver.findElement(By.xpath("//android.widget.Button[@text='OK']"));

		okButton.click();
		System.out.println("Date selected");
		
		Thread.sleep(2000);
		
		selectTimeButton.click();
		Thread.sleep(1000);
		
		WebElement okButtonTime = driver.findElement(By.xpath("//android.widget.Button[@text='OK']"));
		okButtonTime.click();
		
		
		WebElement addSlotButton = driver.findElement(By.id("addSlotButton"));
		if(addSlotButton.isDisplayed()) {
			addSlotButton.click();
		}
		
		Thread.sleep(2000);
		System.out.println("Interview Slot added successfully");
		
		Thread.sleep(2000);
		
		WebElement viewInterviewSlot = driver.findElement(By.id("viewInterviewSlot"));
		if(viewInterviewSlot.isDisplayed()) {
			viewInterviewSlot.click();
			System.out.println("Clicked on view interview slot and navigated to the view slots screen");
		}
		
		WebElement designationTextView = driver.findElement(By.id("designationTextView"));
		
		if(designationTextView.isDisplayed()) {
			swipeLeft();
			System.out.println("Swipe done");
			System.out.println("The interview slot deleted");
	        Thread.sleep(2000);
		}
	}
}
