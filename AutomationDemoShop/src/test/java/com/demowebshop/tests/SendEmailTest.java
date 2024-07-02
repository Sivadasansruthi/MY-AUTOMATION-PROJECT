package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class SendEmailTest extends BaseTest {
	
	@Test
	public void verifyUserIsAbleToSEndEmail()
	{
       
		lp.login(prop.getProperty("email"),prop.getProperty("password"));
		
		lp.searchItem(prop.getProperty("itemToSearch2"));
		
		productPage.sendEmailToFriend(prop.getProperty("friendEmail"));
		
		String actualmsg=productPage.getEmailAlertMsg();
		
		Assert.assertEquals(actualmsg, "Your message has been sent.", "Alert did not match" );
		
	}

}
