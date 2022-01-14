package pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.solution.generic.GenericFunctions;
import com.solution.startup.BaseTest;

import pages.objects.UIScriptingPageObjects;

public class UIScriptingPageActions extends BaseTest {

	UIScriptingPageObjects uiScriptingPageObjects;
	Actions action;

	public UIScriptingPageActions() {
		uiScriptingPageObjects = PageFactory.initElements(driver, UIScriptingPageObjects.class);
	}

	public void enterproductName(String tv) throws Exception {
		uiScriptingPageObjects.search.sendKeys(tv);

	}

	public void clickOnEnterButton() throws Exception {
		action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);

	}

	public void clickOnaddToCart() throws Exception {
		uiScriptingPageObjects.addToCart.click();
		Thread.sleep(5000);

	}

	public void clickOnFirstProduct() throws Exception {
		uiScriptingPageObjects.firstTV.click();

	}

	public void clickOnCart() throws Exception {
		uiScriptingPageObjects.cart.click();

	}

	public void clickQtyDropDown() throws Exception {
		uiScriptingPageObjects.qtyDropdown.click();

	}

	public void clickOnQty() throws Exception {
		uiScriptingPageObjects.qty.click();

	}

	public void getPrice() throws Exception {
		String priceInString = uiScriptingPageObjects.priceField.getText();
		System.out.println(priceInString);


	}

	public void switchToNewwindow() throws Exception {
		GenericFunctions.switchToNewWindow();
		Thread.sleep(3000);

	}

}
