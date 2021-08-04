 package mobileapppages;


import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import utilities.Common;
import utilities.Data;
import utilities.GlobalKeys;

public class TreatApplicationpage extends Common{
	public  static AppiumDriver<WebElement> driver=null;

	private Data data;
	
	public TreatApplicationpage(Data data){
		this.data = data;
	}

	public TreatHomePage setUp(String platformName, String platFormVersion){
		try {
			String strExecutionEnvironment = GlobalKeys.configData.get("ExecutionEnvironment");
			String deviceName = GlobalKeys.configData.get("DeviceName");
			String paltformName = GlobalKeys.configData.get("PlatFormName");			
			String accesskey = GlobalKeys.configData.get("AccessKey");
			String username = GlobalKeys.configData.get("Username");
			String Sauceurl = GlobalKeys.configData.get("Sauceurl");
			String IPAFileName = GlobalKeys.configData.get("IPAFileName");
			String AndroidFileName = GlobalKeys.configData.get("AndroidFileName");
			if(strExecutionEnvironment.trim().contains("RealDevice")){
			/*	String bundleId = "com.ddthrivent.dev";
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability("deviceName", "iphone Sun");
				dc.setCapability("udid", "auto");
				dc.setCapability("platformName", platformName);
				dc.setCapability("platVersion", platFormVersion);
				dc.setCapability("bundleId",  bundleId);  
		        dc.setCapability("xcodeOrgId", "LJ44QB69J7");
				dc.setCapability("xcodeSigningId", "iPhone Developer");
				dc.setCapability("automationName", "XCUITest");
				driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc); */
				
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability("deviceName", "RedmiK20pro");
				dc.setCapability("udid", "d015a208");
				dc.setCapability("platformName", "Android");
				dc.setCapability("platVersion", "11");
				dc.setCapability("noReset", "true");
				dc.setCapability("appPackage", "com.xpresspa.treatmobile.qa");
				dc.setCapability("appActivity", "com.xpresspa.treatmobile.ui.activities.splash.SplashActivity");
				dc.setCapability("skipDeviceInitialization", true);
				dc.setCapability("skipServerInstallation", true);
				URL url = new URL("http://127.0.0.1:4723/wd/hub");
				driver = new AndroidDriver<>(url, dc);
				
			}else{		
				if(platformName.trim().equalsIgnoreCase("iphone")) {
					MutableCapabilities capabilities = new MutableCapabilities();
					capabilities.setCapability("idleTimeout", GlobalKeys.configData.get("idleTimeOut"));
					capabilities.setCapability("noReset", "false");
					capabilities.setCapability("newCommandTimeout", GlobalKeys.configData.get("newCommandTimeout"));
					capabilities.setCapability("language", "en");
					capabilities.setCapability("platformName", "iOs");
					capabilities.setCapability("deviceName", platformName + " " + platFormVersion);
					capabilities.setCapability("name", "AutomationRun_"+ GlobalKeys.timeStamp);
					//capabilities.setCapability("name", "AutomationRun_"+ GlobalKeys.timeStamp);
		
					capabilities.setCapability("app", "storage:filename=" + IPAFileName);
	//				capabilities.setCapability("app", "storage:CFBundleVersion=391" + IPAFileName);
		
					driver = new IOSDriver(
							new URL("https://" + username + ":" +
									accesskey +
									"@"+Sauceurl+"/wd/hub"),
							capabilities);
				}else{
					MutableCapabilities capabilities = new MutableCapabilities();
					capabilities.setCapability("idleTimeout", GlobalKeys.configData.get("idleTimeOut"));
					capabilities.setCapability("noReset", "false");
					capabilities.setCapability("newCommandTimeout", GlobalKeys.configData.get("newCommandTimeout"));
				//	capabilities.setCapability("language", "en");
					capabilities.setCapability("platformName", "Android");
					capabilities.setCapability("deviceName", platformName);
					capabilities.setCapability("name", "AutomationRun_"+ GlobalKeys.timeStamp);
					//capabilities.setCapability("name", "AutomationRun_"+ GlobalKeys.timeStamp);
		
					capabilities.setCapability("app", "storage:filename=" + AndroidFileName); 
	//				capabilities.setCapability("app", "storage:CFBundleVersion=391" + IPAFileName);
		
					driver = new AndroidDriver(
							new URL("https://" + username + ":" +
									accesskey +
									"@"+Sauceurl+"/wd/hub"),
							capabilities);
				}
				
				
			}
			GlobalKeys.driver = driver;
		} catch (Exception e) {
			failAssert("Unable to launch application in Sauce Labs, Exception is : "+e.getMessage());
		}
		return new TreatHomePage(driver,data);
	}


	public void tearDown(String name){
		try {
//			File traceZip = new File(GlobalKeys.outputDirectory + "/perf"+name+".trace.zip");
//			HashMap<String, Object> args = new HashMap<>();
//			args.put("profileName", "Time Profiler");
//			String b64Zip = driver.execute("mobile: stopPerfRecord", args);
//			byte[] bytesZip = Base64.getMimeDecoder().decode(b64Zip);
//			FileOutputStream stream = new FileOutputStream(traceZip);
//			stream.write(bytesZip);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		driver.quit();
		driver.close();


	}


}

