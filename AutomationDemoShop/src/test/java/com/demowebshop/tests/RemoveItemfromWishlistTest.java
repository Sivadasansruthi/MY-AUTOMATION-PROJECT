package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class RemoveItemfromWishlistTest extends BaseTest {
	
	@Test
	public void verifyUserIsAbleToRemoveItemFromWishlist()
	{

		
		lp.login(prop.getProperty("email"),prop.getProperty("password"));
		
		lp.searchItem(prop.getProperty("itemToSearch"));
		productPage.addToWishlist();
		productPage.removeItem();
		String msg=productPage.getCartUpdateMsg();
		Assert.assertEquals(msg,"The wishlist is empty!", "Unable to remove item succesfully" );
		
	}

}
