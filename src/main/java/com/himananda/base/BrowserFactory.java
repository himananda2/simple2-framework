package com.himananda.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static Logger log = Logger.getLogger(BrowserFactory.class);

	public static WebDriver getDriver(String browser) {

		WebDriver driver = null;

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Hreddy\\eclipse-workspace\\sample-framework\\src\\main\\resources\\geckodriver.exe");
			log.info("About to Instantiate Driver");
			driver = new ChromeDriver();

			break;
		case "firefox":
			System.setProperty("webdriver.firefox.marionette",
					"C:\\Users\\Hreddy\\eclipse-workspace\\sample-framework\\src\\main\\resources\\chromedriver.exe");
			log.info("About to Instantiate Driver");
			driver = new FirefoxDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Hreddy\\eclipse-workspace\\sample-framework\\src\\main\\resources\\chromedriver.exe");
			log.info("About to Instantiate Driver");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

}
