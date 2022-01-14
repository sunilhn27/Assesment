package com.solution.generic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.solution.startup.BaseTest;

public class GenericFunctions extends BaseTest {

	Actions action;

	public static void validateUrl(String url) {
		Assert.assertEquals(driver.getCurrentUrl(), url);

	}

	public void clickOnEscapeButton() throws Exception {
		Thread.sleep(3000);
		action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();

	}

	// Method to Switch To New Window.
	public static void switchToNewWindow() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

}
