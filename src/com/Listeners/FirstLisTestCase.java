package com.Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Method.CommonMethods;

public class FirstLisTestCase {
	
	@Test
	public void googleTitleVerify() {
		CommonMethods.setUpDriver("chrome","http://www.google.com");
		CommonMethods.driver.getTitle();
		CommonMethods.driver.quit();
	

	}
	@Test
	public void googleTitleMatch() {
		CommonMethods.setUpDriver("chrome","http://www.google.com");
		CommonMethods.driver.getTitle();
		Assert.assertTrue(false);
		CommonMethods.driver.quit();
}
}

