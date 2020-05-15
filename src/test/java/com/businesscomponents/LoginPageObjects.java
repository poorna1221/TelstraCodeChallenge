package com.businesscomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPageObjects extends BasePage{

	public LoginPageObjects(WebDriver driver) {
		super((AppiumDriver<AndroidElement>) driver);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;

	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Already a customer? Sign in']")
	AndroidElement alreadyCustomer ;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='ap_email_login']")
	AndroidElement enterEmailid ;
	
	@AndroidFindBy(xpath="//android.widget.Button[@index='0']")
	AndroidElement continueButton ;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='ap_password']")
	AndroidElement enterPassword ;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='signInSubmit']")
	AndroidElement signIn ;

	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/skip_sign_in_button")
	AndroidElement skipSignin ;
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/rs_search_src_text")
	AndroidElement homePageSearch ;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Add to Cart']")
	AndroidElement addToCart ;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='Basket']")
	AndroidElement viewCart ;
	

	@AndroidFindBy(className="android.view.View")
	AndroidElement checkoutPageProduct ;
	
	

	@AndroidFindBy(xpath="//android.view.View[@resource-id='title_feature_div']//android.view.View[@index='1']")
	AndroidElement expectedDescription ;
	
	@AndroidFindBy(xpath="//android.view.View[@resource-id='priceblock_ourprice']")
	AndroidElement expectedPrice ;
	
	@AndroidFindBy(xpath="//android.view.View[@resource-id='activeCartViewForm']//android.view.View[@index='2']//android.view.View[@index='1']/android.view.View[@index='0']//android.view.View[@index='2']/android.view.View[@index='0']")
	AndroidElement actualDescription ;
	
	@AndroidFindBy(xpath="//android.widget.ListView[@index='1']//android.view.View[@index='0']")
	AndroidElement actualPrice ;
	
	
}
