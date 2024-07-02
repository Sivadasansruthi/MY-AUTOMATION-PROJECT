package com.demowebshop.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
	
	@Test
	public void verifyUserIsAbleToSeeOnlySearchedItems() {
		
		lp.searchItem(prop.getProperty("itemToSearch"));
		List<String> actualItemsList = productPage.validateSearchedItemsAppearAppropriately();
		
	    for(String item : actualItemsList) {
	    	if(item.toLowerCase().contains(prop.getProperty("itemToSearch"))){
	    		Assert.assertTrue(true, "Missing item "+ prop.getProperty("itemToSearch"));
	    	}
	    	
	    }
	}
	
	

}
