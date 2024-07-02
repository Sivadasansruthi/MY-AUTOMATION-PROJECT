package com.demowebshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.PageActions;

public class ShoppingCartPage extends PageActions {
	
WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".product-subtotal")
	private WebElement subTotal;
	
	@FindBy(id="CountryId")
	private WebElement countryDropdown;
	
	@FindBy(xpath ="//input[@id='termsofservice']")
	private WebElement agreementcheck;
	
	@FindBy(id="checkout")
	private WebElement checkoutbtn;
	
	
	public String validateShoppingCartPrice() {
		return getElementText(subTotal);
	}
	
	public void checkoutProduct(String country) {
		selectDropdownByVisibleText(countryDropdown, country);
	}
	
	public void selectCheckbox()
	{   
		
		clickElementJavaScript(agreementcheck);
	}
	
	public void clickOnCheckout()
	{
		clickElement(checkoutbtn);
	}

	

}
