package com.supportlibraries;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

@SuppressWarnings("rawtypes")
public abstract class BasePage {

	AndroidDriver driver;

	public BasePage(AppiumDriver<AndroidElement> driver) {
		{
			this.driver = (AndroidDriver) driver;

		}
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

}
