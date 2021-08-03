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
	@AndroidFindBy(xpath="//*[@text='User ID or Email']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@value,'User ID or Email')]")
	private MobileElement txtUserID;

	@AndroidFindBy(id="com.ddthrivent.devqa:id/et_password")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[contains(@value,'Password')]")
	private MobileElement txtPassword;

	@AndroidFindBy(xpath="//*[@text='SIGN IN']")
	@iOSXCUITFindBy(xpath = "//*[@name='SIGN IN']")
	private MobileElement btnSignIn;




	public void SignInToApp() {

		try {
			//			passed( "**********************************************"+ data.get("UserName")+""+ data.get("Password")+"***********************************");

			waitForElement(txtUserID);
			enterText(txtUserID, "User ID",  data.get("UserName"));
			hidekeyboard();
			enterText(txtPassword, "Password",  data.get("Password"));
			hidekeyboard();
			takeScreenshot(driver);
			clickOn(btnSignIn, "Sign In Button");
		} catch (Exception e) {
			failed(driver,"Exception caught while logging in " + e.getMessage());
		}

	}

	
	public void SingOutApp() {
		
		
	}
}









