package com.himananda.tests;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.himananda.base.BaseTest;
import com.himananda.base.ExcelUtils;
import com.himananda.pages.LogInPage;
import com.himananda.pages.ProfilePage;

public class LogInTest extends BaseTest {

	final Logger log = Logger.getLogger(LogInTest.class);

	@Test(enabled = false)
	public void positiveLogInTest() {

		String expectedPageTitle = "Seeker Dashboard - Profile";
		String profileName = "Himananda Reddy";

		LogInPage loginPage = new LogInPage(driver);
		loginPage.openLogInPage();
		loginPage.fillUpEmailAndPassword("himanandakr@gmail.com", "India123$");

		ProfilePage profilePage = loginPage.clickOnSignIn();
		profilePage.waitForProfilePageToLoad();

		String ActualPageTitle = profilePage.getTitle();

		log.info("Verifications on Profile Page");

		log.info(ActualPageTitle);

		// Assert.assertEquals(expectedPageTitle, ActualPageTitle,"Profile Page title
		// not expected.\nExpected: " + expectedPageTitle + "\nActual: " +
		// ActualPageTitle);

		Assert.assertTrue(profilePage.isCorrectProfileLoaded(profileName));
	}

	@Test(dataProvider = "getData")
	public void negetiveLogInTest(String userName, String password) {

		String expectedErrorMessage = "Email and/or password incorrect";

		LogInPage loginPage = new LogInPage(driver);
		loginPage.openLogInPage();
		loginPage.fillUpEmailAndPassword(userName, password);

		loginPage.clickOnSignIn();

		String actualErrorMessage = loginPage.getLogInErrorMessage();

		log.info("Verifications on Profile Page");

		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
	}

	@DataProvider

	public Object[][] getData() {

		return new Object[][] { { "himanandakr@gmail.in", "India123$" }, { "himanandakr@gmail.com", "India123$%" } };

	}

	@DataProvider
	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray(
				"C:\\Users\\Hreddy\\eclipse-workspace\\sample-framework\\src\\main\\resources\\testData\\Credentials.xlsx",
				"Sheet1");

		return (testObjArray);

	}
}
