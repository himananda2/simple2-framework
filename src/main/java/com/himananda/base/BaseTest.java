package com.himananda.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

	final Logger log = Logger.getLogger(BaseTest.class);
	protected WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	protected void methodSetUp(String browser) {

		driver = BrowserFactory.getDriver(browser);

/*		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Hreddy\\eclipse-workspace\\sample-framework\\src\\main\\resources\\chromedriver.exe");
		log.info("About to Instantiate Driver");
		driver = new ChromeDriver();*/
	}

	@AfterMethod
	protected void MethodTearDown() {
		driver.quit();
	}

}
