package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	
	@Test
	public void verifyUserIsAbleToLoginWithValidCreds()  {
		
		
		
		String actualEmail=lp.login("obsqura24@gmail.com", "mypassword");


	    String expectedEmail = hp.getLoggedEmail();

	    Assert.assertEquals(actualEmail, expectedEmail, "Email did not match");
		    
		    
		    
		}
		 	
	}
	


