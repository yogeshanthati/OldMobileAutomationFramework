package baseclass;

import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import utilities.Data;


public class AppPage extends pagemethods.Page {

	protected AppPage(AppiumDriver<WebElement> driver,Data data) {
		super(driver,data);
	}


	public Float getFloatRoundOFF(Float value) {

		try {
			if (value == null) {
				return 0.0f;
			}
			DecimalFormat df = new DecimalFormat("0.00");
			df.setRoundingMode(RoundingMode.HALF_EVEN);
			return Float.valueOf(df.format(value));
		} catch (Exception e) {
			return -1.0f;
		}

	}
	
	public Double getDoubleRoundOFF(Double value) {

		try {
			if (value == null) {
				return 0.0;
			}
			DecimalFormat df = new DecimalFormat("0.00");
			df.setRoundingMode(RoundingMode.HALF_EVEN);
			return Double.valueOf(df.format(value));
		} catch (Exception e) {
			return -1.0;
		}

	}

	// UI value as string, UX value as float
	public Float getFloat(WebElement ele) {
		String value = ele.getText().trim();
		System.out.println("**************************************" + value + "**");
		try {
			if (value.equalsIgnoreCase("-")) {
				return 0.0f;
			} else if (value == null) {
				return 0.0f;
			} else {
				value = value.replaceAll("[+,$(%)]", "").trim().replaceAll("\\s+", "");
				return Float.valueOf(value);
			}
		} catch (Exception e) {
			return -1f;
		}
	}
	
	
	public Double getDouble(Double value) {
		try {
			if (value == null) {
				return 0.0;
			}
			return value;
		} catch (Exception e) {
			return -1.0;
		}
	}
	
	public Double getDouble(WebElement ele) {
		String value = ele.getText().trim();
		System.out.println("**************************************" + value + "**");
		try {
			if (value.equalsIgnoreCase("-")) {
				return 0.0;
			} else if (value == null) {
				return 0.0;
			} else {
				value = value.replaceAll("[+,$(%)]", "").trim().replaceAll("\\s+", "");
				return Double.valueOf(value);
			}
		} catch (Exception e) {
			return -1.0;
		}
	}
	
	public Double getDouble(String value) {
		System.out.println("**************************************" + value + "**");
		try {
			if (value.equalsIgnoreCase("-")) {
				return 0.0;
			} else if (value == null) {
				return 0.0;
			} else {
				value = value.replaceAll("[+,$(%)]", "").trim().replaceAll("\\s+", "");
				return Double.valueOf(value);
			}
		} catch (Exception e) {
			return -1.0;
		}
	}

	

	public String getString(String value) {
		try {
			if (value.trim() == null) {
				return "-";
			} else {
				return value;
			}
		} catch (Exception e) {
			return "null";
		}

	}

	
	
	protected String convertToUSCurrency(Float uxNetDeathBenfitValue) {

		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("API Value :: " + uxNetDeathBenfitValue);
		System.out.println("Converted to Curency" + format.format(uxNetDeathBenfitValue));
		return format.format(uxNetDeathBenfitValue);
	}
	
	
	protected String convertToUSCurrency(Double uxNetDeathBenfitValue) {

		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("API Value :: " + uxNetDeathBenfitValue);
		System.out.println("Converted to Curency" + format.format(uxNetDeathBenfitValue));
		return format.format(uxNetDeathBenfitValue);
	}
	
	public static String convertAsOfDateToDate(WebElement weAsOfDate){
		String asOfDate = weAsOfDate.getText();
		System.out.println("as of date is " + asOfDate);
		String[] strArr = null;
		if(asOfDate.contains("As of")) {
			strArr = asOfDate.split("As of");
		}else if(asOfDate.contains("as of")) {
			strArr = asOfDate.split("as of");
		}

		asOfDate = strArr[1].trim();
		return asOfDate;
	}
	
