package pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UIScriptingPageObjects {

	@FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	public WebElement search;

	@FindBy(xpath = "(//*[@class=\"a-size-medium a-color-base a-text-normal\"])[1]")
	public WebElement firstTV;

	@FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
	public WebElement addToCart;

	@FindBy(xpath = "//*[@id=\"nav-cart-text-container\"]")
	public WebElement cart1;

	@FindBy(xpath = "(//span[contains(.,'Vu 126 cm (50 inches) Cinema Series 4K Ultra HD Android Smart LED TV 50LX (Matte Black) (2021 Model) I 100 Watt Front Soundbar')])[3]")
	public WebElement vuTv;

	@FindBy(xpath = "//*[@id=\"attach-sidesheet-view-cart-button\"]")
	public WebElement cart;

	@FindBy(xpath = "//*[@class=\"a-size-medium a-color-base sc-price sc-white-space-nowrap\"]")
	public WebElement priceField;
	
	@FindBy(xpath = "//*[@class=\"a-button a-button-dropdown quantity\"]")
	public WebElement qtyDropdown;
	
	@FindBy(xpath = "(//*[@aria-labelledby=\"quantity_9\"])[5]")
	public WebElement qty;
	
	
	
	
	
}
