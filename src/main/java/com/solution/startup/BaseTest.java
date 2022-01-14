package com.solution.startup;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.solution.constants.IAutoConst;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

@SuppressWarnings("rawtypes")
public class BaseTest {

	public static RequestSpecification requestSpec = null;
	public static ResponseSpecification responseSpec = null;
	public Response response;
	public static WebDriver driver = null;
	private DesiredCapabilities desiredCapabilities;
	private final String IP_ADDRESS = "http://127.0.0.1:4723/wd/hub";
	private AppiumDriver appiumDriver;

	public ResponseSpecification responseSpecificationToGetToken(String endPointUri, Map<String, String> body) {
		try {
			requestSpec = new RequestSpecBuilder().setBaseUri(IAutoConst.BASE_URI)
					.addHeader("Content-Type", "application/json").setBasePath(endPointUri).setBody(body).build();
			responseSpec = new ResponseSpecBuilder().expectStatusCode(Integer.parseInt(IAutoConst.SUCCESS_CODE))
					.build();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return responseSpec;
	}

	@BeforeMethod
	public void init(Method method) throws MalformedURLException {
		if (method.getName().equalsIgnoreCase("uiScriptingAssessment")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://amazon.in");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (method.getName().equalsIgnoreCase("AppScriptingAssessment")) {

			desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("deviceName", "329943c9");
			desiredCapabilities.setCapability("automationName", "UIAutomator2");
			desiredCapabilities.setCapability("platformVersion", "11");
			desiredCapabilities.setCapability("appPackage", "com.flipkart.android.splashActivity");
			desiredCapabilities.setCapability("appActivity",
					"com.flipkart.android.activity.HomeFragmentHolderActivity");
			desiredCapabilities.setCapability("newCommandTimeout", "900");
			desiredCapabilities.setCapability("launchTimeout", "90000");
			desiredCapabilities.setCapability("app", IAutoConst.APK);
			appiumDriver = new AndroidDriver(new URL(IP_ADDRESS), desiredCapabilities);
			appiumDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		} else {
			System.out.println("running API Test");
		}
	}

	@AfterMethod
	public void close() {
		if (driver != null) {
			driver.quit();
		} else if (appiumDriver != null) {
			appiumDriver.quit();
		}
	}
}
