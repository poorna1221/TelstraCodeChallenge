package com.supportlibraries;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ReusableLibraries extends BaseClass {

	/**
	 * wait for object existence. This is to wait for an object if application is
	 * responding slowly
	 */
	public boolean waitForObject(AndroidDriver<AndroidElement> driver, int timeLimitInSeconds, AndroidElement element) {

		boolean isElementPresent;
		try {
			MobileElement mobileElement;
			WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
			mobileElement = (MobileElement) wait.until(ExpectedConditions.visibilityOf(element));
			isElementPresent = mobileElement.isDisplayed();
			return isElementPresent;
		} catch (Exception e) {
			isElementPresent = false;
			System.out.println(e.getMessage());
			return isElementPresent;
		}
	}

	/**
	 * This function performs the click or sendkeys action on an object passed as an
	 * argument to this function
	 */
	public void actionOnObject(AndroidElement ele, String action, String actionString) {

		waitForObject(driver, 120, ele);

		if (action.equalsIgnoreCase("click")) {
			ele.click();
		} else if (action.equalsIgnoreCase("sendkeys")) {
			ele.sendKeys(actionString);
		}

	}

	/**
	 * This function return the text property of an an object
	 */
	public String getText(AndroidElement ele, String text) {

		waitForObject(driver, 120, ele);

		System.out.println(text + " is " + ele.getText());

		return ele.getText();

	}

	/**
	 * This function verifies if the object is available in the application or not
	 */
	public void verifyObjectExistense(AndroidElement anroidElement) {

		waitForObject(driver, 120, anroidElement);

		Assert.assertTrue(anroidElement != null);
	}

	/**
	 * This function compare the expected and actual values of and fails the test
	 * case if the expected and actual values values are not matching
	 */
	public void verifyExpectedActualValues(String expectedValue, String actualValue, String message) {

		Assert.assertEquals(message + "Expected Value is " + expectedValue + "Actual value is " + actualValue,
				expectedValue, actualValue);
	}

	/**
	 * This function is used to scroll to the element text provided as an argument
	 */
	public void scrollToElement(String stringText) {

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + stringText + "\"));");

	}
}
