import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class RecipeListFragmentTest {

	private AppiumDriver driver;
	
	@Before
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Xiaomi Redmi Not 8 Pro");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability("appPackage", "com.example.finalmilestone");
		capabilities.setCapability("appActivity", "com.example.finalmilestone.ui.MainActivity");
		driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
	}
	
	@Test
	public void recipeListTest() throws InterruptedException {
		
		WebElement categoriesrecyclerViewElement = driver.findElement(By.id("recyclerview"));
		
		if(categoriesrecyclerViewElement.isDisplayed()) {
			System.out.println("categories RecyclerViewElement is visible");
		}
		
		
		List<WebElement> categoryTextViewElement = driver.findElements(By.id("categoryTextView"));
		
		if(categoryTextViewElement.size() == 4) {
			System.out.println("All categories displayed");
		}
		
		categoriesrecyclerViewElement.click();
		System.out.println("Navigated to the recipe list screen ");
		
		//recipeList Testing start
		
		WebElement categoriesrecyclerViewElement2 = driver.findElement(By.id("recyclerview"));
		
		if(categoriesrecyclerViewElement2.isDisplayed()) {
			System.out.println("categories RecyclerViewElement is visible");
		}
		
		
		WebElement titleTextViewElement = driver.findElement(By.id("titleTextView"));
		
		if(titleTextViewElement.isDisplayed()) {
			System.out.println("Recipes title displayed");
		}
		
		WebElement recipeImageViewElement = driver.findElement(By.id("recipeImageView"));
		
		if(recipeImageViewElement.isDisplayed()) {
			System.out.println("Recipe Image displayed");
		}
		
		
		titleTextViewElement.click();
		System.out.println("navigated to the recipe details screen ");
	}
	
	@After
    public void tearDown() {
   	 if(driver != null) {
   		 driver.quit();
   	 }
    }

}
