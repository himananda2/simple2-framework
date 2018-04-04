package com.himananda.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.himananda.base.BaseTest;

public class FirstTest extends BaseTest {

	final Logger log = Logger.getLogger(FirstTest.class);

	@Test
	public void firstTestMethod() {

		driver.get("https://www.facebook.com");
		log.info("Facebook opened ...");
	}

	@Test
	public void secondTestMethod() {

		driver.get("https://www.linkedin.com/");
		log.info("Linked opened ...");
	}
}
