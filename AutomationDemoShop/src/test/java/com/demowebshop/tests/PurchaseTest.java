package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class PurchaseTest extends BaseTest {
	
	@Test
	public void verifyUserIsAbleToBuyAProduct()
	{
		
		
		Faker faker=new Faker();
		
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = faker.internet().emailAddress();
		String password= faker.internet().password();
		
		//String city,String address,String postcode,String phoneno
		
		String city=faker.address().city();
		String address1=faker.address().buildingNumber();
		String postcode=faker.address().zipCode();
		String phoneNumber = faker.phoneNumber().phoneNumber();
		
		
		
		lp.navigateToRegisteration();
		
		rp.createUser(firstName, lastName, email, password,password);
		
		lp.searchItem(prop.getProperty("itemToSearch"));
		String ActualPrice=productPage.addTocart().navigateToCart();
		String expectedPrice=shoppingPage.validateShoppingCartPrice();
		Assert.assertEquals(ActualPrice, expectedPrice, "Price difference in cart");
		shoppingPage.checkoutProduct(prop.getProperty("country"));
		shoppingPage.selectCheckbox();
		shoppingPage.clickOnCheckout();
		
		//cp.selectCountrydropdown(prop.getProperty("country"));
		
		cp.createBillingAddress(prop.getProperty("country"),city,address1,postcode,phoneNumber);
		cp.createShippingAddress();
		cp.selectShippingMethod();
		cp.selectPaymentMethod();
		cp.selectPaymentInformation();
		cp.orderConfirmation();
		String ExpectedText=cp.getconfirmationText();
		System.out.println(ExpectedText);
		
		
		Assert.assertEquals(ExpectedText, "Your order has been successfully processed!", "Alert did not match" );
		
		
		
		
	}

}
