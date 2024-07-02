package com.demowebshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.PageActions;

public class LoginPage extends PageActions {
 
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(css="[class='ico-login']")
	private WebElement loginHeader;
	
	@FindBy(id="Email")
	private WebElement emailInput;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement passwordInput;
	
	@FindBy(xpath="//*[@class='buttons']/input[@value='Log in']")
	private WebElement loginBtn;
	
	@FindBy(css = "[class='ico-register']")
	private WebElement registerHeader;
	
	@FindBy(id = "small-searchterms")
	private WebElement searchInputBox;
	
	@FindBy(css = "[value='Search']")
	private WebElement searchBtn;

	
	
	
	public String login(String email, String password) {
		clickElement(loginHeader);
		setTextBox(emailInput, email);
		setTextBox(passwordInput, password);
		clickElement(loginBtn);
		return email;
	}
	
	public void navigateToRegisteration() {
		clickElement(registerHeader);

	}
	
	public void searchItem(String item) {
		//WebElement searchInputBox;
		setTextBox(searchInputBox, item);
		//WebElement searchBtn;
		clickElementJavaScript(searchBtn);
	}
	
	

	
}
