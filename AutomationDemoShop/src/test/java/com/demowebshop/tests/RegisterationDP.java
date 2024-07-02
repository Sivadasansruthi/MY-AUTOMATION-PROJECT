package com.demowebshop.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class RegisterationDP extends BaseTest {
	
	@Test(dataProvider="getData", groups="Smoke")
	public void verifyUserIsAbleToRegisterThroughDP(String firstName, String lastName, String email, String password) {
		lp.navigateToRegisteration();
		rp.createUser(firstName,lastName, email, password, password);
		
		Map<String, String> dataMap = rp.validateRegisterationPageItems();
		Assert.assertEquals(dataMap.get("alertText"), prop.getProperty("registerationMsg"), "Alert did not match" );
		Assert.assertEquals(dataMap.get("loggedEmail"), email, "Logged Email is different" );
	}
	
	@DataProvider
	public String[][] getData() {
		Faker faker = new Faker();
		String data[][]= new String[1][4];
		data[0][0]=faker.name().firstName();
		data[0][1]= faker.name().lastName();
		data[0][2]=faker.internet().emailAddress();
		data[0][3]=faker.internet().password();
		
		return data;
	}
	
	
	

}
