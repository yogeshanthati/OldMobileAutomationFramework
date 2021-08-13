package testcases;


import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import mobileapppages.TreatApplicationpage;
import mobileapppages.TreatHomePage;
import mobileapppages.TreatApplicationpage;
import utilities.Common;
import utilities.Data;

@Listeners({ utilities.TestListener.class })
public class TestCases extends Common {

	public static int count = 1;
	private TreatApplicationpage Applicationpage;
	private mobileapppages.TreatHomePage TreatHomePage;
	public Data data;
	public ArrayList<String> datasets;
	
	
	@BeforeMethod
	public void testStart(Method method) {		
		String name = method.getName();
		data = new Data("TestData"); 
		datasets = data.getDataSets(name);		
	}
	
	@Test // done
	@Parameters({"selenium.deviceName","selenium.PlatformName","selenium.PlatformVersion"})
	public void MOB_TC001_LogIntoTreatApp(String deviceName,String platformName,String platFormVersion) {
		String strName = new Exception().getStackTrace()[0].getMethodName();
		data.setColIndex(strName);
		for (String dataset : datasets) {      			
			data.setIndex(dataset);
			datasetStart(dataset);		
			Applicationpage = new TreatApplicationpage(data);
			TreatHomePage = Applicationpage.setUp(platformName,platFormVersion);
			TreatHomePage.SignInToApp();
			datasetEnd();
		}
	}
	
	
}
