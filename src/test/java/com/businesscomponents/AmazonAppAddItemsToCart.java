package com.businesscomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import junit.framework.Assert;


public class AmazonAppAddItemsToCart {
	AndroidDriver<AndroidElement> driver;
	AppiumDriverLocalService service;

	Properties prop = new Properties();
	FileInputStream fis;

	LoginPageObjects loginPageObjects;

	String expectedDescription,expectedPrice,actualDescription,actualPrice;
	
	@Before
	public void setUp() throws IOException {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		fis = new FileInputStream("Config.properties");

		prop.load(fis);
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,prop.getProperty("DEVICE_NAME"));
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,prop.getProperty("AUTOMATION_NAME"));
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,prop.getProperty("APP_PACKAGE")); 
		
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,prop.getProperty("APP_ACTIVITY"));
		
		driver = new AndroidDriver<AndroidElement>(new URL(prop.getProperty("AppiumServerURL")), capabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		loginPageObjects = new LoginPageObjects(driver);
		
}
	
	@Given("^User logged into Amazon mobile application$")//Function to login to the Amazon application
	public void user_logged_into_Amazon_mobile_application() throws InterruptedException{
		
		waitForObject(driver,6000, loginPageObjects.alreadyCustomer);
		
		loginPageObjects.alreadyCustomer.click();
		
		Thread.sleep(6000);
		

		waitForObject(driver,6000, loginPageObjects.enterEmailid);
		
		loginPageObjects.enterEmailid.sendKeys(prop.getProperty("emailId"));
		
		loginPageObjects.continueButton.click();
		
		waitForObject(driver,6000, loginPageObjects.enterPassword);
		
		loginPageObjects.enterPassword.sendKeys(prop.getProperty("password"));

		
		loginPageObjects.signIn.click();
		
		
		
	}
	

	
		
	@When("^User Search for item and add items to cart and purchase$") //search item in home page and add to cart
	public void user_Search_for_item_and_add_items_to_cart_and_purchase() throws InterruptedException{

		waitForObject(driver,6000, loginPageObjects.homePageSearch);
		
		Assert.assertTrue(loginPageObjects.homePageSearch!=null);
	
		loginPageObjects.homePageSearch.sendKeys(prop.getProperty("searchItem"));
		
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		
		searchForItem();
	   
		waitForObject(driver,6000, loginPageObjects.expectedDescription);	
	
		expectedDescription=loginPageObjects.expectedDescription.getText();
		
		expectedPrice=loginPageObjects.expectedPrice.getText();
	
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add to Cart\"));");
		
		loginPageObjects.addToCart.click();
		
		loginPageObjects.viewCart.click();
	
	}

	@Then("^compare the products information between product search screen and checkout screen$")//compare the price & product description between item search page and checkout page
	public void compare_the_products_information_between_product_search_screen_and_checkout_screen(){
		
		waitForObject(driver,6000, loginPageObjects.actualDescription);
		
		actualDescription=loginPageObjects.actualDescription.getText();
		
		actualPrice=loginPageObjects.actualPrice.getText(); 
		
		Assert.assertEquals("Comparing the item description in item search page and checkoutpage", expectedDescription, actualDescription);
		
		Assert.assertEquals("Comparing the item prices in item search page and checkoutpage", expectedPrice, actualPrice);
		
		
	}

	
	

	public static boolean waitForObject(AndroidDriver<AndroidElement> driver, int timeLimitInSeconds,
			AndroidElement element) {

		boolean isElementPresent;
		try {
			WebElement mobileElement;
			WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
			mobileElement = wait.until(ExpectedConditions.visibilityOf(element));
			isElementPresent = mobileElement.isDisplayed();
			return isElementPresent;
		} catch (Exception e) {
			isElementPresent = false;
			System.out.println(e.getMessage());
			return isElementPresent;
		}
	}
	
	public void searchForItem() throws InterruptedException //Search until the item is found
	{
		System.out.println("AswipeTest");
		
		boolean found=false;
		for(int i=0;i<10;i++)
		{
			try {
				
				
				driver.findElementByXPath("//android.view.View[@index='52']").click();
				found=true;
				break;
				
			} catch (Exception e) {
				verticalSwipeScreen();
			
			}
		}
	}
		public void verticalSwipeScreen() throws InterruptedException//Swipe mobile screen vertically
		{
			
			org.openqa.selenium.Dimension dm = driver.manage().window().getSize();
			int width  = dm.getWidth();
			int height = dm.getHeight();
			
			int x = (width/2);
			int startY = (int)(height*0.8);
			int endY = (int)(height*0.2);
			driver.swipe(x, startY, x, endY, 1000);
			Thread.sleep(5000);
		}
	
@After
public void tearDown() //Close the driver object and stop appium server.
{
	driver.quit();
	
	service.stop();
}

}