	public static String convertAsOfDateToDate(String asOfDate){
		
		System.out.println("as of date is " + asOfDate);
		String[] strArr = null;
		if(asOfDate.contains("As of")) {
			strArr = asOfDate.split("As of");
		}else if(asOfDate.contains("as of")) {
			strArr = asOfDate.split("as of");
		}

		asOfDate = strArr[1].trim();
		return asOfDate;
	}
	public static String dateFormat(String Fromat) {
		DateFormat originalFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
		DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = null;
		try {
			Date format = originalFormat.parse(Fromat);
			formattedDate = targetFormat.format(format);
		} catch (ParseException e) {
			e.getMessage();
		}

		return formattedDate;
	}

	public String getDateFormatString(String Date) {

		DateFormat originalFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
		DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = originalFormat.parse(Date);
			String formattedDate = targetFormat.format(date);
			System.out.println(formattedDate);
			return formattedDate;

		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

	public String generateRandomString(int length) {
		String generatedString = RandomStringUtils.randomAlphabetic(length);
		return generatedString;
	}

	public String generateRandomNumber(int length) {
		String generatedString = RandomStringUtils.randomNumeric(length);

		return generatedString;

	}

	public Float getFloat(String value) {
		try {
			if (value.trim() == "-") {
				return 0.0f;
			} else if (value.trim() == null) {
				return 0.0f;
			} else {
				value = value.replaceAll("[a-z+,$(%)]", "").trim().replaceAll("\\s+", "");

				return Float.valueOf(value);

			}
		} catch (Exception e) {
			return -1f;
		}
	}


	public Float getFloat(Float value) {
		try {
			if (value == null) {
				return 0.0f;
			}
			return value;
		} catch (Exception e) {
			return -1.0f;
		}
	}

	public String removeSpecialCharacters(String value) {

		try {
			if (value.trim() == null) {
				return null;
			} else {
				return value.replaceAll("[^\\d.]", "");
			}
		} catch (Exception e) {

			return e.getMessage();
		}

	}

	
public String removeCommaBetweenDigits(String OrgStr) {
		
		try {
			String UpdateStr=OrgStr.replaceAll("(?<=\\d),(?=\\d)", "");
			 
			return UpdateStr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	public String getFloatAsString(String value) {

		Double val = Double.parseDouble(value);

		DecimalFormat Numberformat = new DecimalFormat("#0.00");

		return Numberformat.format(val);

	}
	
	
	protected void verifyUIAndUX(String UIElement, Float APIValue, String ElementName) {
		if (Float.parseFloat(UIElement.trim().replaceAll("[^\\d.]", "")) == getFloatRoundOFF(
				getFloat(APIValue))) {
			passed(ElementName + " is displayed as expected, value from UX :: "
					+ getFloatRoundOFF(getFloat(APIValue)) + " and value from UI  :: "
					+ UIElement.replaceAll("[^\\d.]", "").trim());
		} else {
			failed(driver,
					ElementName + " is not expected, value from UX :: " + getFloatRoundOFF(getFloat(APIValue))
							+ " but value from UI :: " + UIElement.replaceAll("[^\\d.]", "").trim());
		}
}
	
	protected void verifyUIAndUX(String UIElement, Double APIValue, String ElementName) {
		if (Double.parseDouble(UIElement.trim().replaceAll("[^\\d.]", "")) == getDoubleRoundOFF(
				getDouble(APIValue))) {
			passed(ElementName + " is displayed as expected, value from UX :: "
					+ getDoubleRoundOFF(getDouble(APIValue)) + " and value from UI  :: "
					+ UIElement.replaceAll("[^\\d.]", "").trim());
		} else {
			failed(driver,
					ElementName + " is not expected, value from UX :: " + getDouble(getDouble(APIValue))
							+ " but value from UI :: " + UIElement.replaceAll("[^\\d.]", "").trim());
		}
}
	
	protected void verifyUIAndUX(WebElement UIElement, Double APIValue, String ElementName) {
		if (isElementPresent(UIElement)) {
			if (Double.parseDouble(UIElement.getText().trim().replaceAll("[^\\d.]", "")) == getDoubleRoundOFF(
					getDouble(APIValue))) {
				passed(ElementName + " is displayed as expected, value from UX :: "
						+ getDoubleRoundOFF(getDouble(APIValue)) + " and value from UI  :: "
						+ UIElement.getText().replaceAll("[^\\d.]", "").trim());
			} else {
				failed(driver,
						ElementName + " is not expected, value from UX :: " + getDoubleRoundOFF(getDouble(APIValue))
								+ " but value from UI :: " + UIElement.getText().replaceAll("[^\\d.]", "").trim());
			}
		} else {
			failed(driver,ElementName + "is not displayed");
		}

	}
	
	protected void verifyUIAndUX(WebElement UIElement, Float APIValue, String ElementName) {
		if (isElementPresent(UIElement)) {
			if (Float.parseFloat(UIElement.getText().trim().replaceAll("[^\\d.]", "")) == getFloatRoundOFF(getFloat(APIValue))) {
				passed(ElementName + " is expected from UX value :: " + getFloatRoundOFF(getFloat(APIValue)) + " and from UI value :: "
						+ UIElement.getText().replaceAll("[^\\d.]", "").trim());
			} else {
				failed(driver,ElementName + " is not expected value from UX :: " + getFloatRoundOFF(getFloat(APIValue))
						+ " but value from UI :: " + UIElement.getText().replaceAll("[^\\d.]", "").trim());
			}
		} else {
			failed(driver,ElementName + "is not displayed");
		}

	}

	protected void verifyUIAndUX(WebElement UIElement, String APIValue, String ElementName) {
		if (isElementPresent(UIElement)) {
			if (UIElement.getText().trim().replaceAll("[^\\d.]", "") .equalsIgnoreCase(APIValue)) {
				passed(ElementName + " is expected from UX value :: " + APIValue + " and from UI value :: "
						+ UIElement.getText().replaceAll("[^\\d.]", ""));
			} else {
				failed(driver,ElementName + " is not expected value from UX :: " + APIValue
						+ " but value from UI :: " + UIElement.getText().replaceAll("[^\\d.]", "").trim());
			}
		} else {
			failed(driver,ElementName + "is not displayed");
		}
	}
	protected void verifyUIAndUX(String UIElement, String APIValue, String ElementName) {
		
			if (UIElement.trim().equalsIgnoreCase(APIValue.trim())) {
				passed(ElementName + " is expected from UX value :: " + APIValue + " and from UI value :: "
						+ UIElement.trim());
			} else {
				failed(driver,ElementName + " is not expected value from UX :: " + APIValue
						+ " but value from UI :: " + UIElement.trim());
			
		}
	}
	protected void verifyUIAndUX(Float floatValue, Float APIValue, String ElementName) {
		if (Float.compare(floatValue, getFloatRoundOFF(getFloat(APIValue))) == 0) {
			passed(ElementName+" is displayed as expected from UX :: " + getFloatRoundOFF(getFloat(APIValue))+" and from UI :: "+floatValue);
		} else {
			failed(driver,ElementName+" is displayed as from UX :: "
					+ getFloat(APIValue) + " but from UI :: "
					+ floatValue);
		}
	}
	
	
	protected void verifyUIAndUX(Double Doublevalue, Double APIValue, String ElementName) {
		if (Double.compare(Doublevalue, getDoubleRoundOFF(getDouble(APIValue))) == 0) {
			passed(ElementName+" is displayed as expected from UX :: " + getDoubleRoundOFF(getDouble(APIValue))+" and from UI :: "+Doublevalue);
		} else {
			failed(driver,ElementName+" is displayed as from UX :: "
					+ getDouble(APIValue) + " but from UI :: "
					+ Doublevalue);
		}
	}
	
	public static String getProductTypeCode(String UIProductType) {
		String productTypeCode = "";
		if (UIProductType != null) {
			String[] splitWords = UIProductType.split("\\s");
			for (int i = 0; i < splitWords.length - 1; i++) {
				productTypeCode = productTypeCode + splitWords[i].charAt(0);

			}
		}
		return productTypeCode;
	}
	
	//L2  Screen verification method
	
	//method for replace the comma(,) between numbers
	
	public String[] replaceValues(WebElement ele)
	{
		String replaceValues=ele.getAttribute("label");
		
		System.out.println(replaceValues);
		replaceValues=replaceValues.replaceAll("(\\d+)\\,(\\d+)", "$8@$9");
		String[] values =replaceValues.split(",");
		return values;
	}


	
	public String[] replceAndSplit(WebElement ele)
	{
    String s=ele.getAttribute("label");
    System.out.println("Before Replace   ---->   "+s);
    String regex = "(?<=[\\d])(, )(?=[\\d])";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(s);
    s = m.replaceAll("@ ");
    System.out.println("date  --->    "+s);
	String regex1 = "(?<=[\\d])(,)(?=[\\d])";
    Pattern p1 = Pattern.compile(regex1);
    Matcher m1 = p1.matcher(s);
    s = m1.replaceAll("@");
    System.out.println("Except date  --->    "+s);

    String[] values=s.split(",");
    for (int i = 0; i < values.length; i++) {
    	 String regex2 = "(?<=[\\d])(@ )(?=[\\d])";
    	    Pattern p2 = Pattern.compile(regex2);
    	    Matcher m2 = p2.matcher(values[i]);
    	    values[i] = m2.replaceAll(", ");
    	    
    		String regex3 = "(?<=[\\d])(@)(?=[\\d])";
    	    Pattern p3 = Pattern.compile(regex3);
    	    Matcher m3 = p3.matcher(values[i]);
    	    values[i] = m3.replaceAll(",");
        
	}
		return values;
}
	
	
	
	
	
	public void scrollByDimension(double XStart, double YStart, double XEnd, double YEnd) {
        Dimension dimension =driver.manage().window().getSize();



        Double scrollWidthStart = dimension.getWidth() * XStart;
        int scrollXStart = scrollWidthStart.intValue();



        Double scrollHeightStart = dimension.getHeight() * YStart;
        int scrollYStart = scrollHeightStart.intValue();



        Double scrollWidthEnd = dimension.getWidth() * XEnd;
        int scrollXEnd = scrollWidthEnd.intValue();



        Double scrollHeightEnd = dimension.getHeight() * YEnd;
        int scrollYEnd = scrollHeightEnd.intValue();



        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(scrollXStart, scrollYStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(scrollXEnd, scrollYEnd)).release().perform();



    }
	
	
	public void SwipeByCoordinates(int scrollXStart,int scrollYStart,int scrollXEnd ,int scrollYEnd) {
		
		 try {
			new TouchAction((PerformsTouchActions) driver)
			 .press(PointOption.point(scrollXStart, scrollYStart))
			 .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			 .moveTo(PointOption.point(scrollXEnd, scrollYEnd)).release().perform();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	public String getCurrentDate() {
		 
		 try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			   LocalDateTime now = LocalDateTime.now();
			   String currentDate=dtf.format(now);   
			   return currentDate;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	 }
	
	
	public void scrollDown() {
		Dimension dimension = driver.manage().window().getSize();

		Double scrollHeightStart = dimension.getHeight() * 0.5;
		int scrollStart = scrollHeightStart.intValue();

		Double scrollHeightEnd = dimension.getHeight() * 0.2;
		int scrollEnd = scrollHeightEnd.intValue();

		new TouchAction((PerformsTouchActions) driver)
		.press(PointOption.point(0, scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(0, scrollEnd))
		.release().perform();
		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	

