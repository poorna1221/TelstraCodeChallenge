package com.supportlibraries;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class BasePage {
	
	WebDriver driver;
	public BasePage(AppiumDriver<AndroidElement> driver) {
	{
		this.driver = driver;

	}
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
}
