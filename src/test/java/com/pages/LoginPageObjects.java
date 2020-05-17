package com.pages;

import org.openqa.selenium.WebDriver;

import com.supportlibraries.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPageObjects extends BasePage {

	@SuppressWarnings("unchecked")
	public LoginPageObjects(WebDriver driver) {
		super((AppiumDriver<AndroidElement>) driver);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Already a customer? Sign in']")
	public AndroidElement alreadyCustomer;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='ap_email_login']")
	public AndroidElement enterEmailid;

	@AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
	public AndroidElement continueButton;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='ap_password']")
	public AndroidElement enterPassword;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='signInSubmit']")
	public AndroidElement signIn;

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
	public AndroidElement skipSignin;

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	public AndroidElement homePageSearch;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Add to Cart']")
	public AndroidElement addToCart;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Basket']")
	public AndroidElement viewCart;

	@AndroidFindBy(className = "android.view.View")
	public AndroidElement checkoutPageProduct;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='title_feature_div']//android.view.View[@index='1']")
	public AndroidElement expectedDescription;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='priceblock_ourprice']")
	public AndroidElement expectedPrice;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='activeCartViewForm']//android.view.View[@index='2']//android.view.View[@index='1']/android.view.View[@index='0']//android.view.View[@index='2']/android.view.View[@index='0']")
	public AndroidElement actualDescription;

	@AndroidFindBy(xpath = "//android.widget.ListView[@index='1']//android.view.View[@index='0']")
	public AndroidElement actualPrice;

}
