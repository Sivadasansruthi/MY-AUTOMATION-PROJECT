package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.pageObjects.LoginPage;

public class SubscribeTest extends BaseTest {
	
	@Test
	public void verifyUserIsAbleToSubscribeNewsLetter() throws InterruptedException{
		
		
		     lp.login("obsqura24@gmail.com", "mypassword");
			 String actualAlertMsg = hp.subcribeNewsLetter();

             Assert.assertEquals(actualAlertMsg, "Thank you for signing up! A verification email has been sent. We appreciate your interest.", "Alert message not mataching");
		 
		
		
		

		
	}
}


