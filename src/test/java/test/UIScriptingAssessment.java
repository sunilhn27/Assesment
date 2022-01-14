package test;

import org.testng.annotations.Test;

import com.solution.startup.BaseTest;

import pages.actions.UIScriptingPageActions;

public class UIScriptingAssessment extends BaseTest {

	public UIScriptingPageActions getUIScriptingPageActions() throws Exception {
		return new UIScriptingPageActions();
	}

	@Test(priority = 1)
	public void uiScriptingAssessment() throws Exception {
		getUIScriptingPageActions().enterproductName("Mi TV");
		getUIScriptingPageActions().clickOnEnterButton();
		getUIScriptingPageActions().clickOnFirstProduct();
		getUIScriptingPageActions().switchToNewwindow();
		getUIScriptingPageActions().clickOnaddToCart();
		getUIScriptingPageActions().clickOnCart();
		getUIScriptingPageActions().clickQtyDropDown();
		getUIScriptingPageActions().clickOnQty();
		getUIScriptingPageActions().getPrice();

	}

}
