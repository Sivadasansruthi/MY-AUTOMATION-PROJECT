package com.demowebshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.PageActions;

public class CheckoutPage extends PageActions {
	
WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath ="//select[@id='BillingNewAddress_CountryId']")
	private WebElement countrydropdown;
	//select[@id='BillingNewAddress_CountryId']
	
	@FindBy(xpath ="//input[@id='BillingNewAddress_City']")
	private WebElement city;
	
	@FindBy(xpath ="//input[@id='BillingNewAddress_Address1']")
	private WebElement address;
	
	@FindBy(xpath ="//input[@id='BillingNewAddress_ZipPostalCode']")
	private WebElement postcode;
	
	@FindBy(xpath ="//input[@id='BillingNewAddress_PhoneNumber']")
	private WebElement phoneno;
	
	@FindBy(xpath ="//div[@id='billing-buttons-container']/input")
	private WebElement continueBtn;
	
	
	@FindBy(xpath ="//div[@id='shipping-buttons-container']/input")
	private WebElement continueBtn2;
	
	@FindBy(css="#shippingoption_1")
	private WebElement option2;
	
	@FindBy(xpath ="//div[@id='shipping-method-buttons-container']/input")
	private WebElement continueBtn3;
	
	@FindBy(xpath ="//div[@id='payment-method-buttons-container']/input")
	private WebElement continueBtn4;
	
	@FindBy(xpath ="//div[@id='payment-info-buttons-container']/input")
	private WebElement continueBtn5;
	
	@FindBy(xpath ="//div[@id='confirm-order-buttons-container']/input")
	private WebElement continueBtn6;
	
	@FindBy(xpath ="//div[@class='title']/strong")
	private WebElement confirmationText;
	
	
	
	
	
	
	
	public void createBillingAddress(String countryVal,String cityVal,String addressVal,String postcodeVal,String phonenoVal)
	{
		selectDropdownByVisibleText(countrydropdown, countryVal);
		
		setTextBox(city, cityVal);
		setTextBox(address, addressVal);
		setTextBox(postcode, postcodeVal);
		setTextBox(phoneno, phonenoVal);
		
		clickElement(continueBtn);
		
	}
	
	public void createShippingAddress()
	{
		clickElement(continueBtn2);
	}
	
	public void selectShippingMethod()
	{
		clickElement(option2);
		clickElement(continueBtn3);
	}
	
	public void selectPaymentMethod()
	{
		clickElement(continueBtn4);
	}
	
	public void selectPaymentInformation()
	{
		clickElement(continueBtn5);
	}
	
	public void orderConfirmation()
	{
		clickElement(continueBtn6);
	}
	
	public String getconfirmationText()
	{
		String text= getElementText(confirmationText);
		return text;
	}
	
}
	  

