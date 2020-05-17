package com.supportlibraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {
	static Properties prop = new Properties();
	static FileInputStream fis;
	public static AndroidDriver<AndroidElement> driver;

	public Properties loadConfigFile() throws IOException {

		fis = new FileInputStream("Config.properties");

		prop.load(fis);

		return prop;

	}

	public AppiumDriverLocalService startAppiumServer() {
		AppiumDriverLocalService service;

		service = AppiumDriverLocalService.buildDefaultService();

		service.start();

		return service;

	}

	public AndroidDriver<AndroidElement> initializeWebDriver() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DEVICE_NAME"));

		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("AUTOMATION_NAME"));

		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, prop.getProperty("APP_PACKAGE"));

		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, prop.getProperty("APP_ACTIVITY"));

		driver = new AndroidDriver<AndroidElement>(new URL(prop.getProperty("AppiumServerURL")), capabilities);

		return driver;

	}
}
