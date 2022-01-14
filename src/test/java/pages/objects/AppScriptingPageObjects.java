package pages.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AppScriptingPageObjects {

	

	@AndroidFindBy(id = "com.flipkart.android:id/phonenumber")
	public MobileElement trueCallerTitle;

	@AndroidFindBy(id = "com.flipkart.android:id/continue")
	public MobileElement continueButton;



}
