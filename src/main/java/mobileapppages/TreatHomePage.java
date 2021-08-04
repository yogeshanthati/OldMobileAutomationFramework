package mobileapppages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseclass.AppPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import pagemethods.Page;
import utilities.Data;
import utilities.Util;

public class TreatHomePage extends AppPage {
	private static final String WebElement = null;
	protected TreatHomePage(AppiumDriver<WebElement> driver,Data data) {
		super(driver,data);
	}

	private Page page;
		
	@AndroidFindBy(id="com.xpresspa.treatmobile.qa:id/login_button")
	@iOSXCUITFindBy(accessibility = "Sign In")
	private MobileElement btnSignInSplashScreen;
	
	@AndroidFindBy(id="com.xpresspa.treatmobile.qa:id/edit_email")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=Email Address']")
	private MobileElement txtEmailAddress;

	@AndroidFindBy(id="com.xpresspa.treatmobile.qa:id/edit_password")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Password']")
	private MobileElement txtPassword;

	@AndroidFindBy(id="com.xpresspa.treatmobile.qa:id/btn_login")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Sign In']")
	private MobileElement btnSignIn;

	@AndroidFindBy(id="com.xpresspa.treatmobile.qa:id/myAccountFragment")
	@iOSXCUITFindBy(xpath = "*****")
	private MobileElement btnMyAccount;
	
	@AndroidFindBy(id="com.xpresspa.treatmobile.qa:id/tv_sign_out")
	@iOSXCUITFindBy(xpath = "*****")
	private MobileElement btnSignOut;



	public void SignInToApp() {

		try {
			waitForElement(btnSignInSplashScreen);
			clickOn(btnSignInSplashScreen, "Sign In Button");
			takeScreenshot(driver);
			enterText(txtEmailAddress, "EmailAddress",  data.get("UserName"));
			//hidekeyboard();
			enterText(txtPassword, "Password",  data.get("Password"));
			//hidekeyboard();
			takeScreenshot(driver);
			clickOn(btnSignIn, "Sign In Button");
			
			waitForElement(btnMyAccount);
			
			if(isElementPresent(btnMyAccount)) {
				
				passed("Successfully Navigated To Discover Page");
				
				takeScreenshot(driver);
				SingOutApp();
			}
			else {
				failed(driver,"Failed to Navigate To Discover Page");
			}
		} catch (Exception e) {
			failed(driver,"Exception caught while logging in " + e.getMessage());
		}
		
	

	}

	
	public void SingOutApp() {
		
		waitForElement(btnMyAccount);
		
		if(isElementPresent(btnMyAccount)) {
			
			clickOn(btnMyAccount, "My Account button");
			
			takeScreenshot(driver);

			waitForElement(btnSignOut);
			
			if(isElementPresent(btnSignOut)) {
			
				clickOn(btnSignOut, "Sign out button");
				
				takeScreenshot(driver);
				
				if(isElementPresent(btnSignInSplashScreen)) {
					
					passed("User Successfully Logged out From the account");
				}
				else {
					failed(driver,"User Failed to Log out from the account");
				}
			}
			else {
				failed(driver,"User Failed to Locate SignOut button");
			}
			
			
		}
		else {
			failed(driver,"User Failed to Locate from the My Account button");
		}
		
	}
}









