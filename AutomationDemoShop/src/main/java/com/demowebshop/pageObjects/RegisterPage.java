package com.demowebshop.pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.PageActions;

public class RegisterPage extends PageActions {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "gender-male")
	private WebElement maleCheckbox;

	@FindBy(id = "FirstName")
	private WebElement firstName;

	@FindBy(id = "LastName")
	private WebElement lastName;

	@FindBy(id = "Email")
	private WebElement email;

	@FindBy(id = "Password")
	private WebElement password;

	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPassword;

	@FindBy(id = "register-button")
	private WebElement registerBtn;

	@FindBy(css = ".result")
	private WebElement alertMsg;

	@FindBy(xpath = "(//*[@class='header-links']//a)[1]")
	private WebElement loggedEmail;

	public void createUser(String firstNameVal, String lastNameVal, String emailVal, String passwordVal,
			String ConfirmPassVal) {
		clickElement(maleCheckbox);
		setTextBox(firstName, firstNameVal);
		setTextBox(lastName, lastNameVal);
		setTextBox(email, emailVal);
		setTextBox(password, passwordVal);
		setTextBox(confirmPassword, ConfirmPassVal);
		clickElement(registerBtn);
		System.out.println(firstNameVal + lastNameVal + emailVal + passwordVal);

	}

	public Map<String, String> validateRegisterationPageItems() {
		Map<String, String> dataMap = new HashMap<>();
		dataMap.put("alertText", getElementText(alertMsg));
		dataMap.put("loggedEmail", getElementText(loggedEmail));
		return dataMap;
	}

	
}
