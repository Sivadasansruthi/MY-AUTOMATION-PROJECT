package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class AddItemToWishlistTest extends BaseTest {
	
	@Test
	public void verifyUserIsAbleToAddItemToWishlist()
	{
        /*Faker faker=new Faker();
		
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = faker.internet().emailAddress();
		String password= faker.internet().password(); 
		
        lp.navigateToRegisteration();
		
		rp.createUser(firstName, lastName, email, password,password);*/
		
	    lp.login(prop.getProperty("email"),prop.getProperty("password"));
		
		lp.searchItem(prop.getProperty("itemToSearch"));
		String productName1=productPage.getselectedproductText1();
		productPage.addToWishlist();
		
		String productName2=productPage.getselectedproductText2();
		
		Assert.assertEquals(productName1,productName2, "product name did not match" );
		
	}
	
	

}
