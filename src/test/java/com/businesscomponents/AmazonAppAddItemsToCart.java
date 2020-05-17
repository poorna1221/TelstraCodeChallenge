package com.businesscomponents;

import java.io.IOException;
import java.util.Properties;

import com.pages.LoginPageObjects;
import com.supportlibraries.ReusableLibraries;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AmazonAppAddItemsToCart extends ReusableLibraries {

	AndroidDriver<AndroidElement> driver;

	AppiumDriverLocalService service;

	Properties prop;

	LoginPageObjects loginPageObjects;

	String expectedDescription, expectedPrice, actualDescription, actualPrice;

	@Before
	public void setUp() throws IOException {

		prop = loadConfigFile();

		service = startAppiumServer();

		driver = initializeWebDriver();

		loginPageObjects = new LoginPageObjects(driver);

	}

	/**
	 * As the function name describes this function is used to login to the amazon
	 * mobile application
	 */
	@Given("^User logged into Amazon mobile application$") // Function to login to the Amazon application
	public void user_logged_into_Amazon_mobile_application() {

		actionOnObject(loginPageObjects.alreadyCustomer, "click", "Already a customer Signin");

		actionOnObject(loginPageObjects.enterEmailid, "sendkeys", prop.getProperty("emailId"));

		actionOnObject(loginPageObjects.continueButton, "click", "continueButton");

		actionOnObject(loginPageObjects.enterPassword, "sendkeys", prop.getProperty("password"));

		actionOnObject(loginPageObjects.signIn, "click", "signInButton");
	}

	/**
	 * As the function name describes this function search for an item in home page
	 * and clicks on add to cart button
	 */
	@When("^User Search for item and add items to cart and purchase$")
	public void user_Search_for_item_and_add_items_to_cart_and_purchase() {

		verifyObjectExistense(loginPageObjects.homePageSearch);

		actionOnObject(loginPageObjects.homePageSearch, "sendkeys", prop.getProperty("searchItem"));

		driver.pressKeyCode(AndroidKeyCode.ENTER);

		searchForItem();

		expectedDescription = getText(loginPageObjects.expectedDescription, "ExpectedDescription");

		expectedPrice = getText(loginPageObjects.expectedPrice, "ExpectedPrice");

		scrollToElement("Add to Cart");

		actionOnObject(loginPageObjects.addToCart, "click", "addToCart");

		actionOnObject(loginPageObjects.viewCart, "click", "viewCart");

	}

	/**
	 * This function compares item price & description between item search and
	 * checkout pages
	 */
	@Then("^compare the products information between product search screen and checkout screen$")
	public void compare_the_products_information_between_product_search_screen_and_checkout_screen() {

		actualDescription = getText(loginPageObjects.actualDescription, "ActualDescription");

		actualPrice = getText(loginPageObjects.actualPrice, "ActualPrice");

		verifyExpectedActualValues(expectedDescription, actualDescription, "Item description");

		verifyExpectedActualValues(expectedPrice, actualPrice, "Item Prices");

	}

	/**
	 * This function searches for an item in home page
	 */
	public void searchForItem()// Search until the item is found
	{

		for (int i = 0; i < 10; i++) {
			try {

				driver.findElementByXPath("//android.view.View[@index='45']").click();

				break;

			} catch (Exception e) {

				verticalSwipeScreen();

			}
		}
	}

	/**
	 * This function performs the vertical swipe of screen
	 */
	public void verticalSwipeScreen()// Swipe mobile screen vertically
	{
		org.openqa.selenium.Dimension dm = driver.manage().window().getSize();

		int width = dm.getWidth();

		int height = dm.getHeight();

		int x = (width / 2);

		int startY = (int) (height * 0.8);

		int endY = (int) (height * 0.2);

		driver.swipe(x, startY, x, endY, 1000);

	}

	/**
	 * This function closes the driver object This functions stops the android
	 * service
	 */
	@After
	public void tearDown() // Close the driver object and stop appium server.
	{
		driver.quit();

		service.stop();
	}

}
